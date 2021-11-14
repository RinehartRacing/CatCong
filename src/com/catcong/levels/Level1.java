/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.levels;

import com.catcong.Player;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class Level1 extends Level {
	public Level1(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		/*
		 * Build Level 1
		 */
		super(node, assetManager, bulletAppState, player);
		fillBlocks(new Vector3f(10200, 0, 0), new Vector3f(10300, 0, 100), "level1floor", redbrick);
		fillBlocks(new Vector3f(10302, 0, 48), new Vector3f(10302, 0, 52), "elevatorL1F0", whitetile);

	}
}