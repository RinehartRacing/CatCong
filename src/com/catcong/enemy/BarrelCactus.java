/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.enemy;

import com.catcong.Player;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class BarrelCactus extends Cactus {
	private Vector3f startCoord; // Starting point of BarrelCactus
	private Vector3f endCoord; // Ending point of BarrelCactus

	public BarrelCactus(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		super(node, assetManager, bulletAppState, player);
		speed = 32.0f; // Speed of BarrelCactus
	}

	public void spawnCactus(Vector3f coor1, Vector3f coor2, String name) {
		/*
		 * Spawns the BarrelCactus and places it in its initial position
		 */
		this.name = name;
		this.startCoord = coor1;
		this.endCoord = coor2;
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry(name, b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setTexture("ColorMap", assetManager.loadTexture("assets/Textures/cactus.jpg")); // Use cactus texture
		geom.setMaterial(mat); // Use new material on this Geometry.

		cactusNode = new Node(name);
		cactusNode.setLocalTranslation(new Vector3f(coor1.getX(), coor1.getY() + 8, coor1.getZ())); // Create top part
																									// of cactus
		cactusNode.attachChild(geom);

		for (int i = 1; i < 5; i++) { // Make cactus 5 blocks tall
			Geometry geom2 = geom.clone();
			cactusNode.attachChild(geom2);
			geom2.setLocalTranslation(new Vector3f(0, -i * 2, 0));
		}

		node.attachChild(cactusNode);
		CollisionShape cactusShape = CollisionShapeFactory.createMeshShape(cactusNode); // Add collision to cactus
		control = new RigidBodyControl(cactusShape, 0);
		control.setKinematic(true);
		cactusNode.addControl(control); // Add collision detection
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
	}

	public void updateCactus(float tpf) {
		/*
		 * Responsible for moving the BarrelCactus given ticks per frame (tpf)
		 */
		float maxX = endCoord.getX(); // Start by finding max and min of x coordinates
		float minX = startCoord.getX();
		if (minX > maxX) {
			maxX = startCoord.getX();
			minX = endCoord.getX();
		}

		if (cactusNode != null) {
			float xMov = speed * tpf;
			float cactusPosX = cactusNode.getWorldTranslation().getX();
			if (((cactusPosX >= maxX) && (speed > 0)) || ((cactusPosX < minX) && (speed < 0))) { // Flip speed if
																									// BarrelCactus gets
																									// out of range
				speed *= -1;
			}
			cactusNode.move(xMov, 0, 0); // Move BarelCactus
		}
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
		bulletAppState.getPhysicsSpace().addCollisionListener(this); // Update collision detection
	}

	@Override
	public void collision(PhysicsCollisionEvent event) {
		/*
		 * Called when player hits BarrelCactus
		 */
		if (event.getNodeB() != null) {
			if (this.name.equals(event.getNodeB().getName())) {
				cactusNode.removeControl(control); // Break cactus
				this.removeCactus();
				this.player.loseLife(); // Lose life
			}
		}

	}
}
