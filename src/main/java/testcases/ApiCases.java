package testcases;

import api.Api;
import api.pojo.CreateUserData;
import api.pojo.LoginUserData;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class ApiCases extends Api {
    private String bearerTokenCreatedAccount;

    @Step("Проверяем создается ли пользователь в системе, и сравниваем значения полей почты, и имени из тела отвта, со значениями которые мы вписали в запрос")
    public void createCorrectUser(String emailYandex, String password, String name) {
        ValidatableResponse createUserRequest = createUserRequest(new CreateUserData(emailYandex, password, name));
        createUserRequest.statusCode(200).assertThat().body("success", equalTo(true));
        String mailResponse = createUserRequest.extract().path("user.email");
        String nameResponse = createUserRequest.extract().path("user.name");
        assertEquals(emailYandex, mailResponse);
        assertEquals(name, nameResponse);
        this.bearerTokenCreatedAccount = createUserRequest.extract().path("accessToken");
    }

    @Step("Удаление пользователя с предварительной авторизацией")
    public void deleteUser(String bearerToken) {
        ValidatableResponse deleteUserRequest = deleteUserKeyRequest(bearerToken);
        deleteUserRequest.statusCode(202).assertThat().body("success", equalTo(true)).and().body("message", equalTo("User successfully removed"));
    }

    @Step("Авторизация пользователя")
    public void loginUser(String mail, String password, String name) {
        ValidatableResponse loginUserRequest = loginUserRequest(new LoginUserData(mail, password));
        loginUserRequest.statusCode(200).assertThat().body("success", equalTo(true));
        String mailLoginResponse = loginUserRequest.extract().path("user.email");
        String nameLoginResponse = loginUserRequest.extract().path("user.name");
        assertEquals(mail, mailLoginResponse);
        assertEquals(name, nameLoginResponse);
        this.bearerTokenCreatedAccount = loginUserRequest.extract().path("accessToken");
    }

    @Step("Позволяет получить ключ авторизации после создания нового пользователя")
    public String getBearerTokenCreatedAccount() {
        return bearerTokenCreatedAccount;
    }
}
