package ch.juventus.schule.semesterarbeit.business.kunde;

import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Kunde {
    private String name;
    private int alter;
    private Warenkorb warenkorb;

    public Kunde(String name, int alter) {
        this.name = name;
        this.alter = alter;
        this.warenkorb = new Warenkorb();
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public Warenkorb getWarenkorb() {
        return warenkorb;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", warenkorb=" + warenkorb +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kunde)) return false;
        Kunde kunde = (Kunde) o;
        return alter == kunde.alter &&
                Objects.equals(name, kunde.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, alter);
    }
}
