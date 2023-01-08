import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTests {

    private WebDriver driver;
    RandomGenerator randomGenerator = new RandomGenerator();

    String loginName = "testLogin";
    String loginMail = "TestLogin@test.com";
    String password = "123456";


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
    public void loginMainPage(){
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        loginPageBurger.sendLoginDataFields(loginName, loginMail);

    }


}
