package tests;

import dto.Project;
import dto.ProjectFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class ProjectTest extends BaseTest {

    @Test(description = "Create project")
    public void createProject() {
        Project project = ProjectFactory.getRandom();
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        projectListPage.clickCreateButton();
        newProjectPage.createProject(project);
        projectListPage.open();
        projectListPage.searchProject(project.getCode());
        assertEquals(projectListPage.getProjectByTitle(project.getTitle()), project.getTitle());
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update project")
    public void updateProject() {
        Project oldProject = ProjectFactory.getRandom();
        Project newProject = ProjectFactory.getRandom();
        projectAdapter.create(oldProject);
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        projectListPage.updateProject(oldProject.getCode(), newProject.getTitle(), newProject.getCode());
        projectListPage.open();
        projectListPage.searchProject(newProject.getCode());
        assertEquals(projectListPage.getProjectByTitle(newProject.getTitle()), newProject.getTitle());
        projectAdapter.delete(newProject.getCode());
    }

    @Test(description = "Delete project")
    public void deleteProject() {
        Project project = ProjectFactory.getRandom();
        projectAdapter.create(project);
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        projectListPage.searchProject(project.getCode());
        projectListPage.deleteProject(project.getTitle());
        assertEquals(driver.findElement(By.xpath("//*[text()='Looks like you don’t have any projects yet.']")).getText(),
                "Looks like you don’t have any projects yet.");
    }
}
