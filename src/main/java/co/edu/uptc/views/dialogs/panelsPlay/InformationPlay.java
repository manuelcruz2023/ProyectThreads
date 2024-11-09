package co.edu.uptc.views.dialogs.panelsPlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.views.MainView;
import co.edu.uptc.views.resourcesView.BackgroundPanel;

public class InformationPlay extends BackgroundPanel {

    private MainView mainView;

    public InformationPlay(MainView mainView) {
        super("src\\main\\java\\co\\edu\\uptc\\images\\backgroundInformation.png");
        this.mainView = mainView;
        initFrame();
        begin();
        addLabels();
    }

    public void initFrame() {
        this.setBackground(new Color(56, 116, 120));
        this.setPreferredSize(new Dimension(300, 150));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void begin() {
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void addLabelNumShips() {
        JLabel label = new JLabel("<html><div style='text-align: center;'>Número de OVNIS: " +
                        mainView.numberOfShips + "</div></html>");
        label.setPreferredSize(new Dimension(100, 150));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBorder(new EmptyBorder(0, 30, 0, 30));
        this.add(label);
    }

    private void addLabelAparitionTime() {
        JLabel label = new JLabel("<html><div style='text-align: center;'>Tiempo de aparición de OVNIS:" + mainView.aparitionTime + " ms</div></html>");
        label.setPreferredSize(new Dimension(100, 150));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBorder(new EmptyBorder(0, 30, 0, 30));
        this.add(label);
    }

    private void addLabelVelocity() {
        JLabel label = new JLabel("<html><div style='text-align: center;'>Velocidad de OVNIS: " + mainView.velocity + "ms</div></html>");
        label.setPreferredSize(new Dimension(100, 150));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBorder(new EmptyBorder(0, 30, 0, 30));
        this.add(label);
    }

    private void addLabelMovementShips() {
        JLabel label = new JLabel("<html><div style='text-align: center;'>OVNIS en movimiento: </div></html>");
        label.setPreferredSize(new Dimension(100, 150));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBorder(new EmptyBorder(0, 30, 0, 30));
        this.add(label);
    }

    private void addLabelCrashedShips() {
        JLabel label = new JLabel("<html><div style='text-align: center;'>OVNIS estrellados: " +
          mainView.getColitions() + "</div></html>");
        label.setPreferredSize(new Dimension(100, 150));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBorder(new EmptyBorder(0, 30, 0, 30));
        this.add(label);
    }

    private void addVelocityConfig() {
        
    }

    private void addLabels() {
        addLabelNumShips();
        addLabelAparitionTime();
        addLabelVelocity();
        addLabelMovementShips();
        addLabelCrashedShips();
    }
}
