import commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

public class HomePageTest extends Configuration {

    Header header = new Header(driver);
    ProductPage productPage = new ProductPage(driver);
    HomePage homePage = new HomePage(driver);
    SignUpOrLogInPage signUpOrLogInPage = new SignUpOrLogInPage(driver);
    AccountInformationPage accountInformationPage = new AccountInformationPage(driver);
    SuccessfullyAccountCreationPage successfullyAccountCreationPage = new SuccessfullyAccountCreationPage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    TestCasesPage testCasesPage = new TestCasesPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    SearchedProductPage searchedProductPage = new SearchedProductPage(driver);
    Footer footer = new Footer(driver);
    ViewCartPage viewCart = new ViewCartPage(driver);
    ViewProductPage viewProductPage = new ViewProductPage(driver);

    @Before
    public void openTheUrl(){
        header.navigateTo("https://www.automationexercise.com/");
        homePage.verifyHomePageIsVisibleSuccessfully();
    }

    @Test
    public void subscriptionFunctionalityInHomePage_T10(){
        footer.scrollDownToFooterArea();
        footer.verifySubscriptionTextIsDisplayed();
        footer.enterEmailForSubscription();
        footer.clickOnSubscriptionArrowButton();
        footer.verifySubscriptionSuccessMsgIsDisplayed();
    }

    @Test
    public void verifySubscriptionInCartPage_T11(){
        header.clickOnCart();
        footer.scrollDownToFooterArea();
        footer.verifySubscriptionTextIsDisplayed();
        footer.enterEmailForSubscription();
        footer.clickOnSubscriptionArrowButton();
        footer.verifySubscriptionSuccessMsgIsDisplayed();
    }

    @Test
    public void verifyRegisterWhileCheckout_t14() throws InterruptedException {
        homePage.scrollDownToTheProduct();
        //productPage.mouseHoverToProduct(0);
        //I have 3 same methods in product page
        homePage.mouseHoverToProduct(0);
        homePage.clickOnAddToCartButton(0);
        homePage.waitFor(1000);
        homePage.clickOnContinueButton();
        homePage.waitFor(1000);
        header.clickOnCart();
        viewCart.verifyCartPageIsDisplayed();
    }

    public void t15(){

    }

    public void t16(){

    }
    public void  t17(){
        
    }
}
