package suits;

import apiTests.AddBookByApiTest;
import loginTest.NewLoginTest;
import logoutTest.LogoutTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        NewLoginTest.class,
        LogoutTest.class,
        AddBookByApiTest.class
})
public class SmokeSuite {
}
