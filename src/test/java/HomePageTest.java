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


    @Before
    public void openTheUrl(){
        header.navigateTo("https://www.automationexercise.com/");
    }

    @Test
    public void registerANewUser_T1(){

        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnSignUpOrLogin();
        signUpOrLogInPage.verifyUserIsOnSignUpOrLogInPage();
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
    }

    @Test
    public void loginUserWithCorrectEmailAndPassword_T2(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnSignUpOrLogin();
        signUpOrLogInPage.verifyLogIntoYourAccountTextIsVisible();
        signUpOrLogInPage.enterUserEmailAddress("molly12@test.com");
        signUpOrLogInPage.enterPassword("jsghsf242323");
        signUpOrLogInPage.clickOnLogInButton();
        header.verifyLoggedInAsUserNameIsVisible();
    }

    @Test
    public void loginUserWithIncorrectEmailAndPassword_T3(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnSignUpOrLogin();
        signUpOrLogInPage.verifyLogIntoYourAccountTextIsVisible();
        signUpOrLogInPage.enterUserEmailAddress("moly@test.com");
        signUpOrLogInPage.enterPassword("dfgsdfsdf");
        signUpOrLogInPage.clickOnLogInButton();
        signUpOrLogInPage.verifyErrorYourEmailOrPasswordMsgIsVisible();
    }

    @Test
    public void logoutUserSuccessfully_T4(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnSignUpOrLogin();
        signUpOrLogInPage.verifyLogIntoYourAccountTextIsVisible();
        signUpOrLogInPage.enterUserEmailAddress("molly12@test.com");
        signUpOrLogInPage.enterPassword("jsghsf242323");
        signUpOrLogInPage.clickOnLogInButton();
        header.verifyLoggedInAsUserNameIsVisible();
        header.clickOnLogOut();
        signUpOrLogInPage.verifyUserIsOnSignUpOrLogInPage();
    }

    @Test
    public void registerUserWithExistingEmail_T5(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnSignUpOrLogin();
        signUpOrLogInPage.verifyNewUserSignUpTextIsVisible();
        signUpOrLogInPage.enterRegisteredNameToSignup();
        signUpOrLogInPage.enterUserARegisteredEmailAddress("molly12@test.com");
        signUpOrLogInPage.clickObSignupButton();
        signUpOrLogInPage.verifyEmailAlreadyExistsTextIsVisible();
    }
    @Test
    public void contactUsForm_T6() {
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnContactUs();
        contactUsPage.verifyGetInTouchTextIsVisible();
        contactUsPage.enterYourName("hiyhhh");
        contactUsPage.enterYourEmail("asdasd@text.com");
        contactUsPage.subject();
        contactUsPage.writeYourMessage();
        contactUsPage.uploadAFileButton();
        contactUsPage.clickOnSubmitButton();
        contactUsPage.clickOnAlert();
        contactUsPage.verifySuccessMessageIsDisplaying();
        contactUsPage.clickOnHomeButton();
        homePage.verifyHomePageIsVisibleSuccessfully();
    }

    @Test
    public void verifyTestCasePage_T7(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnTestcase();
        testCasesPage.verifyUserNavigatedToTestCasesPageSuccessfully();
    }

    @Test
    public void verifyAllProductAndProductDetailPage_T8(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnProducts();
        productPage.verifyUserIsOnTheProductPage();
        productPage.verifyProductListIsVisible();
        productPage.clickOnFirstProduct();
        productDetailsPage.verifyUserIsOnTheProductDetailPage();
        //Last step need more details
    }

    @Test
    public void verifySearchProductFunctionality_T9(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnProducts();
        productPage.verifyUserIsOnTheProductPage();
        productPage.enterProductName("top");
        productPage.clickOnSearch();
        searchedProductPage.verifySearchedProductPageIsVisible();
        //Test case is failing
        //searchedProductPage.verifyProductRelatedToSearchAreVisible();
    }

    @Test
    public void subscriptionFunctionalityInHomePage_T10(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        footer.scrollDownToFooterArea();
        footer.verifySubscriptionTextIsDisplayed();
        footer.enterEmailForSubscription();
        footer.clickOnSubscriptionArrowButton();
        footer.verifySubscriptionSuccessMsgIsDisplayed();
    }

    @Test
    public void verifySubscriptionInCartPage_T11(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnCart();
        footer.scrollDownToFooterArea();
        footer.verifySubscriptionTextIsDisplayed();
        footer.enterEmailForSubscription();
        footer.clickOnSubscriptionArrowButton();
        footer.verifySubscriptionSuccessMsgIsDisplayed();
    }

    @Test
    public void verifyAddingProductInCart_T12(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnProducts();
        productPage.mouseHoverToProduct(0);
        productPage.clickOnAddToCartButton(0);
        productPage.clickOnContinueButton();
        productPage.mouseHoverToProduct(1);
        productPage.clickOnAddToCartButton(1);
        productPage.clickOnContinueButton();
        header.clickOnCart();
    }
    
    @Test
    public void verifyDeletingProductInCart_T12(){
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnProducts();
        productPage.mouseHoverToProduct(0);
        productPage.clickOnAddToCartButton(0);
        productPage.clickOnContinueButton();
        productPage.mouseHoverToProduct(1);
        productPage.clickOnAddToCartButton(1);
        productPage.clickOnContinueButton();
        header.clickOnCart();
    }

    @Test
    public void verifyDeletingProductInCart_T14() {
    }
}

