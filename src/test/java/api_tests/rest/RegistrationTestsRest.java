package api_tests.rest;

import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import  api.AuthController;

import java.util.Random;

public class RegistrationTestsRest extends AuthController{

        @Test
        public void registrationPositiveTest(){   //bag
            int i = new Random().nextInt(1000)+1000;
            RegistrationBodyDto registrationBodyDto = RegistrationBodyDto.builder()
                    .userName("jon_doe"+i+"@mail.com")
                    .password("Qwerty123!")
                    .firstName("Jon")
                    .lastName("Doe")
                    .build();
            Assert.assertEquals(statusCodeResponseRegistrationLogin(registrationBodyDto, REGISTRATION_URL),
                    200);
    }
}
