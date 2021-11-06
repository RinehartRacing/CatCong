package com.catcong.enemy;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.Node;

public class Cactus {
	protected Node node;
	protected AssetManager assetManager;
	protected BulletAppState bulletAppState;
	protected Node cactusNode;
	protected RigidBodyControl control;
	public Cactus(Node node, AssetManager assetManager, BulletAppState bulletAppState) {
		this.node = node;
		this.assetManager = assetManager;
		this.bulletAppState = bulletAppState;
		cactusNode = null;
		control = null;
	}
}
