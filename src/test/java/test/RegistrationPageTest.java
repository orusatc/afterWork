package test;

import dataStorage.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDataPage;
import pages.RegistrationPage;


public class RegistrationPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    PersonalDataPage personalDataPage;


@DataProvider
public Object[][] fewUsers(){

    return new Object[][]{
            {User.getUser()},
            {User.getUser()},
//            {User.getUser()},
//            {User.getUser()},
    };
}

    @BeforeMethod
    public void createReference(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        personalDataPage = new PersonalDataPage(driver);
    }

    @Test(dataProvider = "fewUsers", description = "Check registration of new user")
    public void checkNewUserRegistration(User user) {
        homePage.openUkranianRozetka();
        registrationPage.openRegistrationPage();
        registrationPage.registerNewUser(user.getName(), user.getEmail(), user.getPassword());
        personalDataPage.checkRegistration(user.getEmail());
    }


}
