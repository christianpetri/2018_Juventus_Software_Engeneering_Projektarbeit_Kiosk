package ch.juventus.schule.semesterarbeit.business.article;


import java.util.logging.Logger;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Alcohol extends Drink {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private int legalAge;

    public Alcohol(String description, int price, int deciliter, int legalAge) {
        super(description, price, deciliter);
        this.legalAge = legalAge;
    }

    public boolean checkLegalAge(final int customerAge) {
        LOGGER.info("Altersüberprüfung");
        if (customerAge >= this.legalAge) {
            return true;
        } else {
            return false;
        }
    }
}
