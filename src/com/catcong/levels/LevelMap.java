/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.levels;

import com.catcong.LevelControl;
import com.catcong.Player;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.util.SkyFactory;

public class LevelMap extends AbstractAppState implements PhysicsCollisionListener {

	private final Node rootNode;

	private final Node gameLevel = new Node("LevelMap"); // Node to hold level
	private final AssetManager assetManager;
	private final InputManager inputManager;
	private Player player;
	private BulletAppState bulletAppState;
	private SimpleApplication app;
	private LevelControl lc; // LevelControl access object
	private Level0 level0; // 4 level objects
	private Level1 level1;
	private Level2 level2;
	private Level3 level3;
	private boolean toScoreorNottoScore; // Boolean to prevent getting too high of a score with threading

	public LevelMap(SimpleApplication app, LevelControl lc) {
		rootNode = app.getRootNode();
		assetManager = app.getAssetManager();
		inputManager = app.getInputManager();
		player = new Player(app, lc);
		this.app = app;
		this.lc = lc;
		this.toScoreorNottoScore = true;
	}

	@Override
	public void initialize(AppStateManager stateManager, Application app) {
		/*
		 * Called when the Level Map is started
		 */
		super.initialize(stateManager, app);
		app.getCamera().setLocation(new Vector3f(10, 5, 10)); // Set initial camera location
		bulletAppState = new BulletAppState();
		stateManager.attach(bulletAppState);

		player.setupKeys(); // Setup key bindings
		// level0 = new Level0(gameLevel, assetManager, bulletAppState, player);
		// //Create 4 levels
		level1 = new Level1(gameLevel, assetManager, bulletAppState, player);
		level2 = new Level2(gameLevel, assetManager, bulletAppState, player);
		level3 = new Level3(gameLevel, assetManager, bulletAppState, player);
		CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(gameLevel); // Add collision detection to
																						// levels
		gameLevel.addControl(new RigidBodyControl(sceneShape, 0));

		rootNode.attachChild(gameLevel);

		getPhysicsSpace().add(player.get()); // Add physiscs to player
		getPhysicsSpace().addCollisionListener(this);

		inputManager.addMapping("Pause", new KeyTrigger(KeyInput.KEY_P)); // Map p to pause

		rootNode.attachChild(
				SkyFactory.createSky(assetManager, "assets/Textures/BrightSky.dds", SkyFactory.EnvMapType.CubeMap)); // Sky
																														// background
	}

	public PhysicsSpace getPhysicsSpace() {
		return bulletAppState.getPhysicsSpace();
	}

	public void updateLM() {
		/*
		 * Called every time Game Engine updates
		 */
		Vector3f camDir = app.getCamera().getDirection().clone().multLocal(0.6f);
		Vector3f camLeft = app.getCamera().getLeft().clone().multLocal(0.4f);
		player.updateMovement(camDir, camLeft);
		app.getCamera().setLocation(player.get().getPhysicsLocation());

	}

	public Player getPlayer() {
		return player;
	}

	public void pause() {
		/*
		 * Pauses physics
		 */
		setEnabled(!isEnabled());
		player.get().setEnabled(!player.get().isEnabled());
		app.getFlyByCamera().setEnabled(!app.getFlyByCamera().isEnabled());
	}

	public void removeCactus(String name) {
		/*
		 * Removes cactus with given name from all 4 levels
		 */
		level0.removeCactus(name);
		level1.removeCactus(name);
		level2.removeCactus(name);
		level3.removeCactus(name);
	}

	public void setScoreBool(boolean toScoreorNottoScore) {
		this.toScoreorNottoScore = toScoreorNottoScore;
	}

	@Override
	public void cleanup() {
		/*
		 * Properly cleanup Game Engine when done
		 */
		rootNode.detachChild(gameLevel);

		super.cleanup();
	}

	@Override
	public void update(float tpf) {
		/*
		 * Called on loop to move cacti
		 */
		// level0.updateCacti(tpf);
		 level1.updateCacti(tpf);
	}

	@Override
	public void collision(PhysicsCollisionEvent event) {
		/*
		 * Triggered when collision occurs between player and cactus or elevator
		 */
		if (event.getNodeB() != null) {
			if ("elevatorL0F0".equals(event.getNodeB().getName())) { // Elevator collision
				player.get().setPhysicsLocation(new Vector3f(99, 24, 13));
			}
			if ("elevatorL0F1".equals(event.getNodeB().getName())) {
				player.get().setPhysicsLocation(new Vector3f(-1, 44, 13));
			}
			if ("elevatorL0F2".equals(event.getNodeB().getName())) {
				player.get().setPhysicsLocation(new Vector3f(10225, 5, 50));
				player.advanceLevel();
				if (toScoreorNottoScore) { // End of level logic that ensures score doesn't get incremented multiple
											// times
					player.incrementScore(500);
					toScoreorNottoScore = false;
				}
				lc.finishLevel(0);

			}
			if ("elevatorL1F0".equals(event.getNodeB().getName())) {
				player.get().setPhysicsLocation(new Vector3f(21425, 5, 50));
				player.advanceLevel();
				if (toScoreorNottoScore) { // End of level logic that ensures score doesn't get incremented multiple
											// times
					player.incrementScore(500);
					toScoreorNottoScore = false;
				}
				lc.finishLevel(1);

			}
			if ("elevatorL2F0".equals(event.getNodeB().getName())) {
				player.get().setPhysicsLocation(new Vector3f(31625, 5, 50));
				player.advanceLevel();
				if (toScoreorNottoScore) { // End of level logic that ensures score doesn't get incremented multiple
											// times
					player.incrementScore(500);
					toScoreorNottoScore = false;
				}
				lc.finishLevel(2);

			}
			if ("hammerL0F0".equals(event.getNodeB().getName())) { // Hammers
				level0.removeHammer(0);
				player.grabHammer();
			}
			if ("hammerL0F1".equals(event.getNodeB().getName())) {
				level0.removeHammer(1);
				player.grabHammer();
			}
			if (event.getNodeB() != null) {
				if ("hammerL3F0".equals(event.getNodeB().getName())) {
					level3.removeHammer(0);
					player.grabHammer();
				}
				if (event.getNodeB() != null) {
					if ("hammerL1F0".equals(event.getNodeB().getName())) {
						level1.removeHammer(0);
						player.grabHammer();
					}
				}
				if ("hammer2L1F0".equals(event.getNodeB().getName())) {
					level1.removeHammer(1);
					player.grabHammer();
				}
			}

		}
	}

}