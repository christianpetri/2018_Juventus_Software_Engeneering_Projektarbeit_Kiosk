package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;

import java.util.Collections;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class SceneDataHandler implements Cloneable {
    private static SceneDataHandler instance;
    private Customer customer;
    private Kiosk kiosk;
    private int amountToPay;

    private SceneDataHandler(){}

    public static SceneDataHandler getInstance(){
        if(SceneDataHandler.instance == null){
            SceneDataHandler.instance = new SceneDataHandler();
        }
        return SceneDataHandler.instance;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Kiosk getKiosk() {
        return kiosk;
    }

    public void setKiosk(Kiosk kiosk) {

         this.kiosk = new Kiosk(kiosk);

    }

    public void resetSceneDataHandler(){
        this.customer = null;
        this.kiosk = null;
        this.amountToPay = 0;
    }
}
