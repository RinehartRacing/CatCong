/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong;

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
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.ColorRGBA;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

import de.lessvoid.nifty.Nifty;

public class LevelControl extends AbstractAppState {
	private LevelMap LM; // LevelMap object that holds the data of the map
	private BitmapText hudText; // Bitmap text that holds the player's coordinates
	private BitmapText livesText; // Bitmap text that holds the player's lives
	private BitmapText highScore; // Bitmap text that holds the player's current score
	private BitmapText currentLevel; // Bitmap text that holds the player's current level
	private InGameMenu inGameMenu; // InGameMenu object to give this class access to all in-game popup menus
	private NiftyJmeDisplay niftyDisplay; // Object that allows displaying in-game menus
	private Picture pic; // Picture that will hold hammer image
	private boolean paused; // True if game is paused, false otherwise
	private int level; // Stores the current level the player is on

	private SimpleApplication app; // Passed in objects required by JMonkey Game Engine
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
		/*
		 * This function executes when the Game Engine first starts up
		 */
		LM = new LevelMap(app, this); // Create the Map
		paused = false; // Unpause the game
		stateManager.attach(LM); // Add the Map to the Game Engine
		inputManager.addListener(actionListener, "Pause"); // Start listening for pausing

		hudText = new BitmapText(guiFont, false); // Setup on screen coordinates
		hudText.setSize(guiFont.getCharSet().getRenderedSize()); // font-size
		hudText.setColor(ColorRGBA.White); // font-color
		hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
		guiNode.attachChild(hudText); // Add to screen

		livesText = new BitmapText(guiFont, false); // Setup on screen lives
		livesText.setSize(guiFont.getCharSet().getRenderedSize());
		livesText.setColor(ColorRGBA.White);
		livesText.setLocalTranslation(600, livesText.getLineHeight(), 0);
		guiNode.attachChild(livesText);

		highScore = new BitmapText(guiFont, false); // Setup on screen score
		highScore.setSize(guiFont.getCharSet().getRenderedSize());
		highScore.setColor(ColorRGBA.White);
		highScore.setLocalTranslation(1200, highScore.getLineHeight(), 0);
		guiNode.attachChild(highScore);

		currentLevel = new BitmapText(guiFont, false); // Setup on screen current level
		currentLevel.setSize(guiFont.getCharSet().getRenderedSize());
		currentLevel.setColor(ColorRGBA.White);
		currentLevel.setLocalTranslation(1400, currentLevel.getLineHeight(), 0);
		guiNode.attachChild(currentLevel);

		inGameMenu = new InGameMenu(this); // Setup in-game menus

		stateManager.attach(inGameMenu); // Add in-game menus to the game
		initCrossHairs(); // Add cross hair to Game Engine
		preGame(0); // Get set up for Level0

	}

	public void grabHammer() {
		/*
		 * Displays the image of a hammer on the screen when called
		 */
		if (!guiNode.hasChild(pic)) { // If the hammer wasn't already the screen
			pic = new Picture("Hammer Picture");
			pic.setImage(assetManager, "assets/Textures/hammer.jpg", true);
			pic.setWidth(settings.getWidth() / 16);
			pic.setHeight(settings.getHeight() / 16);
			pic.setPosition(settings.getWidth() * (3.0f / 4), settings.getHeight() * (1.0f / 10));
			guiNode.attachChild(pic);
		}
	}

	public void loseHammer() {
		/*
		 * Removes hammer from the screen when called
		 */
		if (pic != null) { // If hammer picture is still on screen
			guiNode.detachChild(pic);
		}
	}

	public void simpleUpdate(float tpf) {
		/*
		 * Called on a loop while the Game Engine is running
		 */
		LM.updateLM(); // Update the map
		hudText.setText(LM.getPlayer().get().getPhysicsLocation().toString()); // Constantly update coordinates on
																				// screen
		livesText.setText("Lives: " + LM.getPlayer().getLives()); // Constantly update lives on screen
		highScore.setText("High Score:  " + LM.getPlayer().getScore()); // Constantly show up to date player score
		currentLevel.setText("Level" + level); // Constantly show current player level

	}

	private final ActionListener actionListener = new ActionListener() {
		/*
		 * This function is executed when the pause button (P) is pressed
		 */
		@Override
		public void onAction(String name, boolean keyPressed, float tpf) {
			if (name.equals("Pause") && !keyPressed) {
				pauseGame();
			}
		}
	};

	public void gameOver() {
		/*
		 * Called when the player runs out of lives
		 */
		this.getGameStats(); // Print the game statistics to the console
		paused = !paused;
		LM.pause(); // Pause the game
		niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
		Nifty nifty = niftyDisplay.getNifty();

		nifty.fromXml("assets/Interface/MainMenuLayout.xml", "gameOver", inGameMenu); // Display GameOver menu we
																						// created in MainMenuLayout.xml
		guiViewPort.addProcessor(niftyDisplay);
	}

	public void preGame(int level) {
		/*
		 * Called before the start of every level
		 */
		this.level = level; // update the current level
		paused = true; // Ensure game is fully paused
		app.getFlyByCamera().setEnabled(false);
		LM.getPlayer().get().setEnabled(false);
		LM.setEnabled(false);
		LM.setScoreBool(true);
		if (paused) {
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "introLevel" + level, inGameMenu); // Display proper
																									// intro menu that
																									// we created in
																									// MainMenuLayout.xml
			guiViewPort.addProcessor(niftyDisplay);
		} else {
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}

	}

	public void finishLevel(int level) {
		/*
		 * Called at the end of every level
		 */
		paused = true; // Ensure game is fully paused
		app.getFlyByCamera().setEnabled(false);
		LM.getPlayer().get().setEnabled(false);
		LM.setEnabled(false);
		if (paused) {
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "completeLevel" + level, inGameMenu); // Display proper
																										// completion
																										// level that we
																										// created in
																										// MainMenuLayout.xml
			guiViewPort.addProcessor(niftyDisplay);
		} else {
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}
	}

	public void defeatSunDevil() {
		/*
		 * Called when the Sun Devil is defeated
		 */
		this.getGameStats(); // Print game stats
		paused = true; // Ensure game is fully paused
		app.getFlyByCamera().setEnabled(false);
		LM.getPlayer().get().setEnabled(false);
		LM.setEnabled(false);
		if (paused) {
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "completeFinalLevel", inGameMenu); // Display final
																									// menu from
																									// MainMenuLayout.xml
																									// that we created
			guiViewPort.addProcessor(niftyDisplay);
		} else {
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}
	}

	public void getGameStats() {
		/*
		 * Prints the player name, score, and level to the console
		 */
		System.out.println("Player Name: " + Game.name);
		System.out.println("Overall Score: " + LM.getPlayer().getScore());
		System.out.println("Level " + level);
	}

	public void pauseGame() {
		/*
		 * Called when the game is paused
		 */
		paused = !paused;
		LM.pause(); // Pause the level map
		if (paused) { // Display pause menu
			niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
			Nifty nifty = niftyDisplay.getNifty();

			nifty.fromXml("assets/Interface/MainMenuLayout.xml", "pause", inGameMenu); // Display pause menu from
																						// MainMenuLayout.xml that we
																						// created
			guiViewPort.addProcessor(niftyDisplay);
		} else { // Remove pause menu
			inputManager.setCursorVisible(false);
			guiViewPort.clearProcessors();
		}
	}

	public void resumeGame() {
		/*
		 * Called when the game resumes
		 */
		paused = false;
		LM.pause(); // Pause the level map
		inputManager.setCursorVisible(false);
		guiViewPort.clearProcessors();
	}

	public void restartGame() {
		/*
		 * Called when the game restarts
		 */
		rootNode.detachAllChildren();
		guiNode.detachAllChildren();
		inputManager.deleteMapping("Pause");
		inputManager.deleteMapping("Lefts");
		inputManager.deleteMapping("Rights");
		inputManager.deleteMapping("Ups");
		inputManager.deleteMapping("Downs");
		inputManager.deleteMapping("Space");
		inputManager.deleteMapping("pick target");
		this.resumeGame();
		this.simpleInitApp();
		this.preGame(0);

	}

	public void setHighScore() {
		/*
		 * Called after game is beat
		 */
		Game.frame.setVisible(false); // Hide Game Engine window

		HighScores hs = new HighScores(); // Display HighScore Menu
		hs.toFront();
		hs.requestFocus();
		hs.addScore(LM.getPlayer().getScore()); // Add score to highscore screen
		this.restartGame(); // Restart Game Engine in background in case the user wants to play again
	}

	public void loadHomeScreen() {
		/*
		 * Called when the user wants to return to the Home Screen
		 */
		Game.frame.setVisible(false); // Hid Game Engine Window
		this.restartGame(); // Restart Game ENgine in background in case the user wants to play again

		new HomeScreen("CatCong"); // Display the HomeScreen window
	}

	public void quitGame() {
		/*
		 * Called when the user wants to quit
		 */
		Game.frame.setVisible(false);
		System.exit(0);
		Game.frame.dispose();

	}

	protected void initCrossHairs() {
		/*
		 * Displays crosshair on the screen for better aim and navigation
		 */
		app.setDisplayStatView(false);
		inputManager.setCursorVisible(false);
		guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
		BitmapText ch = new BitmapText(guiFont, false);
		ch.setSize(guiFont.getCharSet().getRenderedSize() * 2);
		ch.setText("+");
		ch.setLocalTranslation( // center crosshair
				settings.getWidth() / 2 - ch.getLineWidth() / 2, settings.getHeight() / 2 + ch.getLineHeight() / 2, 0);
		guiNode.attachChild(ch);
	}

	public void removeCactus(String name) {
		/*
		 * Called after a cactus breaks
		 */
		LM.removeCactus(name); // Remove cactus from level map
	}

}
