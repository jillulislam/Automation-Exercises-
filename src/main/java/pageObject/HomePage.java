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

    @FindBy(xpath = "//div[1]/div[2]/div/div[2]/ul/li/a")
    WebElement view_product1;

    public void verifyHomePageIsVisibleSuccessfully(){
        verify("https://www.automationexercise.com/", getTextOfCurrentUrl());
    }

    public void clickOnViewProduct(){
        clickOn(view_product1);
    }
}
