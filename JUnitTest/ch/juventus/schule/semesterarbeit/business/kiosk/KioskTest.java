package ch.juventus.schule.semesterarbeit.business.kiosk;

import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class KioskTest {

    private DataBaseAccessMock dbMock;
    private Kiosk kiosk;
    private final String KIOSK_NAME = "Rittergasse";
    private final String KIOSK_LOCATION = "Seen";
    private final String KIOSK_EMPLOYEE_NAME = "Hansi";
    private final int KIOSK_START_CAPITAL = 1000000;



    @Before
    public void initialize() {
        dbMock = DataBaseAccessMock.getInstance();
        kiosk = dbMock.addKiosk(KIOSK_NAME, KIOSK_LOCATION, KIOSK_EMPLOYEE_NAME, KIOSK_START_CAPITAL);
    }
    @Test
    public void toggleIsKioskOpen() {
       assertEquals(kiosk.isKioskOpen(),false);
       kiosk.toggleIsKioskOpen();
       assertEquals(kiosk.isKioskOpen(),true);
    }
}