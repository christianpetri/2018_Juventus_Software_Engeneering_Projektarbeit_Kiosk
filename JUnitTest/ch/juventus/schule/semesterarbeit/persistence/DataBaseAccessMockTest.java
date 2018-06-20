package ch.juventus.schule.semesterarbeit.persistence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class DataBaseAccessMockTest {

    private DataBaseAccessMock dbMock;

    @Test
    public void getInstance() {

    }

    @Before
    public void setup(){
        dbMock =  DataBaseAccessMock.getInstance();
    }

    @Test
    public void addKiosk() {
    }

    @Test
    public void getKiosks() {
    }

    @Test
    public void setCustomer() {
    }

    @Test
    public void getCustomer() {
    }

    @Test
    public void setKioskStorage() {
    }
}