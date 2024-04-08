package suits;

import PatientDashboardTests.SendMessageTest;
import categories.SmokeTestFilter;
import contactUsTest.ContactUsTest;
import loginTest.NewLoginTest;
import logoutTest.LogoutTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTestFilter.class)
@Categories.ExcludeCategory()
@Suite.SuiteClasses({
        NewLoginTest.class,
        LogoutTest.class,
        SendMessageTest.class,
        ContactUsTest.class
})
public class SmokeSuiteWithCategories {
}
