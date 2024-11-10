package co.edu.uptc.views.dialogs.panelsPlay;

import co.edu.uptc.models.Ship;
import co.edu.uptc.utils.UtilThread;
import co.edu.uptc.views.MainView;
import co.edu.uptc.views.resourcesView.BackgroundPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class DisplacementPlay extends BackgroundPanel {
    private MainView mainView;
    public List<Ship> ships;
    private JPanel destinationPanel;
    private Image shipImage;
    private Image scaledShipImage;
    private Graphics g;

    public DisplacementPlay(MainView mainView, String backgroundImagePath, String imagePath) {
        super(backgroundImagePath);
        this.mainView = mainView;
        shipImage = new ImageIcon(imagePath).getImage();
        scaledShipImage = shipImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        initFrame();
        begin();
        addDestination();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });
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
                g.drawImage(scaledShipImage, ship.getPoint().x, ship.getPoint().y, this);
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

    private void handleMouseClick(MouseEvent e) {
        Point clickPoint = e.getPoint();
        if (ships != null) {
            for (Ship ship : ships) {
                Point shipPoint = ship.getPoint();
                Rectangle shipBounds = new Rectangle(shipPoint.x, shipPoint.y, 100, 100);
                if (shipBounds.contains(clickPoint)) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        addPopupMenu(ship, e);
                    }else if (SwingUtilities.isLeftMouseButton(e)) {
                        Component component = e.getComponent();
                        component.addMouseMotionListener(new MouseMotionAdapter() {
                            @Override
                            public void mouseMoved(MouseEvent e) {
                                mainView.presenter.updateShipPosition(ship, e.getX(), e.getY());
                                UtilThread.sleep(50);
                            }
                
                            @Override
                            public void mouseDragged(MouseEvent e) {
                                mainView.presenter.updateShipPosition(ship, e.getX(), e.getY());
                            }
                        });
                    }
                }
            }
        }
    }

    private void addPopupMenu(Ship ship, MouseEvent e) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem decreaseSpeedItem = new JMenuItem("Disminuir velocidad");
        decreaseSpeedItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ship.setVelocity(ship.getVelocity() + (ship.getVelocity() + (ship.getVelocity() / 2)));
            }
        });
        JMenuItem increaseSpeedItem = new JMenuItem("Aumentar velocidad");
        increaseSpeedItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ship.setVelocity(ship.getVelocity() - (ship.getVelocity() - (ship.getVelocity() / 2)));
            }
        });
        popupMenu.add(decreaseSpeedItem);
        popupMenu.add(increaseSpeedItem);
        popupMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    public void addMouseMotionListenerToComponent(Component component) {
        component.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
    }
}
