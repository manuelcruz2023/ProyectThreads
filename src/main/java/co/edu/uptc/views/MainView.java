package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import co.edu.uptc.interfaces.Contract;
import co.edu.uptc.views.dialogs.DialogPlay;
import co.edu.uptc.views.resourcesView.BackgroundPanel;
import co.edu.uptc.views.resourcesView.RoundedButton;

public class MainView extends JFrame implements Contract.View {

    public Contract.Presenter presenter;
    private JPanel panel = new JPanel();
    public DialogPlay dialogPlay;
    public int numberOfShips;

    public MainView() {
        initFrame();
        createContentPane();
        addPanel();
        addTittle();
        createButtons();
    }

    @Override
    public void begin() {
        this.setVisible(true);
    }

    public void initFrame() {

        this.setResizable(false);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
    }

    private void createContentPane() {
        BackgroundPanel backgroundPanel = new BackgroundPanel(
                "src\\main\\java\\co\\edu\\uptc\\images\\inicioJuegoNaves.jpg");
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        this.setContentPane(backgroundPanel);
    }

    private void addTittle() {
        JLabel tittle = new JLabel("Simulador de Naves");
        tittle.setForeground(Color.WHITE);
        tittle.setFont(new java.awt.Font("Arial", 1, 30));
        panel.add(tittle);
        panel.add(Box.createVerticalStrut(250));
    }

    private void createButtonStart() {
        RoundedButton buttonStart = new RoundedButton("Iniciar Juego");
        buttonStart.setPreferredSize(new java.awt.Dimension(150, 50));
        buttonStart.addActionListener(e -> {
            createDialogPLay();
        });
        panel.add(buttonStart);
    }

    private void createButtonOptions() {
        RoundedButton buttonOptions = new RoundedButton("Opciones");
        buttonOptions.setPreferredSize(new java.awt.Dimension(150, 50));
        buttonOptions.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(null, 
                        "Ingrese el número de naves:", "Opciones", 
                                    JOptionPane.QUESTION_MESSAGE);
            numberOfShips = Integer.parseInt(input);
        });
        panel.add(buttonOptions);
    }

    private void createButtonExit() {
        RoundedButton buttonExit = new RoundedButton("Salir");
        buttonExit.setPreferredSize(new java.awt.Dimension(150, 50));
        buttonExit.addActionListener(e -> System.exit(0));
        panel.add(buttonExit);
    }

    private void addPanel() {
        panel.setOpaque(false);
        this.add(panel);
    }

    private void createButtons() {
        createButtonStart();
        createButtonOptions();
        createButtonExit();
    }

    private void createDialogPLay() {
        dialogPlay = new DialogPlay(this);
        dialogPlay.begin();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void updatePosition(Point point) {
        if (dialogPlay != null) {
            dialogPlay.displacementPlay.updatePosition(point);
        }
    }

    @Override
    public Dimension screenSize() {
        Dimension size= new Dimension();
        if (dialogPlay != null && dialogPlay.displacementPlay != null) {
            size = dialogPlay.displacementPlay.getSize();
        }
        return size;
    }

    @Override
    public int numberOfShips() {
        return numberOfShips;
    }
}