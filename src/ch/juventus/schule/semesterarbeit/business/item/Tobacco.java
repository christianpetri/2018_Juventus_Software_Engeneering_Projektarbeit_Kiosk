package ch.juventus.schule.semesterarbeit.business.item;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Tobacco extends BaseArticle {

    public Tobacco(String description, int price) {
        super(description, price);
    }

    public boolean checkLegalAge(int customerAge) {
        System.out.println("Check Legal Age");
        if(customerAge >= 16){
            System.out.println("Jap");
            return true;
        } else {
            System.out.println("Nope");
            return false;
        }
    }
}
