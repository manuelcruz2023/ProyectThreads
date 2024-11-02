package co.edu.uptc.interfaces;

import java.awt.Dimension;
import java.util.List;

import co.edu.uptc.models.Ship;

import java.awt.Point;

public interface Contract {

    public interface View {
        public void setPresenter(Contract.Presenter presenter);
        public void begin();
        public int numberOfShips();
        public void updatePosition(Point point);
        public Dimension screenSize();
    }

    public interface Presenter {
        public void setView(Contract.View view);
        public void setModel(Contract.Model model);
        public int getNumberOfShips();
        public void changePosition(Point point);
        public Dimension getScreenSize();
        public List<Ship> createShips();
    }

    public interface Model {
        public void setPresenter(Contract.Presenter presenter);
        public List<Ship> createShips();
    }
}
