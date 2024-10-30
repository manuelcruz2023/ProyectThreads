package co.edu.uptc.views;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JFrame;
import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.views.dialogs.panelsPlay.DisplacementPlay;
import co.edu.uptc.views.panelsMain.BodyMain;
import co.edu.uptc.views.panelsMain.HeaderMain;

public class MainView extends JFrame implements Contract.View{

    public Contract.Presenter presenter;
    public BodyMain bodyMain;

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
        bodyMain = new BodyMain(this);
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

    @Override
    public void updatePosition(Point point) {
        DisplacementPlay displacementPlay = new DisplacementPlay(bodyMain.dialogPlay);
        displacementPlay.updatePosition(point);
    }
}
