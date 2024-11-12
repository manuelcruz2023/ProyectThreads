package co.edu.uptc.models;

import java.awt.Point;

public class Ship {
    private Point point;
    private Thread thread;
    private int velocity;
    private Point destinationPoint;
    private Boolean selected = false;
    private Boolean selected2 = false;

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
    public Boolean getSelected() {
        return selected;
    }
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    public Boolean getSelected2() {
        return selected2;
    }
    public void setSelected2(Boolean selected2) {
        this.selected2 = selected2;
    }
}
