import testcases.ApiCases;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
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
import testcases.UiTestCases;

public class LoginTests {
    private WebDriver driver;
    RandomGenerator randomGenerator = new RandomGenerator();
    String mail = randomGenerator.randomEmailYandex();
    String password = randomGenerator.randomCorrectPassword();
    String name = randomGenerator.randomName();
    String bearerToken;


    @Before
    public void BeforeTest() {
        ApiCases apiCases = new ApiCases();
        ChromeOptions options = new ChromeOptions();
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
    @DisplayName("Login Main Page")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        uiTestCases.loginAccount(mail, password);
    }

    @Test
    @DisplayName("Login Through Personal Account")
    @Description("Вход через кнопку «Личный кабинет»")
    public void loginThroughPersonalAccountButton() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickPersonalAccountButton();
        uiTestCases.loginAccount(mail, password);
    }

    @Test
    @DisplayName("Login Through Registration Form")
    @Description("Вход через кнопку в форме регистрации")
    public void loginThroughRegistrationForm() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickRegistrationAccountButton();
        registrationPageBurger.clickLoginButton();
        uiTestCases.loginAccount(mail, password);
    }

    @Test
    @DisplayName("Login Through Forgot Password Form")
    @Description("Вход через кнопку в форме восстановления пароля")
    public void loginThroughForgotPasswordForm() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        ForgotPasswordPageBurger forgotPasswordPageBurger = new ForgotPasswordPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickForgotPasswordButton();
        forgotPasswordPageBurger.clickLoginButton();
        uiTestCases.loginAccount(mail, password);
    }
}
