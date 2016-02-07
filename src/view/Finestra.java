package view;

import resources.Paziente;
import resources.WaitingRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    private JTextArea txtAreaVisitati;
    private JPanel pnlEta;
    private JTextField inputEta;
    private JTextField inputNome;
    private JPanel pnlNomeCliente;
    private JPanel pnlForm;
    private JPanel pnlStoria1;
    private JLabel lblUltimoInserito;
    private JButton btnEsciPezzente;
    private JTextArea txtAreaInseriti;
    private JPanel pnlTasti;
    private JButton btnPazienteCasuale;
    private JPanel panelLabel;
    private JLabel lblCapienzaSala;
    private JLabel lblNumeroInAttesa;
    private JComboBox comboCodice;
    private JPanel pnlCognomeCliente;
    private JTextField inputCognome;
    private JLabel lblEseguite;
    int pazRossi = 0;
    int pazPlebei=0;
    //variabili progettuali

    String[] tabellaCodici;

    WaitingRoom stanza=new WaitingRoom();

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
        this.setLocationRelativeTo(null);
        //this.setPosizioneCentro();
        this.setVisible(true);
        this.setResizable(false);
    }

    public Finestra() {
        //array per ora non necesario per le core funcion del programma, solo per impostare l'inserimento della roba nella tendina

        tabellaCodici =new String[5];

        tabellaCodici[0]="Bianco";
        tabellaCodici[1]="Verde";
        tabellaCodici[2]="Giallo";
        tabellaCodici[3]="Rosso";
        tabellaCodici[4]="Scegliere il codice";

        //aggiungo roba alla tendina
        for (int i =0;i<=4;i++){
        comboCodice.addItem(tabellaCodici[i]);
        }

        //seleziono la prima voce (che gestirò come sbagliata dopo) come di default
        comboCodice.setSelectedIndex(4);

        btnMettiInSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //controllo l'estetica
                lblUltimoInserito.setText("");
                if (txtAreaInseriti.getText().equals("Ancora nulla qui...")) {
                    txtAreaInseriti.setText("");
                }

                //if di controllo, vedo se l'utente immette info sensate e complete
                //eccezioni gestite
                if (comboCodice.getSelectedIndex() != 4) {

                    int codicePaz=comboCodice.getSelectedIndex();

                    if (!inputNome.getText().equals("")) {

                        if (inputNome.getText().matches("[a-zA-Z]+")) {
                            String nome = inputNome.getText();

                        if (!inputCognome.getText().equals("")){
                            if(inputCognome.getText().matches("[a-zA-Z]+")){

                            String cognome=inputCognome.getText();
                            if (!inputEta.getText().equals("")) {
                                if (inputEta.getText().matches("^[-+]?\\d+(\\.\\d+)?$")) {

                                    if(codicePaz==3){
                                        pazRossi=pazRossi+1;
                                        lblCapienzaSala.setText(Integer.toString(pazRossi));
                                    }else{
                                        pazPlebei=pazPlebei+1;
                                        lblNumeroInAttesa.setText(Integer.toString(pazPlebei));
                                    }
                                    int età = Integer.parseInt(inputEta.getText());

                                    //qui ho tutti i dati del form

                                    stanza.addPaziente(nome,cognome, codicePaz, età);
                                    //qui ho aggiunto il paziente

                                    txtAreaInseriti.append(nome +" "+cognome+ " aggiunto, codice paziente: " + tabellaCodici[codicePaz] + "\n");

                                    System.out.println("FUNZIONA");

                                } else {
                                    lblUltimoInserito.setText("Inserire SOLO numeri nel campo età");
                                }
                            } else {
                                lblUltimoInserito.setText("Età non inserita");
                            }
                        }else {
                                lblUltimoInserito.setText("Inserire SOLO lettere nel cognome");
                            }
                        }else{
                            lblUltimoInserito.setText("Cognome non inserito");
                        }
                    }else{
                            lblUltimoInserito.setText("Inserire SOLO lettere nel nome");
                        }
                    }else {
                        lblUltimoInserito.setText("Nome non inserito");
                    }
                } else {
                    lblUltimoInserito.setText("Non hai selezionato la priorità del paziente");
                }
            }
        });

        btnPazienteCasuale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //nome da fare meglio
                inputNome.setText("Paolo");
                inputCognome.setText("Moretto");
                //creo età random
                Random r = new Random();
                int Low = 3;
                int High = 80;
                int Result = r.nextInt(High-Low) + Low;

                inputEta.setText(""+Result);

            }
        });
        btnEsciPezzente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lblUltimoInserito.setText("");
                if (txtAreaVisitati.getText().equals("Ancora nulla qui...")) {
                    txtAreaVisitati.setText("");
                }
                try {
                    Paziente tmp=stanza.visitaProxPazInCoda();
                    if (tmp==null){
                        lblUltimoInserito.setText("Nessun paziente inserito");
                    }else{
                        String nome=tmp.getNome();
                        String cognome=tmp.getCognome();
                        int eta=tmp.getEtà();
                        txtAreaVisitati.append(nome+" "+cognome+" "+eta+" "+" VISITATO"+"\n");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        //main
        Finestra f = new Finestra("Gestione Code Ospedale", 750, 450);
    }
}