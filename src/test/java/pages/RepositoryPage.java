package pages;

import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class RepositoryPage extends BasePage {

    public static final String REPOSITORY_NAME = "//h1[contains(text(), '%s')]";
    public static final By CREATE_CASE_BUTTON = By.id("create-suite-button");
    public static final By CREATE_SUITE_BUTTON = By.id("create-suite-button");
    public static final String DELETE_SUITE_BUTTON = "//h3/span[text()='%s']/..//i[contains(@class, 'fa-trash')]";
    public static final String EDIT_SUITE_BUTTON = "//h3/span[text()='%s']/..//i[contains(@class, 'fa-pencil')]";
    public static final By SUBMIT_DELETE_SUITE = By.cssSelector("[type='submit']");
    public static final By EDIT_CASE_BUTTON = By.xpath("//span[text()=' Edit']");
    public static final By DELETE_CASE_BUTTON = By.xpath("//span[text()=' Delete']");
    public static final String CASE_BY_PROJECT_CODE = "//a[text()='%s-1']";
    public static final String CASE_BY_TITLE = "//*[text()='%s']";
    public static final By SUBMIT_DELETE_CASE = By.xpath("//span[text()='Delete']");
    public static final By ERROR_MESSAGE = By.xpath("//*[text()='Looks like you don’t have any suites and cases yet.']");
    public static final String GET_CASE_TITLE = "//a//span//i/ancestor::div//h1//div[text()='%s']";
    public static final String GET_SUITE_TITLE = "//span[text()='%s']";

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public void open(String code) {
        driver.get(BASE_URL + "project/" + code);
    }

    public boolean isPageOpened(Project project) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.xpath(String.format(REPOSITORY_NAME, project)))));
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    @Step("Click create suite button")
    public void clickCreateSuiteButton() {
        driver.findElement(CREATE_SUITE_BUTTON).click();
    }

    @Step("Delete suite")
    public void deleteSuite(String suite) {
        log.info("Deleting suite {}", suite);
        driver.findElement(By.xpath(String.format(DELETE_SUITE_BUTTON, suite))).click();
        driver.findElement(SUBMIT_DELETE_SUITE).click();
    }

    @Step("Click edit suite button")
    public void clickEditSuiteButton(String suite) {
        log.info("Click edit suite button {}", suite);
        driver.findElement(By.xpath(String.format(EDIT_SUITE_BUTTON, suite))).click();
    }

    @Step("Click create case button")
    public void clickCreateCaseButton() {
        log.info("Click create case button");
        driver.findElement(CREATE_CASE_BUTTON).click();
    }

    @Step("Click edit case button")
    public void clickEditCaseButton(String code) {
        log.info("Click edit case button {}", code);
        driver.findElement(By.xpath(String.format(CASE_BY_PROJECT_CODE, code))).click();
        driver.findElement(EDIT_CASE_BUTTON).click();
    }

    @Step("Delete case")
    public void deleteCase(String testCase) {
        log.info("Deleting case {}", testCase);
        driver.findElement(By.xpath(String.format(CASE_BY_TITLE, testCase))).click();
        driver.findElement(DELETE_CASE_BUTTON).click();
        driver.findElement(SUBMIT_DELETE_CASE).click();
    }

    @Step("Getting the case title")
    public String takeCaseTitle(String caseTitle) {
        log.info("Getting case title {}", caseTitle);
        return driver.findElement(By.xpath(String.format(GET_CASE_TITLE, caseTitle))).getText();
    }
    @Step("Search for a case by title")
    public String searchCaseByTitle(String caseTitle) {
        log.info("Search case by title {}", caseTitle);
        return driver.findElement(By.xpath(String.format(CASE_BY_TITLE, caseTitle))).getText();
    }

    @Step("Search for a suite by title")
    public String searchSuiteByTitle(String suiteTitle) {
        log.info("Search suite by title {}", suiteTitle);
        return driver.findElement(By.xpath(String.format(GET_SUITE_TITLE, suiteTitle))).getText();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}