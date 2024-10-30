package co.edu.uptc.views.dialogs.panelsPlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import co.edu.uptc.views.dialogs.DialogPlay;

public class DisplacementPlay extends JPanel {

    private Point point = new Point(100, 100);
    public DialogPlay dialogPlay;

    public DisplacementPlay(DialogPlay dialogPlay) {
        this.dialogPlay = dialogPlay;
        initFrame();
        begin();
        move();
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
        super.paint(g);
        g.drawOval(point.x, point.y, 30, 30);
    }

    private void move() {
        this.dialogPlay.bodyMain.mainView.presenter.moveX();
    }

    public void updatePosition(Point point) {
        this.point = point;
        repaint();
    }
}
