package com.catcong;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class Level2{
	private AssetManager assetManager;
	private Node node;
	private BulletAppState bulletAppState;
	public Level2(Node node, AssetManager assetManager, BulletAppState bulletAppState) {
		this.assetManager = assetManager;
		this.node = node;
		this.bulletAppState = bulletAppState;
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Red); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		buildFloor(geom, 50, 50, 400);
		buildElevator(new Vector3f(500, 0, 50));
		

	}

	public void buildFloor(Geometry geom, int xBox, int yBox, int xTranslate) {
		Node floorNode = new Node("floorNode1");
		for (int i = 0; i < xBox; i++) {
			for (int j = 0; j < yBox; j++) {
				Geometry geomCopy = geom.clone();
				geomCopy.setName("Box");
				geomCopy.setLocalTranslation(new Vector3f(i * 2 + xTranslate, 0, j * 2));
				floorNode.attachChild(geomCopy);
				
			}
		}
		CollisionShape floorShape = CollisionShapeFactory.createMeshShape(floorNode);
		floorNode.addControl(new RigidBodyControl(floorShape, 0));
		node.attachChild(floorNode);
		bulletAppState.getPhysicsSpace().addAll(floorNode);
	}

	public void buildElevator(Vector3f coor) {
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Elevator", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Pink); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		geom.setLocalTranslation(coor);
		Node elevatorNode2 = new Node("elevatorNode2");
		elevatorNode2.attachChild(geom);
		CollisionShape elevatorShape = CollisionShapeFactory.createMeshShape(elevatorNode2);
		elevatorNode2.addControl(new RigidBodyControl(elevatorShape, 0));
		node.attachChild(elevatorNode2);
		bulletAppState.getPhysicsSpace().addAll(elevatorNode2);
	}
	


	
}
