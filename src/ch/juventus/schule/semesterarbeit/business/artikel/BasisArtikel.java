package ch.juventus.schule.semesterarbeit.business.artikel;

import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
 public class BasisArtikel {
    protected String bezeichung;
    protected int preis;

    public BasisArtikel(String bezeichung, int preis) {
        this.bezeichung = bezeichung;
        this.preis = preis;
    }

    public String getBezeichung() {
        return bezeichung;
    }

    public int getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return "BasisArtikel{" +
                "Bezeichung='" + bezeichung + '\'' +
                ", Preis=" + preis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasisArtikel)) return false;
        BasisArtikel that = (BasisArtikel) o;
        return preis == that.preis &&
                Objects.equals(bezeichung, that.bezeichung);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bezeichung, preis);
    }
}
