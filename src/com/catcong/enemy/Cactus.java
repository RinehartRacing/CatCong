package com.catcong.enemy;

import com.catcong.Player;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.Node;

public class Cactus implements PhysicsCollisionListener{
	protected Node node;
	protected AssetManager assetManager;
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
	public void updateCactus(float tpf) {
		
	}
	@Override
	public void collision(PhysicsCollisionEvent event) {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		return name;
	}
	public void removeCactus() {
		cactusNode.removeControl(control);
		bulletAppState.getPhysicsSpace().removeCollisionObject(control);
		cactusNode.detachAllChildren();
		node.detachChild(cactusNode);
		cactusNode = null;
	}
	public Node getCactusNode() {
		return cactusNode;
	}
}
