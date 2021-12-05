/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.levels;

import com.catcong.Player;
import com.catcong.enemy.BarrelCactus;
import com.catcong.enemy.ChollaCactus;
import com.catcong.enemy.SaguaroCactus;
import com.catcong.enemy.SunDevil;
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
		
	
		fillBlocks(new Vector3f(21000, 0, 0), new Vector3f(21150, 0, 150), "level2floor", finalfloor);
		// Ceiling. To see it helps FPS.. it does not.. rofl
		
		fillBlocksGhost(new Vector3f(21000, 31, 0), new Vector3f(21150, 31, 150), "level2floor", officeceiling);
		//Walls
		
		//South
		fillBlocks(new Vector3f(21000, 2, 0), new Vector3f(21100, 30 ,0), "southernWallL21", wood);
		fillBlocks(new Vector3f(21100, 2, 0), new Vector3f(21100, 30 ,15), "southernWallL22", wood);
		fillBlocks(new Vector3f(21100, 2, 15), new Vector3f(21150, 30 ,15), "southernWallL23", wood);
	
		// West Wall
		fillBlocks(new Vector3f(21150, 2, 15), new Vector3f(21150, 30 ,150), "WestWALL", wood);
		
		//North Wall 
		fillBlocks(new Vector3f(21000, 2, 150), new Vector3f(21150, 30 ,150), "NorthWall", wood);
		
		//East Wall: 
		
		fillBlocks(new Vector3f(21000, 2, 0), new Vector3f(21000, 30 ,150), "EastWall", wood);
		
		
		//Southeast beginning maze area West of Jump puzzle
		
		fillBlocks(new Vector3f(21020, 2, 15), new Vector3f(21030, 20 ,15), "mazeEntrance_EastPortion_SouthernWall", wood);
		fillBlocks(new Vector3f(21020, 2, 15), new Vector3f(21020, 20 ,135), "mazeEntrance_EastPortion_EasternWall", wood);
		fillBlocks(new Vector3f(21030, 2, 15), new Vector3f(21030, 20 ,35), "mazeEntrance_EastPortion_WesternWall", wood);
		fillBlocks(new Vector3f(21030, 2, 35), new Vector3f(21020, 20 ,35), "mazeEntrance_EastPortion_NorthernWall", wood);
		
		//Backwall of maze and also Southern Wall for Boss room
		
		fillBlocks(new Vector3f(21020, 2, 45), new Vector3f(21115, 20 ,45), "SouthernWallofBOSS_NorthernWallofMaze", wood);
		
		///making left side of maze including area where level starts. 

		//outline first:
		
		fillBlocks(new Vector3f(21045, 2, 15), new Vector3f(21085, 20 ,15), "MazeEntrance_WestPortion_SouthWall", wood);
		fillBlocks(new Vector3f(21085, 2, 15), new Vector3f(21085, 20 ,25), "SouthOFMaze_ByElevatorEntrance", wood);
		fillBlocks(new Vector3f(21085, 2, 25), new Vector3f(21120, 20 ,25), "SouthOFMaze_ByElevator_StopAtElevator", wood);
		//Entrance
		fillBlocks(new Vector3f(21120, 0, 25), new Vector3f(21125, 20, 25), "Entrance_To_LEVEL2", whitetile);
		fillBlocks(new Vector3f(21125, 2, 25), new Vector3f(21135, 20 ,25), "WestwallofEntrance_To_CactusGrill", wood);
		fillBlocks(new Vector3f(21135, 2, 25), new Vector3f(21135, 20 ,45), "Eastern_Corridor_toCactusGrill", wood);
		
		
		//Going into maze 
		fillBlocks(new Vector3f(21045, 2, 15), new Vector3f(21045, 20 ,17.5f), "Maze_Entrance_Easternroomwall1", wood);
		//fillBlocks(new Vector3f(21045, 2, 27.5f), new Vector3f(21045, 20 ,30), "Maze_Entrance_Easternroomwall2", wood);
		fillBlocks(new Vector3f(21045, 2, 35), new Vector3f(21090, 20 ,35), "Maze_EasternRoom_northwall", wood);
		fillBlocksGhost(new Vector3f(21090, 2, 25), new Vector3f(21090, 20, 35), "HiddenwallINMaze", graybrick);
		//TODO Throw Hammer here
		spawnHammer(new Vector3f(21065, 3, 25), "hammer1L2F0");

		fillBlocks(new Vector3f(21055, 2, 15), new Vector3f(21055, 20 ,35), "Maze_Easternroom_corridorTOHammer", wood);
		
		///behind Entrance
		fillBlocks(new Vector3f(21125, 2, 30), new Vector3f(21110, 4.5f ,35), "Maze_question_mark", wood);
		/*
		 * fillBlocks(new Vector3f(21110, 2, 35), new Vector3f(21125, 20 ,35), "Maze_Question_Mark2", wood);
		fillBlocks(new Vector3f(21125, 2, 35), new Vector3f(21125, 20 ,30), "Maze_Question_Mark3", wood);
		fillBlocks(new Vector3f(21125, 2, 30), new Vector3f(21110, 20 ,30), "Maze_Question_Mark4", wood);
		 */
		
		//CactusGrill 
		fillBlocks(new Vector3f(21135, 2, 45), new Vector3f(21125, 20 ,45), "CactusGrill_SoutherWall", wood);
		fillBlocks(new Vector3f(21125, 2, 45), new Vector3f(21125, 20 ,115), "CactusGrill_EastWall_1", wood);
		fillBlocks(new Vector3f(21125, 2, 115), new Vector3f(21115, 20 ,115), "CactusGrill_EastWall_2", wood);
		fillBlocks(new Vector3f(21115, 2, 115), new Vector3f(21115, 20 ,140), "CactusGrill_EastWall_3", wood);
		fillBlocks(new Vector3f(21125, 2, 140), new Vector3f(21150, 20 ,140), "CactusGrill_NorthWall", wood);
		
		fillBlocks(new Vector3f(21149, 2, 130), new Vector3f(21139, 3 ,139), "Hammer Platform", table);
		
		spawnHammer(new Vector3f(21141, 4, 136), "hammer6L2F0");
		spawnHammer(new Vector3f(21145, 4, 136), "hammer7L2F0");
		
		spawnHammer(new Vector3f(21145, 2, 145), "hammer5L2F0");
		// Room West of Boss Room
		
		
		SaguaroCactus scL2F1C9 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C9.spawnCactus(new Vector3f(21120, 3, 96), new Vector3f(21097, 3, 96), "cactus_WeLoveHaseeb9");
		cacti.add(scL2F1C9);
		
		
		fillBlocks(new Vector3f(21115, 2, 45), new Vector3f(21115, 20 ,65), "WestofBoss_1", wood);
		
		SaguaroCactus scL2F1C1 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C1.spawnCactus(new Vector3f(21122, 3, 48), new Vector3f(21148, 3, 48), "cactus_WeLoveHaseeb1");
		cacti.add(scL2F1C1);

		SaguaroCactus scL2F1C2 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C2.spawnCactus(new Vector3f(21122, 3, 58), new Vector3f(21148, 3, 58), "cactus_WeLoveHaseeb2");
		cacti.add(scL2F1C2);
		
		SaguaroCactus scL2F1C3= new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C3.spawnCactus(new Vector3f(21122, 3, 68), new Vector3f(21148, 3, 68), "cactus_WeLoveHaseeb3");
		cacti.add(scL2F1C3);
		
		SaguaroCactus scL2F1C4 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C4.spawnCactus(new Vector3f(21122, 3, 78), new Vector3f(21148, 3, 78), "cactus_WeLoveHaseeb4");
		cacti.add(scL2F1C4);
		
		SaguaroCactus scL2F1C5 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C5.spawnCactus(new Vector3f(21122, 3, 88), new Vector3f(21148, 3, 88), "cactus_WeLoveHaseeb5");
		cacti.add(scL2F1C5);
		
		SaguaroCactus scL2F1C6 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C6.spawnCactus(new Vector3f(21122, 3, 98), new Vector3f(21148, 3, 98), "cactus_WeLoveHaseeb6");
		cacti.add(scL2F1C6);
		
		SaguaroCactus scL2F1C7 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C7.spawnCactus(new Vector3f(21122, 3, 108), new Vector3f(21148, 3, 108), "cactus_WeLoveHaseeb7");
		cacti.add(scL2F1C7);
		
		SaguaroCactus scL2F1C8 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL2F1C8.spawnCactus(new Vector3f(21122, 3, 118), new Vector3f(21148, 3, 118), "cactus_WeLoveHaseeb8");
		cacti.add(scL2F1C8);
		
		
		
		BarrelCactus bcL2F1c1 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bcL2F1c1.spawnCactus(new Vector3f(21019, 3, 30), new Vector3f(21002,3, 30), "cactus_barrel_weLoveHaseeb1");
		cacti.add(bcL2F1c1);
		
		BarrelCactus bcL2F1c2 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bcL2F1c2.spawnCactus(new Vector3f(21019, 3, 70), new Vector3f(21002,3, 70), "cactus_barrel_weLoveHaseeb2");
		cacti.add(bcL2F1c2);
		
		BarrelCactus bcL2F1c3 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bcL2F1c3.spawnCactus(new Vector3f(21019, 3, 110), new Vector3f(21002,3, 110), "cactus_barrel_weLoveHaseeb3");
		cacti.add(bcL2F1c3);
		
		BarrelCactus bcL2F1c4 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bcL2F1c4.spawnCactus(new Vector3f(21145, 3, 35), new Vector3f(21145,3, 127), "cactus_barrel_weLoveHasseb4");
		cacti.add(bcL2F1c4);
		
		BarrelCactus bcL2F1c5 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bcL2F1c5.spawnCactus(new Vector3f(21140, 3, 35), new Vector3f(21140,3, 127), "cactus_barrel_weLoveHasseb5");
		cacti.add(bcL2F1c5);
		
		BarrelCactus bcL2F1c6 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bcL2F1c6.spawnCactus(new Vector3f(21132, 3, 42), new Vector3f(21022,3, 42), "cactus_barrel_weLoveHasseb6");
		cacti.add(bcL2F1c6);
		
		BarrelCactus bcL2F1c7 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bcL2F1c7.spawnCactus(new Vector3f(21034, 3, 42), new Vector3f(21034,3, 15), "cactus_barrel_weLoveHasseb7");
		cacti.add(bcL2F1c7);
		
		ChollaCactus ccL2F1C1 = new ChollaCactus(node, assetManager, bulletAppState, player);
		ccL2F1C1.spawnCactus(new Vector3f(21080, 2,130 ), "cactusL1F1C1", 'z');
		cacti.add(ccL2F1C1);












		
		//North of boss
		
		fillBlocks(new Vector3f(21075, 2, 130), new Vector3f(21075, 20 ,150), "NorthofBossRoom", wood);
		
		//Boss Room Outline
		
		fillBlocks(new Vector3f(21095, 2, 55), new Vector3f(21095, 20 ,130), "Bossroom_Westwall", wood);
		fillBlocks(new Vector3f(21095, 2, 130), new Vector3f(21085, 20 ,130), "Bossroom_NorthWall_1", wood);
		//TODO chollaCactus Here
		fillBlocks(new Vector3f(21075, 2, 130), new Vector3f(21030, 20 ,130), "Bossroom_NorthWall_2", wood);
		fillBlocks(new Vector3f(21030, 2, 130), new Vector3f(21030, 20 ,45), "Bossroom_EastWall", wood);
		fillBlocks(new Vector3f(21030, 2, 45), new Vector3f(21115, 20 ,45), "BossRoom_SouthWall", wood);
		fillBlocks(new Vector3f(21115, 2, 140), new Vector3f(21085, 20 ,140), "Maze_question_mark", wood);
		
		//Raised Platform for Boss!!! 
		
		//TODO RUSTY WE NEED A BOSS :P  YOU GOT IT BOSS
		SunDevil sd = new SunDevil(node, assetManager, bulletAppState, player);
		sd.spawnCactus(new Vector3f(21060, 8, 90), "cactusSundevil");
		cacti.add(sd);
		
		BarrelCactus bb1 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bb1.spawnCactus(new Vector3f(21089, 3, 125), new Vector3f(21089,3, 46), "cactus_BigBootieMix1");
		cacti.add(bb1);
		
		BarrelCactus bb2 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bb2.spawnCactus(new Vector3f(21085, 3, 125), new Vector3f(21085,3, 46), "cactus_BigBootieMix2");
		cacti.add(bb2);
		
		BarrelCactus bb3 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bb3.spawnCactus(new Vector3f(21076, 3, 125), new Vector3f(21076,3, 46), "cactus_BigBootieMix3");
		cacti.add(bb3);
		
		BarrelCactus bb4 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bb4.spawnCactus(new Vector3f(21089, 3, 57.5f), new Vector3f(21032,3, 57.5f), "cactus_BigBootieMix4");
		cacti.add(bb4);
		
		BarrelCactus bb5 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bb5.spawnCactus(new Vector3f(21089, 3, 52.5f), new Vector3f(21032,3, 52.5f), "cactus_BigBootieMix5");
		cacti.add(bb5);
		
		BarrelCactus bb6 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bb6.spawnCactus(new Vector3f(21042, 3, 129), new Vector3f(21042,3, 47), "cactus_BigBootieMix6");
		cacti.add(bb6);
		
		BarrelCactus bb7 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bb7.spawnCactus(new Vector3f(21037, 3, 129), new Vector3f(21037,3, 47), "cactus_BigBootieMix7");
		cacti.add(bb7);
		
		
		fillBlocks(new Vector3f(21075, 1.5f, 65), new Vector3f(21045, 2.5f ,115), "BossPlatformStep", whitewall);
		fillBlocks(new Vector3f(21072.5f, 2.5f, 67), new Vector3f(21047.5f, 5 ,113), "BossPlatformStep2", newWall);
		fillBlocks(new Vector3f(21070, 5, 69), new Vector3f(21050, 7 ,111), "BossPlatform", whitetile);
		
		
		
		
		//TODO Finish Jump Puzzle
		//Jump Puzzle Outline Wall South wall
		fillBlocks(new Vector3f(21020, 2, 135), new Vector3f(21000, 20 ,135), "mazeEntrance_EastPortion_WesternWall", wood);
		
		//Jump Platforms
		fillBlocksGhost(new Vector3f(21002.5f, 12, 25), new Vector3f(21007.5f, 15 ,35), "Jump_puzzle_1R", outerwall);
		fillBlocks(new Vector3f(21002.5f, 12, 45), new Vector3f(21007.5f, 15 ,55), "Jump_puzzle_2R", outerwall);
		fillBlocks(new Vector3f(21002.5f, 12, 65), new Vector3f(21007.5f, 15 ,75), "Jump_puzzle_3R", outerwall);
		fillBlocksGhost(new Vector3f(21002.5f, 12, 85), new Vector3f(21007.5f, 15 ,95), "Jump_puzzle_4R", outerwall);
		fillBlocks(new Vector3f(21002.5f, 12, 105), new Vector3f(21007.5f, 15 ,115), "Jump_puzzle_4R", outerwall);
		
		fillBlocks(new Vector3f(21013.5f, 12, 25), new Vector3f(21017.5f, 15 ,35), "Jump_puzzle_1L", outerwall);
		fillBlocksGhost(new Vector3f(21013.5f, 12, 45), new Vector3f(21017.5f, 15 ,55), "Jump_puzzle_2L", outerwall);
		fillBlocksGhost(new Vector3f(21013.5f, 12, 65), new Vector3f(21017.5f, 15 ,75), "Jump_puzzle_3L", outerwall);
		fillBlocks(new Vector3f(21013.5f, 12, 85), new Vector3f(21017.5f, 15 ,95), "Jump_puzzle_4L", outerwall);
		fillBlocksGhost(new Vector3f(21013.5f, 12, 105), new Vector3f(21017.5f, 15 ,115), "Jump_puzzle_5L", outerwall);
		
		//Need a Hammer
		spawnHammer(new Vector3f(21005, 16, 130), "hammer2L2F0");
		spawnHammer(new Vector3f(21010, 16, 130), "hammer3L2F0");
		spawnHammer(new Vector3f(21015, 16, 130), "hammer4L2F0");
		
		fillBlocks(new Vector3f(21018, 12, 125), new Vector3f(21001, 15 ,135), "HammerPlatform", outerwall);
		
		//Steps up to Jump Platform
		fillBlocks(new Vector3f(21030, 2, 0), new Vector3f(21025, 5 ,7.5f), "Jump_Step_1", outerwall);
		fillBlocks(new Vector3f(21025, 5, 0), new Vector3f(21020, 10 ,7.5f), "Jump_Step_2", table);
		fillBlocks(new Vector3f(21020, 12, 0), new Vector3f(21000, 15 ,15), "Jump_Step_3", outerwall);
		
		
		
		
		

	}
}