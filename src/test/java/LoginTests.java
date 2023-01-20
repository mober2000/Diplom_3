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

public class LoginTests {
    private WebDriver driver;
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
    @DisplayName("Login Main Page")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        testCases.loginAccount(mail, password);
    }

    @Test
    @DisplayName("Login Through Personal Account")
    @Description("Вход через кнопку «Личный кабинет»")
    public void loginThroughPersonalAccountButton() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickPersonalAccountButton();
        testCases.loginAccount(mail, password);
    }

    @Test
    @DisplayName("Login Through Registration Form")
    @Description("Вход через кнопку в форме регистрации")
    public void loginThroughRegistrationForm() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickRegistrationAccountButton();
        registrationPageBurger.clickLoginButton();
        testCases.loginAccount(mail, password);
    }

    @Test
    @DisplayName("Login Through Forgot Password Form")
    @Description("Вход через кнопку в форме восстановления пароля")
    public void loginThroughForgotPasswordForm() {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        ForgotPasswordPageBurger forgotPasswordPageBurger = new ForgotPasswordPageBurger(driver);
        TestCases testCases = new TestCases(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickForgotPasswordButton();
        forgotPasswordPageBurger.clickLoginButton();
        testCases.loginAccount(mail, password);
    }
}
