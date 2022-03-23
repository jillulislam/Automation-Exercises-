import commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

public class SignupOrLoginTest extends Configuration {

    Header header = new Header(driver);
    HomePage homePage = new HomePage(driver);
    SignUpOrLogInPage signUpOrLogInPage = new SignUpOrLogInPage(driver);
    AccountInformationPage accountInformationPage = new AccountInformationPage(driver);
    SuccessfullyAccountCreationPage successfullyAccountCreationPage = new SuccessfullyAccountCreationPage(driver);

    @Before
    public void openTheUrl(){
        header.navigateTo("https://www.automationexercise.com/");
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnSignUpOrLogin();
        signUpOrLogInPage.verifyUserIsOnSignUpOrLogInPage();
    }

    @Test
    public void registerANewUser_T1(){
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
        signUpOrLogInPage.enterUserEmailAddress("molly12@test.com");
        signUpOrLogInPage.enterPassword("jsghsf242323");
        signUpOrLogInPage.clickOnLogInButton();
        header.verifyLoggedInAsUserNameIsVisible();
    }

    @Test
    public void loginUserWithIncorrectEmailAndPassword_T3(){
        signUpOrLogInPage.enterUserEmailAddress("moly@test.com");
        signUpOrLogInPage.enterPassword("dfgsdfsdf");
        signUpOrLogInPage.clickOnLogInButton();
        signUpOrLogInPage.verifyErrorYourEmailOrPasswordMsgIsVisible();
    }

    @Test
    public void logoutUserSuccessfully_T4(){
        signUpOrLogInPage.enterUserEmailAddress("molly12@test.com");
        signUpOrLogInPage.enterPassword("jsghsf242323");
        signUpOrLogInPage.clickOnLogInButton();
        header.verifyLoggedInAsUserNameIsVisible();
        header.clickOnLogOut();
        signUpOrLogInPage.verifyUserIsOnSignUpOrLogInPage();
    }

    @Test
    public void registerUserWithExistingEmail_T5(){
        signUpOrLogInPage.enterRegisteredNameToSignup();
        signUpOrLogInPage.enterUserARegisteredEmailAddress("molly12@test.com");
        signUpOrLogInPage.clickObSignupButton();
        signUpOrLogInPage.verifyEmailAlreadyExistsTextIsVisible();
    }
}
