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
		
		//TODO Fill Elevator for level 3: 
		fillBlocks(new Vector3f(21502, 0, 48), new Vector3f(21502, 0, 52), "elevatorL2F0", whitetile);
		
		// setting up base platform. IE The floor
		
	
		fillBlocks(new Vector3f(21000, 0, 0), new Vector3f(21150, 0, 150), "level2floor", redbrick);
		// Ceiling. To see it helps FPS.. it does not.. rofl
		
		fillBlocks(new Vector3f(21000, 21, 0), new Vector3f(21150, 21, 150), "level2floor", officeceiling);
		//Walls
		
		//South
		fillBlocks(new Vector3f(21000, 2, 0), new Vector3f(21100, 20 ,0), "southernWallL21", graywall);
		fillBlocks(new Vector3f(21100, 2, 0), new Vector3f(21100, 20 ,15), "southernWallL22", graywall);
		fillBlocks(new Vector3f(21100, 2, 15), new Vector3f(21150, 20 ,15), "southernWallL23", graywall);
	
		// West Wall
		fillBlocks(new Vector3f(21150, 2, 15), new Vector3f(21150, 20 ,150), "WestWALL", graywall);
		
		//North Wall 
		fillBlocks(new Vector3f(21000, 2, 150), new Vector3f(21150, 20 ,150), "NorthWall", graywall);
		
		//East Wall: 
		
		fillBlocks(new Vector3f(21000, 2, 0), new Vector3f(21000, 20 ,150), "EastWall", graywall);
		
		
		
		
		

	}
}