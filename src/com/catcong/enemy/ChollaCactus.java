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

public class ChollaCactus extends Cactus {

	public ChollaCactus(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		super(node, assetManager, bulletAppState, player);
	}

	public void spawnCactus(Vector3f coor1, String name) {
		/*
		 * Spawns ChollaCactus
		 */
		this.name = name;

		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry(name, b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setTexture("ColorMap", assetManager.loadTexture("assets/Textures/cactus.jpg"));
		geom.setMaterial(mat); // Use new material on this Geometry.

		cactusNode = new Node(name);
		cactusNode.setLocalTranslation(new Vector3f(coor1.getX(), coor1.getY() + 8, coor1.getZ()));

		for (int i = 0; i < 5; i++) { // Make Cholla 5 blocks high
			for (int j = 0; j < 4; j++) { // and 4 blocks wide
				Geometry geom2 = geom.clone();
				cactusNode.attachChild(geom2);
				geom2.setLocalTranslation(new Vector3f(0, -i * 2, (-j * 2) + 3));
			}
		}

		node.attachChild(cactusNode);
		CollisionShape cactusShape = CollisionShapeFactory.createMeshShape(cactusNode);
		control = new RigidBodyControl(cactusShape, 0);
		control.setKinematic(true);

		cactusNode.addControl(control);
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
	}

	@Override
	public void collision(PhysicsCollisionEvent event) {
		/*
		 * Called when player collides with Cholla Cactus
		 */
		if (event.getNodeB() != null) {
			if (this.name.equals(event.getNodeB().getName())) {
				cactusNode.removeControl(control);
				this.removeCactus(); // Break cactus
				this.player.loseLife(); // Lose life
			}
		}

	}


	

	@Override
	public void updateCactusX(float tpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCactusZ(float tpf) {
		// TODO Auto-generated method stub
		
	}
}
