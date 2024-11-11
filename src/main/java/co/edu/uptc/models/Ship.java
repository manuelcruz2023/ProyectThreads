package co.edu.uptc.models;

import java.awt.Point;

public class Ship {
    private Point point;
    private Thread thread;
    private int velocity;
    private Point destinationPoint;

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
    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    public Point getDestinationPoint() {
        return destinationPoint;
    }
    public void setDestinationPoint(Point destinationPoint) {
        this.destinationPoint = destinationPoint;
    }
}
