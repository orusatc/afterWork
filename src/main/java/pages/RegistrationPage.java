package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class RegistrationPage extends BasePage {

    private By registrationBy = By.xpath("//a[@class='auth-modal__register-link']");
    private By nameBy = By.xpath("//input[@name='title']");
    private By mailOrPhoneBy = By.xpath("//input[@name='login']");
    private By passwordBy = By.xpath("//input[@name='password']");
    private By signUpButttonBy = By.xpath("//*[@id='buyer']//button[@type='submit']");

    private LoginPage loginPage = new LoginPage(driver);


    public RegistrationPage (WebDriver driver) {
        super(driver);
    }

    public RegistrationPage openRegistrationPage(){
        loginPage.openLoginPage();
        click(registrationBy, 15);
        waitForPageLoad();
        return this;
    }

    public void registerNewUser(String name, String mail, String password){
        writeText(nameBy, 5, name);
        writeText(mailOrPhoneBy, 5, mail);
        writeText(passwordBy, 5, password);
        click(signUpButttonBy, 5);
    }
}
