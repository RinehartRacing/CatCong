package com.catcong.menus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class HowToPlay extends JFrame{
private final int windowWidth = 800;
private final int windowHeight = 800;


	public HowToPlay() {
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
		JLabel gameTitle = new JLabel("How To Play");
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
		JButton play = new JButton("Play");
		JButton highScores = new JButton("High Scores");
		JButton homeScreen = new JButton("Home Screen");
		JButton quit = new JButton("Quit");
				
		play.setLocation(24, 200);
		play.setSize(150, 50);
		play.setForeground(ArizonaBlue);
		play.setBackground(Color.WHITE);
		play.setHorizontalAlignment(JLabel.CENTER);
		play.setBorder(buttonBorder);
		getContentPane().add(play);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do {
					Game.name = JOptionPane.showInputDialog(null, "Enter your name (Max 10 characters)", "Wilbur");
				}while(Game.name.length() > 10);
				dispose();
				Game.frame.setVisible(true);
				
				//LevelControl.startGame();
			}
			
		});
				
		highScores.setLocation(224, 200);
		highScores.setSize(150, 50);
		highScores.setForeground(ArizonaBlue);
		highScores.setBackground(Color.WHITE);
		highScores.setHorizontalAlignment(JLabel.CENTER);
		highScores.setBorder(buttonBorder);
		getContentPane().add(highScores);
		highScores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				HighScores hs = new HighScores();
				
			}
			
		});
				
		homeScreen.setLocation(424, 200);
		homeScreen.setSize(150, 50);
		homeScreen.setForeground(ArizonaBlue);
		homeScreen.setBackground(Color.WHITE);
		homeScreen.setHorizontalAlignment(JLabel.CENTER);
		homeScreen.setBorder(buttonBorder);
		getContentPane().add(homeScreen);
		homeScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				HomeScreen hs = new HomeScreen("CatCong");

			}

		});
				
		quit.setLocation(624, 200);
		quit.setSize(150, 50);
		quit.setForeground(ArizonaBlue);
		quit.setBackground(Color.WHITE);
		quit.setHorizontalAlignment(JLabel.CENTER);
		quit.setBorder(buttonBorder);
		getContentPane().add(quit);
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
			
		});
			
		
		/* Create the three segments of game instructions */
		/* Keyboard Commands */
		// Label
		JLabel KeyboardCommands = new JLabel("Keyboard Commands:");
		KeyboardCommands.setLocation(20, 270);
		KeyboardCommands.setSize(500, 50);
		KeyboardCommands.setFont(new Font("Verdana", Font.BOLD, 20));
		KeyboardCommands.setForeground(Color.WHITE);
		getContentPane().add(KeyboardCommands);
		
		// Text
		JTextArea kbc = new JTextArea("   W = move forward, S = move backward, \n   A = move left, D = move right, \n   Space = jump, P = pause");
		kbc.setLineWrap(true);
		kbc.setLocation(20, 320);
		kbc.setSize(480, 50);
		kbc.setFont(new Font("Verdana", Font.BOLD, 12));
		kbc.setForeground(Color.WHITE);
		kbc.setBackground(UARed);
		getContentPane().add(kbc);
		
		
		/* Powerups And Obstacles */
		// Label
		JLabel PowerupsAndObstacles = new JLabel("Powerups And Obstacles:");
		PowerupsAndObstacles.setLocation(20, 370);
		PowerupsAndObstacles.setSize(500, 50);
		PowerupsAndObstacles.setFont(new Font("Verdana", Font.BOLD, 20));
		PowerupsAndObstacles.setForeground(Color.WHITE);
		getContentPane().add(PowerupsAndObstacles);
	
		// Powerups Text
		JTextArea p = new JTextArea("   Powerups: \n   Left-click the mouse to use the hammer to smash\n   the obstacles throughout the level\n   (see 'Obstacles' below) and earn bonus points for doing so!\n");
		p.setLineWrap(true);
		p.setLocation(20, 410);
		p.setSize(480, 50);
		p.setFont(new Font("Verdana", Font.BOLD, 12));
		p.setForeground(Color.WHITE);
		p.setBackground(UARed);
		getContentPane().add(p);
		
		// Obstacles Text
		JTextArea o = new JTextArea("   Obstacles:\n   There are three types of cacti: saugaro, barrel, and cholla. \n   Saguaro cacti are smaller and can either be jumped over\n   or smashed with the hammer. "
									+ "\n   Both Barrel and Cholla cacti need to be smashed with the hammer,\n   since they obstruct your progression through the level.\n"
									+ "   However, Cholla cacti are stationary whereas Barrel cacti move.");
		o.setLineWrap(true);
		o.setLocation(20, 460);
		o.setSize(480, 120);
		o.setFont(new Font("Verdana", Font.BOLD, 12));
		o.setForeground(Color.WHITE);
		o.setBackground(UARed);
		getContentPane().add(o);
		
		/* Game Scoring */
		// Label
		JLabel GameScoring = new JLabel("Game Scoring:");
		GameScoring.setLocation(20, 580);
		GameScoring.setSize(500, 50);
		GameScoring.setFont(new Font("Verdana", Font.BOLD, 20));
		GameScoring.setForeground(Color.WHITE);
		getContentPane().add(GameScoring);
		
		// Text
		JTextArea gs = new JTextArea("   Your overall game will accumulate as you progress through the level. \n   The numeric score values are defined as follows: \n"
			  + "   Completing The Level => 500 points\n"
			  + "   Smashing Saguaro Cacti => 250 points\n"
			  + "   Smashing Barrel Cacti => 250 points\n"
			  + "   Smashing Cholla Cacti => 250 points\n"
			  + "   Defeating the Sun Devil => 1500 points");
		gs.setLocation(20, 620);
		gs.setSize(480, 120);
		gs.setFont(new Font("Verdana", Font.BOLD, 12));
		gs.setForeground(Color.WHITE);
		gs.setBackground(UARed);
		getContentPane().add(gs);
		
		
		// Display the window
		setVisible(true);
			
	
	}

	public static void main(String[] args) {
		new HowToPlay();
	}
}