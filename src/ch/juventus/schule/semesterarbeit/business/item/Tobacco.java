package ch.juventus.schule.semesterarbeit.business.item;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;

import java.util.Scanner;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Tobacco extends BaseArticle {

    public Tobacco(String description, int price) {
        super(description, price);
    }

    public boolean checkLegalAge(Customer customer) {
        System.out.println("Check Legal Age");
        if(customer.getAge() >= 16){
            return true;
        } else {
            return false;
        }
    }
}
