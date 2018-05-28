package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.artikel.*;
import ch.juventus.schule.semesterarbeit.business.artikelFactory.ArtikelFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.lieferant.Lieferant;
import ch.juventus.schule.semesterarbeit.business.mitarbeiter.Mitarbeiter;
import ch.juventus.schule.semesterarbeit.persistence.DatenverbindungAttrappe;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class PresentationKiosk {

    public PresentationKiosk() {

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
        System.out.println("Kiosk erstellen");
        DatenverbindungAttrappe datenverbindungAttrappe = DatenverbindungAttrappe.getInstance();
        datenverbindungAttrappe.kioskHinzufuegen();
    }

    public void alleKiosksAnzeigen(){
        /*
        Set<Kiosk> kisoks = datenSpeicher.getKiosks();
        if(kisoks.isEmpty()){
            System.out.println("Noch keine Kiosks vorhanden");
        } else {
            for(Kiosk kiosk : kisoks){
                System.out.println(kiosk);
            }
        }
        */
    }

    public void warenkorbErstellen(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("warenkorbKundeErstellen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
