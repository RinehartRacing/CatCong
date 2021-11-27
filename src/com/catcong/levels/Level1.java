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
		fillBlocks(new Vector3f(10200, 0, 0), new Vector3f(10300, 0, 150), "level1floor", redbrick);
		fillBlocks(new Vector3f(10302, 0, 48), new Vector3f(10302, 0, 52), "elevatorL1F0", whitetile);
		//fillBlocks(new Vector3f(0, 2, 26), new Vector3f(100, 60, 26), "RightWall", graywall); From level 1 
		//Right Most Wall. 
		fillBlocks(new Vector3f(10200, 2, 150), new Vector3f(10300, 20 ,150), "RightWall", graywall);
		
		//Southern Wall.
		fillBlocks(new Vector3f(10200, 2, 0), new Vector3f(10200, 20 ,150), "southernWall", graywall);
		
		//Building Stairwell near entrance to level. 
		fillBlocks(new Vector3f(10200, 2, 130), new Vector3f(10215, 20 ,130), "FirstRightStairwell", graywall);
		fillBlocks(new Vector3f(10200, 2, 115), new Vector3f(10215, 20 ,115), "FirstLeftStairwell", graywall);
		fillBlocks(new Vector3f(10215, 2, 115), new Vector3f(10215, 20 ,130), "Front of Stairwell", graywall);
		
		//building wall from entrance to student union to end of level. 
		fillBlocks(new Vector3f(10230, 2, 115), new Vector3f(10280, 20 ,115), "backwallofArizonaMarket", graywall);
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
		
		//IQfresh Room. Safe room

		fillBlocks(new Vector3f(10215, 2, 90), new Vector3f(10215, 20 , 80), "FillingHiddenroomDisplaceZ", graywall);
		fillBlocks(new Vector3f(10215, 2, 70), new Vector3f(10215, 20 , 65), "FillingHiddenroomDisplaceZ", graywall);
		fillBlocks(new Vector3f(10215, 2, 65), new Vector3f(10210, 20 , 65), "FillingHiddenroomDisplaceZ", graywall);
		fillBlocks(new Vector3f(10205, 2, 65), new Vector3f(10205, 20 , 65), "FillingHiddenroomDisplaceZ", graywall);
		
		//Einstein Bagels:
		fillBlocks(new Vector3f(10200, 2, 55), new Vector3f(10205, 20 , 55), "FillingHiddenroomDisplaceZ", graywall);
		fillBlocks(new Vector3f(10210, 2, 55), new Vector3f(10215, 20 , 55), "FillingHiddenroomDisplaceZ", graywall);
		fillBlocks(new Vector3f(10215, 2, 55), new Vector3f(10215, 20 , 45), "FillingHiddenroomDisplaceZ", graywall);
		fillBlocks(new Vector3f(10200, 2, 45), new Vector3f(10215, 20 , 45), "FillingHiddenroomDisplaceZ", graywall);
		
		//Fillingin hallway to end of the level
		fillBlocks(new Vector3f(10215, 2, 45), new Vector3f(10215, 20 , 0), "FillingHiddenroomDisplaceZ", graywall);
		
		
		//Cutting off level across 
		//TODO NEED A NEW COLOUR WAS NOT ABLE TO PUT IT IN
		fillBlocks(new Vector3f(10270, 2, 115), new Vector3f(10270, 20 ,150), "CutoffinFrontofBookstore", graybrick);
		
		
	}
}