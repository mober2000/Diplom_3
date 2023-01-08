package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPageBurger {
    private final WebDriver driver;

    private final By createBurgerText = By.xpath(".//h1[text()='Соберите бургер']");

    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    public ConstructorPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginAccountButton(){
        driver.findElement(loginAccountButton).click();
    }

    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    public void checkCreateOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        driver.findElement(createOrderButton).isDisplayed();
    }

    public void checkCreateBurgerText(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(createBurgerText));
        driver.findElement(createBurgerText).isDisplayed();
    }
}
