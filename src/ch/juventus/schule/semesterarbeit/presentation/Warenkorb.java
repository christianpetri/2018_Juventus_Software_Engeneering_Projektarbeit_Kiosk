package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.kunde.Kunde;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Warenkorb {
    private Kunde kunde;

    public void Warenkaorb(){
        Kunde kunde = new Kunde("Walter" , 18);
    }

    public void artikelHinzufuegen(Kiosk kiosk, BasisArtikel artikel, int menge){
        this.kunde.getWarenkorb().artikelHinzufuegen(kiosk.getLager(), artikel,menge);
    }
}
