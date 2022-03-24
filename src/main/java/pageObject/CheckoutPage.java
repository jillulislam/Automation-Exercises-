package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends CommonActions {

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//*[contains(text(),'Address Details')]")
    WebElement text_addressDetails;

    @FindBy(xpath = "//*[contains(text(),'Review Your Order')]")
    WebElement text_reviewYourOrder;

    @FindBy(xpath = "//*[@id='ordermsg']/textarea")
    WebElement messageArea;

    @FindBy(xpath = "//*[contains(text(),'Place Order')]")
    WebElement btn_placeOrder;

    public void verifyAddressDetailAndReviewYourOrder(){
        verify("Address Details",text_addressDetails.getText());
        verify("Review Your Order",text_reviewYourOrder.getText());
    }

    public void enterAComment(){
        typeText(messageArea,"Please place your order");
    }

    public void clickOnPlaceOrderButton(){
        clickOn(btn_placeOrder);
    }
}
