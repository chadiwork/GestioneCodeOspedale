package resources;

/**
 * Created by harda on 04/02/2016.
 */
public class Paziente {

    String nome,cognome,descrizioneProblema;
    int codiceEmergenza;
    /*
    Bianco=0    Verde=1     Giallo=2    Rosso=3
     */
    public Paziente(int codiceEmergenza, String cognome, String descrizioneProblema, String nome) {
        this.codiceEmergenza = codiceEmergenza;
        this.cognome = cognome;
        this.descrizioneProblema = descrizioneProblema;
        this.nome = nome;
    }

}
