package resources;

import adt.Coda;

/**
 * Creato da Vlady il 04/02/16.
 * in origine parte del progetto:
 * GestioneCodeOspedale
 */
public class WaitingRoom {

    Coda <Paziente> codRosso=new Coda<>();
    Coda <Paziente>codGiallo=new Coda<>();
    Coda <Paziente>codVerde=new Coda<>();
    Coda <Paziente>codBianco=new Coda<>();

    //dati della stanza
    int numPazientiCorrente=0;
    int numeroPazientiVisitati=0;

    public WaitingRoom() {
//        //code inizializzate
//        codRosso =new Coda();
//        codGiallo=new Coda();
//        codVerde=new Coda();
//        codBianco=new Coda();
    }

    //aggiungo il paziente aggiornando i dati della sala
    public void addPaziente(String nome,String cognome,int colore,int età){
        this.numPazientiCorrente++;

        //creo un nuovo paziente qui dato che mi servono i dati della stanza
        Paziente toAdd=new Paziente( nome,cognome, colore, età,getRandTicket());

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

    public Paziente visitaProxPazInCoda() throws Exception {

        if (!codRosso.isEmpty()) {
//            Paziente inUscita;
            Paziente inUscita=(Paziente)codRosso.getFronte().getInfo();
            //lancio eccezione a livello di metodo, il deQueue sotto deve funzionare per forza perchè sono in un if di !vuoto
            codRosso.deQueue();
            return inUscita;
        } else if (!codGiallo.isEmpty()) {
            Paziente inUscita=(Paziente)codGiallo.getFronte().getInfo();
            //lancio eccezione a livello di metodo, il deQueue sotto deve funzionare per forza perchè sono in un if di !vuoto
            codGiallo.deQueue();
            return inUscita;
        } else if (!codVerde.isEmpty()) {
            Paziente inUscita=(Paziente)codVerde.getFronte().getInfo();
            //lancio eccezione a livello di metodo, il deQueue sotto deve funzionare per forza perchè sono in un if di !vuoto
            codVerde.deQueue();
            return inUscita;
        } else if (!codBianco.isEmpty()) {
            Paziente inUscita = (Paziente) codBianco.getFronte().getInfo();
            //lancio eccezione a livello di metodo, il deQueue sotto deve funzionare per forza perchè sono in un if di !vuoto
            codBianco.deQueue();
            return inUscita;
        } else {
            return null;
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

    //controllo se tutte le code sono vuote
    public boolean codeEmpty(){
        if(codBianco.isEmpty()==true && codVerde.isEmpty()==true && codGiallo.isEmpty()==true && codRosso.isEmpty()==true){
            return true;
        }
        else{
            return false;
        }
    }
}
