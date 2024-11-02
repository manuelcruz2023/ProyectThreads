package co.edu.uptc.views.dialogs.panelsPlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;

import co.edu.uptc.models.Ship;
import co.edu.uptc.views.MainView;

public class DisplacementPlay extends JPanel {

    public MainView mainView;
    private Point point;
    private List<Ship> ships;

    public DisplacementPlay(MainView mainView) {
        this.mainView = mainView;
        initFrame();
        begin();
    }

    public void initFrame() {
        this.setBackground(new Color(98, 149, 132));
        this.setPreferredSize(new Dimension(400, 150));
    }

    private void begin() {
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        ships = mainView.presenter.createShips();
        super.paint(g);
        if (ships != null) {
            for (Ship ship : ships) {
                g.drawOval(ship.getPoint().x, ship.getPoint().y, 30, 30);
            }
        }
    }

    public void updatePosition(Point point) {
        this.point = point;
        repaint();
    }
}
