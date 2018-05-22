package ch.juventus.schule.semesterarbeit;

import ch.juventus.schule.semesterarbeit.artikel.*;
import ch.juventus.schule.semesterarbeit.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.lieferant.Lieferant;
import ch.juventus.schule.semesterarbeit.mitarbeiter.Mitarbeiter;

import java.util.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Console {
    public Console() {
        List<Mitarbeiter> mitarbeiter = new ArrayList<>();
        mitarbeiter.add(new Mitarbeiter("Hans"));


        Map<BasisArtikel, Integer> lagerbestandKiosk = new HashMap<>();
        //Factory
        //package klein geschrieben
        lagerbestandKiosk.put( new Softdrinks("Apfelsaft", 13, false,10)    , 5);
        lagerbestandKiosk.put( new Snacks("Mars", 10,false, Snacks_Typ.Suess)       , 8);
        lagerbestandKiosk.put( new Alkohol("Quellfrisch", 3, true,5)        , 9);
        lagerbestandKiosk.put( new Alkohol("Quellfrisch", 1, true,3)        , 9);

        Map<BasisArtikel, Integer> lagerbestadLieferant = new HashMap<>();
        lagerbestadLieferant.put(new Softdrinks("Apfelsaft", 13, false,5), 5);
        lagerbestadLieferant.put(new Snacks("Mars", 10, false, Snacks_Typ.Suess),4);
        lagerbestadLieferant.put(createBigBeer(),4);

        List<Lieferant> lieferant = new ArrayList<>();
        lieferant.add(new Lieferant("Meier", lagerbestadLieferant));

       Kiosk kiosk = new Kiosk("Engelgasse", "Rapperswil SG", false, mitarbeiter.get(0), lagerbestandKiosk, 0, lieferant.get(0));

        System.out.println("Hello");
        BasisArtikel bier = new Alkohol("Quellfrisch", 3, true,5));
        System.out.println(lagerbestadLieferant.containsKey(bier));
        /*
        if(bier.isAlterMussUeberprueftWerden() && customerAge >= bier)
        System.out.println(lagerbestadLieferant.keySet());
        */
        
       //System.out.println(kiosk);
       System.out.println(lagerbestandKiosk.size());


        for (Map.Entry<BasisArtikel, Integer> entry : lagerbestandKiosk.entrySet()) {
            System.out.println("Artikel = " + entry.getKey() + ", Lagerbestand = " + entry.getValue());
        }

        System.out.println(lagerbestandKiosk.get(new Alkohol("Quellfrisch", 1, true,3)));
        //ListIterator iterator = lagerbestandKiosk.values();



    }



    private Alkohol createBigBeer() {
        return new Alkohol("Quellfrisch", 1, true, 5);
    }

}
