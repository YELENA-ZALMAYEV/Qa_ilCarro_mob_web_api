package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {
    @Test
    public  void  registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        UserDto user = UserDto.builder()
                .firstName("samuel")
                .lastName("family")
                .userName("samuel_family"+i+"@gmail.com")
                .password("Qwerty123")
                .build();
        Assert.assertTrue( new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnThreeDots()
                .clickBtnRegistration()
                .typeRegistrationForm(user)
                .clickBtnYallaPositive()
                .isTextInElementPresent_popUpMassageSuccess("Registration success"))
        ;
    }



}
