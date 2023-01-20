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
    String name = "Test";
    String mail = "test@gmail.com";
    String password = "lexa1234";

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
    public void transitionIntoPersonalAccountPageFromConstructorPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        PersonalAccountPageBurger personalAccountPageBurger = new PersonalAccountPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        testCases.loginAccount(mail, password);
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.checkProfileWord();
        personalAccountPageBurger.checkStoryOrdersWord();
        personalAccountPageBurger.checkNameFieldValue(name);
        personalAccountPageBurger.checkLoginFieldValue(mail);
    }

    @Test
    public void transitionIntoConstructorPagePageFromPersonalAccountPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        PersonalAccountPageBurger personalAccountPageBurger = new PersonalAccountPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        testCases.loginAccount(mail, password);
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.checkProfileWord();
        personalAccountPageBurger.clickConstructorButton();
        constructorPageBurger.checkCreateOrderButton();
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.clickStellarBurgerButton();
        constructorPageBurger.checkCreateOrderButton();
    }

    @Test
    public void exitPersonalAccount() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        PersonalAccountPageBurger personalAccountPageBurger = new PersonalAccountPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        testCases.loginAccount(mail, password);
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.clickExitButton();
        loginPageBurger.displayedLoginWord();
        loginPageBurger.clickConstructorButton();
        constructorPageBurger.checkLoginAccountButton();
        constructorPageBurger.clickPersonalAccountButton();
        loginPageBurger.displayedLoginWord();
    }

    @Test
    public void transitionIngredientInConstructorPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        testCases.loginAccount(mail, password);
        constructorPageBurger.clickAndSelectTypeButtonBurger("Начинки");
        constructorPageBurger.checkIngredientNameTypeToScrollList("Начинки");
        constructorPageBurger.clickAndSelectTypeButtonBurger("Соусы");
        constructorPageBurger.checkIngredientNameTypeToScrollList("Соусы");
        constructorPageBurger.clickAndSelectTypeButtonBurger("Булки");
        constructorPageBurger.checkIngredientNameTypeToScrollList("Булки");
    }
}