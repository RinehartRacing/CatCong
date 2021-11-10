package com.catcong.levels;

import com.catcong.Player;
import com.catcong.enemy.ChollaCactus;
import com.catcong.enemy.SunDevil;
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

public class Level3 extends Level {
	public Level3(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		super(node, assetManager, bulletAppState, player);
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box", b);
		Material mat = new Material(assetManager, // Create new material and...
				"Common/MatDefs/Misc/Unshaded.j3md"); // ... specify .j3md file to use (unshaded).
		mat.setColor("Color", ColorRGBA.Blue); // Set some parameters, e.g. blue.
	geom.setMaterial(mat); // Use new material on this Geometry.
		fillBlocks(new Vector3f(31600, 0, 0), new Vector3f(31700, 0, 100), "level3floor", redbrick);
		SunDevil sd = new SunDevil(node, assetManager, bulletAppState, player);
		sd.spawnCactus(new Vector3f(31675, 2, 50), "cactusSundevil");
		cacti.add(sd);
		this.spawnHammer(new Vector3f(31625, 2, 50), "hammerL3F0");
	}
}