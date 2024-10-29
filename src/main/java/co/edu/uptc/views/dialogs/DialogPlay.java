package co.edu.uptc.views.dialogs;

import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.Toolkit;

public class DialogPlay extends JDialog {

    public DialogPlay() {
        initFrame();
    }

    public void initFrame() {
        this.setTitle("Play");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void begin() {
        this.setVisible(true);
    }
}
