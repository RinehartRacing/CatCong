/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.levels;

import com.catcong.Player;
import com.catcong.enemy.BarrelCactus;
import com.catcong.enemy.ChollaCactus;
import com.catcong.enemy.SaguaroCactus;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class Level1 extends Level {
	public Level1(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		/*
		 * Build Level 1
		 */
		
		/* TODO
		 * Just needs Texture and Cactus. 
		 * 
		 * Chris. 
		 * 
		 * 
		 */
		super(node, assetManager, bulletAppState, player);
		fillBlocks(new Vector3f(10200, 0, 0), new Vector3f(10350, 0, 150), "level1floor", bluebrick);
		fillBlocksGhost(new Vector3f(10200, 22, 0), new Vector3f(10350, 22, 150), "level2roof", greenbrick);
		
		//fillBlocks(new Vector3f(0, 2, 26), new Vector3f(100, 60, 26), "RightWall", graywall); From level 1 
		//Eastern Wall. 
		fillBlocks(new Vector3f(10200, 2, 150), new Vector3f(10350, 20 ,150), "RightWall", outerwall);
		
		//Southern Wall.
		fillBlocks(new Vector3f(10200, 2, 0), new Vector3f(10200, 20 ,150), "southernWall", outerwall);
		
		//Western Wall
		fillBlocks(new Vector3f(10200, 2, 0), new Vector3f(10350, 20 , 0), "WesternWall", outerwall);
		
		//NorthernWall
		fillBlocks(new Vector3f(10350, 2, 0), new Vector3f(10350, 20 , 150), "NorthernWall", outerwall);
		
		//Building Stairwell near entrance to level. 
		fillBlocks(new Vector3f(10200, 2, 130), new Vector3f(10215, 20 ,130), "FirstRightStairwell", outerwall);
		fillBlocks(new Vector3f(10200, 2, 115), new Vector3f(10215, 20 ,115), "FirstLeftStairwell", outerwall);
		fillBlocks(new Vector3f(10215, 2, 115), new Vector3f(10215, 20 ,130), "Front of Stairwell", outerwall);
		
		//building wall from entrance to student union to end of level. 
		fillBlocks(new Vector3f(10230, 2, 115), new Vector3f(10340, 20 ,115), "backwallofArizonaMarket", outerwall);
		// Arizona Market
		fillBlocks(new Vector3f(10245, 2, 115), new Vector3f(10245, 20 ,130), "ArizonaMarketDisplaceZ", outerwall);
		fillBlocks(new Vector3f(10245, 2, 130), new Vector3f(10250, 20 ,130), "ArizonaMarketDisplaceX", outerwall);
		
		fillBlocks(new Vector3f(10250, 2, 130), new Vector3f(10270, 20 ,115), "DiagonalArizonaMarket", outerwall);
		
		//hallway by restroom and Theatre to secret wall
		fillBlocks(new Vector3f(10230, 2, 115), new Vector3f(10230, 20 ,90), "HallwayRightTheatre", newWall);
		fillBlocks(new Vector3f(10215, 2, 115), new Vector3f(10215, 20 , 100), "HallwayLeftTheatre", newWall);
		//Secret wall. 
		//fillBlocksGhost(new Vector3f(42, 22, 0), new Vector3f(58, 40, 0), "HiddenRoomFloor", graybrick);
		fillBlocksGhost(new Vector3f(10215, 2, 99), new Vector3f(10215, 20, 90), "HiddenWallbyTheatre", graybrick);
		fillBlocks(new Vector3f(10200, 2, 90), new Vector3f(10215, 20 , 90), "FillingHiddenroomDisplaceZ", newWall);
		//Spawn hammer in secret room:
		
		spawnHammer(new Vector3f(10207, 2, 110), "hammerL1F0");
		
		//Galager's Theatre: 
		fillBlocks(new Vector3f(10230, 2, 90), new Vector3f(10240, 20 , 90), "sittingspacebyGalagerDisplaceZ", newWall);
		fillBlocks(new Vector3f(10240, 2, 65), new Vector3f(10240, 20 , 90), "sittingspacebyGalagerDisplaceX", newWall);
		fillBlocks(new Vector3f(10240, 2, 65), new Vector3f(10280, 20 , 65), "GalagerTheatreEntrance", newWall);
		//TODO do not through cactus in this area its a safezone. 
		fillBlocks(new Vector3f(10280, 2, 65), new Vector3f(10280, 20 , 90), "SafeZoneNorthGalagerDisplaceX", newWall);
		fillBlocks(new Vector3f(10280, 2, 90), new Vector3f(10320, 20 , 90), "SafeZoneNorthGalagerDisplaceZ", newWall);
		
		//Hallway for potential Key. placement
		fillBlocks(new Vector3f(10320, 2, 90), new Vector3f(10320, 20 , 115), "HallwayNorthGalagerDisplaceZ", newWall);
		fillBlocks(new Vector3f(10335, 2, 65), new Vector3f(10335, 20 , 115), "NorthofGalagertoKeyPlacement", newWall);
		fillBlocks(new Vector3f(10335, 2, 65), new Vector3f(10340, 20 , 65), "NorthAreabyMall", newWall);
		
		// Chick Fil eh
		fillBlocks(new Vector3f(10330, 2, 55), new Vector3f(10340, 20 , 55), "ChikFilEeastWall", newWall);
		fillBlocks(new Vector3f(10330, 2, 40), new Vector3f(10340, 20 , 40), "ChikFilEwestWall", newWall);
		fillBlocks(new Vector3f(10330, 2, 40), new Vector3f(10330, 20 , 55), "ChikFilEsouthWall", newWall);
		
		//Panda and on Deck Deli
		fillBlocks(new Vector3f(10335, 2, 30), new Vector3f(10340, 20 , 30), "OnDeckEastWall", newWall);
		fillBlocks(new Vector3f(10335, 2, 25), new Vector3f(10335, 20 , 30), "OnDeckSouthWall", newWall);
		fillBlocks(new Vector3f(10330, 2, 25), new Vector3f(10335, 20 , 25), "OnDeckWestWall", newWall);
		fillBlocks(new Vector3f(10330, 2, 0), new Vector3f(10330, 20 , 25), "PandaSouthWall", newWall);
		
		//Jump Puzzle middle of the room. 
		
		//Crafted walls around puzzle
		
		fillBlocks(new Vector3f(10270, 2, 55), new Vector3f(10300, 20, 55), "JumpingPuzzleOutweWallEast", newWall);
		fillBlocks(new Vector3f(10270, 2, 25), new Vector3f(10300, 20, 25), "JumpingPuzzleOutweWallWest", newWall);
		fillBlocks(new Vector3f(10270, 2, 25), new Vector3f(10270, 20, 45), "JumpingPuzzleOutweWallSouth", newWall);
		fillBlocks(new Vector3f(10300, 2, 35), new Vector3f(10300, 20, 55), "JumpingPuzzleOutweWallNorth", newWall);
		fillBlocks(new Vector3f(10270, 2, 45), new Vector3f(10270, 15, 55), "JumpingPuzzleOutweWallEast", newWall);
		
		// Entrance to puzzle. 
		//fillBlocks(new Vector3f(10300, 2, 25), new Vector3f(10300, 20, 55), "JumpingPuzzleOutweWallEast", graywall);
		
		fillBlocks(new Vector3f(10275, 0, 26), new Vector3f(10290, 10, 50), "JumpPuzzleCatcusfloor", whitetile);
		fillBlocks(new Vector3f(10290, 0, 35), new Vector3f(10299, 10, 50), "JumpPuzzlecactusfloor1", whitetile);
		fillBlocks(new Vector3f(10299, 0, 26), new Vector3f(10290, 5, 50), "JumpPuzzlecactusentrance", whitetile);
		//Center block placement for the 
		
		fillBlocks(new Vector3f(10282.5f, 10, 37.5f), new Vector3f(10287.5f, 15, 42.5f), "JumpPuzzlecactusfloor1", table);
		// spawn hammer time. 
		
		spawnHammer(new Vector3f(10285, 17, 40), "hammer2L1F0");
		
		//jump platforms. 
		fillBlocks(new Vector3f(10283.5f, 14, 26.5f), new Vector3f(10287.5f, 14, 33.5f), "JumpPuzzlecactusfloor1", table);
		fillBlocks(new Vector3f(10280.5f, 14, 26.5f), new Vector3f(10279.5f, 14, 33.5f), "JumpPuzzlecactusfloor2", table);
		fillBlocksGhost(new Vector3f(10276.5f, 14, 28), new Vector3f(10271.5f, 14, 31), "JumpPuzzlecactusfloor3", table);
		fillBlocks(new Vector3f(10272, 14, 37.5f), new Vector3f(10277.5f, 14, 54), "JumpPuzzlecactusfloor2", table);
		///Cactus south of middle block for Puzzle
		SaguaroCactus scL1F1B1 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B1.spawnCactus(new Vector3f(10271, 12, 28.5f), new Vector3f(10281.5f, 12, 28.5f), "cactusL1F1B1");
		cacti.add(scL1F1B1);
		
		SaguaroCactus scL1F1B2 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B2.spawnCactus(new Vector3f(10271, 12, 32.25f), new Vector3f(10281.5f, 12, 32.25f), "cactusL1F1B2");
		cacti.add(scL1F1B2);
		
		SaguaroCactus scL1F1B3 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B3.spawnCactus(new Vector3f(10271, 12, 36), new Vector3f(10281.5f, 12, 36), "cactusL1F1B3");
		cacti.add(scL1F1B3);
		
		SaguaroCactus scL1F1B4 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B4.spawnCactus(new Vector3f(10271, 12, 39.75f), new Vector3f(10281.5f, 12, 39.75f), "cactusL1F1B4");
		cacti.add(scL1F1B4);
		
		SaguaroCactus scL1F1B5 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B5.spawnCactus(new Vector3f(10271, 12, 43.5f), new Vector3f(10281.5f, 12, 43.5f), "cactusL1F1B5");
		cacti.add(scL1F1B5);
		
		SaguaroCactus scL1F1B6 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B6.spawnCactus(new Vector3f(10271, 12, 47.25f), new Vector3f(10281.5f, 12, 47.25f), "cactusL1F1B6");
		cacti.add(scL1F1B6);
		
		// Cactus West of Middle Block 
		SaguaroCactus scL1F1B7 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B7.spawnCactus(new Vector3f(10282.5f, 12, 26.2f), new Vector3f(10282.5f, 12, 35), "cactusL1F1B7");
		cacti.add(scL1F1B7);
		
		SaguaroCactus scL1F1B8 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B8.spawnCactus(new Vector3f(10285.5f, 12, 26.2f), new Vector3f(10285.5f, 12, 35), "cactusL1F1B8");
		cacti.add(scL1F1B8);
		
		// Cactus East of the Middle Block
		SaguaroCactus scL1F1B9 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B9.spawnCactus(new Vector3f(10282.5f, 12, 54), new Vector3f(10282.5f, 12, 43.5f), "cactusL1F1B9");
		cacti.add(scL1F1B9);
		
		SaguaroCactus scL1F1B10 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B10.spawnCactus(new Vector3f(10285.5f, 12, 54), new Vector3f(10285.5f, 12, 43.5f), "cactusL1F1B10");
		cacti.add(scL1F1B10);
		
		// Cactus North of the Middle Block
		SaguaroCactus scL1F1B11 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B11.spawnCactus(new Vector3f(10298, 12, 37), new Vector3f(10290, 12, 37), "cactusL1F1B11");
		cacti.add(scL1F1B11);
		
		SaguaroCactus scL1F1B12 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B12.spawnCactus(new Vector3f(10298, 12, 41), new Vector3f(10290, 12, 41), "cactusL1F1B12");
		cacti.add(scL1F1B12);

		SaguaroCactus scL1F1B13 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B13.spawnCactus(new Vector3f(10298, 12, 45), new Vector3f(10290, 12, 45), "cactusL1F1B13");
		cacti.add(scL1F1B13);
		
		SaguaroCactus scL1F1B14 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'x');
		//// 						Starting location				Ending Location
		scL1F1B14.spawnCactus(new Vector3f(10298, 12, 49), new Vector3f(10290, 12, 49), "cactusL1F1B14");
		cacti.add(scL1F1B14);


		//IQfresh Room. Safe room

		fillBlocks(new Vector3f(10215, 2, 90), new Vector3f(10215, 20 , 80), "IQFreshDisplaceZ1", newWall);
		fillBlocks(new Vector3f(10215, 2, 70), new Vector3f(10215, 20 , 65), "IQFreshDisplaceZ2", newWall);
		fillBlocks(new Vector3f(10215, 2, 65), new Vector3f(10210, 20 , 65), "IQFreshDisplaceX1", newWall);
		fillBlocks(new Vector3f(10202, 2, 65), new Vector3f(10200, 20 , 65), "IQFreshDisplaceX2", newWall);
		
		//Einstein Bagels:
		fillBlocks(new Vector3f(10200, 2, 55), new Vector3f(10202, 20 , 55), "EinsteinBagelsDisplaceX1", newWall);
		fillBlocks(new Vector3f(10210, 2, 55), new Vector3f(10215, 20 , 55), "EinsteinBagelsDisplaceX2", newWall);
		fillBlocks(new Vector3f(10215, 2, 55), new Vector3f(10215, 20 , 50), "EinsteinBagelsDisplaceZ1", newWall);
		fillBlocks(new Vector3f(10215, 2, 40), new Vector3f(10200, 20 , 40), "EinsteinBagelsDisplaceZ2", newWall);
		
		//Fillingin hallway to end of the level
		fillBlocks(new Vector3f(10215, 2, 40), new Vector3f(10215, 20 , 0), "afterEinsteinLeftwallDisplaceZ", newWall);
		fillBlocks(new Vector3f(10230, 2, 55), new Vector3f(10230, 20 , 30), "afterEinsteinRightwallDisplaceZ", newWall);
		fillBlocks(new Vector3f(10230, 2, 0), new Vector3f(10230, 20 , 20), "afterEinsteinRightwallDisplaceZ1", newWall);
		//Elevator to floor 2
		fillBlocks(new Vector3f(10230, 0, 20), new Vector3f(10230, 0, 30), "elevatorL1F0", whitetile);
		fillBlocks(new Vector3f(10232, 2, 20), new Vector3f(10232, 20, 30), "elevatorL1F0", whitetile);
		
		// Core
		fillBlocks(new Vector3f(10230, 2, 55), new Vector3f(10240, 20 , 55), "fromEinsteintoCoreDisplaceX", newWall);
		fillBlocks(new Vector3f(10240, 2, 55), new Vector3f(10240, 20 , 40), "CoreDisplaceZ", newWall);
		fillBlocks(new Vector3f(10240, 2, 40), new Vector3f(10260, 20 , 40), "CoreDisplaceX", newWall);
		
		//Papa Johns and Steak n Shake
		fillBlocks(new Vector3f(10260, 2, 40), new Vector3f(10260, 20 , 0), "SteaknShakePapaJohns", newWall);
		
		
		//Behind Panda
		fillBlocks(new Vector3f(10340, 2, 0), new Vector3f(10340, 20 , 115), "FillingHiddenroomDisplaceZ", newWall);
		// Cactus for the level
		
		
		//1
		BarrelCactus bclv1_1 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bclv1_1.spawnCactus(new Vector3f(10317, 2, 8), new Vector3f(10265, 2, 8), "cactusBfl1_1");
		cacti.add(bclv1_1);
		
		//2 
		BarrelCactus bclv1_2 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bclv1_2.spawnCactus(new Vector3f(10317, 2, 16), new Vector3f(10265, 2, 16), "cactusBfl1_2");
		cacti.add(bclv1_2);
		
		// 3 
		SaguaroCactus scL1F1B15 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B15.spawnCactus(new Vector3f(10250, 2, 42), new Vector3f(10250, 2, 50), "cactusL1F1B15");
		cacti.add(scL1F1B15);
		
		//4 
		ChollaCactus ccL1F1C1 = new ChollaCactus(node, assetManager, bulletAppState, player);
		ccL1F1C1.spawnCactus(new Vector3f(10222, 2, 40), "cactusL1F1C1", 'z');
		cacti.add(ccL1F1C1);
		
		//5 
		BarrelCactus bclv1_3 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bclv1_3.spawnCactus(new Vector3f(10291, 2, 83), new Vector3f(10291, 2, 67), "cactusBfl1_3");
		cacti.add(bclv1_3);
		
		//6
		SaguaroCactus scL1F1B16 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B16.spawnCactus(new Vector3f(10330, 2, 70), new Vector3f(10330, 2, 105), "cactusL1F1B16");
		cacti.add(scL1F1B16);
		
		//7
		SaguaroCactus scL1F1B17 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B17.spawnCactus(new Vector3f(10305, 2, 119), new Vector3f(10305, 2, 140), "cactusL1F1B17");
		cacti.add(scL1F1B17);
		
		// 8 
		BarrelCactus bclv1_4 = new BarrelCactus(node, assetManager, bulletAppState, player, 'z');
		bclv1_4.spawnCactus(new Vector3f(10265, 2, 132), new Vector3f(10265,2, 140), "cactusBfl1_4");
		cacti.add(bclv1_4);
		
		//9 
		SaguaroCactus scL1F1B18 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		//// 						Starting location				Ending Location
		scL1F1B18.spawnCactus(new Vector3f(10236, 2, 119), new Vector3f(10236, 2, 145), "cactusL1F1B18");
		cacti.add(scL1F1B18);
		
		//Cutting off level across 
		//TODO NEED A NEW COLOUR WAS NOT ABLE TO PUT IT IN
		fillBlocks(new Vector3f(10320, 2, 115), new Vector3f(10320, 20 ,150), "CutoffinFrontofBookstore", cactuswall);
		
		
	}
}