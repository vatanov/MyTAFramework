package contactUsTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

/*
* This Test is using JUnitParamsRunner to run the same test with different parameters
* It allows us to write only one test method but run it with different parameters
* Also here we can collect all errors types in one String and use it in the test
* */

// This annotation @RunWith is used to run the same test with different parameters
@RunWith(JUnitParamsRunner.class)
public class ContactUsTest extends BaseTest {
    final static String ERROR = "Please fill all the fields !";
    final static String EMAIL = "user@test.com";
    final static String EMPTY_EMAIL = "";
    final static String SUBJECT = "Test subject";
    final static String EMPTY_SUBJECT = "";
    final static String MESSAGE = "Test message";
    final static String EMPTY_MESSAGE = "";

    // Below added other errors types just as an example (we are not going to use them in the test)
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";

    // Separators
    final static String SEMICOLON = ";";
    final static String COMMA = ",";

    // Wrong User data example
    final static String SHORT_USER_NAME = "tr";

    @Test
    @Parameters(method = "parametersForTest")
    public void contactUsErrorMessagesTest(String email, String subject, String message, String expectedFailureMessage) {
        pageProvider
                .getContactUsPage()
                .openContactUsPage()
                .typeEmail(email)
                .typeSubject(subject)
                .typeMessage(message)
                .clickSubmitButton()
                .checkIsAlertMessageDisplayed()
                .checkTextInAlertMessage(expectedFailureMessage)
                .checkAllAlertMessages(expectedFailureMessage);
    }

    private Object[][] parametersForTest() {
        return new Object[][]{
                {EMPTY_EMAIL, EMPTY_SUBJECT, EMPTY_MESSAGE, ERROR},
                {EMAIL, EMPTY_SUBJECT, EMPTY_MESSAGE, ERROR},
                {EMPTY_EMAIL, SUBJECT, EMPTY_MESSAGE, ERROR},
                {EMPTY_EMAIL, EMPTY_SUBJECT, MESSAGE, ERROR},
                {EMPTY_EMAIL, SUBJECT, MESSAGE, ERROR},
                {EMAIL, EMPTY_SUBJECT, MESSAGE, ERROR},
                {EMAIL, SUBJECT, EMPTY_MESSAGE, ERROR}
                // Example of using multiple errors in one test separated by SEMICOLON
                // {"test", "trtr", "123456",  ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
        };
    }
}
