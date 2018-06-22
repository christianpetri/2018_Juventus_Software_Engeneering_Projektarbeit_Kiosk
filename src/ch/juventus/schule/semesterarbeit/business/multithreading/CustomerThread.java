package ch.juventus.schule.semesterarbeit.business.multithreading;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.article.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Simulates 5 customers that are simultaneous adding articles to their shopping basket and are paying it
 * @author : ${user}
 * @since: ${date}
 */
public class CustomerThread extends Thread {

    private Kiosk kiosk;
    private Customer customer;
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private ArticleFactory articleFactory;
    private Thread thread;
    private String threadName;

    public CustomerThread(String threadName, Kiosk kiosk) {
        this.kiosk = kiosk;
        this.threadName = threadName;

    }

    public void run() {

        articleFactory = new ArticleFactory();
        System.out.println(threadName);

        try {
            this.customer = createNewCustomer();
            addArticleToShoppingBasket();
            payShoppingBasket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    private Customer createNewCustomer() throws InterruptedException {
        Thread.sleep(1000);
        int randomNum = ThreadLocalRandom.current().nextInt(5, 100);
        System.out.println(threadName + ": Adding CustomerController" + randomNum);
        return new Customer("CustomerController " + randomNum, randomNum);
    }

    private void addArticleToShoppingBasket() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(threadName);
        this.customer.getShoppingBasket().addArticle(this.kiosk.getInventory(), articleFactory.createBigAppleJuice(), 1);
        this.customer.getShoppingBasket().addArticle(this.kiosk.getInventory(), articleFactory.createMars(), 1);
    }

    private void payShoppingBasket() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(threadName + ": " + this.customer.getName() + " is paying his ShoppingBasket. The customer paid " + customer.getShoppingBasket().payArticles() + " CHF");
        customer.getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
    }
}
