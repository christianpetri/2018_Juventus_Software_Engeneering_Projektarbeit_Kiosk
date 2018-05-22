package ch.juventus.schule.semesterarbeit.artikel;

import java.util.Scanner;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Alkohol extends Getraenk {

    public Alkohol(String bezeichung, int preis, boolean alterMussUeberprueftWerden, int deciliter) {
        super(bezeichung, preis, alterMussUeberprueftWerden, deciliter);
    }

    @Override
    public String toString() {
        return "Alkohol{" +
                "deciliter=" + deciliter +
                ", bezeichung='" + bezeichung + '\'' +
                ", preis=" + preis +
                ", alterMussUeberprueftWerden=" + alterMussUeberprueftWerden +
                '}';
    }
}
