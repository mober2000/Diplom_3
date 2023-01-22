import api.Api;
import testcases.ApiCases;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPageBurger;
import pageobject.RegistrationPageBurger;
import testcases.UiTestCases;

public class RegistrationTests {
    private WebDriver driver;
    RandomGenerator randomGenerator = new RandomGenerator();
    String name = randomGenerator.randomName();
    String mail = randomGenerator.randomEmailYandex();
    String correctPassword = randomGenerator.randomCorrectPassword();
    String incorrectPassword = randomGenerator.randomIncorrectPassword();

    @Before
    public void BeforeTest() {
        Api api = new Api();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(api.SITE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Check Registration")
    @Description("Проверка успешной регистрации нового пользователя")
    public void checkRegistration() {
        UiTestCases uiTestCases = new UiTestCases(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        ApiCases apiCases = new ApiCases();

        uiTestCases.registrationAccount(name, mail, correctPassword);
        loginPageBurger.displayedLoginWord();
        apiCases.loginUser(mail, correctPassword, name);
        String bearerToken = apiCases.getBearerTokenCreatedAccount();
        apiCases.deleteUser(bearerToken);
    }

    @Test
    @DisplayName("Check Registration Incorrect Password")
    @Description("Проверка ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    public void checkRegistrationIncorrectPassword() {
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);
        UiTestCases uiTestCases = new UiTestCases(driver);
        uiTestCases.registrationAccount(name, mail, incorrectPassword);
        registrationPageBurger.displayedIncorrectPasswordMessage();
    }
}
