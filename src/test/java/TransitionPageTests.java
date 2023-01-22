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
import testcases.ApiCases;
import testcases.UiTestCases;

public class TransitionPageTests {
    private WebDriver driver;
    RandomGenerator randomGenerator = new RandomGenerator();
    String mail = randomGenerator.randomEmailYandex();
    String password = randomGenerator.randomCorrectPassword();
    String name = randomGenerator.randomName();
    String bearerToken;

    @Before
    public void BeforeTest() {
        ChromeOptions options = new ChromeOptions();
        ApiCases apiCases = new ApiCases();
        driver = new ChromeDriver(options);
        driver.get(apiCases.SITE_URL);
        apiCases.createCorrectUser(mail, password, name);
        bearerToken = apiCases.getBearerTokenCreatedAccount();
    }

    @After
    public void tearDown() {
        ApiCases apiCases = new ApiCases();
        driver.quit();
        apiCases.deleteUser(bearerToken);
    }

    @Test
    @DisplayName("Check Transition Into Personal Account Page From Constructor Page")
    @Description("Проверка перехода по клику на «Личный кабинет»")
    public void transitionIntoPersonalAccountPageFromConstructorPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        PersonalAccountPageBurger personalAccountPageBurger = new PersonalAccountPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        uiTestCases.loginAccount(mail, password);
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
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        uiTestCases.loginAccount(mail, password);
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
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        uiTestCases.loginAccount(mail, password);
        constructorPageBurger.clickPersonalAccountButton();
        personalAccountPageBurger.clickExitButton();
        loginPageBurger.displayedLoginWord();
        loginPageBurger.clickConstructorButton();
        constructorPageBurger.checkLoginAccountButton();
        constructorPageBurger.clickPersonalAccountButton();
        loginPageBurger.displayedLoginWord();
    }

    @Test
    @DisplayName("Check Transition Filling Ingredient In Constructor Page")
    @Description("Проверка на переход в раздел: \"Начинки\"")
    public void transitionFillingIngredientInConstructorPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        uiTestCases.loginAccount(mail, password);
        constructorPageBurger.clickAndSelectTypeButtonBurger("Начинки");
        constructorPageBurger.checkIngredientNameTypeToScrollList("Начинки");
    }

    @Test
    @DisplayName("Check Transition Sauce Ingredient In Constructor Page")
    @Description("Проверка на переход в раздел: \"Соусы\"")
    public void transitionSauceIngredientInConstructorPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        uiTestCases.loginAccount(mail, password);
        constructorPageBurger.clickAndSelectTypeButtonBurger("Соусы");
        constructorPageBurger.checkIngredientNameTypeToScrollList("Соусы");
    }

    @Test
    @DisplayName("Check Transition Bun Ingredient In Constructor Page")
    @Description("Проверка на переход в раздел: \"Булки\"")
    public void transitionIngredientInConstructorPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        uiTestCases.loginAccount(mail, password);
        constructorPageBurger.clickAndSelectTypeButtonBurger("Начинки");
        constructorPageBurger.checkIngredientNameTypeToScrollList("Начинки");
        constructorPageBurger.clickAndSelectTypeButtonBurger("Булки");
        constructorPageBurger.checkIngredientNameTypeToScrollList("Булки");
    }
}