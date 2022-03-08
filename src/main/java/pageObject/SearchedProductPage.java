package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchedProductPage extends CommonActions {

    public SearchedProductPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    WebElement text_searchedProduct;

    @FindBy (xpath = "//div[@class='single-products']")
    List<WebElement> searchedProduct;

    public void verifySearchedProductPageIsVisible(){
        verify("SEARCHED PRODUCTS", text_searchedProduct.getText());
    }

//    public void verifyProductRelatedToSearchAreVisible(){
//        verify(true , searchedProductAreVisible(searchedProduct));
//    }
}
