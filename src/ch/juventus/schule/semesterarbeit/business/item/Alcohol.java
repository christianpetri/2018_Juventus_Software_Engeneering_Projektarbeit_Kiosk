package ch.juventus.schule.semesterarbeit.business.item;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Alcohol extends Drink {
    private int legalAge;

    public Alcohol(String description, int price, int deciliter, int legalAge) {
        super(description, price, deciliter);
        this.legalAge = legalAge;
    }

    public boolean checkLegalAge(final int customerAge) {
        System.out.println("Check Legal Age");
        if(customerAge >= this.legalAge){
            return true;
        } else {
            return false;
        }
    }
}
