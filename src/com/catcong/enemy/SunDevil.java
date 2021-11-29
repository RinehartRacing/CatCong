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
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class SunDevil extends Cactus {

	public SunDevil(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		super(node, assetManager, bulletAppState, player);
	}

	public void spawnCactus(Vector3f coor1, String name) {
		this.name = name;

		Spatial sundevil = assetManager.loadModel("assets/Models/sundevil3.obj");	//Load sundevil model
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setTexture("ColorMap", assetManager.loadTexture("assets/Models/texture_0_6195987693227547908.png"));
		//mat.setColor("Color", ColorRGBA.Red);	//Set model color to red
		sundevil.setMaterial(mat); // Use new material on this Geometry.

		cactusNode = new Node(name);
		cactusNode.setLocalTranslation(new Vector3f(coor1.getX(), coor1.getY(), coor1.getZ()));
		cactusNode.rotate(-1.5f, -1.5f, 0f);
		cactusNode.scale(0.01f, 0.01f, 0.01f);
		cactusNode.attachChild(sundevil);
		node.attachChild(cactusNode);
		CollisionShape cactusShape = CollisionShapeFactory.createMeshShape(cactusNode);	//Add collision to SunDevil
		control = new RigidBodyControl(cactusShape, 0);
		control.setKinematic(true);

		cactusNode.addControl(control);
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
	}
	@Override
	public void collision(PhysicsCollisionEvent event) {
		/*
		 * Called if player collides with SunDevil
		 */

	}

	@Override
	public void updateCactus(float tpf) {
		/*
		 * Called if we decide to move SunDevil
		 */
		
	}
}
