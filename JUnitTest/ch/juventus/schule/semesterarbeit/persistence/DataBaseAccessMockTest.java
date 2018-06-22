package ch.juventus.schule.semesterarbeit.persistence;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 *
 * @author : ${user}
 * @since: ${date}
 */


public class DataBaseAccessMockTest {

    private DataBaseAccessMock dbMock;

    @Before public void initialize() {
        dbMock =  DataBaseAccessMock.getInstance();
    }

    @Test
    public void addKiosk() {
        final Kiosk testKiosk = dbMock.addKiosk("Rittergasse", "Seen", "Hansi", 1000);
        assertEquals(dbMock.getKiosks().size(),1);
      dbMock.getKiosks().clear();

      assertEquals(dbMock.getKiosks().size(),0);

    }

    @Test
    public void validateAddKiosk() {
        final Kiosk testKiosk = dbMock.addKiosk("Rittergasse", "Seen", "Hansi", 1000);
        assertEquals(dbMock.getKiosks().size(),1);

        for(Kiosk kiosk : dbMock.getKiosks()){
            if(kiosk.equals(testKiosk)){
                assertEquals(kiosk.getName(), testKiosk.getName());
                System.out.println(kiosk.getName() +" "+ testKiosk.getName());
                break;
            }
        }
        dbMock.getKiosks().clear();
        assertEquals(dbMock.getKiosks().size(),0);

    }
}