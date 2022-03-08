package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonActions {

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    public void verifyHomePageIsVisibleSuccessfully(){
        verify("https://www.automationexercise.com/", getTextOfCurrentUrl());
    }
}
