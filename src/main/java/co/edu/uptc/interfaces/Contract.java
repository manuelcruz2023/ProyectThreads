package co.edu.uptc.interfaces;

import java.awt.Dimension;
import java.util.List;
import co.edu.uptc.models.Ship;

public interface Contract {

    public interface View {
        public void setPresenter(Contract.Presenter presenter);
        public void begin();
        public int numberOfShips();
        public int setVelocity();
        public int setAparitionTime();
        public void updatePosition();
        public Dimension screenSize();
    }

    public interface Presenter {
        public void setView(Contract.View view);
        public void setModel(Contract.Model model);
        public int getNumberOfShips();
        public int getVelocity();
        public int getAparitionTime();
        public int setColitions();
        public void changePosition();
        public Dimension getScreenSize();
        public List<Ship> createShips();
        public void changeVelocity(Ship ship, int velocity);
        public void updateShipPosition(Ship ship, int x, int y);
    }

    public interface Model {
        public void setPresenter(Contract.Presenter presenter);
        public List<Ship> createShips();
        public int getColitions();
        public void changeVelocity(Ship ship, int velocity);
        public void updateShipPosition(Ship ship, int x, int y);
    }
}
