package com.catcong;

import com.catcong.menus.InGameMenu;
import com.jme3.app.SimpleApplication;
import com.jme3.cursors.plugins.JmeCursor;
import com.jme3.font.BitmapText;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class LevelControl extends SimpleApplication {
	private LevelMap LM;
	private BitmapText hudText;
	private BitmapText livesText;
	private InGameMenu inGameMenu;
	private NiftyJmeDisplay niftyDisplay;
	private boolean paused;

	public static void main(String[] args) {
		LevelControl app = new LevelControl();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		LM = new LevelMap(this);
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

		inGameMenu = new InGameMenu(this);

		stateManager.attach(inGameMenu);

		initCrossHairs();

	}

	@Override
	public void simpleUpdate(float tpf) {
		LM.updateLM();
		hudText.setText(LM.getPlayer().get().getPhysicsLocation().toString()); // the text
		livesText.setText("Lives: " + LM.getPlayer().getLives());
	}

	private final ActionListener actionListener = new ActionListener() {
		@Override
		public void onAction(String name, boolean keyPressed, float tpf) {
			if (name.equals("Pause") && !keyPressed) {
				pauseGame();
			}
		}
	};

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

}
