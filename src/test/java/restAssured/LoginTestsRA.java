package restAssured;

import DTOforOKhttp.AuthRequestDTO;
import DTOforOKhttp.AuthResponceDTO;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class LoginTestsRA {
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
}
