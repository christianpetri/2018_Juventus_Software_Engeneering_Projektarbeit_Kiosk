package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;
import ch.juventus.schule.semesterarbeit.business.artikelFactory.ArtikelFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.lieferant.Lieferant;
import ch.juventus.schule.semesterarbeit.business.mitarbeiter.Mitarbeiter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This creates a Data Access Mockup to store the data
 *
 * @author : ${user}
 * @since: ${date}
 */

public class DatenverbindungAttrappe {
    private static DatenverbindungAttrappe instance;
    private Set<Kiosk> kiosks = new HashSet<>();
    private Set<Lieferant> lieferanten = new HashSet<>();

    private DatenverbindungAttrappe() {
    }

    public static DatenverbindungAttrappe getInstance() {
        if (DatenverbindungAttrappe.instance == null) {
            DatenverbindungAttrappe.instance = new DatenverbindungAttrappe();
        }
        return DatenverbindungAttrappe.instance;
    }

    public Kiosk kioskHinzufuegen(String kioskName, String standortName, String mitarbeiterName, int kassenInitalSumme) {
        Mitarbeiter mitarbeiter = new Mitarbeiter(mitarbeiterName);
        ArtikelFactory artikel = new ArtikelFactory();
        Map<BasisArtikel, Integer> lagerbestandKiosk = new HashMap<>();
        lagerbestandKiosk.put(artikel.erzeugeGrosserApfelsaft(), 5);
        lagerbestandKiosk.put(artikel.erzeugeMars(), 8);
        lagerbestandKiosk.put(artikel.erzeugeGrossesBier(), 9);
        lagerbestandKiosk.put(artikel.erzeugeZigarettenPack(), 9);
        lagerbestandKiosk.put(artikel.erzeugeGrosserVodka(), 9);
        lagerbestandKiosk.put(artikel.erzeugeGlamourMagazin(), 9);



        Map<BasisArtikel, Integer> lagerbestadLieferant = new HashMap<>();
        lagerbestadLieferant.put(artikel.erzeugeGrosserApfelsaft(), 5);
        lagerbestadLieferant.put(artikel.erzeugeMars(), 4);
        lagerbestadLieferant.put(artikel.erzeugeGrossesBier(), 4);

        Lieferant lieferant = this.lieferantHinzufuegen(new Lieferant("Meier", lagerbestadLieferant));
        
        Kiosk kiosk = new Kiosk(kioskName, standortName, false, mitarbeiter, lagerbestandKiosk, kassenInitalSumme, lieferant);

        if (kiosks.isEmpty()) {
            this.kiosks.add(kiosk);
            System.out.println("Liste war noch leer: " + kiosk);
            return kiosk;
        } else if (kiosks.contains(kiosk)) {
            for (Kiosk thisKiosk : kiosks) {
                if (thisKiosk.equals(kiosk)) {
                    System.out.println("Der Kiosk existiert bereits " + kiosk);
                    return kiosk;
                }
            }
        } else {
            this.kiosks.add(kiosk);
            System.out.println("Kiosk wurde zur Liste hinzugefuet " + kiosk);
            return kiosk;
        }
        return null;
    }

    public Lieferant lieferantHinzufuegen(Lieferant lieferant) {
        if (lieferanten.isEmpty()) {
            this.lieferanten.add(lieferant);
            //System.out.println(lieferanten);
            System.out.println("Lieferanten Liste war noch leer: " + lieferant);
            return lieferant;
        } else if (lieferanten.contains(lieferant)) {
            for (Lieferant thisLieferant : lieferanten) {
                if (thisLieferant.equals(lieferant)) {
                    System.out.println("Der Lieferant existiert bereits " + lieferant);
                    return lieferant;
                }
            }
        } else {
            this.lieferanten.add(lieferant);
            System.out.println("Lieferant wurde zur Liste hinzugefuet " + lieferant);
            return lieferant;
        }
        return null;
    }

    public Kiosk kioskFinden(Kiosk kiosk) {
        if (kiosks.contains(kiosk)) {
            for (Kiosk thisKisok : kiosks) {
                if (thisKisok.equals(kiosk)) {
                    return kiosk;
                }
            }
        }
        return null;
    }

    public Set<Kiosk> getKiosks() {
        return kiosks;
    }
}
