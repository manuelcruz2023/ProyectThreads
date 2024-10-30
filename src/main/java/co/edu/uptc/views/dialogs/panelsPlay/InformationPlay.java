package co.edu.uptc.views.dialogs.panelsPlay;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class InformationPlay extends JPanel{
    
    public InformationPlay() {
        initFrame();
        begin();
    }

    public void initFrame() {
        this.setBackground(new Color(56, 116, 120));
        this.setPreferredSize(new Dimension(300, 150));
    }

    private void begin() {
        this.setVisible(true);
    }
    
}
