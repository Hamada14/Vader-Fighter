package spaceinvader;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Drawer {

    private final static String BACKGROUND_PATH  = "background.png";

    private final static int CANVAS_WIDTH = Main.WIDTH;
    private final static int CANVAS_HEIGHT = Main.HEIGHT;

    private final static int VELOCITY = 10000000;

    private final Image background;
    private final GraphicsContext gc;

    public Drawer(Canvas canvas) {
        background = new Image(BACKGROUND_PATH);

        canvas.setHeight(CANVAS_HEIGHT);
        canvas.setWidth(CANVAS_WIDTH);

        this.gc = canvas.getGraphicsContext2D();
    }

    public void updateBackground(long time) {
        int shift = (int)((time / VELOCITY) % background.getHeight());
        int heightRemain = (int) (background.getHeight() - shift);
        heightRemain = Math.min(heightRemain, CANVAS_HEIGHT);
        gc.drawImage(background, 0, shift, CANVAS_WIDTH, heightRemain, 0, 0, CANVAS_WIDTH, heightRemain);
        if(heightRemain < CANVAS_HEIGHT) {
            int missingPart = CANVAS_HEIGHT - heightRemain;
            gc.drawImage(background, 0, 0, CANVAS_WIDTH, missingPart, 0, heightRemain, CANVAS_WIDTH, missingPart);
        }
    }
}
