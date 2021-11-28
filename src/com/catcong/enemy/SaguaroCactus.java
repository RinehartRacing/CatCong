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

public class SaguaroCactus extends Cactus {
	private Vector3f startCoord; // initial coordinate of Saguaro
	private Vector3f endCoord; // ending coordinate of Saguaro

	public SaguaroCactus(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player, char direction) {
		super(node, assetManager, bulletAppState, player);
		speedX = 32.0f; // speed of saguaro
		speedZ = 32.0f;
		this.direction = direction; 
	}

	public void spawnCactus(Vector3f coor1, Vector3f coor2, String name) {
		/*
		 * Builds Saguaro geometry
		 */
		this.name = name;
		this.startCoord = coor1;
		this.endCoord = coor2;
		//this.direction = direction;
		
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry(name, b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setTexture("ColorMap", assetManager.loadTexture("assets/Textures/cactus.jpg")); // Load cactus texture

		geom.setMaterial(mat); // Use new material on this Geometry.

		cactusNode = new Node(name);
		cactusNode.setLocalTranslation(coor1);
		cactusNode.attachChild(geom);
		node.attachChild(cactusNode);
		CollisionShape cactusShape = CollisionShapeFactory.createMeshShape(cactusNode); // Setup collision detection
		control = new RigidBodyControl(cactusShape, 0);
		control.setKinematic(true);
		cactusNode.addControl(control);
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
	}

	public void updateCactusZ(float tpf) {
		/*
		 * Responsible for moving the Saguaro
		 */
		if (direction == 'z') {
		float maxZ = endCoord.getZ(); // Find max and min x first
		float minZ = startCoord.getZ();
		if (minZ > maxZ) {
			maxZ = startCoord.getZ();
			minZ = endCoord.getZ();
		}

		if (cactusNode != null) {
			float zMov = speedZ * tpf;
			float cactusPosZ = cactusNode.getWorldTranslation().getZ();
			if (((cactusPosZ >= maxZ) && (speedZ > 0)) || ((cactusPosZ < minZ) && (speedZ < 0))) { // Flip direction if
																									// out of bounds
				speedZ *= -1;
			}
			cactusNode.move(0, 0, zMov); // Move Saguaro
		}
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
		bulletAppState.getPhysicsSpace().addCollisionListener(this);
	}
	}
	public void updateCactusX(float tpf) {
		/*
		 * Responsible for moving the Saguaro
		 */
		if (direction ==  'x') {
		float maxX = endCoord.getX(); // Find max and min x first
		float minX = startCoord.getX();
		if (minX > maxX) {
			maxX = startCoord.getX();
			minX = endCoord.getX();
		}

		if (cactusNode != null) {
			float xMov = speedX * tpf;
			float cactusPosX = cactusNode.getWorldTranslation().getX();
			if (((cactusPosX >= maxX) && (speedX > 0)) || ((cactusPosX < minX) && (speedX < 0))) { // Flip direction if
																									// out of bounds
				speedX *= -1;
			}
			cactusNode.move(xMov, 0, 0); // Move Saguaro
		}
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
		bulletAppState.getPhysicsSpace().addCollisionListener(this);
	}
	}

	@Override
	public void collision(PhysicsCollisionEvent event) {
		/*
		 * Called when player collides with Saguaro
		 */
		if (event.getNodeB() != null) {
			if (this.name.equals(event.getNodeB().getName())) {
				cactusNode.removeControl(control); // Remove collision detection
				this.removeCactus(); // break cactus
				this.player.loseLife(); // lose life
			}
		}

	}


	
}
