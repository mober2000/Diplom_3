package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageBurger {
    private final WebDriver driver;
    private final By emailField = By.name("name");
    private final By passwordField = By.name("Пароль");
    private final By loginImage = By.xpath(".//h2[text()='Вход']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registrationAccountButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public LoginPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistrationAccountButton() {
        driver.findElement(registrationAccountButton).click();
    }

    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    public void sendLoginName(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    public void sendLoginPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void sendLoginDataFields(String email, String password) {
        sendLoginName(email);
        sendLoginPassword(password);
    }

    public void displayedLoginWord() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginImage));
    }
}
