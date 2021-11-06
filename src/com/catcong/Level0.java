package com.catcong;

import com.catcong.enemy.SaguaroCactus;
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

public class Level0{
	private AssetManager assetManager;
	private Node node;
	private BulletAppState bulletAppState;


	public Level0(Node node, AssetManager assetManager, BulletAppState bulletAppState) {
		this.assetManager = assetManager;
		this.node = node;
		this.bulletAppState = bulletAppState;
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Red); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		fillBlocks(new Vector3f(0, 0, 0), new Vector3f(100, 0, 26), "floor2", ColorRGBA.Red);
		fillBlocks(new Vector3f(0, 2, 0), new Vector3f(100, 40, 0), "LeftWall", ColorRGBA.Black);
		fillBlocks(new Vector3f(0, 2, 26), new Vector3f(100, 40, 26), "RightWall", ColorRGBA.Black);
		fillBlocks(new Vector3f(102, 0, 12), new Vector3f(102, 0, 14), "elevatorL0F0", ColorRGBA.Pink);
		fillBlocks(new Vector3f(102, 22, 12), new Vector3f(102, 22, 14), "floor3spawn", ColorRGBA.Pink);
		fillBlocks(new Vector3f(0, 22, 2), new Vector3f(100, 22, 24), "floor3", ColorRGBA.Red);
		fillBlocks(new Vector3f(102, 0, 0), new Vector3f(102, 40, 10), "BackWallLeft", ColorRGBA.Black);
		fillBlocks(new Vector3f(102, 0, 16), new Vector3f(102, 40, 26), "BackWallRight", ColorRGBA.Black);
		fillBlocks(new Vector3f(104, 0, 10), new Vector3f(104, 40, 16), "BackWallMiddle", ColorRGBA.Brown);
		SaguaroCactus sc1 = new SaguaroCactus(node, assetManager, bulletAppState);
		sc1.spawnCactus(new Vector3f(25, 2, 25), new Vector3f(25, 2, 0), "sc1", ColorRGBA.Green);
		

	}

	
	public void fillBlocks(Vector3f coor1, Vector3f coor2, String name, ColorRGBA color) {
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", color); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		
		Node blockNode = new Node(name);
		
		for(float i = coor1.getX(); i <= coor2.getX(); i++) {
			for(float j = coor1.getY(); j <= coor2.getY(); j++) {
				for(float k = coor1.getZ(); k <= coor2.getZ(); k++) {
					Geometry geomCopy = geom.clone();
					geomCopy.setName("Wall");
					geomCopy.setLocalTranslation(new Vector3f(i, j, k));
					blockNode.attachChild(geomCopy);
				}
			}
		}
		CollisionShape blockShape = CollisionShapeFactory.createMeshShape(blockNode);
		blockNode.addControl(new RigidBodyControl(blockShape, 0));
		node.attachChild(blockNode);
		bulletAppState.getPhysicsSpace().addAll(blockNode);
		
	}
	public void buildElevator(Vector3f coor, String name) {
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Elevator", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Pink); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		geom.setLocalTranslation(coor);
		Node elevatorNode = new Node(name);
		elevatorNode.attachChild(geom);
		CollisionShape elevatorShape = CollisionShapeFactory.createMeshShape(elevatorNode);
		elevatorNode.addControl(new RigidBodyControl(elevatorShape, 0));
		node.attachChild(elevatorNode);
		bulletAppState.getPhysicsSpace().addAll(elevatorNode);
	}
	
	/*public void spawnCactus() {
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Cactus", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Green); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		
		cactusNode = new Node("cactusNode");
		cactusNode.setLocalTranslation(new Vector3f(25, 2, 25));
		cactusNode.attachChild(geom);
		node.attachChild(cactusNode);
		CollisionShape cactusShape = CollisionShapeFactory.createMeshShape(cactusNode);
		control = new RigidBodyControl(cactusShape, 0);
		control.setKinematic(true);
		cactusNode.addControl(control);
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
	}*/
	/*public Node getCactusNode() {
		return cactusNode;
	}
	public void removeCactus() {
		cactusNode.removeControl(control);
	}*/
}
