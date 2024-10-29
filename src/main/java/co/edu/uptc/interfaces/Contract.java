package co.edu.uptc.interfaces;

public interface Contract {

    public interface View {
        public void setPresenter(Contract.Presenter presenter);
        public void begin();
    }

    public interface Presenter {
        public void setView(Contract.View view);
        public void setModel(Contract.Model model);
    }

    public interface Model {
        public void setPresenter(Contract.Presenter presenter);
    }
}
