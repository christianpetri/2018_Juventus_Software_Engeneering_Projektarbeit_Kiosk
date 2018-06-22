package ch.juventus.schule.semesterarbeit.business.employee;

/**
 * The employee that is employed by the kiosk
 *
 * @author : ${user}
 * @since: ${date}
 */
public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
