package AppointmentTests;

import baseTest.BaseTest;
import org.junit.Test;

public class makeAppointmentTest extends BaseTest {
    @Test
    public void makeNewAppointment() {
        pageProvider.getHomePage().openHomePage().getHeader().clickDropdownMenu();
        pageProvider.getHomePage().getHeader().clickYourDashboard().checkIsRedirectedToPatientDashboard();

    }
}
