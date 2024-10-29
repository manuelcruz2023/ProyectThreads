package co.edu.uptc.views.panelsMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.views.dialogs.DialogPlay;

public class BodyMain extends JPanel{
    
    public BodyMain() {
        initFrame();
        addButtons();
        begin();
    }

    private void initFrame() {
        this.setBackground(new Color(235, 211, 248));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void begin() {
        this.setVisible(true);
    }

    private void createButtonPlay() {
        JButton buttonPlay = new JButton("Iniciar");
        buttonPlay.setBackground(new Color(62, 50, 50));
        buttonPlay.setForeground(Color.WHITE);
        buttonPlay.setPreferredSize(new Dimension(100, 100));
        buttonPlay.addActionListener(e -> {
            initDialogPlay();
        });
        this.add(buttonPlay);
        this.add(Box.createRigidArea(new Dimension(0, 20))); 
        this.add(Box.createVerticalGlue());
    }
    

    private void createButtonExit() {
        JButton buttonExit = new JButton("Salir");
        buttonExit.setBackground(new Color(62, 50, 50));
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setPreferredSize(new Dimension(100, 100));
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });
        this.add(buttonExit);
    }

    private void addButtons() {
        createButtonPlay();
        createButtonExit();
    }

    private void initDialogPlay() {
        DialogPlay dialogPlay = new DialogPlay();
        dialogPlay.begin();
    }
    
}
