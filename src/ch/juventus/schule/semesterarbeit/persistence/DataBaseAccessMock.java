package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.employee.Employee;
import ch.juventus.schule.semesterarbeit.business.article.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.article.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.supplier.KioskSupplier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * This creates a Data Access Mockup to store the data
 *
 * @author : ${user}
 * @since: ${date}
 */


public class DataBaseAccessMock {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static DataBaseAccessMock instance;
    private Set<Kiosk> kiosks;

    private DataBaseAccessMock() {
        this.kiosks = new HashSet<>();
    }

    public static DataBaseAccessMock getInstance() {
        if (DataBaseAccessMock.instance == null) {
            DataBaseAccessMock.instance = new DataBaseAccessMock();
        }
        return DataBaseAccessMock.instance;
    }

    /**
     * Creates a new kiosk, inits the kiosk storage, inits the employee and inits the supplier and his storage. And adds it into the kiosks
     *
     * @param kioskName    the name of the Kiosk
     * @param locationName the location of the Kiosk
     * @param employeeName the name of the employee that works in that particular Kiosk
     * @param startCapital the amount of money that is in the Cash Register when the kiosk opens for the first time
     * @return the kiosk that was added to the kiosks
     */

    public Kiosk addKiosk(String kioskName, String locationName, String employeeName, int startCapital) {
        Employee employee = new Employee(employeeName);
        ArticleFactory articleFactory = new ArticleFactory();
        Map<BaseArticle, Integer> storageKiosk = new HashMap<>();
        storageKiosk.put(articleFactory.createBigAppleJuice(), 5);
        storageKiosk.put(articleFactory.createMars(), 8);
        storageKiosk.put(articleFactory.createBigBeer(), 9);
        storageKiosk.put(articleFactory.createCigarettePack(), 9);
        storageKiosk.put(articleFactory.createBigVodka(), 9);
        storageKiosk.put(articleFactory.createGlamourMagazin(), 9);

        Map<BaseArticle, Integer> storageSupplier = new HashMap<>();
        storageSupplier.put(articleFactory.createBigAppleJuice(), 5);
        storageSupplier.put(articleFactory.createMars(), 4);
        storageSupplier.put(articleFactory.createBigBeer(), 4);
        storageSupplier.put(articleFactory.createSmallVodka(), 4);

        KioskSupplier kioskSupplier = new KioskSupplier("Meier", storageSupplier);

        Kiosk kiosk = new Kiosk(kioskName, locationName, false, employee, storageKiosk, startCapital, kioskSupplier);

        if (kiosks.contains(kiosk)) {
            for (Kiosk thisKiosk : kiosks) {
                if (thisKiosk.equals(kiosk)) {
                    LOGGER.warning("Der Kiosk existiert bereits " + kiosk);
                    return thisKiosk;
                }
            }
        } else {
            this.kiosks.add(kiosk);
            LOGGER.info("Kiosk wurde zur Liste hinzugefuet " + kiosk);
            return kiosk;
        }
        return null;
    }

    public Set<Kiosk> getKiosks() {
        return kiosks;
    }

    /**
     * Updates the kiosk storage (and "overrides" the old storage)
     *
     * @param myKiosk is the kiosk that was "temporally" was stored in the SceneDataHandler
     */

    public void setKioskStorage(Kiosk myKiosk) {
        Map<BaseArticle, Integer> newInventory = new HashMap<>();
        for (Map.Entry<BaseArticle, Integer> article : myKiosk.getInventory().entrySet()) {
            newInventory.put(article.getKey(), article.getValue());
        }
        for (Kiosk kiosk : kiosks) {
            if (kiosk.equals(myKiosk)) {
                kiosk.setInventory(newInventory);
                break;
            }
        }
        LOGGER.info("Das Lager wurde erfolgreich gespeichert");
    }

    /**
     * Updates the kiosk supplier storage (and "overrides" the old storage)
     *
     * @param myKiosk is the kiosk that was "temporally" was stored in the SceneDataHandler
     */

    public void setKioskSupplierInventory(Kiosk myKiosk) {
        Map<BaseArticle, Integer> newInventory = new HashMap<>();
        for (Map.Entry<BaseArticle, Integer> article : myKiosk.getKioskSupplier().getInventory().entrySet()) {
            newInventory.put(article.getKey(), article.getValue());
        }
        for (Kiosk kiosk : kiosks) {
            if (kiosk.equals(myKiosk)) {
                kiosk.getKioskSupplier().setInventory(newInventory);
                break;
            }
        }
        LOGGER.info("Das Lager wurde erfolgreich gespeichert");
    }
}
