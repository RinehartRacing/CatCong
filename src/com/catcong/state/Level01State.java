package com.catcong.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class Level01State extends AbstractAppState{
	
	private final Node rootNode;
	private final Node localRootNode = new Node("Level 1");
	private final AssetManager assetManager;
	private InputManager inputManager;

	public Level01State(SimpleApplication app) {
		rootNode = app.getRootNode();
		assetManager = app.getAssetManager();
		inputManager = app.getInputManager();
	}
	
	@Override
	public void initialize(AppStateManager stateManager, Application app) {
		super.initialize(stateManager, app);
		
		rootNode.attachChild(localRootNode);
		
		//Spatial scene = assetManager.loadModel("Scenes/Levels/Level1.j3o");
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager,  // Create new material and...
			    "Common/MatDefs/Misc/Unshaded.j3md");  // ... specify .j3md file to use (unshaded).
			mat.setColor("Color", ColorRGBA.White);     // Set some parameters, e.g. blue.
			geom.setMaterial(mat);               // Use new material on this Geometry.
		localRootNode.attachChild(geom);
		
		inputManager.addMapping("Pause", new KeyTrigger(KeyInput.KEY_P));
		inputManager.addListener(actionListener, "Pause");
	}
	
	private final ActionListener actionListener = new ActionListener() {
		@Override
		public void onAction(String name, boolean keyPressed, float tpf) {
			if(name.equals("Pause") && !keyPressed) {
				setEnabled(!isEnabled());
			}
		}
	};
	
	@Override
	public void cleanup() {
		rootNode.detachChild(localRootNode);
		
		super.cleanup();
	}
	
	@Override
	public void update(float tpf) {
		
	}
}
