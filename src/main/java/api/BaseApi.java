package api;

import DTO.AuthRequestDTO;
import DTO.AuthResponceDTO;

import java.util.Random;

import static api.AuthController.urlLogin;

public class BaseApi {
    static String baseURL = "https://contactapp-telran-backend.herokuapp.com/";

    String userName = "";
    String password = "";

    public int randomInt(){
        return new Random().nextInt(1000);
    }
    public String getTokenAuth(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username("mara@gmail.com").password("Mmar123456$").build();
        return (String) AuthController.auth(auth, urlLogin).getBody().as(AuthResponceDTO.class).getToken();
    }
}
