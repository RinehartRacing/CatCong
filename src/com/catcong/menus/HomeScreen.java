/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class HomeScreen {
	private final int windowWidth = 800;
	private final int windowHeight = 800;
	private static JFrame frame;

	public HomeScreen(String name) {
		// Set title of window
		frame = new JFrame(name);

		// Set size of window
		frame.setSize(windowWidth, windowHeight);
		frame.setResizable(false);

		// Specify action for the close button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add null layout manager to the content page
		frame.getContentPane().setLayout(null);

		// Create custom UA colors to use for styling
		Color UARed = new Color(171, 5, 32);
		Color ArizonaBlue = new Color(12, 35, 75);

		// Set the background color
		frame.getContentPane().setBackground(ArizonaBlue);

		// Create game title and borders
		JLabel gameTitle = new JLabel("CAT CONG");
		Border buttonBorder = BorderFactory.createLineBorder(UARed, 3);

		// Add and style game title label to pane
		gameTitle.setLocation(250, 100);
		gameTitle.setSize(450, 40);
		gameTitle.setVerticalAlignment(JLabel.TOP);
		gameTitle.setFont(new Font("Verdana", Font.BOLD, 38));
		gameTitle.setForeground(Color.WHITE);
		gameTitle.setBackground(UARed);
		frame.getContentPane().add(gameTitle);

		// Add and style buttons and add them to pane
		JButton highScore = new JButton("High Scores");
		JButton howToPlay = new JButton("How To Play");
		JButton play = new JButton("Play");
		JButton quit = new JButton("Quit");

		highScore.setLocation(274, 200);
		highScore.setSize(150, 50);
		highScore.setForeground(ArizonaBlue);
		highScore.setBackground(Color.WHITE);
		highScore.setHorizontalAlignment(JLabel.CENTER);
		highScore.setBorder(buttonBorder);
		frame.getContentPane().add(highScore);
		highScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				HighScores hs = new HighScores();

			}

		});

		howToPlay.setLocation(274, 300);
		howToPlay.setSize(150, 50);
		howToPlay.setForeground(ArizonaBlue);
		howToPlay.setBackground(Color.WHITE);
		howToPlay.setHorizontalAlignment(JLabel.CENTER);
		howToPlay.setBorder(buttonBorder);
		frame.getContentPane().add(howToPlay);
		howToPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Called when How to Play button is clicked
				 */
				frame.setVisible(false);
				frame.dispose();
				HowToPlay htp = new HowToPlay();

			}

		});

		play.setLocation(274, 400);
		play.setSize(150, 50);
		play.setForeground(ArizonaBlue);
		play.setBackground(Color.WHITE);
		play.setHorizontalAlignment(JLabel.CENTER);
		play.setBorder(buttonBorder);
		frame.getContentPane().add(play);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Called when Play button is clicked
				 */
				do { // Continue to ask for user input until legal name is entered
					Game.name = JOptionPane.showInputDialog(null, "Enter your name (Max 10 characters)", "Wilbur");
				} while (Game.name.length() > 10);
				frame.dispose();
				Game.frame.setVisible(true);

			}

		});

		quit.setLocation(274, 500);
		quit.setSize(150, 50);
		quit.setForeground(ArizonaBlue);
		quit.setBackground(Color.WHITE);
		quit.setHorizontalAlignment(JLabel.CENTER);
		quit.setBorder(buttonBorder);
		frame.getContentPane().add(quit);
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Called when Quit button is clicked
				 */
				frame.setVisible(false);
				frame.dispose();
				System.exit(0);

			}

		});

		// Display the window
		frame.setVisible(true);

	}

	public JFrame getHomeScreen() {
		return frame;
	}

	public static void main(String[] args) {
		/*
		 * Main method used for module testing
		 */
		new HomeScreen("CatCong");
	}
}
