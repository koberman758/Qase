package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    public static final By EMAIL_INPUT = By.name("email");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("//*[text()='Sign in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public LoginPage open() {
        log.info("Opening Login Page");
        driver.get(BASE_URL);
        return this;
    }

    public void isPageOpened() {
        driver.findElement(By.xpath("//*[text()='Sign in']")).isDisplayed();
    }

    @Step("Login user")
    public void login(String email, String password) {
        log.info("Login user ");
        log.info("Entering email into field e-mail{}", email);
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("Entering password into field password{}", password);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Login button click");
        driver.findElement(LOGIN_BUTTON).click();
    }
}
