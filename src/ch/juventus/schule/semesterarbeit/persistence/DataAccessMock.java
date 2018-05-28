package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.lieferant.Lieferant;

import java.util.*;

/**
 * This creates a Data Access Mockup to store the data
 * @author : ${user}
 * @since: ${date}
 */

public class DataAccessMock {
    private Set<Kiosk> kiosks = new HashSet<>();
    private Set<Lieferant> lieferanten = new HashSet<>();

    public Kiosk kioskHinzufuegen(Kiosk kiosk) {
        if(kiosks.isEmpty()){
            System.out.println(kiosks);
            this.kiosks.add(kiosk);
            System.out.println(kiosks);
            System.out.println("Liste war noch leer: " + kiosk);
            return kiosk;
        } else if (kiosks.contains(kiosk)){
            for(Kiosk thisKiosk : kiosks){
                if(thisKiosk.equals(kiosk)){
                    System.out.println("Der Kiosk existiert bereits " + kiosk);
                    return kiosk;
                }
            }
        } else{
            this.kiosks.add(kiosk);
            System.out.println("Kiosk wurde zur Liste hinzugefuet " + kiosk);
            return kiosk;
        }
        return null;
    }

    public Lieferant lieferantHinzufuegen(Lieferant lieferant){
        if(lieferanten.isEmpty()){
            this.lieferanten.add(lieferant);
            //System.out.println(lieferanten);
            System.out.println("Lieferanten Liste war noch leer: " + lieferant);
            return lieferant;
        } else if (lieferanten.contains(lieferant)){
            for(Lieferant thisLieferant : lieferanten){
                if(thisLieferant.equals(lieferant)){
                    System.out.println("Der Lieferant existiert bereits " + lieferant);
                    return lieferant;
                }
            }
        } else{
            this.lieferanten.add(lieferant);
            System.out.println("Lieferant wurde zur Liste hinzugefuet " + lieferant);
            return lieferant;
        }
        return null;
    }

    public Kiosk kioskFinden (Kiosk kiosk){
        if (kiosks.contains(kiosk)) {
            for (Kiosk thisKisok : kiosks) {
                if (thisKisok.equals(kiosk)) {
                    return kiosk;
                }
            }
        }
        return null;
    }  

    public Set<Kiosk> getKiosks() {
        return kiosks;
    }
}
