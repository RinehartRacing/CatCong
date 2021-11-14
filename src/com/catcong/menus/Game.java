/*
 * Rusty Rinehart, Isabel Dailey, Chris Bremser
 * ECE 373
 */
package com.catcong.menus;

import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.catcong.LevelControl;
import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;

public class Game extends SimpleApplication {
	private LevelControl LC; // LevelControll object access
	public static JFrame frame = new JFrame("CatCong"); // frame of Window
	public static String name = null; // player name

	public static void runGame() throws InterruptedException {

		SwingUtilities.invokeLater(new Runnable() { // Start thread to load Game Engine
			public void run() {
				HomeScreen hs = new HomeScreen("CatCong");
			}
		});

		AppSettings settings = new AppSettings(true); // Game Engine Settings
		settings.setWidth(1920);
		settings.setHeight(1080);

		final Game app = new Game();
		app.setPauseOnLostFocus(false);
		app.setSettings(settings);
		app.createCanvas();
		app.startCanvas(true);

		JmeCanvasContext context = (JmeCanvasContext) app.getContext();
		Canvas canvas = context.getCanvas();
		canvas.setSize(settings.getWidth(), settings.getHeight());

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

			}
		});
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		Thread.sleep(100);
		frame.setVisible(false);

	}

	@Override
	public void simpleInitApp() {
		/*
		 * Called when Game Engine is started
		 */
		LC = new LevelControl(this, guiFont, settings);
		LC.simpleInitApp();
	}

	public static void displayThreads() {
		/*
		 * Helper method for debugging threading issues
		 */
		Set<Thread> threads = Thread.getAllStackTraces().keySet();

		for (Thread t : threads) {
			String name = t.getName();
			Thread.State state = t.getState();
			int priority = t.getPriority();
			String type = t.isDaemon() ? "Daemon" : "Normal";
			System.out.printf("%-20s \t %s \t %d \t %s\n", name, state, priority, type); // Print all active threads
		}
	}

	@Override
	public void simpleUpdate(float tpf) {
		/*
		 * Constantly looped when Game Engine is running
		 */
		LC.simpleUpdate(tpf);
	}

	public static void main(String[] args) {
		/*
		 * Main method of CatCong
		 */
		System.out.println("Opening CatCong!"); // Developers
		System.out.println("Developed by Rusty Rinehart, Isabel Dailey, and Chris Bremser");
		System.out.println("ECE 373 Final Project");

		try {
			runGame(); // Start CatCong
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}