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
 * @author refactor pesante di cenacchi a cura di Chadi && Vlady
 * la droga fa male gente, meth not even once
 */
public class Coda <T> {

    private nodo fronte,ultimo;
    private int dimension;

    public Coda(){
        fronte=null;
        dimension = 0;
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

        if (!this.isEmpty()) {
            //decremento la dimensione della coda dato che non ho il lenght
            this.dimension--;
        }
        //TODO controlla se questo if funziona bene
        else if (this.isEmpty()) {
            this.dimension=0;
            throw new Exception("Impossibile effettuare deQueue perchè la coda è vuota");
        };

        fronte=fronte.getNext();

    }
    //Aggiunto generics (T info)
    public void enQueue(T info){
        //è un append alla fine della coda
        nodo n=new nodo();
        n.setInfo(info);

        //incremento la dimensione della coda dato che non ho il lenght
        //dovrebbe comunque andare in ogni caso
        this.dimension++;

        if (isEmpty())
            ultimo=fronte=n;
        else {
            ultimo.setNext(n);
            ultimo=n;
        }
    }
}