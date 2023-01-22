package api;

import api.pojo.CreateUserData;
import api.pojo.LoginUserData;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class Api extends RestClient {
    String REGISTER_API = "auth/register";
    String LOGIN_API = "auth/login";
    String AUTHORIZATION_USER_API = "auth/user";
    public String SITE_URL = "https://stellarburgers.nomoreparties.site";

    @Step("Запрос на регистрацию нового пользователя")
    public ValidatableResponse createUserRequest(CreateUserData createUserData) {
        return reqSpec
                .body(createUserData)
                .when()
                .post(REGISTER_API)
                .then();
    }

    @Step("Запрос на авторизацию пользователя")
    public ValidatableResponse loginUserRequest(LoginUserData loginUserData) {
        return reqSpec
                .body(loginUserData)
                .when()
                .post(LOGIN_API)
                .then();
    }

    @Step("Запрос на удаление пользователя с ключом авторизации")
    public ValidatableResponse deleteUserKeyRequest(String bearer) {
        return reqSpec
                .header("Authorization", bearer)
                .when()
                .delete(AUTHORIZATION_USER_API)
                .then();
    }

    @Step("Запрос на удаление пользователя без ключа авторизации")
    public ValidatableResponse deleteUserNotKeyRequest() {
        return reqSpec
                .delete(AUTHORIZATION_USER_API)
                .then();
    }
}
