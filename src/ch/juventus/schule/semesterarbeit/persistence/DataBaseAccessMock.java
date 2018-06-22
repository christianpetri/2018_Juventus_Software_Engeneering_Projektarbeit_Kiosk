package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.employee.Employee;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.supplier.KioskSupplier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This creates a Data Access Mockup to store the data
 *
 * @author : ${user}
 * @since: ${date}
 *
 *
 */

public class DataBaseAccessMock {
    private static DataBaseAccessMock instance;
    private Set<Kiosk> kiosks;
    private Set<KioskSupplier> kioskSuppliers;
    private Set<Customer> customers;

    private DataBaseAccessMock() {
        this.kiosks = new HashSet<>();
        this.kioskSuppliers = new HashSet<>();
        this.customers = new HashSet<>();
    }

    public static DataBaseAccessMock getInstance() {
        if (DataBaseAccessMock.instance == null) {
            DataBaseAccessMock.instance = new DataBaseAccessMock();
        }
        return DataBaseAccessMock.instance;
    }

    public Kiosk addKiosk(String kioskName, String locationName, String employeeName, int startCapital) {
        Employee employee = new Employee(employeeName);
        ArticleFactory articel = new ArticleFactory();
        Map<BaseArticle, Integer> storageKiosk = new HashMap<>();
        storageKiosk.put(articel.createBigAppleJuice(), 5);
        storageKiosk.put(articel.createMars(), 8);
        storageKiosk.put(articel.createBigBeer(), 9);
        storageKiosk.put(articel.createCigarettePack(), 9);
        storageKiosk.put(articel.createBigVodka(), 9);
        storageKiosk.put(articel.createGlamourMagazin(), 9);

        Map<BaseArticle, Integer> storageSupplier = new HashMap<>();
        storageSupplier.put(articel.createBigAppleJuice(), 5);
        storageSupplier.put(articel.createMars(), 4);
        storageSupplier.put(articel.createBigBeer(), 4);
        storageSupplier.put(articel.createSmallVodka(), 4);

        KioskSupplier kioskSupplier = new KioskSupplier("Meier", storageSupplier);

        Kiosk kiosk = new Kiosk(kioskName, locationName, false, employee, storageKiosk, startCapital, kioskSupplier);
        if(kiosks.contains(kiosk)){
            for (Kiosk thisKiosk : kiosks) {
                if (thisKiosk.equals(kiosk)) {
                    System.out.println("Der Kiosk existiert bereits " + kiosk);
                    return thisKiosk;
                }
            }
        } else{
            this.kiosks.add(kiosk);
            System.out.println("Kiosk wurde zur Liste hinzugefuet " + kiosk);
            return kiosk;
        }
        return null;
    }

  /*
  public KioskSupplier lieferantHinzufuegen(KioskSupplier supplier) {
        if (kioskSuppliers.isEmpty()) {
            this.kioskSuppliers.add(supplier);
            //System.out.println(kioskSuppliers);
            System.out.println("Lieferanten Liste war noch leer: " + supplier);
            return supplier;
        } else if (kioskSuppliers.contains(supplier)) {
            for (KioskSupplier thisSupplier : kioskSuppliers) {
                if (thisSupplier.equals(supplier)) {
                    System.out.println("Der KioskSupplier existiert bereits " + supplier);
                    return supplier;
                }
            }
        } else {
            this.kioskSuppliers.add(supplier);
            System.out.println("KioskSupplier wurde zur Liste hinzugefuet " + supplier);
            return supplier;
        }
        return null;
    }
    */

    public Set<Kiosk> getKiosks() {
        return kiosks;
    }
    /*
    public Kiosk getKiosk(String name, String location) {
        Kiosk tempKiosk = new Kiosk(name, location, false, null, null, 1, null);
        if(kiosks.contains(tempKiosk)){
            for(Kiosk kiosk : kiosks){
                if(kiosk.equals(tempKiosk)){
                    return kiosk;
                }
            }
        }
        return null;
    }
    */
    public void setKioskStorage(Kiosk myKiosk){
        Map<BaseArticle,Integer> newInventory = new HashMap<>();
        for(Map.Entry<BaseArticle,Integer> article : myKiosk.getInventory().entrySet()){
            newInventory.put(article.getKey(),article.getValue());
        }
        for(Kiosk kiosk : kiosks){
            if(kiosk.equals(myKiosk)){
                kiosk.setInventory(newInventory);
                break;
            }
        }
    }
    public void setKioskSupplierInventroy(Kiosk myKiosk){
        Map<BaseArticle,Integer> newInventory = new HashMap<>();
        for(Map.Entry<BaseArticle,Integer> article : myKiosk.getKioskSupplier().getInventory().entrySet()){
            newInventory.put(article.getKey(),article.getValue());
        }
        for(Kiosk kiosk : kiosks){
            if(kiosk.equals(myKiosk)){
                kiosk.getKioskSupplier().setInventory(newInventory);
                break;
            }
        }
    }
}
