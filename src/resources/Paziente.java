package resources;

/**
 * Created by harda on 04/02/2016.
 */
public class Paziente {

    String nome,cognome,descrizioneProblema,ticket;
    int colore;
    int età;
    /*
    Bianco=0    Verde=1     Giallo=2    Rosso=3
     */


    //costruttore sintetico che useremo
    public Paziente(String nome, int colore, int età,String ticket) {
        this.nome = nome;
        this.colore = colore;
        this.età = età;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
