package ch.juventus.schule.semesterarbeit.business.multithreading;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.employee.Employee;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class CustomerThread extends Thread{

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
    public void run(){

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

    public void start(){
        if( thread == null){
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    //Erstellt 5 Kunden, fügt Waren in deren Einkaufskörbe, Waren werden verkauft
    /*
'Automatischer Durchlauf': Der Kunde wird als Thread implementiert. Fügt einen sleep(5000)
beim Bezahlen hinzu um eine Warteschlange von Kunden zu bekommen. Füge auch einen
sleep(2000) beim Artikel in Warenkorb des Kunden legen hinzu, damit nicht alle Kunden
bereits in der Schlange stehen bevor der erste bezahlt hat. Das Erstellen der Kunden soll im
Abstand von 1000ms passieren.
o Die Warteschlange an der Kasse soll detailliert ausgegeben werden. Ein Log wenn ein
Kunde die Warteschlange betritt mit Position in der Schlange, ein Log wenn der
Kunde an der Reihe ist und ein Log wenn der Kunde bezahlt hat. Beispiel:
 Kunde1 an Kasse (Warteschlange Position 1)
 Kunde1 bezahlt
 Kunde2 an Kasse (Warteschlange Position 2)
 Kunde3 an Kasse (Warteschlange Position 3)
 Kunde 1 hat bezahlt
 Kunde 2 bezahlt
 Kunde4 an Kasse (Warteschlange Position 3)
 Usw.
    * */
    private Customer createNewCustomer() throws InterruptedException {
        Thread.sleep(1000);
        int randomNum = ThreadLocalRandom.current().nextInt(5, 100);
        System.out.println("Adding Customer" + randomNum);
        return new Customer("Customer" + randomNum , randomNum);
    }

    private void addArticleToShoppingBasket() throws InterruptedException {
        Thread.sleep(2000);
        this.customer.getShoppingBasket().addArticles(this.kiosk.getStorage(), articleFactory.createBigAppleJuice(),1);
        this.customer.getShoppingBasket().addArticles(this.kiosk.getStorage(), articleFactory.createMars(),1);

    }

    private void payShoppingBasket() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(this.customer.getName() + " is paying his ShoppingBasket ");
        System.out.println("The customer paid " +customer.getShoppingBasket().payArticles(kiosk.getStorage()) + " CHF");

    }
}
