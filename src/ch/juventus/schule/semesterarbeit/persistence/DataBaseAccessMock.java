package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.supplier.Supplier;
import ch.juventus.schule.semesterarbeit.business.employee.Employee;

import java.util.*;

/**
 * This creates a Data Access Mockup to store the data
 *
 * @author : ${user}
 * @since: ${date}
 */

public class DataBaseAccessMock {
    private static DataBaseAccessMock instance;
    private Set<Kiosk> kiosks;
    private Set<Supplier> suppliers;
    private Set<Customer> customers;

    private DataBaseAccessMock() {
        this.kiosks = new HashSet<>();
        this.suppliers = new HashSet<>();
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

        Supplier supplier = new Supplier("Meier", storageSupplier);

        Kiosk kiosk = new Kiosk(kioskName, locationName, false, employee, storageKiosk, startCapital, supplier);
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
  public Supplier lieferantHinzufuegen(Supplier supplier) {
        if (suppliers.isEmpty()) {
            this.suppliers.add(supplier);
            //System.out.println(suppliers);
            System.out.println("Lieferanten Liste war noch leer: " + supplier);
            return supplier;
        } else if (suppliers.contains(supplier)) {
            for (Supplier thisSupplier : suppliers) {
                if (thisSupplier.equals(supplier)) {
                    System.out.println("Der Supplier existiert bereits " + supplier);
                    return supplier;
                }
            }
        } else {
            this.suppliers.add(supplier);
            System.out.println("Supplier wurde zur Liste hinzugefuet " + supplier);
            return supplier;
        }
        return null;
    }
    */

    public Kiosk findKiosk(String name, String location) {
        Kiosk tempKiosk = new Kiosk(name, location, false, null, null, 0, null);
        if (this.kiosks.contains(tempKiosk)) {
            for (Kiosk thisKiosk : kiosks) {
                if (thisKiosk.equals(tempKiosk)) {
                    return thisKiosk;
                }
            }
        }
        return null;
    }

    public Set<Kiosk> getKiosks() {
        return kiosks;
    }

    public void setCustomer(String name, int age){
       if(!this.customers.contains(new Customer(name, age))){
            this.customers.add(new Customer(name, age));
        }
    }

    public Customer getCustomer(String name, int age) {
        Customer tempCustomer = new Customer(name, age);
        if (customers.contains(tempCustomer)) {
            for (Customer customer : customers) {
                if (customer.equals(tempCustomer)) {
                    return customer;
                }
            }
        }
        return null;
    }

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
}
