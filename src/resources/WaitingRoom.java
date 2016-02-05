package resources;

import adt.Coda;

/**
 * Creato da Vlady il 04/02/16.
 * in origine parte del progetto:
 * GestioneCodeOspedale
 */
public class WaitingRoom {

    Coda codRosso;
    Coda codGiallo;
    Coda codVerde;
    Coda codBianco;

    //dati della stanza
    int numPazientiCorrente=0;
    int numeroPazientiVisitati=0;

    public WaitingRoom() {
        //code inizializzate
        codRosso <Paziente>=new Coda<>();
        codGiallo=new Coda();
        codVerde=new Coda();
        codBianco=new Coda();
    }

    //aggiungo il paziente aggiornando i dati della sala
    public void addPaziente(String nome,int colore,int età){
        this.numPazientiCorrente++;

        //creo un nuovo paziente qui dato che mi servono i dati della stanza
        Paziente toAdd=new Paziente( nome, colore, età,getRandTicket());

        //aggiungo il paziente alla lista interessata
        switch (toAdd.colore) {
            case 0:
                codBianco.enQueue(toAdd);
                break;
            case 1:
                codVerde.enQueue(toAdd);
                break;
            case 2:
                codGiallo.enQueue(toAdd);
                break;
            case 3:
                codRosso.enQueue(toAdd);
                break;
        }
    }

    public boolean visitaProxPazInCoda(){

        if (!codRosso.isEmpty()) {
            Paziente inUscita;
            inUscita=codRosso.getFronte()
        } else if () {
        } else if () {
        } else if () {
        }

    }

    public String getRandTicket() {
        //restituisce una stringa con un codice unico che sembra quello delle macchine per numeri
        String uno,due;
        uno=new RandomString(2).nextString();
        due=""+uno;

        due.toUpperCase();
        return due=due+"-"+numeroPazientiVisitati;
    }
}
