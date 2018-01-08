package spaceinvader.control;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.concurrent.CopyOnWriteArrayList;

public class ControlReleaseHandler implements EventHandler<KeyEvent> {

    private CopyOnWriteArrayList<String> keys;

    public ControlReleaseHandler(CopyOnWriteArrayList<String> keys) {
        this.keys = keys;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        String strCode = keyEvent.getCode().toString();
        keys.remove(strCode);
    }
}
