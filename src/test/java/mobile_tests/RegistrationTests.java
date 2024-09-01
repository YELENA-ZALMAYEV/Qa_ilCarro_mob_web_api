package mobile_tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {
    @Test
    public  void  registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("samuel")
                .lastName("family")
                .userName("samuel_family"+i+"@gmail.com")
                .password("Qwerty1$%")
                .build();
        Assert.assertTrue( new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnTreeDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxIAgree()
                .clickBtnYallaPositive()
                .isTextInElementPresent_popUpMassageSuccess("Registration success!"));

    }

}
