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
		//TODO Ask Rusty This created a full triangle but not an angle. 
		fillBlocks(new Vector3f(10250, 2, 130), new Vector3f(10270, 20 ,115), "DiagonalArizonaMarket", graywall);
		
		//hallway by restroom and Theatre to secret wall
		fillBlocks(new Vector3f(10230, 2, 115), new Vector3f(10230, 20 ,90), "HallwayRightTheatre", graywall);
		fillBlocks(new Vector3f(10215, 2, 115), new Vector3f(10215, 20 , 100), "HallwayLeftTheatre", graywall);
		//Secret wall. 
		//fillBlocksGhost(new Vector3f(42, 22, 0), new Vector3f(58, 40, 0), "HiddenRoomFloor", graybrick);
		fillBlocksGhost(new Vector3f(10215, 2, 99), new Vector3f(10215, 20, 90), "HiddenWallbyTheatre", graybrick);
		fillBlocks(new Vector3f(10200, 2, 90), new Vector3f(10215, 20 , 90), "FillingHiddenroomDisplaceZ", graywall);
		//Spawn hammer in secret room:
		//TODO Hammer Does not get picked up. Dont know why
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
		fillBlocks(new Vector3f(10320, 2, 115), new Vector3f(10320, 20 ,150), "CutoffinFrontofBookstore", graybrick);
		
		
	}
}