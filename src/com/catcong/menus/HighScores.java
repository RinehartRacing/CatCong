package com.catcong.menus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

public class HighScores extends JFrame {
	private final int windowWidth = 800;
	private final int windowHeight = 800;
	private Object[][] data;
	private String[] columns;
	private JTable table;
	private JScrollPane sp;

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
				Game.name = JOptionPane.showInputDialog(null, "Enter your name", "Wilbur");
				dispose();
				Game.frame.setVisible(true);
				
				// LevelControl.startGame();
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
		// headers for the table
		columns = new String[] { "Rank", "Name", "High Score" };

		this.readFile();
		// create table with data
		table = new JTable(data, columns);
		Border tableBorder = BorderFactory.createLineBorder(UARed, 3);

		table.setRowHeight(43);
		table.setFont(new Font("Verdana", Font.BOLD, 20));
		table.setForeground(Color.WHITE);
		table.setBackground(UARed);

		sp = new JScrollPane(table);

		// Set dimensions and customize high scores table
		sp.setLocation(200, 300);
		sp.setSize(450, 450);

		// add the table to the frame
		getContentPane().add(sp);

		setVisible(true);

	}

	public void shiftData(int loc) {
		Object[][] sd = new Object[10][3];
		for (int i = 0; i < data.length; i++) {
			if (i < loc) {
				sd[i] = data[i];
			} else if (i == loc) {
				sd[i] = new Object[3];
			} else {
				sd[i] = data[i - 1];
			}
		}
		data = sd;
	}

	public void addScore(int score) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Game.name);
		if (Game.name != null) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][0] == null || data[i][1] == null || data[i][2] == null) {
					data[i][0] = i + 1;
					data[i][1] = Game.name;
					data[i][2] = score;
					break;
				} else {
					int oldscore = (int) data[i][2];
					if (score > oldscore) {
						this.shiftData(i);
						data[i][0] = i + 1;
						data[i][1] = Game.name;
						data[i][2] = score;
						break;
					} else if (score <= oldscore) {
						continue;
					} else {
						System.out.println("Error loading score.");
					}
				}
			}
			writeFile();
			this.setVisible(false);
			HighScores hs = new HighScores();
			this.dispose();
		}
	}

	public void writeFile() {
		try {
			FileWriter fileOut = new FileWriter("highscores.txt");
			for (int i = 0; i < data.length; i++) {
				if (data[i][0] == null || data[i][1] == null || data[i][2] == null) {
					break;
				}
				if (i != 0) {
					fileOut.write("\n");
				}
				fileOut.write(data[i][1] + " " + data[i][2]);

			}
			fileOut.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void resetScores() {
		try {
			FileWriter fileOut = new FileWriter("highscores.txt");
			fileOut.write("");
			fileOut.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void readFile() {
		// actual data for the table in a 2d array
		data = new Object[10][3];
		try {
			File myFile = new File("highscores.txt");
			Scanner fileIn = new Scanner(myFile);
			int count = 1;
			while (fileIn.hasNextLine()) {
				String name = fileIn.next();
				int score = fileIn.nextInt();
				data[count - 1][0] = count;
				data[count - 1][1] = name;
				data[count - 1][2] = score;
				count++;
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void printData() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		HighScores hs = new HighScores();
		hs.resetScores();
	}
}
