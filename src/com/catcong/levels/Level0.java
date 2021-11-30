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

		fillBlocks(new Vector3f(0, 0, 0), new Vector3f(100, 0, 26), "floor2", redbrick);
		fillBlocks(new Vector3f(0, 2, 0), new Vector3f(40, 40, 0), "LeftWallFront", graywall);
		fillBlocks(new Vector3f(60, 2, 0), new Vector3f(100, 40, 0), "LeftWallBack", graywall);

		fillBlocks(new Vector3f(40, 0, 0), new Vector3f(60, 0, -15), "LeftRoomFloor", redbrick);
		fillBlocks(new Vector3f(40, 2, -2), new Vector3f(40, 40, -15), "LeftRoomLeftWall", graywall);
		fillBlocks(new Vector3f(60, 2, -2), new Vector3f(60, 40, -15), "LeftRoomRightWall", graywall);
		fillBlocks(new Vector3f(40, 2, -17), new Vector3f(60, 40, -17), "LeftRoomBackWall", graywall);
		fillBlocks(new Vector3f(42, 20, 0), new Vector3f(58, 20, -15), "LeftRoomCeiling", officeceiling);

		fillBlocks(new Vector3f(42, 22, 0), new Vector3f(58, 22, -15), "HiddenRoomFloor", redbrick);
		fillBlocksGhost(new Vector3f(42, 22, 0), new Vector3f(58, 40, 0), "HiddenRoomFloor", graybrick);
		fillBlocks(new Vector3f(42, 40, 0), new Vector3f(58, 40, -15), "HiddenRoomCeiling", officeceiling);

		fillBlocks(new Vector3f(0, 2, 26), new Vector3f(100, 60, 26), "RightWall", graywall);
		fillBlocks(new Vector3f(-2, 0, 0), new Vector3f(-2, 20, 26), "FrontWall", graywall);
		fillBlocks(new Vector3f(102, 0, 10), new Vector3f(102, 0, 16), "elevatorL0F0", whitetile);
		fillBlocks(new Vector3f(102, 22, 10), new Vector3f(102, 22, 16), "floor3spawn", whitetile);
		fillBlocks(new Vector3f(0, 20, 2), new Vector3f(100, 20, 24), "floor2ceiling", officeceiling);
		fillBlocks(new Vector3f(2, 22, 2), new Vector3f(100, 22, 24), "floor3", redbrick);
		fillBlocks(new Vector3f(102, 0, 0), new Vector3f(102, 40, 8), "BackWallLeft", graywall);
		fillBlocks(new Vector3f(102, 0, 18), new Vector3f(102, 40, 26), "BackWallRight", graywall);
		fillBlocks(new Vector3f(104, 0, 6), new Vector3f(110, 40, 20), "BackWallMiddle", whitewall);

		fillBlocks(new Vector3f(0, 22, 0), new Vector3f(0, 60, 8), "FrontWallLeft", graywall);
		fillBlocks(new Vector3f(0, 22, 18), new Vector3f(0, 60, 26), "FrontWallRight", graywall);
		fillBlocks(new Vector3f(-2, 22, 8), new Vector3f(-2, 60, 18), "FrontWallMiddle", whitewall);
		fillBlocks(new Vector3f(0, 22, 10), new Vector3f(0, 22, 16), "elevatorL0F1", whitetile);

		fillBlocks(new Vector3f(0, 40, 2), new Vector3f(100, 40, 24), "floor3ceiling", officeceiling);
		fillBlocks(new Vector3f(2, 42, 2), new Vector3f(100, 42, 24), "floor4", redbrick);
		fillBlocks(new Vector3f(0, 42, 10), new Vector3f(0, 42, 16), "floor4spawn", whitetile);
		fillBlocks(new Vector3f(0, 22, 0), new Vector3f(40, 60, 0), "floor4LeftWallFront", graywall);
		fillBlocks(new Vector3f(60, 22, 0), new Vector3f(100, 60, 0), "floor4LeftWallBack", graywall);
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