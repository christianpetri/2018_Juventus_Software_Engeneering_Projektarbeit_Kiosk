package ch.juventus.schule.semesterarbeit.business.kunde;

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
}
