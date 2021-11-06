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
import com.jme3.scene.shape.Box;

public class SaguaroCactus extends Cactus {
	private Vector3f startCoord;
	private Vector3f endCoord;
	public SaguaroCactus(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		super(node, assetManager, bulletAppState, player);
		speed = 16.0f;
	}

	public void spawnCactus(Vector3f coor1, Vector3f coor2, String name, ColorRGBA color) {
		this.name = name;
		this.startCoord = coor1;
		this.endCoord = coor2;
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

	public void updateCactus(float tpf) {

		if (cactusNode != null) {
			float zMov = speed * tpf;

			if (((cactusNode.getWorldTranslation().getZ() >= this.startCoord.getZ()) && (speed > 0))
					|| ((cactusNode.getWorldTranslation().getZ() < this.endCoord.getZ()) && (speed < 0))) {
				speed *= -1;
			}
			cactusNode.move(0, 0, zMov);
		}
		bulletAppState.getPhysicsSpace().addAll(cactusNode);
		bulletAppState.getPhysicsSpace().addCollisionListener(this);
	}

	@Override
	public void collision(PhysicsCollisionEvent event) {
		if (event.getNodeB() != null) {
			if (this.name.equals(event.getNodeB().getName())) {
				System.out.println("Hit cactus");
				cactusNode.removeControl(control);
				node.detachChild(cactusNode);
				this.player.loseLife();
			}
		}

	}
}
