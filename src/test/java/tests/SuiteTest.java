package tests;

import dto.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class SuiteTest extends BaseTest {

    @Test(description = "Create suite")
    public void createSuite() {
        Project project = ProjectFactory.getRandom();
        Suite suite = SuiteFactory.getRandom();
        projectAdapter.create(project);
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        repositoryPage.open(project.getCode());
        repositoryPage.clickCreateSuiteButton();
        suitePage.fillIn(suite);
        suitePage.createSuite();
        assertEquals(repositoryPage.searchSuiteByTitle(suite.getTitle()), suite.getTitle());
        suiteAdapter.delete(project.getCode());
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Edit suite")
    public void editSuite() {
        Project project = ProjectFactory.getRandom();
        Suite oldSuite = SuiteFactory.getRandom();
        Suite newSuite = SuiteFactory.getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(oldSuite, project.getCode());
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        repositoryPage.open(project.getCode());
        repositoryPage.clickEditSuiteButton(oldSuite.getTitle());
        suitePage.fillIn(newSuite);
        suitePage.saveSuite();
        assertEquals(repositoryPage.searchSuiteByTitle(newSuite.getTitle()), newSuite.getTitle());
        suiteAdapter.delete(project.getCode());
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Delete suite")
    public void deleteSuite() {
        Project project = ProjectFactory.getRandom();
        Suite suite = SuiteFactory.getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectListPage.isPageOpened();
        repositoryPage.open(project.getCode());
        repositoryPage.deleteSuite(suite.getTitle());
        assertEquals(repositoryPage.getErrorMessage(), "Looks like you don’t have any suites and cases yet.");
        projectAdapter.delete(project.getCode());
    }
}
