package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class SplashScreen extends  BaseScreen{

    public SplashScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc= 'More options']")
    AndroidElement btnThreeDots;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/versionText']")
    AndroidElement versionApp;
    @FindBy (xpath = "//*[@text ='Registration' and @resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnRegistration;

    public boolean validateVersion() {
        return  textInElementPresent(versionApp,"Version 1.0.0", 3);
    }

    public SplashScreen goToSearchScreen() {
        pause(5);
        return new SplashScreen (driver);
    }

    public SplashScreen clickBtnTreeDots() {
        btnThreeDots.click();
        return this;
    }

    public  RegistrationScreen  clickBtnRegistration(){
        btnRegistration.click();
        return  new RegistrationScreen(driver);

    }
}
