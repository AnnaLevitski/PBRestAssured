package api;

import DTO.AuthRequestDTO;
import DTO.AuthResponceDTO;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static api.AuthController.urlLogin;

public class BaseApi {
    public BaseApi() {}



    static String baseURL = "https://contactapp-telran-backend.herokuapp.com/";

    String userName = "";
    String password = "";

    public int randomInt(){
        return new Random().nextInt(1000);
    }
    public static String getTokenAuth(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("dototo1223456@gmail.com").password("Mmar123456$").build();
        return (String) AuthController.auth(auth, urlLogin).getBody().as(AuthResponceDTO.class).getToken();
    }
}
