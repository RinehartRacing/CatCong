package com.catcong;

import com.catcong.menus.InGameMenu;
import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.cursors.plugins.JmeCursor;
import com.jme3.font.BitmapText;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Geometry;
import com.jme3.ui.Picture;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class LevelControl extends SimpleApplication {
	private LevelMap LM;
	private BitmapText hudText;
	private BitmapText livesText;
	private BitmapText hammerStatus;
	private InGameMenu inGameMenu;
	private NiftyJmeDisplay niftyDisplay;
	private Picture pic;
	private boolean paused;

	public static void main(String[] args) {
		LevelControl app = new LevelControl();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		LM = new LevelMap(this, this);
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

		inGameMenu = new InGameMenu(this);

		stateManager.attach(inGameMenu);
		initCrossHairs();

	}

	public void grabHammer() {
		pic = new Picture("HUD Picture");
		pic.setImage(assetManager, "assets/Textures/hammer.jpg", true);
		pic.setWidth(settings.getWidth() / 16);
		pic.setHeight(settings.getHeight() / 16);
		pic.setPosition(settings.getWidth() * (3.0f / 4), settings.getHeight() * (1.0f / 10));
		guiNode.attachChild(pic);
	}

	public void loseHammer() {
		if (pic != null) {
			guiNode.detachChild(pic);
		}
	}

	@Override
	public void simpleUpdate(float tpf) {
		LM.updateLM();
		hudText.setText(LM.getPlayer().get().getPhysicsLocation().toString()); // the text
		livesText.setText("Lives: " + LM.getPlayer().getLives());
		hammerStatus.setText("HammerStatus: " + LM.getPlayer().getHammer());
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
		paused = !paused;
		LM.pause();
		niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
		Nifty nifty = niftyDisplay.getNifty();

		nifty.fromXml("assets/Interface/MainMenuLayout.xml", "gameOver", inGameMenu);
		guiViewPort.addProcessor(niftyDisplay);
	}
	public void pauseGame() {
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

	}

	public void loadHomeScreen() {
		this.stop();
		System.out.println("Load Home Screen Here");
	}

	public void quitGame() {
		this.stop();
	}

	protected void initCrossHairs() {
		setDisplayStatView(false);
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
