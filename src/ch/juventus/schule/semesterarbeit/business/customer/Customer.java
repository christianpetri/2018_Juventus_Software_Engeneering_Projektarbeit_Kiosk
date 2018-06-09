package ch.juventus.schule.semesterarbeit.business.customer;

import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Customer {
    private String name;
    private int age;
    private ShoppingBasket shoppingBasket;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.shoppingBasket = new ShoppingBasket(this.age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", shoppingBasket=" + shoppingBasket +
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
