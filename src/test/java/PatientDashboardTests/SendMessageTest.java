package PatientDashboardTests;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.DENTIST;
import static data.TestData.DOC_MARK_SMITH;

public class SendMessageTest extends BaseTest {
    @Test
    public void sendMessage() {
        pageProvider.getHomePage().openHomePage()
                .getHeader()
                .clickDropdownMenu()
                .clickYourDashboard()
                .checkIsRedirectedToPatientDashboard();

        pageProvider.getPatientDashboardPage()
                .clickMessengerButton()
                .msgrClickComposeButton()
                .msgrSetDoctorTypeDropdown(DENTIST)
                .msgrSetDoctorNameDropdown(DOC_MARK_SMITH)
                .msgrTypeSubject("asGHJGHdf")
                .msgrTypeMessage("fghj ghFGHNFGHjk dfghj")
                .msgrClickSendButton();

        pageProvider.getAlertHandler()
                .checkAlertPresent()
                .checkAlertTextPresent("Message Sent Successfully")
                .acceptAlert();
    }
}
