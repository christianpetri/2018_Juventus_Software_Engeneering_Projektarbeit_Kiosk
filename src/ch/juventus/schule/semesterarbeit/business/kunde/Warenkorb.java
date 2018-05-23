package ch.juventus.schule.semesterarbeit.business.kunde;

import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Warenkorb {
    private Map<Object, Integer> warenkorb = new HashMap<>();

    public void artikelHinzufuegen(Map<BasisArtikel, Integer> lager, BasisArtikel artikel, int menge){
        if(menge <= lager.get(artikel)){
            warenkorb.put(artikel,menge + ((warenkorb.get(artikel) == null) ? 0 : warenkorb.get(artikel)));
            lager.put(artikel,lager.get(artikel) - menge );
            System.out.println("Es sind " + warenkorb.get(artikel) + " Artikel von Typ " + artikel +" im Warenkorb");
            System.out.println("Es sind noch " + lager.get(artikel) + " " + artikel.getBezeichung() + " an Lager");
        } else {
            System.out.println("Es sind noch " + lager.get(artikel) + " " + artikel.getBezeichung() +" verfügbar");
        }
    }

    @Override
    public String toString() {
        return "Warenkorb{" +
                "warenkorb=" + warenkorb +
                '}';
    }
}
