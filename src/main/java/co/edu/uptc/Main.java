package co.edu.uptc;

import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.views.MainView;

public class Main {
    public static void main(String[] args) {
        Contract.View view = new MainView();
        view.begin();
    }
}