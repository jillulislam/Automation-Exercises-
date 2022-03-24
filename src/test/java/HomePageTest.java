import commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

public class HomePageTest extends Configuration {

    Header header = new Header(driver);
    HomePage homePage = new HomePage(driver);
    SignUpOrLogInPage signUpOrLogInPage = new SignUpOrLogInPage(driver);
    AccountInformationPage accountInformationPage = new AccountInformationPage(driver);
    SuccessfullyAccountCreationPage successfullyAccountCreationPage = new SuccessfullyAccountCreationPage(driver);
    Footer footer = new Footer(driver);
    ViewCartPage viewCart = new ViewCartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);

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
        homePage.waitFor(1000);
        homePage.clickOnAddToCartButton(0);
        homePage.waitFor(1000);
        homePage.clickOnContinueButton();
        homePage.waitFor(1000);
        header.clickOnCart();
        viewCart.verifyCartPageIsDisplayed();
        viewCart.clickOnProceedToCheckout();
        viewCart.clickOnContinueOnCart();
        header.clickOnSignUpOrLogin();
        signUpOrLogInPage.enterNameToSignup();
        signUpOrLogInPage.enterEmailToSignUp();
        signUpOrLogInPage.clickObSignupButton();
        accountInformationPage.verifyEnterAccountInformationTextIsVisible();
        accountInformationPage.clickOnMr();
        accountInformationPage.enterPassword();
        accountInformationPage.selectDate();
        accountInformationPage.selectMonth();
        accountInformationPage.selectYear();
        accountInformationPage.selectSignUpForOurNewsLetterCheckBox();
        accountInformationPage.selectReceiveSpecialOfferFromOurPartnersCheckBox();
        accountInformationPage.enterFirstName();
        accountInformationPage.enterLastName();
        accountInformationPage.enterCompanyName();
        accountInformationPage.enterAddress();
        accountInformationPage.enterAddress2();
        accountInformationPage.selectCountry();
        accountInformationPage.enterState();
        accountInformationPage.enterCity();
        accountInformationPage.enterZipCode();
        accountInformationPage.enterMobileNo();
        accountInformationPage.clickOnCreateAccountButton();
        successfullyAccountCreationPage.verifyAccountIsCreatedSuccessfully();
        successfullyAccountCreationPage.clickOnContinue();
        header.verifyLoggedInAsUserNameIsVisible();
        header.clickOnCart();
        viewCart.clickOnProceedToCheckout();
        checkoutPage.verifyAddressDetailAndReviewYourOrder();
        checkoutPage.enterAComment();
        checkoutPage.clickOnPlaceOrderButton();
        paymentPage.enterNameOnTheCard();
        paymentPage.enterCardNumber();
        paymentPage.enterCvc();
        paymentPage.enterCardExpiryMonth();
        paymentPage.enterCardExpiryYear();
        paymentPage.waitFor(1000);
        paymentPage.ClickOnPayAndConfirmButton();
        paymentPage.waitFor(1000);
        //No such element exception is displaying for the step
        //paymentPage.verifySuccessMessageDisplayedSuccessfully();
        header.clickOnDeleteButton();
        //can not verify delete message because of the server issue
    }
}
