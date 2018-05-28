package ch.juventus.schule.semesterarbeit.business.kunde;

import ch.juventus.schule.semesterarbeit.business.artikel.Alkohol;
import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;
import ch.juventus.schule.semesterarbeit.business.artikel.Tabak;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Warenkorb {
    private Map<BasisArtikel, Integer> warenkorb = new HashMap<>();

    public void artikelHinzufuegen(Map<BasisArtikel, Integer> lager, BasisArtikel artikel, int menge){
        boolean alterIstOk = true;
        if ((artikel instanceof Alkohol)){
            System.out.println("Alk!");
            Alkohol that = (Alkohol) artikel;
            alterIstOk = that.alterUeberpruefen();
        } else if ((artikel instanceof Tabak)){
            System.out.println("Tabak!");
            Tabak that = (Tabak) artikel;
            alterIstOk = that.alterUeberpruefen();
        }
        if(menge <= lager.get(artikel) && alterIstOk){
            warenkorb.put(artikel,menge + ((warenkorb.get(artikel) == null) ? 0 : warenkorb.get(artikel)));
            lager.put(artikel,lager.get(artikel) - menge );
            System.out.println("Es sind " + warenkorb.get(artikel) + " Artikel von Typ " + artikel +" im Warenkorb");
            System.out.println("Es sind noch " + lager.get(artikel) + " " + artikel.getBezeichung() + " an Lager");
        } else {
            System.out.println("Es sind noch " + lager.get(artikel) + " " + artikel.getBezeichung() +" verfügbar");
        }
    }

    public void artikelBezahlen(){
        System.out.println("Es sind " + warenkorb.size() +" Artikel im Warenkorb");
        int summe = 0;
        for (Map.Entry<BasisArtikel, Integer> artikel : warenkorb.entrySet()) {
            System.out.println("Artikel: " +artikel.getKey().getBezeichung() +" Preis:" + artikel.getKey().getPreis() + " CHF, Anzahl = " + artikel.getValue());
            summe += artikel.getKey().getPreis()*artikel.getValue();
        }
        System.out.println("Bitte bezahlen Sie " + summe + " CHF");
    }

    @Override
    public String toString() {
        return "Warenkorb{" +
                "warenkorb=" + warenkorb +
                '}';
    }
}
