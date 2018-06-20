package ch.juventus.schule.semesterarbeit.business.kiosk;

import ch.juventus.schule.semesterarbeit.business.employee.Employee;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.supplier.KioskSupplier;

import java.util.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Kiosk {
    private String name;
    private String location;
    private boolean isKioskOpen;
    private List<Employee> employees = new ArrayList<>();
    private Map<BaseArticle, Integer> inventory;
    private int amountOfMoneyInTheCashRegister;
    private KioskSupplier kioskSupplier;
    private String createShoppingBasket;
    private String orderArticles;
    private String getInventory;

    public Kiosk(String name, String location, boolean isKioskOpen, Employee employee, Map<BaseArticle, Integer> inventory, int amountOfMoneyInTheCashRegister, KioskSupplier kioskSupplier) {
        this.name = name;
        this.location = location;
        this.isKioskOpen = isKioskOpen;
        this.employees.add(employee);
        this.inventory = inventory;
        this.amountOfMoneyInTheCashRegister = amountOfMoneyInTheCashRegister;
        this.kioskSupplier = kioskSupplier;
        this.createShoppingBasket = "Einkauf tätigen";
        this.orderArticles = "Artikel bestellen";
        this.getInventory = "Inventar";
    }

    public Kiosk(Kiosk orginal){
        this.name = orginal.name;
        this.location = orginal.location;
        this.isKioskOpen = orginal.isKioskOpen;
        this.employees  = orginal.employees;
        Map<BaseArticle,Integer> inv = new HashMap<>();
       // inv =
        //this.inventory = Map<BaseArticle, Integer>  (orginal.inventory);
        this.amountOfMoneyInTheCashRegister = orginal.amountOfMoneyInTheCashRegister;
        this.kioskSupplier =  new KioskSupplier(orginal.kioskSupplier);
        this.createShoppingBasket = "Einkauf tätigen";
        this.orderArticles = "Artikel bestellen";
        this.getInventory = "Inventar";
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees.add(employees);
    }

    public Map<BaseArticle, Integer> getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public boolean isKioskOpen() {
        return isKioskOpen;
    }

    public void toggleIsKioskOpen() {
        this.isKioskOpen = !this.isKioskOpen;
    }

    public String getCreateShoppingBasket() {
        return createShoppingBasket;
    }

    public String getOrderArticles() {
        return orderArticles;
    }

    public String getGetInventory() {
        return getInventory;
    }

    public void setInventory(Map<BaseArticle, Integer> inventory) {
        this.inventory = inventory;
    }

    public void putItemIntoTheStorage(BaseArticle baseArticle, Integer amount) {
            inventory.put(baseArticle , amount);
    }

    public int getAmountOfMoneyInTheCashRegister() {
        return amountOfMoneyInTheCashRegister;
    }

    public void setAmountOfMoneyInTheCashRegister(int amountOfMoneyInTheCashRegister) {
        this.amountOfMoneyInTheCashRegister = amountOfMoneyInTheCashRegister;
    }

    public KioskSupplier getKioskSupplier() {
        return kioskSupplier;
    }

    public void setKioskOpen(boolean kioskOpen) {
        isKioskOpen = kioskOpen;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "name='" + name + '\'' +
                ", Standort='" + location + '\'' +
                ", Ist der Kiosk geöffnet=" + isKioskOpen +
                ", Employee=" + employees +
                ", Lager=" + inventory +
                ", Geldsumme in der Kasse=" + amountOfMoneyInTheCashRegister +
                ", KioskSupplier=" + kioskSupplier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kiosk)) return false;
        Kiosk kiosk = (Kiosk) o;
        return Objects.equals(name, kiosk.name) &&
                Objects.equals(location, kiosk.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}

