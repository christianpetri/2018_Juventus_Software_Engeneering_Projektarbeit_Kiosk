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
    public void initialize(){
        customer = new Customer(CUSTOMER_NAME, CUSTOMER_AGE);
        customer.toString();
    }

    @Test
    public void compareCustomerName(){
       Customer testCustomer = new Customer(CUSTOMER_NAME, CUSTOMER_AGE);
       assertEquals(customer.getName(),testCustomer.getName());

    }
}