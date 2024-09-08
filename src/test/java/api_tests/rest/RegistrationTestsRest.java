package api_tests.rest;

import dto.ErrorMessageDtoString;
import dto.RegistrationBodyDto;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import  api.AuthController;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class RegistrationTestsRest extends AuthController{



        @Test
        public void registrationPositiveTest() {   //bag
            int i = new Random().nextInt(1000)+1000;
            RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                    .userName("jon_doe"+i+"@mail.com")
                    .password("Qwerty123!")
                    .firstName("Jon")
                    .lastName("Doe")
                    .build();

           // Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getStatusCode(), 200);
    }

    @Test
    public void registrationNegativeTest_WOPassword() {   //bag
        int i = new Random().nextInt(1000)+1000;
        RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                .userName("jon_doe"+i+"@mail.com")
                .password("Qwerty123!")
                .firstName("Jon")
                .lastName("Doe")
                .build();
      //   Assert.assertEquals(registrationLogin(registrationBodyDto, REGISTRATION_URL).getBody().as(ErrorMessageDtoString.class)
       //          .getMessage(), "Bad Requst");
    }
}
