package com.catcong;

import java.util.Set;

import javax.swing.JFrame;

import com.catcong.levels.LevelMap;
import com.catcong.menus.HomeScreen;
import com.catcong.menus.InGameMenu;
import com.catcong.menus.Game;
import com.catcong.menus.HighScores;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.collision.CollisionResults;
import com.jme3.cursors.plugins.JmeCursor;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class LevelControl extends AbstractAppState{
	private LevelMap LM;
	private BitmapText hudText;
	private BitmapText livesText;
	private BitmapText hammerStatus;
	private BitmapText highScore;
	private BitmapText currentLevel;
	private InGameMenu inGameMenu;
	private NiftyJmeDisplay niftyDisplay;
	private Picture pic;
	private boolean paused;
	private int level;

	
	private SimpleApplication app;
	private AppStateManager stateManager;
	private InputManager inputManager;
	private BitmapFont guiFont;
	private Node guiNode;
	private AssetManager assetManager;
	private AppSettings settings;
	private AudioRenderer audioRenderer;
	private ViewPort guiViewPort;
	private Node rootNode;
	
	
	public LevelControl(SimpleApplication app, BitmapFont guiFont, AppSettings settings) {
		this.app = app;
		this.stateManager = app.getStateManager();
		this.inputManager = app.getInputManager();
		this.guiFont = guiFont;
		this.guiNode = app.getGuiNode();
		this.assetManager = app.getAssetManager();
		this.settings = settings;
		this.audioRenderer = app.getAudioRenderer();
		this.guiViewPort = app.getGuiViewPort();
		this.rootNode = app.getRootNode();
		this.level = 0;
	}

	public void simpleInitApp() {
		LM = new LevelMap(app, this);
		paused = false;
		stateManager.attach(LM);
		inputManager.addListener(actionListener, "Pause");

		hudText = new BitmapText(guiFont, false);
		hudText.setSize(guiFont.getCharSet().getRenderedSize()); // font size
		hudText.setColor(ColorRGBA.White); // font color

		hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
		guiNode.attachChild(hudText);

		livesText = new BitmapText(guiFont, false);
		livesText.setSize(guiFont.getCharSet().getRenderedSize());
		livesText.setColor(ColorRGBA.White);
		livesText.setLocalTranslation(600, livesText.getLineHeight(), 0);
		guiNode.attachChild(livesText);

		hammerStatus = new BitmapText(guiFont, false);
		hammerStatus.setSize(guiFont.getCharSet().getRenderedSize());
		hammerStatus.setColor(ColorRGBA.White);
		hammerStatus.setLocalTranslation(900, hammerStatus.getLineHeight(), 0);
		guiNode.attachChild(hammerStatus);
		
		highScore = new BitmapText(guiFont, false);
		highScore.setSize(guiFont.getCharSet().getRenderedSize());
		highScore.setColor(ColorRGBA.White);
		highScore.setLocalTranslation(1200, highScore.getLineHeight(), 0);
		guiNode.attachChild(highScore);
		
		currentLevel = new BitmapText(guiFont, false);
		currentLevel.setSize(guiFont.getCharSet().getRenderedSize());
		currentLevel.setColor(ColorRGBA.White);
		currentLevel.setLocalTranslation(1400, currentLevel.getLineHeight(), 0);
		guiNode.attachChild(currentLevel);
		
		inGameMenu = new InGameMenu(this);

		stateManager.attach(inGameMenu);
		initCrossHairs();
		preGame(0);

	}

	public void grabHammer() {
		if (!guiNode.hasChild(pic)) {
			pic = new Picture("HUD Picture");
			pic.setImage(assetManager, "assets/Textures/hammer.jpg", true);
			pic.setWidth(settings.getWidth() / 16);
			pic.setHeight(settings.getHeight() / 16);
			pic.setPosition(settings.getWidth() * (3.0f / 4), settings.getHeight() * (1.0f / 10));
			guiNode.attachChild(pic);
		}
	}

	public void loseHammer() {
		if (pic != null) {
			guiNode.detachChild(pic);
		}
	}

	public void simpleUpdate(float tpf) {
		LM.updateLM();
		hudText.setText(LM.getPlayer().get().getPhysicsLocation().toString()); // the text
		livesText.setText("Lives: " + LM.getPlayer().getLives());
		hammerStatus.setText("HammerStatus: " + LM.getPlayer().getHammer());
		highScore.setText("High Score:  " + LM.getPlayer().getScore());
		currentLevel.setText("Level" + level);
		
	}

	private final ActionListener actionListener = new ActionListener() {
		@Override
		public void onAction(String name, boolean keyPressed, float tpf) {
			if (name.equals("Pause") && !keyPressed) {
				pauseGame();
			}
		}
	};

	public void gameOver() {
		this.getGameStats();
		paused = !paused;
		LM.pause();
		niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
		Nifty nifty = niftyDisplay.getNifty();

		nifty.fromXml("assets/Interface/MainMenuLayout.xml", "gameOver", inGameMenu);
		guiViewPort.addProcessor(niftyDisplay);
	}

	public void preGame(int level) {
		this.level = level;
		paused = true;
		app.getFlyByCamera().setEnabled(false);
		LM.getPlayer().get().setEnabled(false);
		LM.setEnabled(false);
		LM.setScoreBool(true);
		if (paused) {
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "introLevel" + level, inGameMenu);
			guiViewPort.addProcessor(niftyDisplay);
		} else {
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}

	}

	public void finishLevel(int level) {
		paused = true;
		app.getFlyByCamera().setEnabled(false);
		LM.getPlayer().get().setEnabled(false);
		LM.setEnabled(false);
		if (paused) {
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "completeLevel" + level, inGameMenu);
			guiViewPort.addProcessor(niftyDisplay);
		} else {
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}
	}
	
	public void defeatSunDevil() {
		paused = true;
		app.getFlyByCamera().setEnabled(false);
		LM.getPlayer().get().setEnabled(false);
		LM.setEnabled(false);
		if (paused) {
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "completeFinalLevel", inGameMenu);
			guiViewPort.addProcessor(niftyDisplay);
		} else {
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}
	}
	public void getGameStats() {
		System.out.println("Player Name: " + Game.name);
		System.out.println("Overall Score: " + LM.getPlayer().getScore());
		System.out.println("Level " + level);
	}
	public void pauseGame() {
		System.out.println("Game Paused");
		paused = !paused;
		LM.pause();
		if (paused) {
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "pause", inGameMenu);
			guiViewPort.addProcessor(niftyDisplay);
		} else {
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}
	}

	public void resumeGame() {
		paused = false;
		LM.pause();
		inputManager.setCursorVisible(false);
		guiViewPort.clearProcessors();
	}

	public void restartGame() {
		rootNode.detachAllChildren();
		guiNode.detachAllChildren();
		inputManager.deleteMapping("Pause");
		inputManager.deleteMapping("Lefts");
		inputManager.deleteMapping("Rights");
		inputManager.deleteMapping("Ups");
		inputManager.deleteMapping("Downs");
		inputManager.deleteMapping("Space");
		this.resumeGame();
		this.simpleInitApp();
		this.preGame(0);

	} 
	
	public void setHighScore() {
		Game.frame.setVisible(false);
		
		HighScores hs = new HighScores();
		hs.toFront();
		//hs.requestFocus();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(LM.getPlayer().getScore());
		hs.addScore(LM.getPlayer().getScore());
		this.restartGame();
	}

	public void loadHomeScreen() {
		

		Game.frame.setVisible(false);
		this.restartGame();
		
		HomeScreen hs = new HomeScreen("CatCong");
		System.out.println("Load Home Screen Here");
	}

	public void quitGame() {
		
		Game.frame.setVisible(false);
		System.exit(0);
		Game.frame.dispose();

		
	}

	protected void initCrossHairs() {
		app.setDisplayStatView(false);
		inputManager.setCursorVisible(false);
		guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
		BitmapText ch = new BitmapText(guiFont, false);
		ch.setSize(guiFont.getCharSet().getRenderedSize() * 2);
		ch.setText("+"); // crosshairs
		ch.setLocalTranslation( // center
				settings.getWidth() / 2 - ch.getLineWidth() / 2, settings.getHeight() / 2 + ch.getLineHeight() / 2, 0);
		guiNode.attachChild(ch);
	}

	public void removeCactus(String name) {
		LM.removeCactus(name);
	}

}
