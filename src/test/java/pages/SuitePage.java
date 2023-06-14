package pages;

import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class SuitePage extends BasePage {

    public static final By CREATE_BUTTON = By.xpath("//*[text()='Create']");
    public static final By SAVE_BUTTON = By.xpath("//*[text()='Save']");
    public static final By SUITE_TITLE = By.id("title");
    public static final By DESCRIPTION = By.id("description");
    public static final By PRECONDITIONS = By.id("preconditions");
    public static final String SUITE_URL = "case/%s/create";

    public SuitePage(WebDriver driver) {
        super(driver);
    }

    public SuitePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        return this;
    }

    @Step("Filling in the fields of the suite")
    public SuitePage fillIn(Suite suite) {
        log.info("Filling suite data");
        driver.findElement(SUITE_TITLE).click();
        driver.findElement(SUITE_TITLE).clear();
        log.info("Filling title field {}", suite.getTitle());
        driver.findElement(SUITE_TITLE).sendKeys(suite.getTitle());
        log.info("Filling description field {}", suite.getDescription());
        driver.findElement(DESCRIPTION).sendKeys(suite.getDescription());
        log.info("Filling preconditions field {}", suite.getPreconditions());
        driver.findElement(PRECONDITIONS).sendKeys(suite.getPreconditions());
        return this;
    }

    @Step("Click create suite button")
    public void createSuite() {
        log.info("Click create suite button");
        driver.findElement(CREATE_BUTTON).click();
    }

    @Step("Click save suite button")
    public void saveSuite() {
        log.info("Click save suite button");
        driver.findElement(SAVE_BUTTON).click();
    }

    public SuitePage updateFillIn(Suite suite) {
        return this;
    }
}