package ch.juventus.schule.semesterarbeit.business.kiosk;

import ch.juventus.schule.semesterarbeit.business.employee.Employee;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.supplier.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Kiosk {
    private String name;
    private String location;
    private boolean isKioskOpen;
    private List<Employee> employees = new ArrayList<>();
    private Map<BaseArticle, Integer> storage;
    private int amountOfMoneyInTheCashRegister;
    private Supplier supplier;
    private String createShoppingBasket;
    private String orderArticles;
    private String getInventory;

    public Kiosk(String name, String location, boolean isKioskOpen, Employee employee, Map<BaseArticle, Integer> storage, int amountOfMoneyInTheCashRegister, Supplier supplier) {
        this.name = name;
        this.location = location;
        this.isKioskOpen = isKioskOpen;
        this.employees.add(employee);
        this.storage = storage;
        this.amountOfMoneyInTheCashRegister = amountOfMoneyInTheCashRegister;
        this.supplier = supplier;
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

    public Map<BaseArticle, Integer> getStorage() {
        return storage;
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

    public void setStorage(Map<BaseArticle, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "name='" + name + '\'' +
                ", Standort='" + location + '\'' +
                ", Ist der Kiosk geöffnet=" + isKioskOpen +
                ", Employee=" + employees +
                ", Lager=" + storage +
                ", Geldsumme in der Kasse=" + amountOfMoneyInTheCashRegister +
                ", Supplier=" + supplier +
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
