package co.edu.uptc.presenters;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.interfaces.Contract.Model;
import co.edu.uptc.interfaces.Contract.View;
import co.edu.uptc.models.Ship;

public class Presenter implements Contract.Presenter {

    private Contract.View view;
    private Contract.Model model;
    
    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void changePosition() {
        view.updatePosition();
    }

    @Override
    public Dimension getScreenSize() {
        return view.screenSize();
    }

    @Override
    public List<Ship> createShips() {
        return model.createShips();
    }

    @Override
    public int getNumberOfShips() {
        return view.numberOfShips();
    }

    @Override
    public int getVelocity() {
        return view.setVelocity();
    }
    
    @Override
    public int getAparitionTime() {
        return view.setAparitionTime();
    }

    @Override
    public void changeVelocity(Ship ship, int velocity) {
        model.changeVelocity(ship, velocity);
    }

    @Override
    public void updateShipPosition(Ship ship, int x, int y) {
        model.updateShipPosition(ship, x, y);
    }

    @Override
    public void continueMovement(Ship ship, Point point) {
        model.continueMovement(ship, point);
    }

    @Override
    public void updateTotalShipsOnScreen() {
        int totalShips = model.getTotalShipsOnScreen();
        view.updateTotalShipsOnScreen(totalShips);
    }

    @Override
    public void updateTotalShipsCrashed() {
        int totalCrashed = model.getTotalShipsCrashed();
        view.updateTotalShipsCrashed(totalCrashed);
    }
}
