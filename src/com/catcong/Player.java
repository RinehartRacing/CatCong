package com.catcong;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;

public class Player implements PlayerMovement, ActionListener{
	CharacterControl cc;
	CapsuleCollisionShape capsuleShape;
	InputManager inputManager;
	SimpleApplication app;
	private boolean left = false, right = false, up = false, down = false;
	final private Vector3f walkDirection;
	private int lives;
	public Player(SimpleApplication app) {
		capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
		
		cc = new CharacterControl(capsuleShape, 0.05f);
		cc.setJumpSpeed(50);
		cc.setFallSpeed(50);
		cc.setGravity(100);

		cc.setPhysicsLocation(new Vector3f(4, 13, 0));
		walkDirection = new Vector3f();
		this.inputManager = app.getInputManager();
		this.app = app;
		lives = 3;
	}
	public CharacterControl get() {
		return cc;
	}
	
	@Override
	public void setupKeys() {
		inputManager.addMapping("Lefts", new KeyTrigger(KeyInput.KEY_A));
		inputManager.addMapping("Rights", new KeyTrigger(KeyInput.KEY_D));
		inputManager.addMapping("Ups", new KeyTrigger(KeyInput.KEY_W));
		inputManager.addMapping("Downs", new KeyTrigger(KeyInput.KEY_S));
		inputManager.addMapping("Space", new KeyTrigger(KeyInput.KEY_SPACE));
		inputManager.addListener(this, "Lefts");
		inputManager.addListener(this, "Rights");
		inputManager.addListener(this, "Ups");
		inputManager.addListener(this, "Downs");
		inputManager.addListener(this, "Space");
	}
	@Override
	public void onAction(String binding, boolean value, float tpf) {
		if (binding.equals("Lefts")) {
			if (value) {
				left = true;
			} else {
				left = false;
			}
		}
		else if (binding.equals("Rights")) {
			if (value) {
				right = true;
			} else {
				right = false;
			}
		}
		else if (binding.equals("Ups")) {
			if (value) {
				up = true;
			} else {
				up = false;
			}
		}
		else if (binding.equals("Downs")) {
			if (value) {
				down = true;
			} else {
				down = false;
			}
		}
		else if (binding.equals("Space")) {
			if(this.get().getPhysicsLocation().getY() < 4.31f) {
				//player.setPhysicsLocation(new Vector3f(player.getPhysicsLocation().getX(), 100.0f, player.getPhysicsLocation().getZ()));
			}
			this.get().jump();
			app.getCamera().setLocation(this.get().getPhysicsLocation());
			System.out.println(this.get().getPhysicsLocation());
		}
		
	}
	
	@Override
	public void updateMovement(Vector3f camDir, Vector3f camLeft) {
		walkDirection.set(0, 0, 0);
		if(left) {
			walkDirection.addLocal(camLeft);
		}
		if(right) {
			walkDirection.addLocal(camLeft.negate());
		}
		if(up) {
			walkDirection.addLocal(camDir);
		}
		if(down) {
			walkDirection.addLocal(camDir.negate());
		}
		this.get().setWalkDirection(walkDirection);
	}
	public int getLives() {
		return this.lives;
	}
	public void loseLife() {
		this.lives--;
	}
}
