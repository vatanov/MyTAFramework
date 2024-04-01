package contactUsTest;

import baseTest.BaseTest;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static libs.ConfigProvider.configProperties;

/*
* This Test is using test data from Excel file SpreadSheetData.xls
* */

@RunWith(Parameterized.class)
public class ContactUsWithExcelTest extends BaseTest {
    String email;
    String subject;
    String message;
    String expectedFailureMessage;

    public ContactUsWithExcelTest(String email, String subject, String message, String expectedFailureMessage) {
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.expectedFailureMessage = expectedFailureMessage;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(inputStream, "contactUsData").getData();
    }

    @Test
    public void contactUsErrorMessagesTest() {
        pageProvider
                .getContactUsPage()
                .openContactUsPage()
                .typeEmail(email)
                .typeSubject(subject)
                .typeMessage(message)
                .clickSubmitButton()
                .checkIsSuccessMessageDisplayed()
                .checkTextInSuccessMessage(expectedFailureMessage);
    }
}
