import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageBurger {
    private final WebDriver driver;
    private final By nameField = By.name("name");
    private final By passwordField = By.name("Пароль");
    private final By registrationButton = By.className("Auth_link__1fOlj");
    private final By loginImage = By.xpath(".//h2[text()='Вход']");


    public LoginPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void displayedLoginImage(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginImage));
        driver.findElement(loginImage).isDisplayed();
    }
    public void sendLoginName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void sendLoginPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void sendLoginDataFields(String name, String password){
        sendLoginName(name);
        sendLoginPassword(password);
    }
}
