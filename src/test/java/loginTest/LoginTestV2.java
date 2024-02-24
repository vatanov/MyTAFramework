package loginTest;

import org.junit.Test;

public class LoginTestV2 extends baseTest.BaseTest{
    @Test
    public void validLoginTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().clickLoginButtonInHeader();
        pageProvider.getLoginPage().enterEmail("j.doe@mail.com");
        pageProvider.getLoginPage().enterPassword("qwerty");
        pageProvider.getLoginPage().clickLoginButton();

        //TODO: Add assertion
    }
}
