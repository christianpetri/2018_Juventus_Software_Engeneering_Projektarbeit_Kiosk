package ch.juventus.schule.semesterarbeit.presentation.kiosk.inventory.add;

/**
 * Throws an exception if the kiosk has not enough money to pay the supplier
 *
 * @author : ${user}
 * @since: ${date}
 */
public class KioskCashRegisterException extends Exception {
    public KioskCashRegisterException() {
    }

    public KioskCashRegisterException(String message) {
        super(message);
    }
}
