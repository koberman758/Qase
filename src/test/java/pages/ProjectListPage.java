package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProjectListPage extends BasePage {

    public static final By CREATE_BUTTON = By.id("createButton");
    public static final By SEARCH_FIELD = By.cssSelector("[placeholder='Search for projects']");
    public static final String DROPDOWN_BUTTON = "//*[text()='%s']/ancestor::tr//a[@class='btn btn-dropdown']";
    public static final By DROPDOWN_DELETE = By.xpath("//*[button='Delete']");
    public static final String DROPDOWN_SETTINGS = "https://app.qase.io/project/%s/settings/general";
    public static final String GET_PROJECT = "//*[text()='%s']";
    public static final By ACCEPT_DELETE_BUTTON = By.xpath("//span[text()='Delete project']");
    public static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");
    public static final By PROJECT_CODE_FIELD = By.id("project-code");
    public static final By PROJECT_NAME_FIELD = By.id("project-name");


    public ProjectListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public void open() {
        driver.get(BASE_URL + "projects");
    }

    @Step("Search for a project by 'code'")
    public void searchProject(String code) {
        log.info("Search project by code name");
        driver.findElement(SEARCH_FIELD).click();
        driver.findElement(SEARCH_FIELD).clear();
        driver.findElement(SEARCH_FIELD).sendKeys(code);
        driver.findElement(SEARCH_FIELD).click();
        driver.findElement(SEARCH_FIELD).clear();
        driver.findElement(SEARCH_FIELD).sendKeys(code);
    }

    @Step("Deleting a project by title")
    public void deleteProject(String title) {
        log.info("Deleting a project by title");
        driver.findElement(By.xpath(String.format(DROPDOWN_BUTTON, title))).click();
        driver.findElement(DROPDOWN_DELETE).click();
        driver.findElement(ACCEPT_DELETE_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
    }

    @Step("Updating the project")
    public void updateProject(String code, String newTitle, String newCode) {
        log.info("Updating project with new data {}{}", newTitle, newCode);
        driver.get(String.format(DROPDOWN_SETTINGS, code));
        driver.findElement(PROJECT_NAME_FIELD).click();
        driver.findElement(PROJECT_NAME_FIELD).clear();
        driver.findElement(PROJECT_NAME_FIELD).sendKeys(newTitle);
        driver.findElement(PROJECT_CODE_FIELD).click();
        driver.findElement(PROJECT_CODE_FIELD).clear();
        driver.findElement(PROJECT_CODE_FIELD).sendKeys(newCode);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    @Step("Click create project button")
    public void clickCreateButton() {
        driver.findElement(CREATE_BUTTON).click();
    }

    @Step("Search for a project by title")
    public String getProjectByTitle(String title) {
        return driver.findElement(By.xpath(String.format(GET_PROJECT, title))).getText();
    }
}
