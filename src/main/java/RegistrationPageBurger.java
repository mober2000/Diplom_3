import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageBurger {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//label[text()='Имя']");
    private final By emailField = By.xpath(".//label[text()='Email']");
    private final By passwordField = By.name("Пароль");
    private final By activeNameOrEmailFields = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private final By registrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By incorrectPasswordMessage = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");


    public RegistrationPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    public void sendRegistrationName(String name) {
        driver.findElement(nameField).click();
        driver.findElement(activeNameOrEmailFields).sendKeys(name);
    }

    public void sendRegistrationMail(String email) {
        driver.findElement(emailField).click();
        driver.findElement(activeNameOrEmailFields).sendKeys(email);
    }

    public void sendRegistrationPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    public void displayedIncorrectPasswordMessage(){
        driver.findElement(incorrectPasswordMessage).isDisplayed();
    }

    public void sendRegistrationDataFields(String name, String email, String password){
        sendRegistrationName(name);
        sendRegistrationMail(email);
        sendRegistrationPassword(password);
    }

}
