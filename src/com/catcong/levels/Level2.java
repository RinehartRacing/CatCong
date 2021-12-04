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
		
		
		//Southeast beginning maze area West of Jump puzzle
		
		fillBlocks(new Vector3f(21020, 2, 15), new Vector3f(21030, 20 ,15), "mazeEntrance_EastPortion_SouthernWall", graywall);
		fillBlocks(new Vector3f(21020, 2, 15), new Vector3f(21020, 20 ,135), "mazeEntrance_EastPortion_EasternWall", graywall);
		fillBlocks(new Vector3f(21030, 2, 15), new Vector3f(21030, 20 ,35), "mazeEntrance_EastPortion_WesternWall", graywall);
		fillBlocks(new Vector3f(21030, 2, 35), new Vector3f(21020, 20 ,35), "mazeEntrance_EastPortion_NorthernWall", graywall);
		
		//Backwall of maze and also Southern Wall for Boss room
		
		fillBlocks(new Vector3f(21020, 2, 45), new Vector3f(21225, 20 ,45), "SouthernWallofBOSS_NorthernWallofMaze", graywall);
		
		///making left side of maze including area where level starts. 

		//outline first:
		
		fillBlocks(new Vector3f(21045, 2, 15), new Vector3f(21085, 20 ,15), "MazeEntrance_WestPortion_SouthWall", graywall);
		fillBlocks(new Vector3f(21085, 2, 15), new Vector3f(21085, 20 ,30), "SouthOFMaze_ByElevatorEntrance", graywall);
		fillBlocks(new Vector3f(21085, 2, 30), new Vector3f(21120, 20 ,30), "SouthOFMaze_ByElevator_StopAtElevator", graywall);
		//Elevator:
		fillBlocks(new Vector3f(21120, 0, 30), new Vector3f(21125, 0, 34), "elevatorL2F0", whitetile);
		fillBlocks(new Vector3f(21120, 2, 34), new Vector3f(21125, 20, 34), "elevatorL2F0", whitetile);
		
		fillBlocks(new Vector3f(21030, 2, 15), new Vector3f(21030, 20 ,35), "mazeEntrance_EastPortion_WesternWall", graywall);
		
		
		
		//Jump Puzzle Outline Wall South wall
		fillBlocks(new Vector3f(21020, 2, 135), new Vector3f(21000, 20 ,135), "mazeEntrance_EastPortion_WesternWall", graywall);
		
		
		
		
		
		

	}
}