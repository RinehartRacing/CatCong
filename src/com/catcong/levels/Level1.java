/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.levels;

import com.catcong.Player;
import com.catcong.enemy.BarrelCactus;
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
		fillBlocks(new Vector3f(10200, 0, 0), new Vector3f(10350, 0, 150), "level1floor", redbrick);
		
		//fillBlocks(new Vector3f(0, 2, 26), new Vector3f(100, 60, 26), "RightWall", graywall); From level 1 
		//Eastern Wall. 
		fillBlocks(new Vector3f(10200, 2, 150), new Vector3f(10350, 20 ,150), "RightWall", graywall);
		
		//Southern Wall.
		fillBlocks(new Vector3f(10200, 2, 0), new Vector3f(10200, 20 ,150), "southernWall", graywall);
		
		//Western Wall
		fillBlocks(new Vector3f(10200, 2, 0), new Vector3f(10350, 20 , 0), "WesternWall", graywall);
		
		//NorthernWall
		fillBlocks(new Vector3f(10350, 2, 0), new Vector3f(10350, 20 , 150), "NorthernWall", graywall);
		
		//Building Stairwell near entrance to level. 
		fillBlocks(new Vector3f(10200, 2, 130), new Vector3f(10215, 20 ,130), "FirstRightStairwell", graywall);
		fillBlocks(new Vector3f(10200, 2, 115), new Vector3f(10215, 20 ,115), "FirstLeftStairwell", graywall);
		fillBlocks(new Vector3f(10215, 2, 115), new Vector3f(10215, 20 ,130), "Front of Stairwell", graywall);
		
		//building wall from entrance to student union to end of level. 
		fillBlocks(new Vector3f(10230, 2, 115), new Vector3f(10340, 20 ,115), "backwallofArizonaMarket", graywall);
		// Arizona Market
		fillBlocks(new Vector3f(10245, 2, 115), new Vector3f(10245, 20 ,130), "ArizonaMarketDisplaceZ", graywall);
		fillBlocks(new Vector3f(10245, 2, 130), new Vector3f(10250, 20 ,130), "ArizonaMarketDisplaceX", graywall);
		
		fillBlocks(new Vector3f(10250, 2, 130), new Vector3f(10270, 20 ,115), "DiagonalArizonaMarket", graywall);
		
		//hallway by restroom and Theatre to secret wall
		fillBlocks(new Vector3f(10230, 2, 115), new Vector3f(10230, 20 ,90), "HallwayRightTheatre", graywall);
		fillBlocks(new Vector3f(10215, 2, 115), new Vector3f(10215, 20 , 100), "HallwayLeftTheatre", graywall);
		//Secret wall. 
		//fillBlocksGhost(new Vector3f(42, 22, 0), new Vector3f(58, 40, 0), "HiddenRoomFloor", graybrick);
		fillBlocksGhost(new Vector3f(10215, 2, 99), new Vector3f(10215, 20, 90), "HiddenWallbyTheatre", graybrick);
		fillBlocks(new Vector3f(10200, 2, 90), new Vector3f(10215, 20 , 90), "FillingHiddenroomDisplaceZ", graywall);
		//Spawn hammer in secret room:
		
		spawnHammer(new Vector3f(10207, 2, 110), "hammerL1F0");
		
		//Galager's Theatre: 
		fillBlocks(new Vector3f(10230, 2, 90), new Vector3f(10240, 20 , 90), "sittingspacebyGalagerDisplaceZ", graywall);
		fillBlocks(new Vector3f(10240, 2, 65), new Vector3f(10240, 20 , 90), "sittingspacebyGalagerDisplaceX", graywall);
		fillBlocks(new Vector3f(10240, 2, 65), new Vector3f(10280, 20 , 65), "GalagerTheatreEntrance", graywall);
		//TODO do not through cactus in this area its a safezone. 
		fillBlocks(new Vector3f(10280, 2, 65), new Vector3f(10280, 20 , 90), "SafeZoneNorthGalagerDisplaceX", graywall);
		fillBlocks(new Vector3f(10280, 2, 90), new Vector3f(10320, 20 , 90), "SafeZoneNorthGalagerDisplaceZ", graywall);
		
		//Hallway for potential Key. placement
		fillBlocks(new Vector3f(10320, 2, 90), new Vector3f(10320, 20 , 115), "HallwayNorthGalagerDisplaceZ", graywall);
		fillBlocks(new Vector3f(10335, 2, 65), new Vector3f(10335, 20 , 115), "NorthofGalagertoKeyPlacement", graywall);
		fillBlocks(new Vector3f(10335, 2, 65), new Vector3f(10340, 20 , 65), "NorthAreabyMall", graywall);
		
		// Chick Fil eh
		fillBlocks(new Vector3f(10330, 2, 55), new Vector3f(10340, 20 , 55), "ChikFilEeastWall", graywall);
		fillBlocks(new Vector3f(10330, 2, 40), new Vector3f(10340, 20 , 40), "ChikFilEwestWall", graywall);
		fillBlocks(new Vector3f(10330, 2, 40), new Vector3f(10330, 20 , 55), "ChikFilEsouthWall", graywall);
		
		//Panda and on Deck Deli
		fillBlocks(new Vector3f(10335, 2, 30), new Vector3f(10340, 20 , 30), "OnDeckEastWall", graywall);
		fillBlocks(new Vector3f(10335, 2, 25), new Vector3f(10335, 20 , 30), "OnDeckSouthWall", graywall);
		fillBlocks(new Vector3f(10330, 2, 25), new Vector3f(10335, 20 , 25), "OnDeckWestWall", graywall);
		fillBlocks(new Vector3f(10330, 2, 0), new Vector3f(10330, 20 , 25), "PandaSouthWall", graywall);
		
		//Jump Puzzle middle of the room. 
		
		//Crafted walls around puzzle
		
		fillBlocks(new Vector3f(10270, 2, 55), new Vector3f(10300, 20, 55), "JumpingPuzzleOutweWallEast", graywall);
		fillBlocks(new Vector3f(10270, 2, 25), new Vector3f(10300, 20, 25), "JumpingPuzzleOutweWallWest", graywall);
		fillBlocks(new Vector3f(10270, 2, 25), new Vector3f(10270, 20, 45), "JumpingPuzzleOutweWallSouth", graywall);
		fillBlocks(new Vector3f(10300, 2, 35), new Vector3f(10300, 20, 55), "JumpingPuzzleOutweWallNorth", graywall);
		fillBlocks(new Vector3f(10270, 2, 45), new Vector3f(10270, 15, 55), "JumpingPuzzleOutweWallEast", graywall);
		
		// Entrance to puzzle. 
		//fillBlocks(new Vector3f(10300, 2, 25), new Vector3f(10300, 20, 55), "JumpingPuzzleOutweWallEast", graywall);
		
		fillBlocks(new Vector3f(10275, 0, 25), new Vector3f(10290, 10, 50), "JumpPuzzleCatcusfloor", whitetile);
		fillBlocks(new Vector3f(10290, 0, 35), new Vector3f(10299, 10, 50), "JumpPuzzlecactusfloor1", whitetile);
		fillBlocks(new Vector3f(10299, 0, 25), new Vector3f(10290, 5, 50), "JumpPuzzlecactusentrance", whitetile);
		//Center block placement for the 
		
		fillBlocks(new Vector3f(10282.5f, 10, 37.5f), new Vector3f(10287.5f, 15, 42.5f), "JumpPuzzlecactusfloor1", redbrick);
		// spawn hammer time. 
		
		spawnHammer(new Vector3f(10285, 17, 40), "hammer2L1F0");
		
		//jump platforms. 
		fillBlocks(new Vector3f(10283.5f, 14, 26.5f), new Vector3f(10287.5f, 14, 33.5f), "JumpPuzzlecactusfloor1", redbrick);
		fillBlocks(new Vector3f(10280.5f, 14, 26.5f), new Vector3f(10279.5f, 14, 33.5f), "JumpPuzzlecactusfloor2", redbrick);
		fillBlocksGhost(new Vector3f(10276.5f, 14, 28), new Vector3f(10271.5f, 14, 31), "JumpPuzzlecactusfloor3", redbrick);
		fillBlocks(new Vector3f(10272, 14, 37.5f), new Vector3f(10277.5f, 14, 54), "JumpPuzzlecactusfloor2", redbrick);
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

		fillBlocks(new Vector3f(10215, 2, 90), new Vector3f(10215, 20 , 80), "IQFreshDisplaceZ1", graywall);
		fillBlocks(new Vector3f(10215, 2, 70), new Vector3f(10215, 20 , 65), "IQFreshDisplaceZ2", graywall);
		fillBlocks(new Vector3f(10215, 2, 65), new Vector3f(10210, 20 , 65), "IQFreshDisplaceX1", graywall);
		fillBlocks(new Vector3f(10202, 2, 65), new Vector3f(10200, 20 , 65), "IQFreshDisplaceX2", graywall);
		
		//Einstein Bagels:
		fillBlocks(new Vector3f(10200, 2, 55), new Vector3f(10202, 20 , 55), "EinsteinBagelsDisplaceX1", graywall);
		fillBlocks(new Vector3f(10210, 2, 55), new Vector3f(10215, 20 , 55), "EinsteinBagelsDisplaceX2", graywall);
		fillBlocks(new Vector3f(10215, 2, 55), new Vector3f(10215, 20 , 50), "EinsteinBagelsDisplaceZ1", graywall);
		fillBlocks(new Vector3f(10215, 2, 40), new Vector3f(10200, 20 , 40), "EinsteinBagelsDisplaceZ2", graywall);
		
		//Fillingin hallway to end of the level
		fillBlocks(new Vector3f(10215, 2, 40), new Vector3f(10215, 20 , 0), "afterEinsteinLeftwallDisplaceZ", graywall);
		fillBlocks(new Vector3f(10230, 2, 55), new Vector3f(10230, 20 , 30), "afterEinsteinRightwallDisplaceZ", graywall);
		fillBlocks(new Vector3f(10230, 2, 0), new Vector3f(10230, 20 , 20), "afterEinsteinRightwallDisplaceZ1", graywall);
		//Elevator to floor 2
		fillBlocks(new Vector3f(10230, 2, 20), new Vector3f(10230, 0, 30), "elevatorL1F0", whitetile);
		fillBlocks(new Vector3f(10232, 2, 20), new Vector3f(10232, 20, 30), "elevatorL1F0", whitetile);
		
		// Core
		fillBlocks(new Vector3f(10230, 2, 55), new Vector3f(10240, 20 , 55), "fromEinsteintoCoreDisplaceX", graywall);
		fillBlocks(new Vector3f(10240, 2, 55), new Vector3f(10240, 20 , 40), "CoreDisplaceZ", graywall);
		fillBlocks(new Vector3f(10240, 2, 40), new Vector3f(10260, 20 , 40), "CoreDisplaceX", graywall);
		
		//Papa Johns and Steak n Shake
		fillBlocks(new Vector3f(10260, 2, 40), new Vector3f(10260, 20 , 0), "SteaknShakePapaJohns", graywall);
		
		
		//Behind Panda
		fillBlocks(new Vector3f(10340, 2, 0), new Vector3f(10340, 20 , 115), "FillingHiddenroomDisplaceZ", graywall);
		
		
		//Cutting off level across 
		//TODO NEED A NEW COLOUR WAS NOT ABLE TO PUT IT IN
		fillBlocks(new Vector3f(10320, 2, 115), new Vector3f(10320, 20 ,150), "CutoffinFrontofBookstore", cactuswall);
		
		
	}
}