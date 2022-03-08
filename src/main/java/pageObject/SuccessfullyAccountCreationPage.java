package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfullyAccountCreationPage extends CommonActions {

    public SuccessfullyAccountCreationPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//div[@class='row']/div/h2/b")
    WebElement text_accountCreated;

    @FindBy(xpath = "//div[@class='pull-right']/a")
    WebElement btn_continue;

    public void verifyAccountIsCreatedSuccessfully(){
        verify("ACCOUNT CREATED!",getTextOfAnElement(text_accountCreated));
    }

    public void clickOnContinue(){
        clickOn(btn_continue);
    }



}
