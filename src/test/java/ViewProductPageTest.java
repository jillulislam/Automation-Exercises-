import commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

public class ViewProductPageTest extends Configuration {

    Header header = new Header(driver);
    HomePage homePage = new HomePage(driver);;
    ViewCartPage viewCart = new ViewCartPage(driver);
    ViewProductPage viewProductPage = new ViewProductPage(driver);

    @Before
    public void openTheUrl(){
        header.navigateTo("https://www.automationexercise.com/");
        homePage.verifyHomePageIsVisibleSuccessfully();
        homePage.clickOnViewProduct();
        viewProductPage.verifyProductDetailsPageIsOpen();
    }

    @Test
    public void verifyProductQtyInCart_T13() {
        viewProductPage.increaseQtyTo("4");
        //did not find the element of arrow to increase product qty;
        viewProductPage.clickOnAddToCartButton();
        //Can we keep continue button somewhere common as it has been used in multiple pages
        viewProductPage.clickOnContinueButton();
        header.clickOnCart();
        viewCart.verifyTheQtyIsCorrect("4");
    }
}
