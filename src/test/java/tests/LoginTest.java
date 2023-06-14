package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test(description = "Login")
    public void successfulLogin() {
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        assertTrue(projectListPage.isPageOpened(), "Login failed");
    }
}
