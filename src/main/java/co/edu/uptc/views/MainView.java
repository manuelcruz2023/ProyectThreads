package co.edu.uptc.views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.views.panelsMain.BodyMain;
import co.edu.uptc.views.panelsMain.HeaderMain;

public class MainView extends JFrame implements Contract.View{

    public Contract.Presenter presenter;


    public MainView() {
        initFrame();
        addPanels();
    }
    
    @Override
    public void begin() {
        this.setVisible(true);
    }

    public void initFrame() {
        this.setResizable(false);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
    }

    public void createHeaderMain() {
        HeaderMain headerMain = new HeaderMain();
        this.add(headerMain, BorderLayout.NORTH);
    }

    private void createBodyMain() {
        BodyMain bodyMain = new BodyMain();
        this.add(bodyMain, BorderLayout.CENTER);
    }

    private void addPanels() {
        createHeaderMain();
        createBodyMain();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;

    }
}
