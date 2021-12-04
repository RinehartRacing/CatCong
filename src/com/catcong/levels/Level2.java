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
		
		fillBlocks(new Vector3f(21020, 2, 45), new Vector3f(21115, 20 ,45), "SouthernWallofBOSS_NorthernWallofMaze", graywall);
		
		///making left side of maze including area where level starts. 

		//outline first:
		
		fillBlocks(new Vector3f(21045, 2, 15), new Vector3f(21085, 20 ,15), "MazeEntrance_WestPortion_SouthWall", graywall);
		fillBlocks(new Vector3f(21085, 2, 15), new Vector3f(21085, 20 ,25), "SouthOFMaze_ByElevatorEntrance", graywall);
		fillBlocks(new Vector3f(21085, 2, 25), new Vector3f(21120, 20 ,25), "SouthOFMaze_ByElevator_StopAtElevator", graywall);
		//Entrance
		fillBlocks(new Vector3f(21120, 0, 25), new Vector3f(21125, 20, 25), "Entrance_To_LEVEL2", whitetile);
		fillBlocks(new Vector3f(21125, 2, 25), new Vector3f(21135, 20 ,25), "WestwallofEntrance_To_CactusGrill", graywall);
		fillBlocks(new Vector3f(21135, 2, 25), new Vector3f(21135, 20 ,45), "Eastern_Corridor_toCactusGrill", graywall);
		
		
		//Going into maze 
		fillBlocks(new Vector3f(21045, 2, 15), new Vector3f(21045, 20 ,17.5f), "Maze_Entrance_Easternroomwall1", graywall);
		//fillBlocks(new Vector3f(21045, 2, 27.5f), new Vector3f(21045, 20 ,30), "Maze_Entrance_Easternroomwall2", graywall);
		fillBlocks(new Vector3f(21045, 2, 35), new Vector3f(21090, 20 ,35), "Maze_EasternRoom_northwall", graywall);
		fillBlocksGhost(new Vector3f(21090, 2, 25), new Vector3f(21090, 20, 35), "HiddenwallINMaze", graybrick);
		//TODO Throw Hammer here
		
		fillBlocks(new Vector3f(21055, 2, 15), new Vector3f(21055, 20 ,35), "Maze_Easternroom_corridorTOHammer", graywall);
		
		///behind Entrance
		fillBlocks(new Vector3f(21125, 2, 30), new Vector3f(21110, 4.5f ,35), "Maze_question_mark", graywall);
		/*
		 * fillBlocks(new Vector3f(21110, 2, 35), new Vector3f(21125, 20 ,35), "Maze_Question_Mark2", graywall);
		fillBlocks(new Vector3f(21125, 2, 35), new Vector3f(21125, 20 ,30), "Maze_Question_Mark3", graywall);
		fillBlocks(new Vector3f(21125, 2, 30), new Vector3f(21110, 20 ,30), "Maze_Question_Mark4", graywall);
		 */
		
		//CactusGrill 
		fillBlocks(new Vector3f(21135, 2, 45), new Vector3f(21125, 20 ,45), "CactusGrill_SoutherWall", graywall);
		fillBlocks(new Vector3f(21125, 2, 45), new Vector3f(21125, 20 ,115), "CactusGrill_EastWall_1", graywall);
		fillBlocks(new Vector3f(21125, 2, 115), new Vector3f(21115, 20 ,115), "CactusGrill_EastWall_2", graywall);
		fillBlocks(new Vector3f(21115, 2, 115), new Vector3f(21115, 20 ,140), "CactusGrill_EastWall_3", graywall);
		fillBlocks(new Vector3f(21125, 2, 140), new Vector3f(21150, 20 ,140), "CactusGrill_NorthWall", graywall);
		
		// Room West of Boss Room
		fillBlocks(new Vector3f(21115, 2, 45), new Vector3f(21115, 20 ,65), "WestofBoss_1", graywall);
		
		
		
		//North of boss
		
		fillBlocks(new Vector3f(21075, 2, 130), new Vector3f(21075, 20 ,150), "NorthofBossRoom", graywall);
		
		//Boss Room Outline
		
		fillBlocks(new Vector3f(21095, 2, 55), new Vector3f(21095, 20 ,130), "Bossroom_Westwall", graywall);
		fillBlocks(new Vector3f(21095, 2, 130), new Vector3f(21085, 20 ,130), "Bossroom_NorthWall_1", graywall);
		//TODO chollaCactus Here
		fillBlocks(new Vector3f(21075, 2, 130), new Vector3f(21030, 20 ,130), "Bossroom_NorthWall_2", graywall);
		fillBlocks(new Vector3f(21030, 2, 130), new Vector3f(21030, 20 ,45), "Bossroom_EastWall", graywall);
		fillBlocks(new Vector3f(21030, 2, 45), new Vector3f(21115, 20 ,45), "BossRoom_SouthWall", graywall);
		fillBlocks(new Vector3f(21115, 2, 140), new Vector3f(21085, 20 ,140), "Maze_question_mark", graywall);
		
		//Raised Platform for Boss!!! 
		
		//TODO RUSTY WE NEED A BOSS :P 
		
		
		
		
		fillBlocks(new Vector3f(21075, 1.5f, 65), new Vector3f(21045, 2.5f ,115), "BossPlatformStep", whitewall);
		fillBlocks(new Vector3f(21072.5f, 2.5f, 67), new Vector3f(21047.5f, 5 ,113), "BossPlatformStep2", newWall);
		fillBlocks(new Vector3f(21070, 5, 69), new Vector3f(21050, 7 ,111), "BossPlatform", whitetile);
		
		
		
		
		//TODO Finish Jump Puzzle
		//Jump Puzzle Outline Wall South wall
		fillBlocks(new Vector3f(21020, 2, 135), new Vector3f(21000, 20 ,135), "mazeEntrance_EastPortion_WesternWall", graywall);
		
		
		
		
		
		

	}
}