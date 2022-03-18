package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //Wait Wrapper Method
    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTitleContains(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    //Click Method
    public void click (WebElement element) {
        waitVisibility(element);
        element.click();
    }

    //Write Text
    public void writeText (WebElement element, String text) {
        waitVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void writeTextWithSpanTime (WebElement element, String text) throws InterruptedException {
        waitVisibility(element);
        element.clear();
        element.sendKeys(text);
        Thread.sleep(1000);
    }

    //Read Text
    public String readText (WebElement element) {
        waitVisibility(element);
        return element.getText();
    }

    //Assert
    public void assertEquals (WebElement element, String expectedText) {
        waitVisibility(element);
        Assert.assertEquals(readText(element), expectedText);
    }
}
