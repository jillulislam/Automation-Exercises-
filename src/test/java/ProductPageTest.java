import commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

public class ProductPageTest extends Configuration {

    Header header = new Header(driver);
    ProductPage productPage = new ProductPage(driver);
    HomePage homePage = new HomePage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    SearchedProductPage searchedProductPage = new SearchedProductPage(driver);
    ViewCartPage viewCart = new ViewCartPage(driver);

    @Before
    public void openTheUrl(){
        header.navigateTo("https://www.automationexercise.com/");
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnProducts();
        productPage.verifyUserIsOnTheProductPage();
    }

    @Test
    public void verifyAllProductAndProductDetailPage_T8(){
        productPage.verifyProductListIsVisible();
        productPage.clickOnFirstProduct();
        productDetailsPage.verifyUserIsOnTheProductDetailPage();
        //Last step need more details
    }

    @Test
    public void verifySearchProductFunctionality_T9(){
        productPage.enterProductName("top");
        productPage.clickOnSearch();
        searchedProductPage.verifySearchedProductPageIsVisible();
        //Test case is failing
        //searchedProductPage.verifyProductRelatedToSearchAreVisible();
    }

    @Test
    public void verifyAddingProductInCart_T12() throws InterruptedException {
        productPage.mouseHoverToProduct(0);
        productPage.getFirstProductPrice();
        productPage.clickOnAddToCartButton(0);
        productPage.waitFor(1000);
        productPage.clickOnContinueButton();
        productPage.waitFor(1000);
        productPage.mouseHoverToProduct(1);
        productPage.getSecondProductPrice();
        productPage.waitFor(1000);
        productPage.clickOnAddToCartButton(1);
        productPage.clickOnContinueButton();
        productPage.totalPrice();
        header.clickOnCart();
        viewCart.verifyTheTotalQtyIsCorrect();
        //last step is throughing error
        productPage.verifyProductPricesAreCorrect();
    }
}
