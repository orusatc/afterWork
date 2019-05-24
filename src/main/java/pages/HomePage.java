package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HomePage extends BasePage {
    private String rozetkaUrl = "https://rozetka.com.ua/";
    private By languageBy = By.xpath("//li[@class='header-topline__language-item']/a");
    private By userLoginBy = By.xpath("//a[@class='header-topline__user-link link-dashed']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private HomePage openRozetka() {
        driver.get(rozetkaUrl);
        waitForPageLoad();
        return this;
    }

    public HomePage openUkranianRozetka() {
        openRozetka();
        click(languageBy, 10);
        waitForPageLoad();
        return this;
    }

    public void checkUserSignIn(String expectedName){
        // finish with waiter with condition
        // wait for visibility of element Вітаємо
        //waitForElementVisibility();
        String actualUser = readText(userLoginBy, 30);
        assertThat(actualUser, equalTo(expectedName));
    }
}
