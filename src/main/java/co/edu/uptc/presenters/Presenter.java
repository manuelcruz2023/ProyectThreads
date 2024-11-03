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
    
}
