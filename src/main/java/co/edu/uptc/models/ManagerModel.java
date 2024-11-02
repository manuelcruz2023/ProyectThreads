package co.edu.uptc.models;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.utils.UtilThread;

public class ManagerModel implements Contract.Model {

    private Contract.Presenter presenter;
    private List<Ship> ships;
    private Random random;
    Dimension screenSize;

    public ManagerModel() {
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public List<Ship> createShips() {
        int numberOfShips = presenter.getNumberOfShips();
        ships = new ArrayList<>();
        for (int i = 0; i < numberOfShips; i++) {
            ships.add(randomApperance());
        }
        return ships;
    }

    public Ship randomApperance() {
        Ship ship = new Ship();
        screenSize = presenter.getScreenSize();
        presenter.getScreenSize();
        random = new Random();
        Point randomPoint = new Point();
        randomPoint = new Point(random.nextInt((int) screenSize.getWidth() - 30),
                random.nextInt((int) screenSize.getHeight() - 30));
        ship.setPoint(randomPoint);
        return ship;
    }
}
