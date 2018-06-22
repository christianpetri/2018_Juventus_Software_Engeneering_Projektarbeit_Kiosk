package ch.juventus.schule.semesterarbeit.business.kiosk;

import ch.juventus.schule.semesterarbeit.business.article.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.employee.Employee;
import ch.juventus.schule.semesterarbeit.business.supplier.KioskSupplier;

import java.util.*;

/**
 * The Kiosk
 *
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

    public Kiosk(String name, String location, boolean isKioskOpen, Employee employee, Map<BaseArticle, Integer> inventory, int amountOfMoneyInTheCashRegister, KioskSupplier kioskSupplier) {
        this.name = name;
        this.location = location;
        this.isKioskOpen = isKioskOpen;
        this.employees.add(employee);
        this.inventory = inventory;
        this.amountOfMoneyInTheCashRegister = amountOfMoneyInTheCashRegister;
        this.kioskSupplier = kioskSupplier;
    }

    public Kiosk(Kiosk originalKiosk) {
        this.name = originalKiosk.getName();
        this.location = originalKiosk.getLocation();
        this.isKioskOpen = originalKiosk.isKioskOpen();
        this.employees = originalKiosk.getEmployees();
        Map<BaseArticle, Integer> newInventory = new HashMap<>();
        for (Map.Entry<BaseArticle, Integer> article : originalKiosk.getInventory().entrySet()) {
            newInventory.put(article.getKey(), article.getValue());
        }
        this.inventory = newInventory;
        this.amountOfMoneyInTheCashRegister = originalKiosk.getAmountOfMoneyInTheCashRegister();
        this.kioskSupplier = new KioskSupplier(originalKiosk.getKioskSupplier());
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

    public void setInventory(Map<BaseArticle, Integer> inventory) {
        this.inventory = inventory;
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

    public void setKioskOpen(boolean kioskOpen) {
        isKioskOpen = kioskOpen;
    }

    /**
     * Toggles the "is Kiosk open" from true to false and from false to true
     */
    public void toggleIsKioskOpen() {
        this.isKioskOpen = !this.isKioskOpen;
    }

    /**
     * The kiosk gets an article form supplier and puts it into its inventory
     *
     * @param baseArticle The article that is put into the inventory
     * @param amount      How many article items are put into the inventory
     */
    public void putItemIntoTheStorage(BaseArticle baseArticle, Integer amount) {
        inventory.put(baseArticle, amount);
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

