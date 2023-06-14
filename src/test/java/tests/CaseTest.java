package tests;

import dto.Project;
import dto.ProjectFactory;
import dto.TestCase;
import dto.TestCaseFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CaseTest extends BaseTest {

    @Test (description = "Create test case")
    public void createTestCase() {
        Project project = ProjectFactory.getRandom();
        TestCase testCase = TestCaseFactory.getRandom();
        projectAdapter.create(project);
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user,password);
        projectListPage.isPageOpened();
        casePage.openCreateCase(project.getCode());
        casePage.isPageOpened();
        casePage.fillInInput(testCase);
        casePage.fillInDropDown(testCase);
        casePage.save();
        assertEquals(repositoryPage.searchCaseByTitle(testCase.getTitle()), testCase.getTitle());
        caseAdapter.delete(project.getCode());
        projectAdapter.delete(project.getCode());
    }

    @Test (description = "Edit test case")
    public void editTestCase() {
        Project project = ProjectFactory.getRandom();
        TestCase oldTestCase = TestCaseFactory.getRandom();
        TestCase newTestCase = TestCaseFactory.getRandom();
        projectAdapter.create(project);
        caseAdapter.create(oldTestCase, project.getCode());
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user,password);
        projectListPage.isPageOpened();
        repositoryPage.open(project.getCode());
        repositoryPage.clickEditCaseButton(project.getCode());
        casePage.isPageOpened();
        casePage.fillInInput(newTestCase);
        casePage.fillInDropDown(newTestCase);
        casePage.save();
        assertEquals(repositoryPage.takeCaseTitle(newTestCase.getTitle()), newTestCase.getTitle());
        caseAdapter.delete(project.getCode());
        projectAdapter.delete(project.getCode());
    }

    @Test (description = "Delete test case")
    public void deleteTestCase() {
        Project project = ProjectFactory.getRandom();
        TestCase testCase = TestCaseFactory.getRandom();
        projectAdapter.create(project);
        caseAdapter.create(testCase, project.getCode());
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.login(user,password);
        projectListPage.isPageOpened();
        repositoryPage.open(project.getCode());
        repositoryPage.deleteCase(testCase.getTitle());
        assertEquals(repositoryPage.getErrorMessage(), "Looks like you don’t have any suites and cases yet.");
        projectAdapter.delete(project.getCode());
    }
}
