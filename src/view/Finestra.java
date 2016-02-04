package view;

import resources.Paziente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Creato da Vlady il 15/01/2016.
 * in origine parte del progetto:
 * PilaProjYakovenko
 */
public class Finestra extends JFrame {
    //componenti GUI
    private JPanel rootPanel;
    private JTextField inputField;
    private JPanel pnlStoria2;
    private JButton btnMettiInSala;
    private JLabel lblViaggi;
    private JPanel pnlCenter;
    private JPanel pnlDX;
    private JTextArea txtAreaUscita;
    private JPanel pnlEta;
    private JTextField inputEta;
    private JTextField inputNome;
    private JPanel pnlNomeCliente;
    private JPanel pnlForm;
    private JPanel pnlStoria1;
    private JLabel lblUltimoInserito;
    private JButton btnEsciAuto;
    private JTextArea txtAreaInseriti;
    private JPanel pnlTasti;
    private JButton btnPazienteCasuale;
    private JPanel panelLabel;
    private JLabel lblCapienzaSala;
    private JLabel lblNumeroInAttesa;
    private JComboBox comboCodice;
    private JLabel lblEseguite;

    //variabili progettuali

    String[] contenutiTendina;

    //colori
    private Color coloreSuccesso = new Color(0, 132, 0);
    private Color coloreMain = new Color(0, 146, 255);

    public Finestra(String title, int larghezza, int altezza) {
        //setup iniziale finestra
        super(title);
        this.setContentPane(new Finestra().rootPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(larghezza, altezza);
        this.setPosizioneCentro();
        this.setVisible(true);
        this.setResizable(false);
    }

    public Finestra() {

        contenutiTendina[0]="Bianco";
        contenutiTendina[1]="Verde";
        contenutiTendina[2]="Giallo";
        contenutiTendina[3]="Rosso";
        contenutiTendina[4]="Scegliere il codice";

        for (int i =0;i<4;i++){
            comboCodice.add(contenutiTendina[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        //main
        Finestra f = new Finestra("Gestione Code Ospedale", 750, 450);
    }

    public void setPosizioneCentro() {
        // valuta le dimensioni della finestra
        int larg;
        int alt;
        alt = this.getHeight();
        larg = this.getWidth();
        // serve per la risoluzione dello schermo
        final Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension dimensione = kit.getScreenSize();
        final int x = dimensione.width / 2 - larg / 2;
        final int y = dimensione.height / 2 - alt / 2;
        this.setLocation(x, y);
    }
    
}