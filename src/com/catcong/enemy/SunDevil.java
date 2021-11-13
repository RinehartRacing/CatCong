package com.catcong.enemy;

import com.catcong.Player;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class SunDevil extends Cactus {

	public SunDevil(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		super(node, assetManager, bulletAppState, player);
	}

	public void spawnCactus(Vector3f coor1, String name) {
		this.name = name;

		Spatial sundevil = assetManager.loadModel("assets/Models/sundevil.obj");
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		//mat.setTexture("ColorMap", assetManager.loadTexture("assets/Textures/sundevil.jpg"));
		mat.setColor("Color", ColorRGBA.Red);
		sundevil.setMaterial(mat); // Use new material on this Geometry.

		cactusNode = new Node(name);
		cactusNode.setLocalTranslation(new Vector3f(coor1.getX(), coor1.getY(), coor1.getZ()));
		cactusNode.rotate(0f, -1.57f, 0f);
		cactusNode.attachChild(sundevil);
		node.attachChild(cactusNode);
		CollisionShape cactusShape = CollisionShapeFactory.createMeshShape(cactusNode);
		control = new RigidBodyControl(cactusShape, 0);
		control.setKinematic(true);

		cactusNode.addControl(control);
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
	}
	@Override
	public void collision(PhysicsCollisionEvent event) {
		if (event.getNodeB() != null) {
			if (this.name.equals(event.getNodeB().getName())) {
				System.out.println("Hit cactus");
				cactusNode.removeControl(control);
				this.removeCactus();
				this.player.loseLife();
			}
		}

	}
}