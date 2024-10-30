package co.edu.uptc.models;

import java.awt.Point;
import java.util.Random;

import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.utils.UtilThread;

public class ManagerModel implements Contract.Model{

    private Contract.Presenter presenter;
    private Point point;
    private Random random = new Random();

    public ManagerModel() {

    }
    
    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void moveX() {
        point = new Point(0, 0);
        Thread thread = new Thread(() -> {
            while(point.x < 100) {
                point.x++;
                UtilThread.sleep(10);
                presenter.changePosition(point);
            } 
        });
        thread.start();
    }
}
