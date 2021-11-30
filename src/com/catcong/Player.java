/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
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

public class Player implements PlayerMovement, ActionListener, AnalogListener {
	CharacterControl cc; // Holds the object that control player movement
	CapsuleCollisionShape capsuleShape; // The player shape
	InputManager inputManager; // Access to control Game Engine inputs
	SimpleApplication app; // Access to the Game Engine
	private boolean left = false, right = false, up = false, down = false; // Status of how player is moving
	final private Vector3f walkDirection; // Direction player is moving
	private int lives; // Player lives
	private boolean hasHammer; // True if player has a hammer, false otherwise
	private LevelControl lc; // Access to the LevelControl public methods
	private int level; // Current player level
	private int score; // Current player score

	public Player(SimpleApplication app, LevelControl lc) {
		capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1); // Set dimensions of player

		cc = new CharacterControl(capsuleShape, 0.05f);
		cc.setJumpSpeed(35);
		cc.setFallSpeed(50);
		cc.setGravity(100);

		//cc.setPhysicsLocation(new Vector3f(4, 13, 0)); // Spawn location of player
		//(10250,13,50) //level 1 start : (10210, 13, 145) //Level 2 tenative : (21005,5,5)
		cc.setPhysicsLocation(new Vector3f(10210,13,145));
		walkDirection = new Vector3f();
		this.inputManager = app.getInputManager();
		this.app = app;
		//TODO Fix Lives back to 3. the 3 is annoying me with placing cactus
		
		this.lives = 10;
		this.hasHammer = false;
		this.lc = lc;
		this.level = 0;
		this.score = 0;
	}

	public CharacterControl get() {
		return cc;
	}

	@Override
	public void setupKeys() {
		/*
		 * Creates mapping and listeners to all the required keys
		 */
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
		/*
		 * Defines what happens after each key is pressed
		 */
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
			this.get().jump();
			app.getCamera().setLocation(this.get().getPhysicsLocation()); // Move camera with player
		}

	}

	@Override
	public void updateMovement(Vector3f camDir, Vector3f camLeft) {
		/*
		 * Updates movement direction of player
		 */
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
		/*
		 * Called when player loses a life
		 */
		this.lives--;
		if (this.lives <= 0) { // If player is out of lives, make it gameover
			lc.gameOver();
		}
	}

	public boolean getHammer() {
		return this.hasHammer;
	}

	public void grabHammer() {
		/*
		 * Called when the player wants to grab a hammer
		 */
		this.hasHammer = true;
		lc.grabHammer();
	}

	public void loseHammer() {
		/*
		 * Called when the player loses a hammer
		 */
		this.hasHammer = false;
		lc.loseHammer();
	}

	public void advanceLevel() {
		/*
		 * Increment player to next level
		 */
		this.level++;
	}

	public int getLevel() {
		return this.level;
	}

	@Override
	public void onAnalog(String binding, float value, float tpf) {
		/*
		 * Called when left click of mouse is clicked
		 */
		if (binding.equals("pick target")) {
			// Reset results list.
			CollisionResults results = new CollisionResults();
			// Aim the ray from camera location in camera direction
			Ray ray = new Ray(app.getCamera().getLocation(), app.getCamera().getDirection());
			// Collect intersections between ray and all nodes in results list.
			app.getRootNode().collideWith(ray, results);
			// Print the results so we see what is going on
			for (int i = 0; i < results.size(); i++) {
				// For each "hit", we know distance, impact point, geometry.
				float dist = results.getCollision(i).getDistance();
				String target = results.getCollision(i).getGeometry().getName();
				if (target.length() > 7) { // If trying to hit cactus
					if (target.substring(0, 6).equals("cactus")) {
						if (getHammer() && dist < 15) { // and cactus is within 15 wu
							lc.removeCactus(target); // Break the cactus
							this.loseHammer(); // Lose the hammer
							incrementScore(250); // Increment the score
						}

					}
					if (target.equals("A_normal_mat")) { // If trying to hit SunDevil model
						if (getHammer() && dist < 25) { // and SunDevil is within 25 wu
							lc.removeCactus("cactusSundevil"); // Remove the SunDevil
							this.loseHammer(); // Lose the hammer
							incrementScore(1500); // Increment the score
							lc.defeatSunDevil(); // Tell LevelControl that the SunDevil is defeated
						}
					}
				}

			}

		}

	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;

	}

	public void incrementScore(int score) {
		/*
		 * Add to player's score
		 */
		this.score += score;
	}

}
