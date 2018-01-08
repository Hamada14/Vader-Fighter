package spaceinvader.control;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Controller {

    private final ControlPressHandler pressHandler;
    private final ControlReleaseHandler releaseHandler;

    private final CopyOnWriteArrayList<String> keys;
    public Controller() {
        this.keys = new CopyOnWriteArrayList<>();
        this.pressHandler = new ControlPressHandler(keys);
        this.releaseHandler = new ControlReleaseHandler(keys);
    }

    public List<String> getPressedKeys() {
        return new ArrayList(keys);
    }

    public ControlPressHandler getPressHandler() {
        return pressHandler;
    }

    public ControlReleaseHandler getReleaseHandler() {
        return releaseHandler;
    }
}
