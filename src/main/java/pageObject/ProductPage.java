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

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    WebElement btn_continueButton;

    @FindBy(xpath = "//div[@class='single-products']/div/h2")
    List <WebElement> product_price;

    public void verifyUserIsOnTheProductPage(){
        verify("Automation Exercise - All Products", getTextOfPageTitle());
    }

    public void mouseHoverToProduct(int index){
        WebElement element1 = products.get(index);
        mouseHoverToAnElement(element1);
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

    public void clickOnContinueButton(){
        clickOn(btn_continueButton);
    }

    public void clickOnAddToCartButton(int index){
        WebElement element1 = btn.get(index);
        clickOn(element1);
    }

    public int getFirstProductPrice(){
        String first_product = product_price.get(0).getText();
        String[] price1 = first_product.split(" ");
        String price2 = price1[1];
        int productPrice = Integer.parseInt(price2);
        return productPrice;
    }

    public int getSecondProductPrice(){
        String second_product = product_price.get(1).getText();
        String[] price1 = second_product.split(" ");
        String price2 = price1[1];
        int second_productPrice = Integer.parseInt(price2);
        return second_productPrice;
    }

    public void totalPrice(){
        int total = getFirstProductPrice() + getSecondProductPrice();
        System.out.println("Total : " + total);
    }

    public void verifyProductPricesAreCorrect(){
        ViewCartPage viewCartPage = new ViewCartPage(driver);
        verify(getFirstProductPrice(),viewCartPage.getPriceOfFirstProduct());
    }
}
