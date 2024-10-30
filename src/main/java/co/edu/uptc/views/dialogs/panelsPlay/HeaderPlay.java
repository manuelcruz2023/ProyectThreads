package co.edu.uptc.views.dialogs.panelsPlay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPlay extends JPanel{
    
    public HeaderPlay() {
        initFrame();
        begin();
    }

    public void initFrame() {
        this.setBackground(new Color(36, 54, 66));
        this.setPreferredSize(new Dimension(400, 100));
        this.setLayout(new BorderLayout());
    }

    private void begin() {
        this.setVisible(true);
    }

    public void addTittle() {
        JLabel tittle = new JLabel(
            "<html><div style='text-align: center;'>Simulador de movimientos de OVNIS</div></html>");
        tittle.setHorizontalAlignment(JLabel.CENTER);
        tittle.setForeground(Color.WHITE);
        tittle.setFont(new Font("Arial", Font.BOLD, 35));
        this.add(tittle, BorderLayout.CENTER);
    }
}
