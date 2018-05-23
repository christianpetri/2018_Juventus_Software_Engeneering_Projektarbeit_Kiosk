package ch.juventus.schule.semesterarbeit.business.artikelFactory;

import ch.juventus.schule.semesterarbeit.business.artikel.*;

import java.util.Base64;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArtikelFactory {

    public static Snacks erzeugeMars(){
        return new Snacks("Mars", 10, Snacks_Typ.Suess);
    }

    public static Softdrinks erzeugeGrosserApfelsaft(){
        return new Softdrinks("Apfelsaft", 5, 100);
    }


    public static Alkohol erzeugeGrossesBier(){
        return new Alkohol("Quellfrisch", 5, 5,16);
    }

    public static Alkohol erzeugeKleinerVodka(){
        return new Alkohol("Vodka", 10, 5,18);
    }

    public static Alkohol erzeugeGrosserVodka(){
        return new Alkohol("Vodka", 3, 3,18);
    }

    public static Tabak erzeugeZigarettenPack(){
        return new Tabak("Zigaretten", 10);
    }

    public static BasisArtikel erzeugeGlamourMagazin(){
        return new Zeitschriften("Glamour Daily", 100, Zeitschriften_Typ.International);
    }
}
