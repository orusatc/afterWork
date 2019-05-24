package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By entranceInOwnCabinet = By.xpath("//a[@class='header-topline__user-link link-dashed']");
    private By loginField = By.xpath("//*[@id='auth_email']");
    private By paswordField = By.xpath("//*[@id='auth_pass']");
    private By enterButton = By.xpath("//div[@class='auth-modal__inner']//span[@class='button-inner']");


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage openLoginPage(){
        click(entranceInOwnCabinet, 5);
        return this;
    }

    public void enterLogin(String email){
        writeText(loginField, 5, email);
    }

    public void enterPassword(String password){
        writeText(paswordField, 5, password);
    }

    public void clickEnter(){
        click(enterButton, 0);
    }

    public void loginUser(String email, String password){
        openLoginPage();
        enterLogin(email);
        enterPassword(password);
        clickEnter();
        waitForPageLoad();
    }

}
