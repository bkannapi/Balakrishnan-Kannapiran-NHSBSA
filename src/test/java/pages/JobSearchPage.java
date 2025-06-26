
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

    public class JobSearchPage {
        WebDriver driver;
        WebDriverWait wait;

        public JobSearchPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        private final Function<By, WebElement> find = locator ->
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        public void enterJobPreferences(String keyword) {
            var keywordField = find.apply(By.id("keyword"));
            keywordField.clear();
            keywordField.sendKeys(keyword);
        }

        public void clickSearch()
        {
            find.apply(By.id("search")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement resultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.nhsuk-grid-column-two-thirds ul")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resultsSection);

            // Now wait until it's visible
            wait.until(ExpectedConditions.visibilityOf(resultsSection));

        }

        public void sortByNewest() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until dropdown is clickable
            WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("sort")));
            var sortDropdown = new Select(dropdownElement);
            sortDropdown.selectByVisibleText("Date Posted (newest)");

            // Small pause to let sorting trigger before scrolling
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

            // Scroll down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");

            // Scroll to the result element specifically
            WebElement resultContainer = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div.nhsuk-grid-column-two-thirds ul")
            ));
            js.executeScript("arguments[0].scrollIntoView(true);", resultContainer);

            // Wait for the result items to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("div.nhsuk-grid-column-two-thirds ul li")
            ));

            // Extra sleep to allow visible verification of sorted results
            try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
        }

       // public boolean resultsDisplayed() {
         // return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("job-listing"), 0));
      // }
    }


