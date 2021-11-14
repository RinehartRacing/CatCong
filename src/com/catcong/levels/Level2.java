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

public class Level2 extends Level {
	public Level2(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		/*
		 * Build Level 2
		 */
		super(node, assetManager, bulletAppState, player);
		
		fillBlocks(new Vector3f(21400, 0, 0), new Vector3f(21500, 0, 100), "level2floor", redbrick);
		fillBlocks(new Vector3f(21502, 0, 48), new Vector3f(21502, 0, 52), "elevatorL2F0", whitetile);

	}
}