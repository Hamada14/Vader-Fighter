package spaceinvader.game;

import javafx.animation.AnimationTimer;
import spaceinvader.control.Controller;

public class Game extends AnimationTimer {

    private static final double NANO_TO_SECOND = 1e9;

    private long lastFPSUpdateTime;
    private int previousFPSCount;
    private int FPSCount;

    private final Drawer drawer;
    private final Engine engine;
    private final Controller controller;

    public Game(Drawer drawer, Engine engine, Controller controller) {
        this.engine = engine;
        this.drawer = drawer;
        this.controller = controller;
        this.lastFPSUpdateTime = System.nanoTime();
        this.FPSCount = 0;
    }

    @Override
    public void handle(long time) {
        int fpsCount = updateFPSCount(time);
        engine.updateSystem(time, controller.getPressedKeys());
        drawer.draw(time, engine.getSprites(), fpsCount);
    }

    private int updateFPSCount(long time) {
        FPSCount++;
        int secondsPassed = (int) ((time - lastFPSUpdateTime) / NANO_TO_SECOND);
        if(secondsPassed >= 1) {
            lastFPSUpdateTime = time;
            previousFPSCount = FPSCount;
            FPSCount = 1;
        }
        return previousFPSCount;
    }
}
