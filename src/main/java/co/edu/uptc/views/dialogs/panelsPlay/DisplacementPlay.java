package co.edu.uptc.views.dialogs.panelsPlay;

import co.edu.uptc.models.Ship;
import co.edu.uptc.views.MainView;
import co.edu.uptc.views.resourcesView.BackgroundPanel;

import java.awt.*;
import java.util.List;

public class DisplacementPlay extends BackgroundPanel {
    private MainView mainView;
    private List<Ship> ships;

    public DisplacementPlay(MainView mainView, String backgroundImagePath) {
        super(backgroundImagePath); // Llama al constructor de BackgroundPanel con la ruta de la imagen
        this.mainView = mainView;
        initFrame();
        begin();
    }

    public void initFrame() {
        this.setPreferredSize(new Dimension(400, 150));
    }

    private void begin() {
        this.setVisible(true);
    }

    @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // Llama a la implementación de BackgroundPanel para dibujar la imagen de fondo
    
            // Dibuja los barcos
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
}
