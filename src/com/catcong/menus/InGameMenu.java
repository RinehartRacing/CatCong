package com.catcong.menus;

import com.catcong.LevelControl;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class InGameMenu extends AbstractAppState implements ScreenController {

	private LevelControl LC; // LevelControl access

	public InGameMenu(LevelControl LC) {
		this.LC = LC;
	}

	public void bind(Nifty nifty, Screen screen) {
	}

	public void onStartScreen() {
		/*
		 * Required by ScreenController
		 */
	}

	public void onEndScreen() {
		/*
		 * Required by ScreenController
		 */
	}

	@Override
	public void initialize(AppStateManager stateManager, Application app) {
	}

	public void resumeButton() {
		/*
		 * Called when resume is pressed in in-game menu
		 */
		LC.resumeGame();
	}

	public void start1() {
		/*
		 * Called when player presses play to start level 1
		 */
		LC.resumeGame();
		LC.preGame(1);
	}

	public void start2() {
		/*
		 * Called when player presses play to start level 2
		 */
		LC.resumeGame();
		LC.preGame(2);
	}

	public void start3() {
		/*
		 * Called when player presses play to start level 3
		 */
		LC.resumeGame();
		LC.preGame(3);
	}

	public void restartButton() {
		/*
		 * Called when player presses restart
		 */
		LC.restartGame();
	}

	public void homeScreenButton() {
		/*
		 * Called when player wants to return to home screen
		 */
		LC.loadHomeScreen();
	}

	public void quitButton() {
		/*
		 * Called when player presses quit button
		 */
		LC.quitGame();
	}

	public void setHighScore() {
		/*
		 * Called when returning to Home Screen after game is beat
		 */
		LC.setHighScore();
	}
}
