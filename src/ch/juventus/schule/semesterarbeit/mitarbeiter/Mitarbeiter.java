package ch.juventus.schule.semesterarbeit.mitarbeiter;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Mitarbeiter {
    private String name;

    public Mitarbeiter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "name='" + name + '\'' +
                '}';
    }
}
