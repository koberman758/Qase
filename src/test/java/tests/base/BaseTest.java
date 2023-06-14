package tests.base;

import adapters.BaseAdapter;
import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;
import utils.PropertyReader;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected NewProjectPage newProjectPage;
    protected ProjectListPage projectListPage;
    protected ProjectAdapter projectAdapter;
    protected CaseAdapter caseAdapter;
    protected SuiteAdapter suiteAdapter;
    protected BaseAdapter baseAdapter;
    protected CasePage casePage;
    protected SuitePage suitePage;
    protected RepositoryPage repositoryPage;
    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));


    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        projectListPage = new ProjectListPage(driver);
        newProjectPage = new NewProjectPage(driver);
        casePage = new CasePage(driver);
        repositoryPage = new RepositoryPage(driver);
        suitePage = new SuitePage(driver);
        projectAdapter = new ProjectAdapter();
        caseAdapter = new CaseAdapter();
        suiteAdapter = new SuiteAdapter();
        baseAdapter = new BaseAdapter();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if(driver != null){
            //driver.quit();
        }
    }
}
