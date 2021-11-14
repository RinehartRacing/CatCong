/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.enemy;

import com.catcong.Player;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.Node;

public abstract class Cactus implements PhysicsCollisionListener{
	protected Node node;	//node Cactus attaches to
	protected AssetManager assetManager;	//JMonkey Engine objects
	protected BulletAppState bulletAppState;
	protected Node cactusNode;
	protected RigidBodyControl control;
	protected float speed;
	protected String name;
	protected Player player;
	public Cactus(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		this.node = node;
		this.assetManager = assetManager;
		this.bulletAppState = bulletAppState;
		this.player = player;
		cactusNode = null;
		control = null;
	}
	public abstract void updateCactus(float tpf);
	public abstract void collision(PhysicsCollisionEvent event);
	public String toString() {
		/*
		 * Override toString method
		 */
		return name;
	}
	public void removeCactus() {
		/*
		 * Removes Cactus from Game Engine
		 */
		cactusNode.removeControl(control);	//Remove collision detection
		bulletAppState.getPhysicsSpace().removeCollisionObject(control);
		cactusNode.detachAllChildren();
		node.detachChild(cactusNode);
		cactusNode = null;
	}
	public Node getCactusNode() {
		return cactusNode;
	}
}
