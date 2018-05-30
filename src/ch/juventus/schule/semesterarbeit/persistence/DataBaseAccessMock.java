package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArtikelFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.supplier.Supplier;
import ch.juventus.schule.semesterarbeit.business.employee.Employee;

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

public class DataBaseAccessMock {
    private static DataBaseAccessMock instance;
    private Set<Kiosk> kiosks;
    private Set<Supplier> lieferanten;

    private DataBaseAccessMock() {
        this.kiosks = new HashSet<>();
        this.lieferanten = new HashSet<>();
    }

    public static DataBaseAccessMock getInstance() {
        if (DataBaseAccessMock.instance == null) {
            DataBaseAccessMock.instance = new DataBaseAccessMock();
        }
        return DataBaseAccessMock.instance;
    }

    public Kiosk kioskHinzufuegen(String kioskName, String standortName, String mitarbeiterName, int kassenInitalSumme) {
        Employee employee = new Employee(mitarbeiterName);
        ArtikelFactory artikel = new ArtikelFactory();
        Map<BaseArticle, Integer> lagerbestandKiosk = new HashMap<>();
        lagerbestandKiosk.put(artikel.erzeugeGrosserApfelsaft(), 5);
        lagerbestandKiosk.put(artikel.erzeugeMars(), 8);
        lagerbestandKiosk.put(artikel.erzeugeGrossesBier(), 9);
        lagerbestandKiosk.put(artikel.erzeugeZigarettenPack(), 9);
        lagerbestandKiosk.put(artikel.erzeugeGrosserVodka(), 9);
        lagerbestandKiosk.put(artikel.erzeugeGlamourMagazin(), 9);



        Map<BaseArticle, Integer> lagerbestadLieferant = new HashMap<>();
        lagerbestadLieferant.put(artikel.erzeugeGrosserApfelsaft(), 5);
        lagerbestadLieferant.put(artikel.erzeugeMars(), 4);
        lagerbestadLieferant.put(artikel.erzeugeGrossesBier(), 4);

        Supplier supplier = this.lieferantHinzufuegen(new Supplier("Meier", lagerbestadLieferant));

        Kiosk kiosk = new Kiosk(kioskName, standortName, false, employee, lagerbestandKiosk, kassenInitalSumme, supplier);
        if(kiosks.contains(kiosk)){
            for (Kiosk thisKiosk : kiosks) {
                if (thisKiosk.equals(kiosk)) {
                    System.out.println("Der Kiosk existiert bereits " + kiosk);
                    return kiosk;
                }
            }
        } else{
            this.kiosks.add(kiosk);
            System.out.println("Kiosk wurde zur Liste hinzugefuet " + kiosk);
            return kiosk;
        }
        return null;
    }

    public Supplier lieferantHinzufuegen(Supplier supplier) {
        if (lieferanten.isEmpty()) {
            this.lieferanten.add(supplier);
            //System.out.println(lieferanten);
            System.out.println("Lieferanten Liste war noch leer: " + supplier);
            return supplier;
        } else if (lieferanten.contains(supplier)) {
            for (Supplier thisSupplier : lieferanten) {
                if (thisSupplier.equals(supplier)) {
                    System.out.println("Der Supplier existiert bereits " + supplier);
                    return supplier;
                }
            }
        } else {
            this.lieferanten.add(supplier);
            System.out.println("Supplier wurde zur Liste hinzugefuet " + supplier);
            return supplier;
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
