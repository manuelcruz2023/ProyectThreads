package co.edu.uptc.views.dialogs.panelsPlay;

import co.edu.uptc.models.Ship;
import co.edu.uptc.views.MainView;
import co.edu.uptc.views.resourcesView.BackgroundPanel;

import java.awt.*;
import java.util.List;

import javax.swing.JPanel;

public class DisplacementPlay extends BackgroundPanel {
    private MainView mainView;
    private List<Ship> ships;
    private JPanel destinationPanel;

    public DisplacementPlay(MainView mainView, String backgroundImagePath) {
        super(backgroundImagePath);
        this.mainView = mainView;
        initFrame();
        begin();
        addDestination();
    }

    public void initFrame() {
        this.setPreferredSize(new Dimension(400, 150));
    }

    private void begin() {
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ships == null) {
            ships = mainView.presenter.createShips();
        }
        if (ships != null) {
            for (Ship ship : ships) {
                g.setColor(Color.WHITE);
                g.drawOval(ship.getPoint().x, ship.getPoint().y, 30, 30);
            }
        }
    }

    public void updatePosition() {
        repaint();
    }

    public void addDestination() {
        destinationPanel = new JPanel();
        destinationPanel.setPreferredSize(new Dimension(30, 30));
        destinationPanel.setLocation(this.getWidth() - 30, this.getHeight() - 30);
        destinationPanel.setBackground(Color.white);
        add(destinationPanel);
        repaint();
    }
}
