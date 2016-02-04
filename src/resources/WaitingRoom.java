package resources;

import adt.Coda;

/**
 * Creato da Vlady il 04/02/16.
 * in origine parte del progetto:
 * GestioneCodeOspedale
 */
public class WaitingRoom<Paziente> extends Coda {

    //dati della stanza
    int numPazientiCorrente=0;
    int numeroPazientiVisitati=0;

    public WaitingRoom() {

    }

    //aggiungo il paziente aggiornando i dati della sala
    public void addPaziente(Paziente patient){
        this.numPazientiCorrente++;
        this.enQueue(patient);
    }

    public boolean visitaProxPazInCoda(){

        this.numeroPazientiVisitati++;
        this.numPazientiCorrente--;
        //restituisco true se riesco a visitare(perchè c'è qualcuno) e false se non ci riesco
        try {
            this.deQueue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getNumeroTicket() {
        //restituisce una stringa con un codice unico che sembra quello delle macchine per numeri
        String uno,due;
        uno=new RandomString(2).nextString();
        due=""+uno;
        due.toUpperCase();
        due=due+"-"+numeroPazientiVisitati;
    }




}
