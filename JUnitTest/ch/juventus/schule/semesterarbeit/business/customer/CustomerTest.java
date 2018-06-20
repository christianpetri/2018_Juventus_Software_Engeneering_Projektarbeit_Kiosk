package ch.juventus.schule.semesterarbeit.business.customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class CustomerTest {

    private Customer customer;

    private final String CUSTOMER_NAME = "Fritz";
    private final int CUSTOMER_AGE = 50;

    private final String expectedCustomerName = "Customer{" +
            "name=\'" + CUSTOMER_NAME + '\'' +
            ", age=" + CUSTOMER_AGE +
            ", shoppingBasket=" +
            "" +
            "'}'";
    //shoppingBasket
    @Before
    public void setup(){
        customer = new Customer(CUSTOMER_NAME, CUSTOMER_AGE);
        customer.toString();
    }

    @Test
    public void toString() {
        System.out.println("Testing toString method for customer");
        Assert.assertEquals(expectedCustomerName, customer.toString());
    }

    @Test
    public void equals() {
    }

    @Test
    public void hashCode() {
    }
}