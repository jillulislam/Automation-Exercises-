package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends CommonActions {

    public Footer(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(id = "susbscribe_email")
    WebElement subscriptionEmail_field;

    @FindBy(id = "subscribe")
    WebElement btn_subscriptionEmail;

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    WebElement lbl_subscription;

    @FindBy(xpath = "//div[@id='success-subscribe']/div")
    WebElement lbl_subscriptionSuccessMsg;

    public void enterEmailForSubscription(){
        typeText(subscriptionEmail_field, "rakib@test.com");
    }

    public void clickOnSubscriptionArrowButton(){
        clickOn(btn_subscriptionEmail);
    }

    public void scrollDownToFooterArea(){
        scrollToElement(lbl_subscription);
    }

    public void verifySubscriptionSuccessMsgIsDisplayed(){
        verify("You have been successfully subscribed!",lbl_subscriptionSuccessMsg.getText());
    }

    public void verifySubscriptionTextIsDisplayed(){
        verify("SUBSCRIPTION",lbl_subscription.getText());
    }
}
