package pages;

import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewProjectPage extends BasePage {

    public static final By PROJECT_NAME = By.id("project-name");
    public static final By PROJECT_CODE = By.id("project-code");
    public static final By DESCRIPTION = By.id("description-area");
    public static final By ACCESS_TYPE = By.xpath("//*[text()='Public']");
    public static final By CREATE_BUTTON = By.xpath("//*[text()='Create project']");

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create new project")
    public void createProject(Project project) {
        log.info("Filling data in new project {}", project);
        log.info("Filling project name in new project {}", project);
        driver.findElement(PROJECT_NAME).sendKeys(project.getTitle());
        log.info("Clear field code in new project");
        driver.findElement(PROJECT_CODE).clear();
        log.info("Filling project code in new project {}", project);
        driver.findElement(PROJECT_CODE).sendKeys(project.getCode());
        log.info("Filling description in new project {}", project);
        driver.findElement(DESCRIPTION).sendKeys(project.getDescription());
        log.info("Access type selection");
        driver.findElement(ACCESS_TYPE).click();
        log.info("Create button click");
        driver.findElement(CREATE_BUTTON).click();
    }
}

