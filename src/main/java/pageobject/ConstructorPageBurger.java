package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPageBurger {
    private final WebDriver driver;
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
    }

    public void checkLoginAccountButton(){
        driver.findElement(loginAccountButton).isDisplayed();
    }

    public void clickAndSelectTypeButtonBurger(String ingredientType){
        driver.findElement(By.xpath(".//span[text()='" + ingredientType + "']")).click();
        driver.findElement(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='" + ingredientType + "']")).isDisplayed();
    }

    public void checkIngredientNameTypeToScrollList(String ingredientType){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".//h2[text()='" + ingredientType +"']"))));

    }


}
