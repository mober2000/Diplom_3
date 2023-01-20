import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
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
    @DisplayName("Check Transition Into Personal Account Page From Constructor Page")
    @Description("Проверка перехода по клику на «Личный кабинет»")
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
    @DisplayName("Check Transition Into Personal Account Page From Constructor Page")
    @Description("Проверка перехода по клику на «Конструктор» и на логотип Stellar Burgers")
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
    @DisplayName("Check Exit Personal Account")
    @Description("Проверка выхода из аккаунта по кнопке «Выйти» в личном кабинете.")
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
    @DisplayName("Check Transition IngredientInConstructorPage")
    @Description("Проверка на переходы между разделами: \"Начинки\", \"Соусы\", \"Булки\"")
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