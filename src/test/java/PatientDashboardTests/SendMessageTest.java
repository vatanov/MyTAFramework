package PatientDashboardTests;

import baseTest.BaseTest;
import libs.DateTimeUtils;
import libs.DbUtils;
import org.junit.After;
import org.junit.Test;

import static data.TestData.DENTIST;
import static data.TestData.DOC_MARK_SMITH;

public class SendMessageTest extends BaseTest {
    private final String subject = "TC-01 - Message " + DateTimeUtils.getDateAndTimeFormatted();
    private final String message = "TC-01 - New Message Body " + DateTimeUtils.getDateAndTimeFormatted();
    @Test
    public void sendMessage() {
        pageProvider.getHomePage().openHomePage()
                .getHeader()
                .clickDropdownMenu()
                .clickYourDashboard()
                .checkIsRedirectedToPatientDashboard();

        pageProvider.getPatientDashboardPage()
                .clickMessengerButton()
                // TODO: Add verification if Message tab is opened
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

        pageProvider.getPatientDashboardPage()
                .checkIsRedirectedToPatientDashboard()
                .clickMessengerButton()
                // TODO: Add verification if Message tab is opened
                .msgrClickSentButton()
                .msgrCheckSentMsgIsPresent(subject);
    }

    @After
    public void deleteSentMessage() {
        DbUtils dbUtils = new DbUtils();
        dbUtils.executeQueryWithoutResult(String.format("DELETE FROM sentmsg WHERE subject = '%s';", subject));
    }
}
