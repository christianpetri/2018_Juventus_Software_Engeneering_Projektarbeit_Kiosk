package ch.juventus.schule.semesterarbeit;

import ch.juventus.schule.semesterarbeit.artikel.Getraenk;
import ch.juventus.schule.semesterarbeit.artikel.Tabak;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Console {
    public Console(){
        
        List<Getraenk> warenkorb = new ArrayList<Getraenk>();
        Getraenk apfelsaft = new Getraenk("Apfelsaft" , 13, 5);
        warenkorb.add(apfelsaft);

        System.out.printf(String.valueOf(warenkorb));

    }
}
