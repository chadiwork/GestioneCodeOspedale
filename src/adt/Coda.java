/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adt;

/**
 *
 * Esempio semplificato di coda, realizzata come lista semplice
 * formata da nodi legati tra loro da un riferimento
 * Il nodo ha una struttura fissa e contiene solo una stringa
 * @author Cenacchi + Chadi && Vlady
 */
public class Coda <T> {

    private nodo fronte,ultimo;

    public Coda(){
        fronte=null;
    }

    public boolean isEmpty(){
        return fronte==null;
    }

    public nodo getFronte() {
        return fronte;
    }
    public nodo getUltimo() {
        return ultimo;
    }
    
    public void deQueue() throws Exception{
    //si estrae dalla cima (fronte)

        if (this.isEmpty()) throw new Exception ("Impossibile effettuare dequeue perchè la coda è vuota");
        fronte=fronte.getNext();

    }
    //Aggiunto generics (T info)
    public void enQueue(T info){
        //è un append alla fine della coda
        nodo n=new nodo();
        n.setInfo(info);
        if (isEmpty())
            ultimo=fronte=n;
        else {
            ultimo.setNext(n);
            ultimo=n;
            
        }
    }
}