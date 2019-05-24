package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.logger.CustomLogger;

import java.lang.reflect.Method;

public class BaseTest {

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

//    @BeforeClass
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\orusa\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//        //Create a Chrome driver. All test classes use this.
//        driver = new ChromeDriver();
//
//        //Maximize Window
//        driver.manage().window().maximize();
//    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\orusa\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void testStatus(Method method){
        driver.quit();
        CustomLogger.setTestStatus(method);
    }

//    @AfterClass(alwaysRun = true)
//    public void teardown() {
//        driver.quit();
//    }
}
