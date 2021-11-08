package com.catcong.menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class HighScores extends JFrame{
private final int windowWidth = 800;
private final int windowHeight = 800;


	public HighScores() {
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
		JLabel gameTitle = new JLabel("High Scores");
		Border buttonBorder = BorderFactory.createLineBorder(UARed, 3);
	
		// Add and style game title label to pane
		gameTitle.setLocation(250, 100);
		gameTitle.setSize(450, 40);
		gameTitle.setVerticalAlignment(JLabel.TOP);
		gameTitle.setFont(new Font("Verdana", Font.BOLD, 30));
		gameTitle.setForeground(Color.WHITE);
		gameTitle.setBackground(UARed);
		getContentPane().add(gameTitle);
		
		// Add and style buttons and add them to pane
		JButton homeScreen = new JButton("Home Screen");
		JButton howToPlay = new JButton("How To Play");
		JButton play = new JButton("Play");
		JButton quit = new JButton("Quit");
		
		homeScreen.setLocation(24, 200);
		homeScreen.setSize(150, 50);
		homeScreen.setForeground(ArizonaBlue);
		homeScreen.setBackground(Color.WHITE);
		homeScreen.setHorizontalAlignment(JLabel.CENTER);
		homeScreen.setBorder(buttonBorder);
		getContentPane().add(homeScreen);
		
		howToPlay.setLocation(224, 200);
		howToPlay.setSize(150, 50);
		howToPlay.setForeground(ArizonaBlue);
		howToPlay.setBackground(Color.WHITE);
		howToPlay.setHorizontalAlignment(JLabel.CENTER);
		howToPlay.setBorder(buttonBorder);
		getContentPane().add(howToPlay);
		
		play.setLocation(424, 200);
		play.setSize(150, 50);
		play.setForeground(ArizonaBlue);
		play.setBackground(Color.WHITE);
		play.setHorizontalAlignment(JLabel.CENTER);
		play.setBorder(buttonBorder);
		getContentPane().add(play);
		
		quit.setLocation(624, 200);
		quit.setSize(150, 50);
		quit.setForeground(ArizonaBlue);
		quit.setBackground(Color.WHITE);
		quit.setHorizontalAlignment(JLabel.CENTER);
		quit.setBorder(buttonBorder);
		getContentPane().add(quit);
		
		
		/* Creating the high scores table */
		// Data that's displayed in table
		String[][] data = {{"Wilbur"}, {"10000"}, {"03-12-1885"}};
		
		// Column names
		String[] columns = {"Name", "Score", "Date Achieved"};
		
		// Initialize the table
		JTable highScores = new JTable(data, columns);
		highScores.setBounds(30, 30, 30, 30);
		
		// Add it to the JScrollPane
		JScrollPane sp = new JScrollPane(highScores);
		getContentPane().add(sp);
		
		
		// Display the window
		setVisible(true);
	
	}

	public static void main(String[] args) {
		new HighScores();
	}
}
