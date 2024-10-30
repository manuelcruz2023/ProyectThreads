package co.edu.uptc.interfaces;

import java.awt.Point;

public interface Contract {

    public interface View {
        public void setPresenter(Contract.Presenter presenter);
        public void begin();
        public void updatePosition(Point point);
    }

    public interface Presenter {
        public void setView(Contract.View view);
        public void setModel(Contract.Model model);
        public void moveX();
        public void changePosition(Point point);
    }

    public interface Model {
        public void setPresenter(Contract.Presenter presenter);
        public void moveX();
    }
}
