/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.levels;

import java.util.ArrayList;

import com.catcong.Player;
import com.catcong.enemy.Cactus;
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
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class Level {
	protected AssetManager assetManager; // Game Engine objects
	protected Node node;
	protected BulletAppState bulletAppState;
	protected ArrayList<Cactus> cacti; // List of all cactus in Level
	protected ArrayList<Node> hammers; // List of all hammers in level
	protected Player player; // player object reference
	protected RigidBodyControl hammerControl; // hammer collision detection object
	protected String redbrick = "assets/Textures/redbrick.jpg"; // Textures
	protected String whitewall = "assets/Textures/whitewall.jpg";
	protected String whitetile = "assets/Textures/whitetile.jpg";
	protected String graywall = "assets/Textures/graywall.png";
	protected String officeceiling = "assets/Textures/officeceiling.jpg";
	protected String graybrick = "assets/Textures/graybrick.jpg";
	protected String cactuswall = "assets/Textures/cactus.jpg";
	protected String redStop = "assets/Textures/RedColour.png";
	protected String floor = "assets/Textures/floor2.png";
	protected String newWall = "assets/Textures/wall1.png";
	protected String outerwall = "assets/Textures/outerwall.png";
	protected String ecefloor = "assets/Textures/ecefloor.png";
	protected String bluebrick = "assets/Textures/bluebrick.png";
	protected String table = "assets/Textures/table.png";
	protected String wood = "assets/Textures/wood.png";
	protected String finalfloor = "assets/Textures/finalfloor.png";
	protected String greenbrick = "assets/Textures/greenbrick.png";
	
	public Level(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		this.assetManager = assetManager;
		this.node = node;
		this.bulletAppState = bulletAppState;
		this.cacti = new ArrayList<Cactus>();
		this.hammers = new ArrayList<Node>();
		this.player = player;
	}

	public void fillBlocks(Vector3f coor1, Vector3f coor2, String name, String texture) {
		/*
		 * Fills in blocks from one coordinate to another in three dimensions
		 */
		Box b = new Box(1, 1, 1); // Create unit box
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).

		mat.setTexture("ColorMap", assetManager.loadTexture(texture));
		geom.setMaterial(mat); // Use new material on this Geometry.

		Node blockNode = new Node(name);
		float xMax = Math.max(coor1.getX(), coor2.getX()); // Start by getting max and min of x,y, and z
		float xMin = Math.min(coor1.getX(), coor2.getX());
		float yMax = Math.max(coor1.getY(), coor2.getY());
		float yMin = Math.min(coor1.getY(), coor2.getY());
		float zMax = Math.max(coor1.getZ(), coor2.getZ());
		float zMin = Math.min(coor1.getZ(), coor2.getZ());
		for (float i = xMin; i <= xMax; i += 2) { // Loop through every coordinate in range
			for (float j = yMin; j <= yMax; j += 2) {
				for (float k = zMin; k <= zMax; k += 2) {
					Geometry geomCopy = geom.clone(); // Clone unit box
					geomCopy.setName("Wall");
					geomCopy.setLocalTranslation(new Vector3f(i, j, k));
					blockNode.attachChild(geomCopy);
				}
			}
		}
		CollisionShape blockShape = CollisionShapeFactory.createMeshShape(blockNode); // Add collision detection
		blockNode.addControl(new RigidBodyControl(blockShape, 0));
		node.attachChild(blockNode);
		bulletAppState.getPhysicsSpace().addAll(blockNode);

	}

	public void fillBlocksGhost(Vector3f coor1, Vector3f coor2, String name, String texture) {
		/*
		 * Same functionality as fillBLocks but has no collision detection
		 */
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).

		mat.setTexture("ColorMap", assetManager.loadTexture(texture));
		geom.setMaterial(mat); // Use new material on this Geometry.

		Node blockNode = new Node(name);
		float xMax = Math.max(coor1.getX(), coor2.getX());
		float xMin = Math.min(coor1.getX(), coor2.getX());
		float yMax = Math.max(coor1.getY(), coor2.getY());
		float yMin = Math.min(coor1.getY(), coor2.getY());
		float zMax = Math.max(coor1.getZ(), coor2.getZ());
		float zMin = Math.min(coor1.getZ(), coor2.getZ());
		for (float i = xMin; i <= xMax; i += 2) {
			for (float j = yMin; j <= yMax; j += 2) {
				for (float k = zMin; k <= zMax; k += 2) {
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
		/*
		 * Spawns and elevator at a given coordinate
		 */
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
		/*
		 * Tells every cactus in level to move
		 */
		for (int i = 0; i < cacti.size(); i++) {
			if (cacti.get(i).getCactusNode() != null) {
				cacti.get(i).updateCactusX(tpf);
				cacti.get(i).updateCactusZ(tpf);
			}
		}
	}

	public void spawnHammer(Vector3f coor, String name) {
		/*
		 * Spawns a hamer at a given coordinate
		 */
		Box b = new Box(1, 1, 1);
		Spatial hammer = assetManager.loadModel("assets/Models/neuro_hammer_obj/neuro_hammer_obj.obj");
		hammer.setLocalScale(new Vector3f(0.2f, 0.2f, 0.2f));
		hammer.rotate(-1.57f, 0, 0);
		// Geometry geom = new Geometry("hammer", b);
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setTexture("ColorMap", assetManager.loadTexture("assets/Models/neuro_hammer_obj/neuro_hammer_diffuse.jpg"));
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

	public void removeHammer(String hammerName) {
		/*
		 * Removes hammer from level
		 */
		for (int i = 0; i < hammers.size(); i++) {
			if (hammers.get(i).getName().equals(hammerName)) {
				Node hammerNode = hammers.get(i);
				hammers.remove(i);
				player.grabHammer();
				node.detachChild(hammerNode);
				hammerNode.removeControl(hammerControl);
				hammerNode.detachAllChildren();
				hammerNode = null;

			}
		}
	}

	public void removeCactus(String name) {
		/*
		 * Removes cactus from level
		 */
		for (int i = 0; i < cacti.size(); i++) {
			if (cacti.get(i).toString() == name) {
				cacti.get(i).removeCactus();
			}
		}
	}
}
