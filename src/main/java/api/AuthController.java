package api;

import dto.RegistrationBodyDto;
import interfaces.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;


public class AuthController implements BaseApi {
    //+ biblioteka rest ashort
    protected Response registrationLogin(RegistrationBodyDto registrationBodyDto, String url){
        return  given()
                .body(registrationBodyDto)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + url)
                .thenReturn()
                ;

    }

//    protected int statusCodeResponseRegistrationLogin(RegistrationBodyDto registrationBodyDto, String url){
//     //  return  registrationLogin(registrationBodyDto, url) .getStatusCode();
//
//      Response response = registrationLogin (registrationBodyDto, url);
//      System.out.println(response);
//      return response.getStatusCode();
//
//    }
}

