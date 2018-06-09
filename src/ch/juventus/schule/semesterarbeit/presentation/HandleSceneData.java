package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class HandleSceneData {
    private static HandleSceneData instance;
    private Customer customer;
    private Kiosk kiosk;

    private HandleSceneData(){};

    public static HandleSceneData getInstance(){
        if(HandleSceneData.instance == null){
            HandleSceneData.instance = new HandleSceneData();
        }
        return HandleSceneData.instance;
    }


}
