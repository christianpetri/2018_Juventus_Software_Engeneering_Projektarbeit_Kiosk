package ch.juventus.schule.semesterarbeit.business.artikel;

import java.util.Scanner;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Tabak extends BasisArtikel {

    public Tabak(String bezeichung, int preis) {
        super(bezeichung, preis);
    }

    public boolean alterUeberpruefen() {
        System.out.println("Ist die Person mindestens 16 Jahre Alt?\n Geben Sie bitte \"Ja\", \"Nein\" oder \"Abbrechen\" ein. (Abkürzung: j, n oder a)");
        Scanner scan = new Scanner(System.in);
        while (true){
            String antwort = scan.next();
            if(antwort.toLowerCase().equals("j") || antwort.toLowerCase().equals("ja")){
                System.out.println("Die Person darf den Artikel kaufen");
                return true;
            } else if (antwort.toLowerCase().equals("n") || antwort.toLowerCase().equals("nein")){
                System.out.println("Die Person darf den NICHT Artikel kaufen");
                return false;
            }else if (antwort.toLowerCase().equals("a") || antwort.toLowerCase().equals("abbrechen")){
                System.out.println("Abgebrochen, Artikel wurde nicht hinzugefügt");
                return false;
            } else{
                System.out.println("Bitte geben Sie Ja oder Nein ein");
                System.out.println(antwort);
            }
        }
    }
}
