package hooks;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import report.ExtentReportManager;

public class Hooks {
    private WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ExtentReportManager.initReport();
    }

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("url"));
        ExtentReportManager.createTest(scenario.getName());
        ExtentReportManager.log("Starting scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManager.logFail("Step failed");
        } else {
            ExtentReportManager.logPass("Step passed");
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @AfterAll
    public static void afterAll() {
        ExtentReportManager.flushReport();
    }
}
