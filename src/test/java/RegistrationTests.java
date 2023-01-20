import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPageBurger;
import pageobject.RegistrationPageBurger;

public class RegistrationTests {
    private WebDriver driver;
    RandomGenerator randomGenerator = new RandomGenerator();
    String name = randomGenerator.randomName();
    String mail = randomGenerator.randomEmailYandex();
    String correctPassword = randomGenerator.randomCorrectPassword();
    String incorrectPassword = randomGenerator.randomIncorrectPassword();

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
    public void checkRegistration() {
        TestCases testCases = new TestCases(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        testCases.registrationAccount(name, mail, correctPassword);
        loginPageBurger.displayedLoginWord();
    }

    @Test
    public void checkRegistrationIncorrectPassword() {
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);
        TestCases testCases = new TestCases(driver);
        testCases.registrationAccount(name, mail, incorrectPassword);
        registrationPageBurger.displayedIncorrectPasswordMessage();

    }
}
