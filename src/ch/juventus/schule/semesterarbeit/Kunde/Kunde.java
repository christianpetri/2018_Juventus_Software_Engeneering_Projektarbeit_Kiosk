package ch.juventus.schule.semesterarbeit.Kunde;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Kunde {
    private String name;
    private int alter;

    public Kunde(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                '}';
    }
}
