package com.catcong.state;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;

public class Level extends AbstractAppState{
	private BulletAppState bulletAppState;

	public void initialize(AppStateManager stateManager, Application app) {
		bulletAppState = new BulletAppState();
		stateManager.attach(bulletAppState);
	}
}
