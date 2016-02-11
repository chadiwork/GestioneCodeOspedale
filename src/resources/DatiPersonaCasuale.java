package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Chado on 11/02/2016.
 * Classe per leggere e generare nomi e cognomi casuali
 */
public class DatiPersonaCasuale {
    String[] nome;
    String[] cognome;
    File fileNomi;
    File fileCognomi;
    Scanner lettoreFileNomi;
    Scanner lettoreFileCognomi;

    public DatiPersonaCasuale() throws FileNotFoundException{
        fileNomi=new File("C:\\Users\\Chado\\Desktop\\GestioneCodeOspedale\\src\\file\\Nomi.txt");
        fileCognomi=new File("C:\\Users\\Chado\\Desktop\\GestioneCodeOspedale\\src\\file\\Cognomi.txt");
        lettoreFileNomi=new Scanner(fileNomi);
        lettoreFileCognomi=new Scanner(fileCognomi);
        nome=new String[8913];
        cognome=new String[170];
    }
    public void leggiNomi(){
        //leggo il file finchè c'è una stringa e incremento l'array
        int i=0;
        while (lettoreFileNomi.hasNext()){
            String tmp=lettoreFileNomi.next(); //String temporanea
            nome[i]=tmp.substring(0, 1).toUpperCase() + tmp.substring(1); //Mette maiuscole ai nomi
            i++;
        }
        lettoreFileNomi.close();
    }
    public void leggiCognomi(){
        //leggo il file finchè c'è una stringa e incremento l'array
        int i=0;
        while (lettoreFileCognomi.hasNext()){
            String tmp=lettoreFileCognomi.next(); //String temporanea
            cognome[i]= tmp.substring(0, 1).toUpperCase() + tmp.substring(1); //Mette maiuscole ai nomi

            i++;
        }
        lettoreFileCognomi.close();
    }
    //Restituisce un intero casuale
    public int indiceCasuale(int Low, int High){
        Random r=new Random();
        int Result=r.nextInt(High-Low)+Low;
        return Result;
    }

    public String[] getNome() {
        return nome;
    }

    public String[] getCognome() {
        return cognome;
    }
}
