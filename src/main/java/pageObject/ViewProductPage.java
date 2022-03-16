package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewProductPage extends CommonActions {

    public ViewProductPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(name = "quantity")
    WebElement qty;

    @FindBy(xpath = "//div[2]/div/span/button")
    WebElement btn_addToCart;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    WebElement btn_continueButton;

    public void verifyProductDetailsPageIsOpen(){
        verify("https://www.automationexercise.com/product_details/1",getTextOfCurrentUrl());
    }
    public void increaseQtyTo(String quantity){
        mouseHoverToAnElement(qty);
        clearTheField(qty);
        typeText(qty,quantity);
    }

    public void clickOnAddToCartButton(){
        clickOn(btn_addToCart);
    }

    public void clickOnContinueButton(){
        clickOn(btn_continueButton);
    }

}

