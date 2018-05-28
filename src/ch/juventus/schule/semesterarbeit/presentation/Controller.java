package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.artikel.*;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.kunde.Kunde;
import ch.juventus.schule.semesterarbeit.business.lieferant.Lieferant;
import ch.juventus.schule.semesterarbeit.business.mitarbeiter.Mitarbeiter;
import ch.juventus.schule.semesterarbeit.persistence.DataAccessMock;

import java.util.*;

import static ch.juventus.schule.semesterarbeit.business.artikelFactory.ArtikelFactory.*;
import static ch.juventus.schule.semesterarbeit.business.artikelFactory.ArtikelFactory.erzeugeGrosserApfelsaft;
import static ch.juventus.schule.semesterarbeit.business.artikelFactory.ArtikelFactory.erzeugeMars;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Controller {
    DataAccessMock db = new DataAccessMock();
    public Controller() {

        /*
        List<Mitarbeiter> mitarbeiter = new ArrayList<>();
        Mitarbeiter hans = new Mitarbeiter("Hans");
        mitarbeiter.add(new Mitarbeiter("Hans"));
        System.out.println(mitarbeiter);

        Map<BasisArtikel, Integer> lagerbestandKiosk = new HashMap<>();
        lagerbestandKiosk.put( erzeugeGrosserApfelsaft(), 5 );
        lagerbestandKiosk.put( erzeugeMars()            , 8 );
        lagerbestandKiosk.put( erzeugeGrossesBier()     , 9 );
        lagerbestandKiosk.put( erzeugeZigarettenPack()  , 9 );
        lagerbestandKiosk.put( erzeugeGrosserVodka()    , 9 );
        lagerbestandKiosk.put( erzeugeGlamourMagazin()  , 9 );
        */
        /*
        Map<BasisArtikel, Integer> lagerbestadLieferant = new HashMap<>();
        lagerbestadLieferant.put(erzeugeGrosserApfelsaft(), 5);
        lagerbestadLieferant.put(erzeugeMars(),4);
        lagerbestadLieferant.put(erzeugeGrossesBier(),4);

        List<Lieferant> lieferant = new ArrayList<>();
        lieferant.add(new Lieferant("Meier", lagerbestadLieferant));

       Kiosk kiosk = new Kiosk("Engelgasse", "Rapperswil SG", false, hans, lagerbestandKiosk, 0, lieferant.get(0));

        System.out.println(lagerbestadLieferant.containsKey(erzeugeGrossesBier()));
        /*
        if(bier.isAlterMussUeberprueftWerden() && customerAge >= bier)
        System.out.println(lagerbestadLieferant.keySet());
        */
        /*
       //System.out.println(kiosk);
       System.out.println(lagerbestandKiosk.size());
       Alkohol bier = erzeugeGrossesBier();
       */
/*
        for (Map.Entry<BasisArtikel, Integer> entry : lagerbestandKiosk.entrySet()) {
            System.out.println("Artikel = " + entry.getKey() + ", Lagerbestand = " + entry.getValue());
        }
*/
        /*
        Kunde walter = new Kunde("Walter" , 18);

        System.out.println(lagerbestandKiosk);
        walter.getWarenkorb().artikelHinzufuegen(lagerbestandKiosk,erzeugeGrosserApfelsaft(),4);
        walter.getWarenkorb().artikelHinzufuegen(lagerbestandKiosk,erzeugeGrosserApfelsaft(),1);
        walter.getWarenkorb().artikelHinzufuegen(lagerbestandKiosk,erzeugeMars(),4);
        walter.getWarenkorb().artikelHinzufuegen(lagerbestandKiosk,erzeugeZigarettenPack(),4);
        walter.getWarenkorb().artikelHinzufuegen(lagerbestandKiosk,erzeugeGrossesBier(),4);


        System.out.println(walter);

        walter.getWarenkorb().artikelBezahlen();
        //System.out.println(lagerbestandKiosk.get(erzeugeGrossesBier()));
        System.out.println(lagerbestandKiosk);
        //ListIterator iterator = lagerbestandKiosk.values();
         */
    }
    public void kioskErstellen(){
        System.out.println("kioskErstellen");
        Mitarbeiter mitarbeiter = new Mitarbeiter("Hans");

        Map<BasisArtikel, Integer> lagerbestandKiosk = new HashMap<>();
        lagerbestandKiosk.put( erzeugeGrosserApfelsaft(), 5 );
        lagerbestandKiosk.put( erzeugeMars()            , 8 );
        lagerbestandKiosk.put( erzeugeGrossesBier()     , 9 );
        lagerbestandKiosk.put( erzeugeZigarettenPack()  , 9 );
        lagerbestandKiosk.put( erzeugeGrosserVodka()    , 9 );
        lagerbestandKiosk.put( erzeugeGlamourMagazin()  , 9 );


        Map<BasisArtikel, Integer> lagerbestadLieferant = new HashMap<>();
        lagerbestadLieferant.put(erzeugeGrosserApfelsaft(), 5);
        lagerbestadLieferant.put(erzeugeMars(),4);
        lagerbestadLieferant.put(erzeugeGrossesBier(),4);

        Kiosk kiosk = db.kioskHinzufuegen(new Kiosk("Engelgasse",
                "Rapperswil SG",
                false,
                mitarbeiter,
                lagerbestandKiosk,
                0,
                db.lieferantHinzufuegen(new Lieferant("Meier", lagerbestadLieferant))
        ));
        System.out.println("Controller: " + kiosk);
    }

    public void alleKiosksAnzeigen(){
        Set<Kiosk> kisoks = db.getKiosks();
        if(kisoks.isEmpty()){
            System.out.println("Noch keine Kiosks vorhanden");
        } else {
            for(Kiosk kiosk : kisoks){
                System.out.println(kiosk);
            }
        }
    }

}
