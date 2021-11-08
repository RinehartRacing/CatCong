package com.catcong.levels;

import java.util.ArrayList;

import com.catcong.Player;
import com.catcong.enemy.BarrelCactus;
import com.catcong.enemy.Cactus;
import com.catcong.enemy.ChollaCactus;
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
import com.jme3.math.Matrix3f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class Level{
	protected AssetManager assetManager;
	protected Node node;
	protected BulletAppState bulletAppState;
	protected ArrayList<Cactus> cacti;
	protected ArrayList<Node> hammers;
	protected Player player;
	protected RigidBodyControl hammerControl;
	protected String redbrick = "assets/Textures/redbrick.jpg";
	protected String whitewall = "assets/Textures/whitewall.jpg";
	protected String whitetile = "assets/Textures/whitetile.jpg";
	protected String graywall = "assets/Textures/graywall.png";
	protected String officeceiling = "assets/Textures/officeceiling.jpg";
	protected String graybrick = "assets/Textures/graybrick.jpg";
	public Level(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		this.assetManager = assetManager;
		this.node = node;
		this.bulletAppState = bulletAppState;
		this.cacti = new ArrayList<Cactus>();
		this.hammers = new ArrayList<Node>();
	}
	public void fillBlocks(Vector3f coor1, Vector3f coor2, String name, String texture) {
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).

		mat.setTexture("ColorMap",
	            assetManager.loadTexture(texture));
		geom.setMaterial(mat); // Use new material on this Geometry.
		
		Node blockNode = new Node(name);
		float xMax = Math.max(coor1.getX(), coor2.getX());
		float xMin = Math.min(coor1.getX(), coor2.getX());
		float yMax = Math.max(coor1.getY(), coor2.getY());
		float yMin = Math.min(coor1.getY(), coor2.getY());
		float zMax = Math.max(coor1.getZ(), coor2.getZ());
		float zMin = Math.min(coor1.getZ(), coor2.getZ());
		for(float i = xMin; i <= xMax; i++) {
			for(float j = yMin; j <= yMax; j++) {
				for(float k = zMin; k <= zMax; k++) {
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
	public void fillBlocksGhost(Vector3f coor1, Vector3f coor2, String name, String texture) {
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).

		mat.setTexture("ColorMap",
	            assetManager.loadTexture(texture));
		geom.setMaterial(mat); // Use new material on this Geometry.
		
		Node blockNode = new Node(name);
		float xMax = Math.max(coor1.getX(), coor2.getX());
		float xMin = Math.min(coor1.getX(), coor2.getX());
		float yMax = Math.max(coor1.getY(), coor2.getY());
		float yMin = Math.min(coor1.getY(), coor2.getY());
		float zMax = Math.max(coor1.getZ(), coor2.getZ());
		float zMin = Math.min(coor1.getZ(), coor2.getZ());
		for(float i = xMin; i <= xMax; i++) {
			for(float j = yMin; j <= yMax; j++) {
				for(float k = zMin; k <= zMax; k++) {
					Geometry geomCopy = geom.clone();
					geomCopy.setName("Wall");
					geomCopy.setLocalTranslation(new Vector3f(i, j, k));
					blockNode.attachChild(geomCopy);
				}
			}
		}
		node.attachChild(blockNode);
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
	public void updateCacti(float tpf) {
		for(int i = 0; i < cacti.size(); i++) {
			if(cacti.get(i).getCactusNode() != null) {
				cacti.get(i).updateCactus(tpf);
			}
		}
	}
	
	public void spawnHammer(Vector3f coor, String name) {
		Box b = new Box(1, 1, 1);
		Spatial hammer = assetManager.loadModel("assets/Models/neuro_hammer_obj/neuro_hammer_obj.obj");
		hammer.setLocalScale(new Vector3f(0.2f, 0.2f, 0.2f));
		hammer.rotate(-1.57f, 0, 0);
		//Geometry geom = new Geometry("hammer", b);
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setTexture("ColorMap",
	            assetManager.loadTexture("assets/Models/neuro_hammer_obj/neuro_hammer_diffuse.jpg"));
		mat.setColor("Color", ColorRGBA.Gray);
		hammer.setMaterial(mat);
		hammer.setLocalTranslation(new Vector3f(coor.getX(), coor.getY() + 1.5f, coor.getZ()));
		
		Node hammerNode = new Node(name);
		hammerNode.attachChild(hammer);
		CollisionShape hammerShape = CollisionShapeFactory.createMeshShape(hammerNode);
		hammerControl = new RigidBodyControl(hammerShape, 0);
		hammerNode.addControl(hammerControl);
		node.attachChild(hammerNode);
		bulletAppState.getPhysicsSpace().addAll(hammerNode);
		hammers.add(hammerNode);
	}
	
	public void removeHammer(int hammer) {
		Node hammerNode = hammers.get(hammer);
		node.detachChild(hammerNode);
		hammerNode.removeControl(hammerControl);
	}
	
	public void removeCactus(String name) {
		for(int i = 0; i < cacti.size(); i++) {
			if(cacti.get(i).toString() == name) {
				cacti.get(i).removeCactus();
			}
		}
	}
}
