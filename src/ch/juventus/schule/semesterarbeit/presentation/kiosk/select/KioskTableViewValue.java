package ch.juventus.schule.semesterarbeit.presentation.kiosk.select;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

/**
 * Provides the Values for the TableView(JavaFX) for the scene: kiosk select
 *
 * @author : ${user}
 * @since: ${date}
 */
public class KioskTableViewValue {
    private Kiosk kiosk;
    private String name;
    private String location;
    private boolean isKioskOpen;
    private String createShoppingBasket;
    private String orderArticles;
    private String getInventory;

    public KioskTableViewValue(Kiosk kiosk, String name, String location, boolean isKioskOpen) {
        this.kiosk = kiosk;
        this.name = name;
        this.location = location;
        this.isKioskOpen = isKioskOpen;
        this.createShoppingBasket = "Verkauf tätigen";
        this.orderArticles = "Artikel bestellen";
        this.getInventory = "Inventar anzeigen";
    }

    public Kiosk getKiosk() {
        return kiosk;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public boolean isKioskOpen() {
        return isKioskOpen;
    }

    public String getCreateShoppingBasket() {
        return createShoppingBasket;
    }

    public String getOrderArticles() {
        return orderArticles;
    }

    public String getGetInventory() {
        return getInventory;
    }
}
