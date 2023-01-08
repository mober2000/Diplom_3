import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.ConstructorPageBurger;
import pageobject.ForgotPasswordPageBurger;
import pageobject.LoginPageBurger;
import pageobject.RegistrationPageBurger;

public class LoginTests {

    private WebDriver driver;
    String loginMail = "TestLogin@test.com";
    String password = "123456";


    @Before
    public void BeforeTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginMainPage(){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.sendLoginDataFields(loginMail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
    }

    @Test
    public void loginThroughPersonalAccountButton(){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);

        constructorPageBurger.clickPersonalAccountButton();
        loginPageBurger.sendLoginDataFields(loginMail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
    }

    @Test
    public void loginThroughRegistrationForm(){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickRegistrationAccountButton();
        registrationPageBurger.clickLoginButton();
        loginPageBurger.sendLoginDataFields(loginMail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
    }

    @Test
    public void loginThroughForgotPasswordForm(){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        ForgotPasswordPageBurger forgotPasswordPageBurger = new ForgotPasswordPageBurger(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickForgotPasswordButton();
        forgotPasswordPageBurger.clickLoginButton();
        loginPageBurger.sendLoginDataFields(loginMail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
    }
}
