package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends CommonActions {

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(name = "name_on_card")
    WebElement field_nameOnTheCard;

    @FindBy(name = "card_number")
    WebElement field_card_number;

    @FindBy(name = "cvc")
    WebElement field_cvc;

    @FindBy(name = "expiry_month")
    WebElement field_expiry_month;

    @FindBy(name = "expiry_year")
    WebElement field_expiry_year;

    @FindBy(id = "submit")
    WebElement btn_PayAndConfirm;

    @FindBy(xpath = "//div[@id='success_message']/div")
    WebElement text_successMessage;

    public void enterNameOnTheCard(){
        typeText(field_nameOnTheCard, "M Ali");
    }

    public void enterCardNumber(){
        typeText(field_card_number,"1111111111111");
    }

    public void enterCvc(){
        typeText(field_cvc, "222");
    }

    public void enterCardExpiryMonth(){
        typeText(field_expiry_month,"08");
    }

    public void enterCardExpiryYear(){
        typeText(field_expiry_year,"2026");
    }

    public void ClickOnPayAndConfirmButton(){
       clickOn(btn_PayAndConfirm);
    }

    public String getTextOfSuccessMessage(){
        String message = getTextOfAnElement(text_successMessage);
        return message;
    }

    public void verifySuccessMessageDisplayedSuccessfully(){
        verify("Your order has been placed successfully!",text_successMessage.getText());
    }
}
