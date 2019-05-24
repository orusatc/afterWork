package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PersonalDataPage extends RegistrationPage {



    private String popUpBy = "//*[@id='message_confirm']/div/div[%d]";
    private By popUpTextBy = By.xpath(String.format(popUpBy, 1));
    private By popMailBy = By.xpath(String.format(popUpBy, 2));
    private By confirmBy = By.xpath(String.format(popUpBy, 3));

    private String popUpText = "Ви не підтвердили свою пошту:";
    private String confirmText = "Підтвердити";

    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }


    public void checkRegistration(String mail) {
        checkPopUpText();
        checkPopEmail(mail);
        checkPopConfirm();
        //description("Check all fields from pop up on Personal data page");
    }

    public void checkPopUpText(){
        String actualText = readText(popUpTextBy, 5);
        assertThat(actualText, equalTo(popUpText));
        //description("Check pop up text on Personal data page");
    }

    public void checkPopEmail(String mail){
        String actualEmail = readText(popMailBy, 5);
        assertThat(actualEmail, equalTo(mail));
        //description("Check pop up email on Personal data page");
    }

    public void checkPopConfirm(){
        String actualConfirm = readText(confirmBy, 5);
        assertThat(actualConfirm, equalTo(confirmText));
        //description("Check presence of button Confirm on Personal data page");
    }
}
