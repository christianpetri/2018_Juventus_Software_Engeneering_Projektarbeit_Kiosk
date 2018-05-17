package ch.juventus.schule.semesterarbeit.artikel;

import java.util.Scanner;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Tabak extends BasisArtikel implements Altersueberpruefung {
    public Tabak(String bezeichung, int preis) {
        super(bezeichung, preis);
    }

    @Override
    public boolean alterUeberpruefen() {
        System.out.println("Ist die Person mindestens 18 Jahre Alt?\n Geben Sie bitte \"Ja\" oder \"Nein\" ein");
        Scanner scan = new Scanner(System.in);
        boolean istNichtEineValideAntwort = true;
        while (istNichtEineValideAntwort){
            String antwort = scan.next();
            antwort.toLowerCase();
            if(antwort.equals("j") || antwort.equals("ja")){
                istNichtEineValideAntwort = false;
                return true;
            } else if (antwort.equals("n") || antwort.equals("nein")){
                istNichtEineValideAntwort = false;
                return false;
            } else{
                System.out.println("Bitte geben Sie Ja oder Nein ein ");
                System.out.println(antwort);
            }
        }
        return false;
    }
}
