package code.games.hex.view.graphical;

import java.awt.*;

/**
 * A MoveEvent extends AWTEvent by exposing
 * a constructor that take a Point source. This
 * allows the consumer of the event to know what
 * Point was clicked.
 */
@SuppressWarnings("serial")
public class MoveEvent extends AWTEvent {
    public MoveEvent(Point destination, int id) {
        super(destination, id);
    }
}
