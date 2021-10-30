package com.catcong;

import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.Vector3f;

public class LevelControl extends SimpleApplication{
	private LevelMap LM;
	public static void main(String[] args) {
		LevelControl app = new LevelControl();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		LM = new LevelMap(this);
		stateManager.attach(LM);
		inputManager.addListener(actionListener, "Pause");
	}
	
	@Override
	public void simpleUpdate(float tpf) {
		LM.updateLM();
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
