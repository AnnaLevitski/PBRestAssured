package com.api;

import com.core.models.dto.AuthRequestDTO;
import com.core.models.dto.AuthResponceDTO;
import com.core.models.dto.ErrorDto;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class LoginTests extends AuthController {
    @BeforeClass
    @SuppressWarnings("unchecked")
    public void preConditions(){
        try {
            RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com/";
            RestAssured.basePath = "v1";
        }catch (Exception ignored){

        }

    }
    @Test
    public void login_success(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("mara@gmail.com").password("Mmar123456$").build();
        AuthResponceDTO authResponceDTO = given().body(auth)
                .contentType("application/json")
                .when()
                .post("/user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponceDTO.class);
        System.out.println(authResponceDTO.getToken());
    }
    @Test
    public void login_successApi(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("mara@gmail.com").password("Mmar123456$").build();
        Assert.assertEquals(statusCodeAuth(auth, urlLogin), 200);
    }
    @Test
    public void login_negativePassvordApi(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("mara@gmail.com").password("mar123456$").build();
        Assert.assertEquals(statusCodeAuth(auth, urlLogin), 401);
    }
    @Test
    public void login_negativeLogin(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("maragmail.com").password("Mmar123456$").build();
        ErrorDto errorDto = given().body(auth)
                .contentType("application/json")
                .when()
                .post("/user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getError());

    }
}
