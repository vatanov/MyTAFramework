package PatientDashboardTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

import static data.TestData.DENTIST;
import static data.TestData.DOC_MARK_SMITH;

public class SendMessageTest extends BaseTest {
    private final String subject = "TC-01 - Message " + Util.getDateAndTimeFormatted();
    private final String message = "TC-01 - New Message Body " + Util.getDateAndTimeFormatted();
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
                .msgrTypeSubject(subject)
                .msgrTypeMessage(message)
                .msgrClickSendButton();

        pageProvider.getAlertHandler()
                .checkAlertPresent()
                .checkTextInAlert("Message Sent Successfully")
                .acceptAlert();
    }
}
