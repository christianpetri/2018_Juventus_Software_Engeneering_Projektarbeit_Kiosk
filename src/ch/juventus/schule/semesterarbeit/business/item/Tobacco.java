package ch.juventus.schule.semesterarbeit.business.item;

import java.util.logging.Logger;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Tobacco extends BaseArticle {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Tobacco(String description, int price) {
        super(description, price);
    }

    public boolean checkLegalAge(int customerAge) {
        LOGGER.info("Altersüberprüfung");
        if(customerAge >= 16){
            return true;
        } else {
            return false;
        }
    }
}
