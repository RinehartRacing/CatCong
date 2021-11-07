
package com.catcong;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.font.BitmapText;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.util.SkyFactory;

public class LevelMap extends AbstractAppState  implements PhysicsCollisionListener {

	private final Node rootNode;
	/**
	 * This will hold all of our scene details and make it easier to clean up when
	 * we change to the next level
	 */
	private final Node gameLevel = new Node("LevelMap");
	private final AssetManager assetManager;
	private final InputManager inputManager;
	private Player player;
	private BulletAppState bulletAppState;
	private SimpleApplication app;
	private LevelControl lc;
	private Level0 level0;
	public LevelMap(SimpleApplication app, LevelControl lc) {
		rootNode = app.getRootNode();
		assetManager = app.getAssetManager();
		inputManager = app.getInputManager();
		player = new Player(app, lc);
		this.app = app;
		this.lc = lc;
	}

	@Override
	public void initialize(AppStateManager stateManager, Application app) {
		super.initialize(stateManager, app);
		app.getCamera().setLocation(new Vector3f(10, 5, 10));
		bulletAppState = new BulletAppState();
		stateManager.attach(bulletAppState);

		player.setupKeys();
		level0 = new Level0(gameLevel, assetManager, bulletAppState, player);
		Level1 level1 = new Level1(gameLevel, assetManager, bulletAppState);
		Level2 level2 = new Level2(gameLevel, assetManager, bulletAppState);
		Level3 level3 = new Level3(gameLevel, assetManager, bulletAppState);
		CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(gameLevel);
		gameLevel.addControl(new RigidBodyControl(sceneShape, 0));

		rootNode.attachChild(gameLevel);

		//getPhysicsSpace().addAll(gameLevel);
		getPhysicsSpace().add(player.get());
		getPhysicsSpace().addCollisionListener(this);

		inputManager.addMapping("Pause", new KeyTrigger(KeyInput.KEY_P));
		
		rootNode.attachChild(SkyFactory.createSky(assetManager,
				"assets/Textures/BrightSky.dds", SkyFactory.EnvMapType.CubeMap));
	}

	public PhysicsSpace getPhysicsSpace() {
		return bulletAppState.getPhysicsSpace();
	}

	public void updateLM() {
		Vector3f camDir = app.getCamera().getDirection().clone().multLocal(0.6f);
		Vector3f camLeft = app.getCamera().getLeft().clone().multLocal(0.4f);
		player.updateMovement(camDir, camLeft);
		app.getCamera().setLocation(player.get().getPhysicsLocation());
		
	}
	public Player getPlayer() {
		return player;
	}

	public void pause() {
		setEnabled(!isEnabled());
		player.get().setEnabled(!player.get().isEnabled());
		app.getFlyByCamera().setEnabled(!app.getFlyByCamera().isEnabled());
	}
	public void removeCactus(String name) {
		level0.removeCactus(name);
	}
	@Override
	public void cleanup() {
		rootNode.detachChild(gameLevel);

		super.cleanup();
	}

	@Override
	public void update(float tpf) {
		level0.updateCacti(tpf);
	}
	@Override
	public void collision(PhysicsCollisionEvent event) {
		if (event.getNodeB() != null) {
			if ("elevatorL0F0".equals(event.getNodeB().getName())) {
				System.out.println("On elevator");
				player.get().setPhysicsLocation(new Vector3f(99, 24, 13));
			}
			if ("elevatorNode1".equals(event.getNodeB().getName())) {
				System.out.println("On elevator");
				player.get().setPhysicsLocation(new Vector3f(425, 5, 50));
			}
			if ("elevatorNode2".equals(event.getNodeB().getName())) {
				System.out.println("On elevator");
				player.get().setPhysicsLocation(new Vector3f(625, 5, 50));
			}
			if("hammerL0F0".equals(event.getNodeB().getName())) {
				System.out.println("Touched hammer");
				level0.removeHammer(0);
				player.grabHammer();
			}
			
		}
	}

}