package spaceinvader.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import spaceinvader.Main;
import spaceinvader.sprites.Sprite;

import java.util.List;

public class Drawer {

    private final static String BACKGROUND_PATH  = "background.png";

    private final static int CANVAS_WIDTH = Main.WIDTH;
    private final static int CANVAS_HEIGHT = Main.HEIGHT;

    private final static int BACKGROUND_VELOCITY = 10000000;

    private final static int FPS_FONT_SIZE = 14;
    private final static int FPS_X = 5;
    private final static int FPS_Y = 15;

    private final static int FONT_LINE_WIDTH = 2;

    private final Image background;
    private final GraphicsContext gc;

    public Drawer(Canvas canvas) {
        background = new Image(BACKGROUND_PATH);

        canvas.setHeight(CANVAS_HEIGHT);
        canvas.setWidth(CANVAS_WIDTH);

        this.gc = canvas.getGraphicsContext2D();
    }

    public void draw(long time, List<Sprite> sprites, int fpsCount) {
        drawBackground(time);
        drawSprites(sprites);
        writeFPSCount(fpsCount);
    }

    private void drawBackground(long time) {
        int shift = (int)((((-time / BACKGROUND_VELOCITY) % background.getHeight())
                + background.getHeight()) % background.getHeight());
        int drawnHeight = (int) (background.getHeight() - shift);
        int missingHeight = Math.min(CANVAS_HEIGHT, CANVAS_HEIGHT - drawnHeight);
        drawnHeight = Math.min(drawnHeight, CANVAS_HEIGHT);
        gc.drawImage(background, 0, shift, CANVAS_WIDTH, drawnHeight, 0, 0, CANVAS_WIDTH, drawnHeight);
        if(missingHeight >= 0) {
            int startPoint = (int) ((shift + drawnHeight) % background.getHeight());
            gc.drawImage(background, 0, startPoint, CANVAS_WIDTH, missingHeight, 0, drawnHeight, CANVAS_WIDTH, missingHeight);
        }
    }

    private void writeFPSCount(int fpsCount) {
        gc.setFill(Color.GREEN);
        gc.setLineWidth(FONT_LINE_WIDTH);
        Font font = Font.font( "Times New Roman", FontWeight.BOLD, FPS_FONT_SIZE);
        gc.setFont(font);
        gc.fillText( "FPS: " + fpsCount, FPS_X, FPS_Y);
    }

    private void drawSprites(List<Sprite> sprites) {
        for(Sprite sprite : sprites) {
            gc.drawImage(sprite.getImage(), sprite.getX(), sprite.getY());
        }
    }
}
