package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.models.ManagerModel;
import co.edu.uptc.views.MainView;

public class Runner {

    Contract.View view;
    Contract.Model model;
    Contract.Presenter presenter;

    private void makeMVP () {
        view = new MainView();
        model = new ManagerModel();
        presenter = new Presenter();
        model.setPresenter(presenter);
        view.setPresenter(presenter);
        presenter.setView(view);
        presenter.setModel(model);
    }

    public void run() {
        makeMVP();
        view.begin();
    }
}
