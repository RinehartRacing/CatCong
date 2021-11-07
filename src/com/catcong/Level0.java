package com.catcong;

import java.util.ArrayList;

import com.catcong.enemy.BarrelCactus;
import com.catcong.enemy.Cactus;
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

public class Level0{
	private AssetManager assetManager;
	private Node node;
	private BulletAppState bulletAppState;
	private ArrayList<Cactus> cacti;
	private ArrayList<Node> hammers;
	private Player player;
	private RigidBodyControl hammerControl;

	public Level0(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		this.assetManager = assetManager;
		this.node = node;
		this.bulletAppState = bulletAppState;
		this.cacti = new ArrayList<Cactus>();
		this.hammers = new ArrayList<Node>();
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Red); // Set some parameters, e.g. blue.
		geom.setMaterial(mat); // Use new material on this Geometry.
		String redbrick = "assets/Textures/redbrick.jpg";
		String whitewall = "assets/Textures/whitewall.jpg";
		String whitetile = "assets/Textures/whitetile.jpg";
		String graywall = "assets/Textures/graywall.png";
		String officeceiling = "assets/Textures/officeceiling.jpg";
		fillBlocks(new Vector3f(0, 0, 0), new Vector3f(100, 0, 26), "floor2", redbrick);
		fillBlocks(new Vector3f(0, 2, 0), new Vector3f(100, 40, 0), "LeftWall", graywall);
		fillBlocks(new Vector3f(0, 2, 26), new Vector3f(100, 40, 26), "RightWall", graywall);
		fillBlocks(new Vector3f(102, 0, 12), new Vector3f(102, 0, 14), "elevatorL0F0", whitetile);
		fillBlocks(new Vector3f(102, 22, 12), new Vector3f(102, 22, 14), "floor3spawn", whitetile);
		fillBlocks(new Vector3f(0, 20, 2), new Vector3f(100, 20, 24), "floor2ceiling", officeceiling);
		fillBlocks(new Vector3f(0, 22, 2), new Vector3f(100, 22, 24), "floor3", redbrick);
		fillBlocks(new Vector3f(102, 0, 0), new Vector3f(102, 40, 10), "BackWallLeft", graywall);
		fillBlocks(new Vector3f(102, 0, 16), new Vector3f(102, 40, 26), "BackWallRight", graywall);
		fillBlocks(new Vector3f(104, 0, 10), new Vector3f(104, 40, 16), "BackWallMiddle", whitewall);
		SaguaroCactus sc1 = new SaguaroCactus(node, assetManager, bulletAppState, player);
		sc1.spawnCactus(new Vector3f(25, 2, 25), new Vector3f(25, 2, 0), "cactusS1", ColorRGBA.Green);
		cacti.add(sc1);
		
		BarrelCactus bc1 = new BarrelCactus(node, assetManager, bulletAppState, player);
		bc1.spawnCactus(new Vector3f(100, 24, 10), new Vector3f(0, 24, 10), "cactusB1", ColorRGBA.Green);
		cacti.add(bc1);
		
		BarrelCactus bc2 = new BarrelCactus(node, assetManager, bulletAppState, player);
		bc2.spawnCactus(new Vector3f(100, 24, 15), new Vector3f(0, 24, 15), "cactusB2", ColorRGBA.Green);
		cacti.add(bc2);
		
		BarrelCactus bc3 = new BarrelCactus(node, assetManager, bulletAppState, player);
		bc3.spawnCactus(new Vector3f(100, 24, 19), new Vector3f(0, 24, 19), "cactusB3", ColorRGBA.Green);
		cacti.add(bc3);
		
		spawnHammer(new Vector3f(40, 2, 10), "hammerL0F0");

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
		Node hammerNode = hammers.get(0);
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
