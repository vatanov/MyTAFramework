package loginTest;

import data.TestData;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTestV2 extends baseTest.BaseTest{
    @Test
    public void validLoginTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().clickLoginButtonInHeader();
        pageProvider.getLoginPage().enterEmail(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickLoginButtonInModal();

        pageProvider.getHomePage().getHeader().checkIsDropdownMenuDisplayed();
    }
}
