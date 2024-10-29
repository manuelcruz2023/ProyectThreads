package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.interfaces.Contract.Model;
import co.edu.uptc.interfaces.Contract.View;

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
    
}
