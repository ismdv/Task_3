package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserApi {

    @Step("Send POST request to /api/auth/register")
    public Response sendPostRequestReg(User user) {
        return given()
                .contentType(JSON)
                .and()
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    @Step("Send POST request to /api/auth/login")
    public Response sendPostRequestAuth(User user) {
        return given()
                .contentType(JSON)
                .and()
                .body(user)
                .when()
                .post("/api/auth/login");
    }


    @Step("Send DELETE request to api/auth/user")
    public Response sendDeleteRequest(String token) {
        return given()
                .header("Authorization", token)
                .delete("api/auth/user");
    }

    @Step("Delete user")
    public void deleteUser(String token) {
        if (token != null) {
            sendDeleteRequest(token);
            System.out.println("The user has been deleted.");
        }
    }

}
