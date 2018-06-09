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
    private List<Employee> employee = new ArrayList<>();
    private Map<BaseArticle, Integer> storage;
    private int amountOfMoneyInTheCashRegister;
    private Supplier supplier;
    private String createShoppingBasket;
    private String orderArticles;
    private String getInventroy;

    public Kiosk(String name, String location, boolean isKioskOpen, Employee employee, Map<BaseArticle, Integer> storage, int amountOfMoneyInTheCashRegister, Supplier supplier) {
        this.name = name;
        this.location = location;
        this.isKioskOpen = isKioskOpen;
        this.employee.add(employee);
        this.storage = storage;
        this.amountOfMoneyInTheCashRegister = amountOfMoneyInTheCashRegister;
        this.supplier = supplier;
        this.createShoppingBasket = "Warenkorb erstellen";
        this.orderArticles = "Artikel bestellen";
        this.getInventroy = "Inventar";
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee.add(employee);
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

    public String getCreateShoppingBasket() {
        return createShoppingBasket;
    }

    public String getOrderArticles() {
        return orderArticles;
    }

    public String getGetInventroy() {
        return getInventroy;
    }

    public void toggleKioskIsOpen() {
        if(isKioskOpen){
            this.isKioskOpen = false;
        } else {
            this.isKioskOpen = true;
        }
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "name='" + name + '\'' +
                ", Standort='" + location + '\'' +
                ", Ist der Kiosk geöffnet=" + isKioskOpen +
                ", Employee=" + employee +
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
