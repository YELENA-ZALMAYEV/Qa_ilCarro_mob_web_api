package api_tests_okhttptests;

import dto.*;
import interfaces.BaseApi;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static okhttp3.RequestBody.create;

public class DeleteCarByIdTestsOkhttp implements BaseApi {
    TokenDto token = new TokenDto();

    CarDto car = new CarDto();
    @BeforeClass
    public void login(){
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .userName("dhvisedhiu$@gmail.com")
                .password("hguygi@#$")
                .build();
        RequestBody requestBody;
        requestBody = create(JSON, GSON.toJson(registrationBodyDto));
        Request request = new Request.Builder()
                .url(BASE_URL+LOGIN_URL)
                .post(requestBody)
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            token = GSON.fromJson(response.body().string(), TokenDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(token);
    }

    @BeforeMethod
    public  void  getSerialNumber(){
        Request request = new Request.Builder()
                .url(BASE_URL+GET_USER_CARS_URL)
                .addHeader("Authorization", String.valueOf(token))
                .get()
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CarsDto carsDto;
        if (response.isSuccessful()) {
            try {
                carsDto = GSON.fromJson(response.body().string(), CarsDto.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            car = carsDto.getCars()[0];
            System.out.println("car-->" + car);
        } else
            System.out.println("get all user car is not successful");
    }

    @Test
    public  void  deleteCarByIdPositiveTest(){
        String idCar= car.getSerialNumber();
        Request request = new  Request.Builder()
                .url(BASE_URL+DELETE_CAR_URL + idCar)
                .addHeader("Authorization", String.valueOf(token))
                .delete()
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(response.isSuccessful());
    }
    @Test
    public  void   deleteCarByIdNegativeTest_WOId() throws IOException {
        String idCar= car.getSerialNumber();
        Request request = new  Request.Builder()
                .url(BASE_URL+DELETE_CAR_URL)
                .addHeader("Authorization" , token.getAccessToken())
                .addHeader("Authorization", String.valueOf(token))
                .delete()
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ErrorMessageDtoString errorMessageDtoString;
        errorMessageDtoString = GSON.fromJson(response.body().string(), ErrorMessageDtoString.class);
      //  Assert.assertTrue(response.isSuccessful()); //bag - charlz
        System.out.println(errorMessageDtoString.getMessage());
        Assert.assertEquals(errorMessageDtoString.getStatus(), "400");
    }
    @Test
    public  void   deleteCarByIdNegativeTest_wrongToken() throws IOException {
        String idCar= car.getSerialNumber();
        Request request = new  Request.Builder()
                .url(BASE_URL+DELETE_CAR_URL+ idCar)
                .addHeader("Authorization" , "11111111fgdfgdrg") //+ ex date
              //  .addHeader("Authorization", String.valueOf(token))
                .delete()
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ErrorMessageDtoString errorMessageDtoString;
        errorMessageDtoString = GSON.fromJson(response.body().string(), ErrorMessageDtoString.class);
        //  Assert.assertTrue(response.isSuccessful()); //bag - charlz
        System.out.println(errorMessageDtoString.getMessage());
        Assert.assertEquals(errorMessageDtoString.getStatus(), "401");
    }
}
