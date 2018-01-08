package spaceinvader.game;

import spaceinvader.sprites.Rocket;
import spaceinvader.sprites.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    private long lastWakeUp;

    private Rocket rocket;

    public Engine(long lastWakeUp) {
        this.lastWakeUp = lastWakeUp;
        this.rocket = new Rocket();
    }

    public void updateSystem(long time, List<String> pressedKeys) {
        rocket.updateState(pressedKeys);
        updatePositions(time);
        lastWakeUp = time;
    }

    private void updatePositions(long time) {
        long timeDifference = time - lastWakeUp;
        rocket.updatePosition(timeDifference);
    }

    public List<Sprite> getSprites() {
        List<Sprite> sprites = new ArrayList<>();
        sprites.add(rocket);
        return sprites;
    }
}
