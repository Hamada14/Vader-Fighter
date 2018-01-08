package spaceinvader;

import javafx.animation.AnimationTimer;

public class Game extends AnimationTimer {

    private Drawer drawer;

    public Game(Drawer drawer) {
        this.drawer = drawer;
    }

    @Override
    public void handle(long time) {

        draw(time);
    }

    private void draw(long time) {
        drawer.updateBackground(time);
    }
}
