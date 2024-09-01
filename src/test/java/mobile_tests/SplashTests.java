package mobile_tests;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.BaseScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class SplashTests extends AppiumConfig{

    @Test
    public void  validateVersionTest(){
        Assert.assertTrue(new SplashScreen(driver).validateVersion());
    }


}
