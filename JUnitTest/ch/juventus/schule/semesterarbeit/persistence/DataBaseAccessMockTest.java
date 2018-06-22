package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author : ${user}
 * @since: ${date}
 */


public class DataBaseAccessMockTest {

    private DataBaseAccessMock dbMock;
    private final String KIOSK_NAME = "Rittergasse";
    private final String KIOSK_LOCATION = "Seen";
    private final String KIOSK_EMPLOYEE_NAME = "Hansi";
    private final int KIOSK_START_CAPITAL = 1000000;



    @Before
    public void initialize() {
        dbMock = DataBaseAccessMock.getInstance();
    }

    @Test
    public void addKiosk() {
        final Kiosk testKiosk = dbMock.addKiosk(KIOSK_NAME, KIOSK_LOCATION, KIOSK_EMPLOYEE_NAME, KIOSK_START_CAPITAL);
        assertEquals(dbMock.getKiosks().size(), 1);
        dbMock.getKiosks().clear();

        assertEquals(dbMock.getKiosks().size(), 0);

    }

    @Test
    public void validateAddKiosk() {
        final Kiosk testKiosk = dbMock.addKiosk(KIOSK_NAME, KIOSK_LOCATION, KIOSK_EMPLOYEE_NAME, KIOSK_START_CAPITAL);
        assertEquals(dbMock.getKiosks().size(), 1);

        for (Kiosk kiosk : dbMock.getKiosks()) {
            if (kiosk.equals(testKiosk)) {
                assertEquals(kiosk.getName(), testKiosk.getName());
                System.out.println(kiosk.getName() + " " + testKiosk.getName());
                break;
            }
        }
        dbMock.getKiosks().clear();
        assertEquals(dbMock.getKiosks().size(), 0);
    }
}