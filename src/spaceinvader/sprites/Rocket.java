package spaceinvader.sprites;

import javafx.scene.image.Image;
import spaceinvader.Main;

import java.util.List;

public class Rocket extends Sprite {

    private final static String IMAGE_PATH = "rocket.png";
    private final static Image ROCKET_IMAGE;

    private final static int IMAGE_HEIGHT = 55;
    private final static boolean IMAGE_PRESERVE_RATIO = true;
    private final static boolean IMAGE_SMOOTHING = true;

    private final static double MAX_VELOCITY = 5;

    static {
        ROCKET_IMAGE = new Image(IMAGE_PATH, IMAGE_HEIGHT, 0, IMAGE_PRESERVE_RATIO, IMAGE_SMOOTHING);
    }

    public Rocket() {
        super(ROCKET_IMAGE, Main.WIDTH / 2 , Main.HEIGHT - 2 * ROCKET_IMAGE.getHeight());
    }

    public void updateState(List<String> keysPressed) {
        if(keysPressed.contains("LEFT") && !keysPressed.contains("RIGHT")) {
            setVelocityX(-1 * MAX_VELOCITY);
        } else if(keysPressed.contains("RIGHT") && !keysPressed.contains("LEFT")) {
            setVelocityX(MAX_VELOCITY);
        } else {
            setVelocityX(0);
        }
    }
}
