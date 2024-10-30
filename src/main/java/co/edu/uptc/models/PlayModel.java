package co.edu.uptc.models;

import java.awt.Point;

public class PlayModel {
    
    private Point point;
    
    private void moveX() {
        Thread thread = new Thread(() -> {
            while(point.x < 100) {
                point.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } 
        });
    }
}
