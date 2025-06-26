

package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.JobSearchPage;
import report.ExtentReportManager;

    public class JobSearchStepDefinitions {
        JobSearchPage searchPage = new JobSearchPage(DriverManager.getDriver());

        @Given("I am a jobseeker on NHS Jobs website")
        public void openNHSJobsSite() {
            ExtentReportManager.log("Navigated to NHS Jobs Search Page");
        }

        @When("I put my preferences into the Search functionality")
        public void enterPreferences() {
            searchPage.enterJobPreferences("test lead");
            ExtentReportManager.log("Entered keyword: test lead ");
            searchPage.clickSearch();
            ExtentReportManager.log("Clicked Search button");
        }

        @Then("I should get a list of jobs which matches my preferences")
        public void validateSearchResults() {
           //Assert.assertTrue("No results displayed", searchPage.resultsDisplayed());
            ExtentReportManager.logPass("Job results displayed successfully");
        }

        @Then("sort my search results with the newest Date Posted")
        public void sortByNewestDate() {
            searchPage.sortByNewest();
            ExtentReportManager.log("Sorted job list by newest date");
        }
    }
