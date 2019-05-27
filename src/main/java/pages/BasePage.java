package pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public static Logger logger;

    public void description(String description){

    }

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    //Wait wrapper method
    public void waitForElementVisibility(By elementBy, int waitingTime){
        wait = new WebDriverWait(driver, waitingTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //Wait for page load
    public void waitForPageLoad(){
        wait.until(driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }

    public void click(By elementBy,  int waitingTime){
        waitForElementVisibility(elementBy, waitingTime);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, int waitingTime, String text) {
        waitForElementVisibility(elementBy, waitingTime);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy, int waitingTime) {
        waitForElementVisibility(elementBy, waitingTime);
        return driver.findElement(elementBy).getText();
    }

}
