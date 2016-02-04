package resources;

/**
 * Created by harda on 04/02/2016.
 */
public class Paziente {

    String nome,cognome,descrizioneProblema;
    int codiceEmergenza;
    int età;
    /*
    Bianco=0    Verde=1     Giallo=2    Rosso=3
     */

    //costruttore sintetico che useremo
    public Paziente(String nome, int codiceEmergenza, int età) {
        this.nome = nome;
        this.codiceEmergenza = codiceEmergenza;
        this.età = età;
    }
    //costruttore completo che MAI useremo
    public Paziente(String nome, String cognome, String descrizioneProblema, int codiceEmergenza, int età) {
        this.nome = nome;
        this.cognome = cognome;
        this.descrizioneProblema = descrizioneProblema;
        this.codiceEmergenza = codiceEmergenza;
        this.età = età;
    }
}
