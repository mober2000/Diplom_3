import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.ConstructorPageBurger;
import pageobject.LoginPageBurger;
import pageobject.PersonalAccountPageBurger;

public class TransitionPageTests {
    private WebDriver driver;
    String loginName = "testLogin";
    String loginMail = "testlogin@test.com";
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
    public void transitionIntoPersonalAccountPageFromConstructorPage(){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        PersonalAccountPageBurger personalAccountPageBurger = new PersonalAccountPageBurger(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.sendLoginDataFields(loginMail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.checkProfileWord();
        personalAccountPageBurger.checkStoryOrdersWord();
        personalAccountPageBurger.checkNameFieldValue(loginName);
        personalAccountPageBurger.checkLoginFieldValue(loginMail);
    }

    @Test
    public void transitionIntoConstructorPagePageFromPersonalAccountPage(){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        PersonalAccountPageBurger personalAccountPageBurger = new PersonalAccountPageBurger(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.sendLoginDataFields(loginMail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.checkProfileWord();
        personalAccountPageBurger.clickConstructorButton();
        constructorPageBurger.checkCreateOrderButton();
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.clickStellarBurgerButton();
        constructorPageBurger.checkCreateOrderButton();
    }

}