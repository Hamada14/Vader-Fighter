package spaceinvader.sprites;

import javafx.scene.image.Image;
import spaceinvader.Main;

public class Sprite {

    private final static int SLOW_RATIO = 10000000;

    private double x, y;
    private double velocityX, velocityY;

    private final Image spriteImage;

    public Sprite(Image spriteImage, double x, double y) {
        this.spriteImage = spriteImage;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public Image getImage() {
        return spriteImage;
    }

    public void updatePosition(double time) {
        double newX = x + time * velocityX / SLOW_RATIO;
        double newY = y + time * velocityY / SLOW_RATIO;

        newX = Math.max(0, newX);
        newX = Math.min(Main.WIDTH - spriteImage.getWidth(), newX);

        newY = Math.max(0, newY);
        newY = Math.min(Main.HEIGHT, newY);

        x = newX;
        y = newY;
    }
}
