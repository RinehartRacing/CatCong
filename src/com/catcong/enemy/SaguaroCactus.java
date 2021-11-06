package com.catcong.enemy;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class SaguaroCactus extends Cactus{
	public SaguaroCactus(Node node, AssetManager assetManager, BulletAppState bulletAppState) {
		super(node, assetManager, bulletAppState);
	}
	public void spawnCactus(Vector3f coor1, Vector3f coor2, String name, ColorRGBA color) {
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Cactus", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Green); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		
		cactusNode = new Node(name);
		cactusNode.setLocalTranslation(coor1);
		cactusNode.attachChild(geom);
		node.attachChild(cactusNode);
		CollisionShape cactusShape = CollisionShapeFactory.createMeshShape(cactusNode);
		control = new RigidBodyControl(cactusShape, 0);
		control.setKinematic(true);
		cactusNode.addControl(control);
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
	}

}
