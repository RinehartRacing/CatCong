package com.catcong.menus;

import com.catcong.LevelControl;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;
import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class WindowTests extends SimpleApplication {
    private LevelControl LC;
    public static JFrame frame = new JFrame("CatCong");
	public static void runGame() throws InterruptedException{
    	//LC = new LevelControl();
    	//LC.start();
    	HomeScreen hs = new HomeScreen("CatCong");
    	//JFrame homeFrame = hs.getHomeScreen();
    	AppSettings settings = new AppSettings(true);
        settings.setWidth(1920);
        settings.setHeight(1080);

        final WindowTests app = new WindowTests();
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
    	LC = new LevelControl(this, guiFont, settings);
    	LC.simpleInitApp();
    }
    
    @Override
    public void simpleUpdate(float tpf) {
		LC.simpleUpdate(tpf);
	}
    public static void main(String[] args) {
    	try {
			runGame();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}