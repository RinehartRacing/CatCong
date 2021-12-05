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

public class Level0 extends Level {

	public Level0(Node node, AssetManager assetManager, BulletAppState bulletAppState, Player player) {
		/*
		 * Build Level 0
		 */
		super(node, assetManager, bulletAppState, player);

		fillBlocks(new Vector3f(0, 0, 0), new Vector3f(100, 0, 26), "floor2", ecefloor);
		fillBlocks(new Vector3f(0, 2, 0), new Vector3f(40, 40, 0), "LeftWallFront", graywall);
		fillBlocks(new Vector3f(60, 2, 0), new Vector3f(100, 40, 0), "LeftWallBack", graywall);

		fillBlocks(new Vector3f(40, 0, 0), new Vector3f(60, 0, -15), "LeftRoomFloor", ecefloor);
		fillBlocks(new Vector3f(40, 2, -1), new Vector3f(40, 40, -15), "LeftRoomLeftWall", graywall);
		fillBlocks(new Vector3f(60, 2, -1), new Vector3f(60, 40, -15), "LeftRoomRightWall", graywall);
		fillBlocks(new Vector3f(40, 2, -17), new Vector3f(60, 40, -17), "LeftRoomBackWall", graywall);
		fillBlocks(new Vector3f(42, 20, 1), new Vector3f(58, 20, -15), "LeftRoomCeiling", officeceiling);
		
		// jump puzzle Walls 
		fillBlocks(new Vector3f(60, 42, -1), new Vector3f(60, 76, -15), "JumpPuzzle1RightWall", graywall);
		fillBlocks(new Vector3f(40, 42, -15), new Vector3f(60, 76, -15), "JumpPuzzleBackWall", graywall);
		fillBlocks(new Vector3f(18, 25, -2), new Vector3f(18, 76, -14), "JumpPuzzleLEFTWall", graywall);
		fillBlocks(new Vector3f(40, 25, -15), new Vector3f(40, 76, -30), "JumpPuzzleRightkWall", graywall);
		fillBlocks(new Vector3f(40, 25, -30), new Vector3f(8, 76, -30), "JumpPuzzleBACKBackWall", graywall);
		fillBlocks(new Vector3f(8, 25, -15), new Vector3f(8, 76, -30), "JumpPuzzleBackLEFTWall1", graywall);
		fillBlocks(new Vector3f(20, 25, -14), new Vector3f(10, 76, -14), "JumpPuzzleBackFRONTWall", graywall);
		fillBlocks(new Vector3f(42, 42, 1), new Vector3f(58, 42, -14), "JumpPuzzleFloor", table);
		
		//Ceiling of top floor
		fillBlocksGhost(new Vector3f(-1, 77, -30), new Vector3f(104, 77, 26), "Ceiling", officeceiling);
		
		//Platform 
		fillBlocks(new Vector3f(40, 38, -1.5f), new Vector3f(20, 45, -15), "Plaftorm_one", outerwall);
		fillBlocks(new Vector3f(20, 38, -15), new Vector3f(38, 50, -30), "Plaftorm_two", table);
		fillBlocks(new Vector3f(19, 38, -15), new Vector3f(10, 55, -30), "Plaftorm_three", outerwall);
		
		//TODO Hammer Here
		spawnHammer(new Vector3f(14.5f, 56, -22.4f), "hammerL0F2");

		fillBlocks(new Vector3f(42, 22, 0), new Vector3f(58, 22, -15), "HiddenRoomFloor", ecefloor);
		fillBlocksGhost(new Vector3f(42, 22, 0), new Vector3f(58, 38, 0), "HiddenRoomFloor", graybrick);
		fillBlocks(new Vector3f(42, 40, 0), new Vector3f(58, 40, -15), "HiddenRoomCeiling", officeceiling);

		fillBlocks(new Vector3f(0, 2, 26), new Vector3f(100, 76, 26), "RightWall", graywall);
		fillBlocks(new Vector3f(-2, 0, 0), new Vector3f(-2, 20, 26), "FrontWall", graywall);
		fillBlocks(new Vector3f(102, 0, 10), new Vector3f(102, 0, 16), "elevatorL0F0", whitetile);
		fillBlocks(new Vector3f(102, 22, 10), new Vector3f(102, 22, 16), "floor3spawn", whitetile);
		fillBlocks(new Vector3f(0, 20, 2), new Vector3f(100, 20, 24), "floor2ceiling", officeceiling);
		fillBlocks(new Vector3f(2, 22, 2), new Vector3f(100, 22, 24), "floor3", ecefloor);
		fillBlocks(new Vector3f(102, 0, 0), new Vector3f(102, 76, 8), "BackWallLeft", graywall);
		fillBlocks(new Vector3f(102, 0, 18), new Vector3f(102, 76, 26), "BackWallRight", graywall);
		fillBlocks(new Vector3f(104, 0, 6), new Vector3f(110, 76, 20), "BackWallMiddle", whitewall);

		fillBlocks(new Vector3f(0, 22, 0), new Vector3f(0, 76, 8), "FrontWallLeft", graywall);
		fillBlocks(new Vector3f(0, 22, 18), new Vector3f(0, 76, 26), "FrontWallRight", graywall);
		fillBlocks(new Vector3f(-2, 22, 8), new Vector3f(-2, 76, 18), "FrontWallMiddle", whitewall);
		fillBlocks(new Vector3f(0, 22, 10), new Vector3f(0, 22, 16), "elevatorL0F1", whitetile);

		fillBlocks(new Vector3f(0, 40, 2), new Vector3f(100, 40, 24), "floor3ceiling", officeceiling);
		fillBlocks(new Vector3f(2, 42, 2), new Vector3f(100, 42, 24), "floor4", ecefloor);
		fillBlocks(new Vector3f(0, 42, 10), new Vector3f(0, 42, 16), "floor4spawn", whitetile);
		fillBlocks(new Vector3f(0, 22, 0), new Vector3f(40, 76, 0), "floor4LeftWallFront", graywall);
		fillBlocks(new Vector3f(60, 22, 0), new Vector3f(100, 76, 0), "floor4LeftWallBack", graywall);
		fillBlocks(new Vector3f(2, 22, 2), new Vector3f(100, 22, 24), "floor4LeftWall", graywall);
		//fillBlocks(coordinates of one corner, coordinates of opposite corner, unique name, texture to use)
		fillBlocks(new Vector3f(102, 42, 10), new Vector3f(102, 42, 16), "elevatorL0F2", whitetile);
		SaguaroCactus sc1 = new SaguaroCactus(node, assetManager, bulletAppState, player, 'z');
		sc1.spawnCactus(new Vector3f(25, 2, 25), new Vector3f(25, 2, 0), "cactusS1");
		cacti.add(sc1);

		BarrelCactus bc1 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bc1.spawnCactus(new Vector3f(100, 24, 10), new Vector3f(0, 24, 10), "cactusB1");
		cacti.add(bc1);

		BarrelCactus bc2 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bc2.spawnCactus(new Vector3f(100, 24, 15), new Vector3f(0, 24, 15), "cactusB2");
		cacti.add(bc2);

		BarrelCactus bc3 = new BarrelCactus(node, assetManager, bulletAppState, player, 'x');
		bc3.spawnCactus(new Vector3f(100, 24, 19), new Vector3f(0, 24, 19), "cactusB3");
		cacti.add(bc3);

		ChollaCactus cc1 = new ChollaCactus(node, assetManager, bulletAppState, player);
		cc1.spawnCactus(new Vector3f(100, 44, 13), "cactusC1", 'x');
		cacti.add(cc1);
		spawnHammer(new Vector3f(50, 2, -10), "hammerL0F0");
		spawnHammer(new Vector3f(50, 24, -10), "hammerL0F1");
	}

}