package testcases;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobject.ConstructorPageBurger;
import pageobject.LoginPageBurger;
import pageobject.RegistrationPageBurger;

public class UiTestCases {
    private final WebDriver driver;

    public UiTestCases(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Регистрация пользователя")
    public void registrationAccount(String name, String mail, String password) {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);
        RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger(driver);

        constructorPageBurger.clickLoginAccountButton();
        loginPageBurger.clickRegistrationAccountButton();
        registrationPageBurger.sendRegistrationDataFields(name, mail, password);
        registrationPageBurger.clickRegistrationButton();
    }

    @Step("Авторизация пользователя")
    public void loginAccount(String mail, String password) {
        ConstructorPageBurger constructorPageBurger = new ConstructorPageBurger(driver);
        LoginPageBurger loginPageBurger = new LoginPageBurger(driver);

        loginPageBurger.sendLoginDataFields(mail, password);
        loginPageBurger.clickLoginButton();
        constructorPageBurger.checkCreateOrderButton();
    }
}
