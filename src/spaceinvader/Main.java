package spaceinvader;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import spaceinvader.control.Controller;
import spaceinvader.game.Drawer;
import spaceinvader.game.Engine;
import spaceinvader.game.Game;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main extends Application {

    public final static int WIDTH = 1024;
    public final static int HEIGHT = 768;

    private final static String GAME_TITLE = "Space Invader";
    private final static boolean IS_RESIZABLE = false;

    public static void main(String[] args) {
        launch(args);
    }

    private void initializeStage(Stage stage) {
        stage.setTitle(GAME_TITLE);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setResizable(IS_RESIZABLE);
    }

    private Canvas addCanvas (Stage stage, Controller controller) {
        Canvas canvas = new Canvas();
        Group root = new Group();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        scene.setOnKeyPressed(controller.getPressHandler());
        scene.setOnKeyReleased(controller.getReleaseHandler());

        return canvas;
    }

    @Override
    public void start(Stage stage) {
        Controller controller = new Controller();
        Canvas canvas = addCanvas(stage, controller);
        Drawer drawer = new Drawer(canvas);
        Game game = new Game(drawer, new Engine(System.nanoTime()), controller);
        initializeStage(stage);
        stage.show();
        game.start();
    }
}
