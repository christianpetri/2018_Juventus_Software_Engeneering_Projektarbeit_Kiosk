package ch.juventus.schule.semesterarbeit.business.customer;

import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Customer {
    private String name;
    private int age;
    private ShoppingCart shoppingCart;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.shoppingCart = new ShoppingCart();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", shoppingCart=" + shoppingCart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
