package co.edu.uptc.models;

import java.awt.Point;

public class Trajectory {
    
    private Point origin;
    private Point destination;

    public Trajectory(Point origin, Point destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Point getOrigin() {
        return origin;
    }

    public Point getDestination() {
        return destination;
    }
}