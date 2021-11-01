package com.catcong.menus;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class MainMenuController extends AbstractAppState implements ScreenController {

  private Application app;
  private AppStateManager stateManager;
  private Nifty nifty;
  private Screen screen;
    
  public MainMenuController() {
  
  }
  
  public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
  }
  
    public void onStartScreen() {
  }

    public void onEndScreen() {
  }
    
  @Override
  public void initialize(AppStateManager stateManager, Application app) {
    this.app = app;
    this.stateManager = stateManager;
  }
}
