

package pages;

import dto.TestCase;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.DropDown;
import wrappers.Input;

@Log4j2
public class CasePage extends BasePage {
    public static final By SAVE_BUTTON = By.id("save-case");
    public static final String CREATE_CASE_URL = "case/%s/create";
    public static final String EDIT_CASE_URL = "case/%s/edit/1";

    public CasePage(WebDriver driver) {
        super(driver);
    }

    public CasePage openCreateCase(String code) {
        driver.get(BASE_URL + (String.format(CREATE_CASE_URL, code)));
        return this;
    }

    @Step("Opening edit case page")
    public CasePage openEditCase(String code) {
        driver.get(BASE_URL + (String.format(EDIT_CASE_URL, code)));
        return this;
    }

    public CasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        return this;
    }

    @Step("Filling inputs in the fields of the test case")
    public CasePage fillInInput(TestCase testCase) {
        log.info("Filling inputs {}", testCase);
        log.info("Filling Title field {}", testCase.getTitle());
        new Input(driver, "Title").write(testCase.getTitle());
        log.info("Filling Description field {}", testCase.getDescription());
        new Input(driver, "Description").write(testCase.getDescription());
        log.info("Filling Pre-conditions field {}", testCase.getPreconditions());
        new Input(driver, "Pre-conditions").write(testCase.getPreconditions());
        log.info("Filling Post-conditions field {}", testCase.getPostconditions());
        new Input(driver, "Post-conditions").write(testCase.getPostconditions());
        return this;
    }

    @Step("Selecting drops in the test case")
    public CasePage fillInDropDown(TestCase testCase) {
        log.info("Selecting drops {}", testCase);
        log.info("Select Status dropdown {}", testCase.getStatus());
        new DropDown(driver, "Status").selectNew(testCase.getStatus());
        log.info("Select Severity dropdown {}", testCase.getSeverity());
        new DropDown(driver, "Severity").selectNew(testCase.getSeverity());
        log.info("Select Priority dropdown {}", testCase.getPriority());
        new DropDown(driver, "Priority").selectNew(testCase.getPriority());
        log.info("Select Type dropdown {}", testCase.getType());
        new DropDown(driver, "Type").selectNew(testCase.getType());
        log.info("Select Layer dropdown {}", testCase.getLayer());
        new DropDown(driver, "Layer").selectNew(testCase.getLayer());
        log.info("Select is flaky dropdown {}", testCase.getIs_flaky());
        new DropDown(driver, "Is flaky").selectNew(testCase.getIs_flaky());
        log.info("Select Behavior dropdown {}", testCase.getBehavior());
        new DropDown(driver, "Behavior").selectNew(testCase.getBehavior());
        log.info("Select Automation status dropdown {}", testCase.getAutomation());
        new DropDown(driver, "Automation status").selectNew(testCase.getAutomation());
        return this;
    }

    @Step("Saving new test case")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}

