package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends CommonActions {

    public ProductPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//div[@class='col-sm-4']")
    List <WebElement> product_list ;

    @FindBy(xpath = "//div[@class='single-products']")
    List <WebElement> products;

    @FindBy(xpath = "//section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    WebElement first_product;

    @FindBy(xpath = "//section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a")
    WebElement second_product;

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement search;

    @FindBy(xpath = "//div[@class='single-products']/div/a[@data-product-id='1']")
    WebElement btn_addToCart1;

    @FindBy(xpath = "//div[@class='overlay-content']/a")
    List <WebElement> btn;


    @FindBy(xpath = "//div[@class='single-products']/div/a[@data-product-id='2']")
    WebElement btn_addToCart2;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    WebElement btn_continueButton;

    public void verifyUserIsOnTheProductPage(){
        verify("Automation Exercise - All Products", getTextOfPageTitle());
    }

    public void mouseHoverToProduct(int index){
        for (int i =0; i<products.size()-1; i++){
            WebElement element1 = products.get(index);
            mouseHoverToAnElement(element1);
        }
    }

    public void verifyProductListIsVisible(){
        productListIsVisible(product_list);
    }

    public void clickOnFirstProduct(){
        clickOn(first_product);
    }

    public void enterProductName(String text){
        typeText(searchBox, text);
    }

    public void clickOnSearch(){
        clickOn(search);
    }

    public void clickOnAddToCartButton1(){
        clickOn(btn_addToCart1);
    }

    public void clickOnAddToCartButton2(){
        clickOn(btn_addToCart2);
    }

    public void clickOnContinueCartButton(){
        clickOn(btn_continueButton);
    }

    public void clickOnAddToBusketButton(int index){
            WebElement element1 = btn.get(index);
            clickOn(element1);
    }
}
