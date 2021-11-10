package com.catcong;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.collision.CollisionResults;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

public class Player implements PlayerMovement, ActionListener, AnalogListener {
	CharacterControl cc;
	CapsuleCollisionShape capsuleShape;
	InputManager inputManager;
	SimpleApplication app;
	private boolean left = false, right = false, up = false, down = false;
	final private Vector3f walkDirection;
	private int lives;
	private boolean hasHammer;
	private LevelControl lc;
	private int level;
	public Player(SimpleApplication app, LevelControl lc) {
		capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);

		cc = new CharacterControl(capsuleShape, 0.05f);
		cc.setJumpSpeed(50);
		cc.setFallSpeed(50);
		cc.setGravity(100);

		cc.setPhysicsLocation(new Vector3f(4, 13, 0));
		walkDirection = new Vector3f();
		this.inputManager = app.getInputManager();
		this.app = app;
		this.lives = 3;
		this.hasHammer = false;
		this.lc = lc;
		this.level = 0;
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
		inputManager.addMapping("pick target", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
		inputManager.addListener(this, "Lefts");
		inputManager.addListener(this, "Rights");
		inputManager.addListener(this, "Ups");
		inputManager.addListener(this, "Downs");
		inputManager.addListener(this, "Space");
		inputManager.addListener(this, "pick target");
	}

	@Override
	public void onAction(String binding, boolean value, float tpf) {
		if (binding.equals("Lefts")) {
			if (value) {
				left = true;
			} else {
				left = false;
			}
		} else if (binding.equals("Rights")) {
			if (value) {
				right = true;
			} else {
				right = false;
			}
		} else if (binding.equals("Ups")) {
			if (value) {
				up = true;
			} else {
				up = false;
			}
		} else if (binding.equals("Downs")) {
			if (value) {
				down = true;
			} else {
				down = false;
			}
		} else if (binding.equals("Space")) {
			if (this.get().getPhysicsLocation().getY() < 4.31f) {
				// player.setPhysicsLocation(new Vector3f(player.getPhysicsLocation().getX(),
				// 100.0f, player.getPhysicsLocation().getZ()));
			}
			this.get().jump();
			app.getCamera().setLocation(this.get().getPhysicsLocation());
			System.out.println(this.get().getPhysicsLocation());
		}

	}

	@Override
	public void updateMovement(Vector3f camDir, Vector3f camLeft) {
		walkDirection.set(0, 0, 0);
		if (left) {
			walkDirection.addLocal(camLeft);
		}
		if (right) {
			walkDirection.addLocal(camLeft.negate());
		}
		if (up) {
			walkDirection.addLocal(camDir);
		}
		if (down) {
			walkDirection.addLocal(camDir.negate());
		}
		this.get().setWalkDirection(walkDirection);
	}

	public int getLives() {
		return this.lives;
	}

	public void loseLife() {
		this.lives--;
		if(this.lives <= 0) {
			lc.gameOver();
		}
	}

	public boolean getHammer() {
		return this.hasHammer;
	}

	public void grabHammer() {
		this.hasHammer = true;
		lc.grabHammer();
	}

	public void loseHammer() {
		this.hasHammer = false;
		lc.loseHammer();
	}
	public void advanceLevel() {
		this.level++;
	}
	@Override
	public void onAnalog(String binding, float value, float tpf) {
		if (binding.equals("pick target")) {
			// Reset results list.
			CollisionResults results = new CollisionResults();
			// Aim the ray from camera location in camera direction
			// (assuming crosshairs in center of screen).
			Ray ray = new Ray(app.getCamera().getLocation(), app.getCamera().getDirection());
			// Collect intersections between ray and all nodes in results list.
			app.getRootNode().collideWith(ray, results);
			// Print the results so we see what is going on
			for (int i = 0; i < results.size(); i++) {
				// For each "hit", we know distance, impact point, geometry.
				float dist = results.getCollision(i).getDistance();
				Vector3f pt = results.getCollision(i).getContactPoint();
				String target = results.getCollision(i).getGeometry().getName();
				//System.out.println("Selection #" + i + ": " + target + " at " + pt + ", " +
						//dist + " WU away.");
				if (target.length() > 7) {
					if (target.substring(0, 6).equals("cactus")) {
						if (getHammer() && dist < 15) {
							System.out.println("Break cactus!");
							lc.removeCactus(target);
							this.loseHammer();
						}
						
					}
					if(target.equals("A_normal_mat")) {
						if (getHammer() && dist < 25) {
							System.out.println("Kill boss!");
							lc.removeCactus("cactusSundevil");
							this.loseHammer();
							lc.defeatSunDevil();
						}
					}
				}

			}

		}
		
		

	}
}
