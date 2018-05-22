package ch.juventus.schule.semesterarbeit.artikel;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author : ${user}
 * @since: ${date}
 */
 public class BasisArtikel {
    protected String bezeichung;
    protected int preis;
    protected boolean alterMussUeberprueftWerden;

    public BasisArtikel(String bezeichung, int preis, boolean alterMussUeberprueftWerden) {
        this.bezeichung = bezeichung;
        this.preis = preis;
        this.alterMussUeberprueftWerden = alterMussUeberprueftWerden;
    }

    public String getBezeichung() {
        return bezeichung;
    }

    public int getPreis() {
        return preis;
    }

    public boolean isAlterMussUeberprueftWerden() {
        return alterMussUeberprueftWerden;
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
                alterMussUeberprueftWerden == that.alterMussUeberprueftWerden &&
                Objects.equals(bezeichung, that.bezeichung);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bezeichung, preis, alterMussUeberprueftWerden);
    }
}
