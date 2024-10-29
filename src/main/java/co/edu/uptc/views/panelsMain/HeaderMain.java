package co.edu.uptc.views.panelsMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderMain extends JPanel{
    
    public HeaderMain() {
        initFrame();
        addTittle();
        begin();
    }

    public void initFrame() {
        this.setBackground(new Color(62, 50, 50));
        this.setPreferredSize(new Dimension(400, 150));
        this.setLayout(new BorderLayout());
    }

    private void begin() {
        this.setVisible(true);
    }

    public void addTittle() {
        JLabel tittle = new JLabel(
            "<html><div style='text-align: center;'>Simulador de<br>movimientos de OVNIS</div></html>");
        tittle.setHorizontalAlignment(JLabel.CENTER);
        tittle.setForeground(Color.WHITE);
        tittle.setFont(new Font("Arial", Font.BOLD, 35));
        this.add(tittle, BorderLayout.CENTER);
    }
}
