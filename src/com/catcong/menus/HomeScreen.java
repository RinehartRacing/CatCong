package com.catcong.menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class HomeScreen extends JFrame{
private final int windowWidth = 800;
private final int windowHeight = 800;

	public HomeScreen() {
		// Set title of window
		super("Cat Cong");
		
		// Set size of window
		setSize(windowWidth, windowHeight);
		setResizable(false);

		// Specify action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add null layout manager to the content page
		getContentPane().setLayout(null);
		
		// Create custom UA colors to use for styling
		Color UARed = new Color(171, 5, 32);
		Color ArizonaBlue = new Color(12, 35, 75);
		
		// Set the background color
		getContentPane().setBackground(ArizonaBlue);
	
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
		getContentPane().add(gameTitle);
		
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
		getContentPane().add(highScore);
		
		howToPlay.setLocation(274, 300);
		howToPlay.setSize(150, 50);
		howToPlay.setForeground(ArizonaBlue);
		howToPlay.setBackground(Color.WHITE);
		howToPlay.setHorizontalAlignment(JLabel.CENTER);
		howToPlay.setBorder(buttonBorder);
		getContentPane().add(howToPlay);
		
		play.setLocation(274, 400);
		play.setSize(150, 50);
		play.setForeground(ArizonaBlue);
		play.setBackground(Color.WHITE);
		play.setHorizontalAlignment(JLabel.CENTER);
		play.setBorder(buttonBorder);
		getContentPane().add(play);
		
		quit.setLocation(274, 500);
		quit.setSize(150, 50);
		quit.setForeground(ArizonaBlue);
		quit.setBackground(Color.WHITE);
		quit.setHorizontalAlignment(JLabel.CENTER);
		quit.setBorder(buttonBorder);
		getContentPane().add(quit);
	
		// Display the window
		setVisible(true);
	
	}

	public static void main(String[] args) {
		new HomeScreen();
	}
}
