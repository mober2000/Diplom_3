package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPageBurger {
    private final WebDriver driver;
    private final By loginAccountButton = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginAccountButton).click();
    }
}
