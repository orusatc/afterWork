package test;

import dataStorage.RegisteredUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDataPage;
import pages.RegistrationPage;
import utils.extentReports.ExtentTestManager;

import java.lang.reflect.Method;

public class SearchTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    PersonalDataPage personalDataPage;
    RegisteredUser registeredUser;
//Rozalline
//123zxcQ

    @BeforeMethod
    public void createReference(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        personalDataPage = new PersonalDataPage(driver);
    }

    @Test(description = "Check registration of new user")
    public void checkNewUserRegistration() {
        registeredUser = RegisteredUser.getUser();
        homePage.openUkranianRozetka();
        loginPage.loginUser(registeredUser.getEmail(), registeredUser.getPassword());
        homePage.checkUserSignIn(registeredUser.getName());
    }


@Test(description = "Print Test")
public void printTest(Method method){

    //extentReports Description
    ExtentTestManager.startTest(method.getName(),"Open url: https://rozetka.com.ua/");







    //loginField.click();
    System.out.println("First test");
    ExtentTestManager.getTest().setDescription("Description inside test");
}
}