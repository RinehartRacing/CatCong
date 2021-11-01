package com.catcong;

import com.catcong.menus.MainMenuController;
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;

import de.lessvoid.nifty.Nifty;

public class LevelControl extends SimpleApplication{
	private LevelMap LM;
	private BitmapText hudText;
	private MainMenuController myMainMenuController;
	public static void main(String[] args) {
		LevelControl app = new LevelControl();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		LM = new LevelMap(this);
		stateManager.attach(LM);
		inputManager.addListener(actionListener, "Pause");
		
		hudText = new BitmapText(guiFont, false);
		hudText.setSize(guiFont.getCharSet().getRenderedSize());      // font size
		hudText.setColor(ColorRGBA.White);                             // font color
		
		hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
		guiNode.attachChild(hudText);
		
		myMainMenuController = new MainMenuController();

        stateManager.attach(myMainMenuController);
		
		NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
        Nifty nifty = niftyDisplay.getNifty();
        guiViewPort.addProcessor(niftyDisplay);
        
        nifty.fromXml("assets/Interface/MainMenuLayout.xml", "start", myMainMenuController);
	}
	
	@Override
	public void simpleUpdate(float tpf) {
		LM.updateLM();
		hudText.setText(LM.getPlayer().get().getPhysicsLocation().toString());             // the text
	}
	
	private final ActionListener actionListener = new ActionListener() {
		@Override
		public void onAction(String name, boolean keyPressed, float tpf) {
			if (name.equals("Pause") && !keyPressed) {
				LM.pause();
			}
		}
	};
}
