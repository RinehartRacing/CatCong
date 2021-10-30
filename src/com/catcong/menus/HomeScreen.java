package com.catcong.menus;

import java.awt.*;
import javax.swing.*;

public class HomeScreen extends JFrame{
private JPanel panel; 
private JPanel panel1;
private JPanel panel2; 
private JPanel panel3; 
private JPanel panel4;
private JLabel gameTitle;
private final int windowWidth = 500;
private final int windowHeight = 500;

	public HomeScreen() {
		// Set title of window
		super("Cat Cong");
		
		// Set size of window
		setSize(windowWidth, windowHeight);
		
		// Specify action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add BorderLayout manager to the content page
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
	
		// Add game title to pane
		labelPanel(borderLayout);
		
		// Add buttons to pane
		buttonPanel(borderLayout);
		
		// Display the window
		setVisible(true);
	
	}
	
	public void labelPanel(BorderLayout borderLayout) {
		
		JPanel panel = new JPanel();  // Panel for the label
		
		// Create the label
		gameTitle = new JLabel("CAT CONG");
		
		// Add the label to the panel
		panel.add(gameTitle);
		
		// Add panel to content pane
		add(panel, borderLayout.NORTH);
		
	}
	
	public void buttonPanel(BorderLayout borderLayout) {
		// Add panels
		JPanel panel1 = new JPanel(); // Panel for the "High Scores" button
		//JPanel panel2 = new JPanel(); // Panel for the "How To Play" button
		//JPanel panel3 = new JPanel(); // Panel for the "Play" button
		//JPanel panel4 = new JPanel(); // Panel for the "Quit Cat Cong" button
				
				
		// Create the buttons
		JButton highScore = new JButton("High Scores");
		//JButton howToPlay = new JButton("How To Play");
		//JButton play = new JButton("Play");
		//JButton quit = new JButton("Quit Cat Cong");
				
		// Add the buttons to the panel
		panel1.add(highScore);
		//panel2.add(howToPlay);
		//panel3.add(play);
		//panel4.add(quit);
		
		// Add buttons to the content pane
		add(panel1, borderLayout.CENTER);
		//add(panel2);
		//add(panel3);
		//add(panel4);
				
	}
	
	public static void main(String[] args) {
		new HomeScreen();
	}
}
