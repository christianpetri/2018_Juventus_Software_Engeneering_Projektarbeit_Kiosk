package ch.juventus.schule.semesterarbeit.business.item;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;

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

    public boolean checkLegalAge(Customer customer) {
        System.out.println("Check Legal Age");
        if(customer.getAge() >= this.legalAge){
            return true;
        } else {
            return false;
        }
    }
}
