package ch.juventus.schule.semesterarbeit.presentation.kiosk.select;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

import java.util.HashSet;
import java.util.Set;

/**
 * Provides support for TableView for the scene: kiosk select
 *
 * @author : ${user}
 * @since: ${date}
 */
public class KioskTableViewValueFactory {
    private Set<KioskTableViewValue> kiosksPlaceholder;

    public KioskTableViewValueFactory(Set<Kiosk> kiosks) {
        kiosksPlaceholder = new HashSet<>();
        for (Kiosk kiosk : kiosks) {
            kiosksPlaceholder.add(new KioskTableViewValue(kiosk, kiosk.getName(), kiosk.getLocation(), kiosk.isKioskOpen()));
        }
    }

    public Set<KioskTableViewValue> getKiosksPlaceholder() {
        return kiosksPlaceholder;
    }
}
