import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        driver.get("https://stellarburgers.nomoreparties.site/login");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkRegistration(){
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        loginPageBurger.clickRegistrationButton();
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);
        registrationPageBurger.sendRegistrationDataFields(name, mail, correctPassword);
        registrationPageBurger.clickRegistrationButton();
        loginPageBurger.displayedLoginImage();
    }

    @Test
    public void checkRegistrationIncorrectPassword(){
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        loginPageBurger.clickRegistrationButton();
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);
        registrationPageBurger.sendRegistrationDataFields(name, mail, incorrectPassword);
        registrationPageBurger.clickRegistrationButton();
        registrationPageBurger.displayedIncorrectPasswordMessage();
    }
}
