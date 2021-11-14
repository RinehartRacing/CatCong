/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.levels;

import com.catcong.Player;
import com.catcong.enemy.SunDevil;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class Level3 extends Level {
	public Level3(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		/*
		 * Build Level 3
		 */
		super(node, assetManager, bulletAppState, player);
		
		fillBlocks(new Vector3f(31600, 0, 0), new Vector3f(31700, 0, 100), "level3floor", redbrick);
		SunDevil sd = new SunDevil(node, assetManager, bulletAppState, player);
		sd.spawnCactus(new Vector3f(31675, 2, 50), "cactusSundevil");
		cacti.add(sd);
		this.spawnHammer(new Vector3f(31625, 2, 50), "hammerL3F0");
	}
}