package spaceinvader.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import spaceinvader.Main;

public class Drawer {

    private final static String BACKGROUND_PATH  = "background.png";

    private final static int CANVAS_WIDTH = Main.WIDTH;
    private final static int CANVAS_HEIGHT = Main.HEIGHT;

    private final static int VELOCITY = 10000000;

    private final Image background;
    private final GraphicsContext gc;

    private final int FPS_FONT_SIZE = 14;
    private final int FPS_X = 5;
    private final int FPS_Y = 15;

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

    public void updateFPS(int fpsCount) {
        gc.setFill(Color.GREEN);
        gc.setLineWidth(2);
        Font font = Font.font( "Times New Roman", FontWeight.BOLD, FPS_FONT_SIZE);
        gc.setFont(font);
        gc.fillText( "FPS: " + fpsCount, FPS_X, FPS_Y);
    }
}
