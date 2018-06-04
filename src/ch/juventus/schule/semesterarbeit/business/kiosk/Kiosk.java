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
    private String standort;
    private boolean kisokIsOpen;
    private List<Employee> employee = new ArrayList<>();
    private Map<BaseArticle, Integer> lager;
    private int geldsummeDieInDerKasseIst;
    private Supplier supplier;

    public Kiosk(String name, String standort, boolean kisokIsOpen, Employee employee, Map<BaseArticle, Integer> lager, int geldsummeDieInDerKasseIst, Supplier supplier) {
        this.name = name;
        this.standort = standort;
        this.kisokIsOpen = kisokIsOpen;
        this.employee.add(employee);
        this.lager = lager;
        this.geldsummeDieInDerKasseIst = geldsummeDieInDerKasseIst;
        this.supplier = supplier;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee.add(employee);
    }

    public Map<BaseArticle, Integer> getLager() {
        return lager;
    }

    public String getName() {
        return name;
    }

    public String getStandort() {
        return standort;
    }

    public boolean isKisokIsOpen() {
        return kisokIsOpen;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "name='" + name + '\'' +
                ", Standort='" + standort + '\'' +
                ", Ist der Kiosk geöffnet=" + kisokIsOpen +
                ", Employee=" + employee +
                ", Lager=" + lager +
                ", Geldsumme in der Kasse=" + geldsummeDieInDerKasseIst +
                ", Supplier=" + supplier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kiosk)) return false;
        Kiosk kiosk = (Kiosk) o;
        return Objects.equals(name, kiosk.name) &&
                Objects.equals(standort, kiosk.standort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, standort);
    }
}
