package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel pnlStoriaViaggi;
    private JButton btnCaricaAuto;
    private JLabel lblViaggi;
    private JPanel pnlCenter;
    private JPanel pnlDX;
    private JTextArea txtAreaUscita;
    private JPanel pnlTarga;
    private JTextField inputFieldTarga;
    private JTextField inputFieldLunghezza;
    private JPanel pnlNomeCliente;
    private JPanel pnlRiempimentoTraghetto;
    private JPanel pnlStoriaInserimenti;
    private JLabel lblUltimoInserito;
    private JButton btnEsciAuto;
    private JTextArea txtAreaInseriti;
    private JPanel pnlTasti;
    private JProgressBar progressCapienzaTraghetto;
    private JButton btnAutoCasuale;
    private JPanel pnlSemaforo;
    private JLabel lblGrandezzaTraghetto;
    private JLabel lblSogliaViaggio;
    private JPanel panelLabel;
    private JLabel lblNumeroGrandezza;
    private JLabel lblNumeroSoglia;
    private JLabel lblEseguite;



    //inizio variabili d'appoggio
    //private String semaforo; //può essere solo R,Y,G (red,yellow,green), l'ho usato per avere più possibilità rispetto al
    // booleano
    private int dimensioneTraghetto = 100;//tarata per essere 100 ma modificabile
    private int caratteriDiTarga = 7;//tarata per 7 ma modificabile
    private int sogliaViaggioMinimo = 75;//tarata per 75 ma modificabile
    private boolean arrADest = false;

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


    }

    public static void main(String[] args) throws Exception {
        //main
        Finestra f = new Finestra("Caronte 1.1 | By Hopeless13", 750, 450);
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