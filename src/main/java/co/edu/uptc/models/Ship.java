package co.edu.uptc.models;

import java.awt.Point;
import java.util.List;

public class Ship {
    private Point point;
    private Thread thread;

    public Ship() {

    }
    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    public Thread getThread() {
        return thread;
    }
    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
