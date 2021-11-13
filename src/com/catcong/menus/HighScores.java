package com.catcong.menus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class HighScores extends JFrame {
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
		homeScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				HomeScreen hs = new HomeScreen("CatCong");

			}

		});

		howToPlay.setLocation(224, 200);
		howToPlay.setSize(150, 50);
		howToPlay.setForeground(ArizonaBlue);
		howToPlay.setBackground(Color.WHITE);
		howToPlay.setHorizontalAlignment(JLabel.CENTER);
		howToPlay.setBorder(buttonBorder);
		getContentPane().add(howToPlay);
		howToPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				HowToPlay htp = new HowToPlay();

			}

		});

		play.setLocation(424, 200);
		play.setSize(150, 50);
		play.setForeground(ArizonaBlue);
		play.setBackground(Color.WHITE);
		play.setHorizontalAlignment(JLabel.CENTER);
		play.setBorder(buttonBorder);
		getContentPane().add(play);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				Game.frame.setVisible(true);
				
				//LevelControl.startGame();
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
		
		/* Create table */
		 //headers for the table
        String[] columns = {
            "Rank", "Name", "High Score"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "john", 40.0},
            {2, "Rambo", 70.0 },
            {3, "Zorro", 60.0},
            {4, "Kenobi", 60.0},
            {5, "Rusty", 69.0},
            {6, "Isabel", 60.0},
            {7, "Trike", 60.0},
            {8, "Anakin", 60.0},
            {9, "Reace", 60.0},
            {10, "Chris", 60.0 },
        };
        //create table with data
        JTable table = new JTable(data, columns);
		Border tableBorder = BorderFactory.createLineBorder(UARed, 3);
		
		table.setRowHeight(43);
		table.setFont(new Font("Verdana", Font.BOLD, 20));
		table.setForeground(Color.WHITE);
		table.setBackground(UARed);	
		
		JScrollPane sp = new JScrollPane(table);
		
		// Set dimensions and customize high scores table
		sp.setLocation(200, 300);
		sp.setSize(450, 450);
		
        //add the table to the frame
        getContentPane().add(sp);
         
        setVisible(true);

	}

	public static void main(String[] args) {
		new HighScores();
	}
}
