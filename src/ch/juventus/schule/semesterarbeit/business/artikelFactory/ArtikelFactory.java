package ch.juventus.schule.semesterarbeit.business.artikelFactory;

import ch.juventus.schule.semesterarbeit.business.artikel.*;

import java.util.Base64;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArtikelFactory {

    public Snacks erzeugeMars(){
        return new Snacks("Mars", 10, Snacks_Typ.Suess);
    }

    public Softdrinks erzeugeGrosserApfelsaft(){
        return new Softdrinks("Apfelsaft", 5, 100);
    }

    public Alkohol erzeugeGrossesBier(){
        return new Alkohol("Quellfrisch", 5, 5,16);
    }

    public Alkohol erzeugeKleinerVodka(){
        return new Alkohol("Vodka", 10, 5,18);
    }

    public Alkohol erzeugeGrosserVodka(){
        return new Alkohol("Vodka", 3, 3,18);
    }

    public Tabak erzeugeZigarettenPack(){
        return new Tabak("Zigaretten", 10);
    }

    public BasisArtikel erzeugeGlamourMagazin(){
        return new Zeitschriften("Glamour Daily", 100, Zeitschriften_Typ.International);
    }
}
