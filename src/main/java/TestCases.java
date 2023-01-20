import org.openqa.selenium.WebDriver;
import pageobject.ConstructorPageBurger;
import pageobject.LoginPageBurger;
import pageobject.RegistrationPageBurger;

public class TestCases {
    private WebDriver driver;
    public TestCases(WebDriver driver) {
        this.driver = driver;
    }


    public void registrationAccount(String name, String mail, String password){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickRegistrationAccountButton();
        registrationPageBurger.sendRegistrationDataFields(name, mail, password);
        registrationPageBurger.clickRegistrationButton();
    }

    public void loginAccount(String mail, String password){
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);

        loginPageBurger.sendLoginDataFields(mail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
    }
}
