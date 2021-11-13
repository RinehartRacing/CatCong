package com.catcong.menus;

import javax.swing.JFrame;

public class HighScoreSet extends JFrame{
	private final int windowWidth = 800;
	private final int windowHeight = 800;

	public HighScoreSet() {
		// Set title of window
		super("Cat Cong");

		// Set size of window
		setSize(windowWidth, windowHeight);
		setResizable(false);

		// Specify action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add null layout manager to the content page
		getContentPane().setLayout(null);
		
		setVisible(true);
	}
}
