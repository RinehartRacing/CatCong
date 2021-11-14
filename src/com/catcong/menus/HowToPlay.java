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
				Game.name = JOptionPane.showInputDialog(null, "Enter your name", "Wilbur");
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
			
		
		// Create the three segments of game instructions
		JTextArea KeyboardCommands = new JTextArea("W = forward, S = backward, A = left, D = right", 10, 10);
		JTextArea PowerUpsAndObstacles = new JTextArea("Use the hammer to smash the cacti. There are two types of cacti: saugaro and barrel. Saguaro cacti are smaller and ");
		JTextArea LevelGameplay = new JTextArea();
		
		
		
		
		// Display the window
		setVisible(true);
			
	
	}

	public static void main(String[] args) {
		new HowToPlay();
	}
}
