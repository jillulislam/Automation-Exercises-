package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonActions {

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//div[1]/div[2]/div/div[2]/ul/li/a")
    WebElement view_product1;

    @FindBy(xpath = "//div[@class='overlay-content']/a")
    List<WebElement> btn;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    WebElement btn_continueButton;

    @FindBy(xpath = "//div[@class='single-products']")
    List <WebElement> products;

    public void verifyHomePageIsVisibleSuccessfully(){
        verify("https://www.automationexercise.com/", getTextOfCurrentUrl());
    }

   public void clickOnViewProduct(){
        clickOn(view_product1);
    }

    public void scrollDownToTheProduct(){
        scrollToElement(view_product1);
    }

    public void clickOnAddToCartButton(int index){
        WebElement element1 = btn.get(index);
        clickOn(element1);
    }

    public void mouseHoverToProduct(int index){
        WebElement element1 = products.get(index);
        mouseHoverToAnElement(element1);
    }

    public void clickOnContinueButton(){
        clickOn(btn_continueButton);
    }
}
