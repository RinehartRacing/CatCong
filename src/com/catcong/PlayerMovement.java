/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong;

import com.jme3.math.Vector3f;

public interface PlayerMovement {
	public void setupKeys();
	public void updateMovement(Vector3f camDir, Vector3f camLeft);
	public void grabHammer();
}
