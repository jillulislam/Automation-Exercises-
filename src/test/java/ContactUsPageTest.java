import commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.ContactUsPage;
import pageObject.Header;
import pageObject.HomePage;

public class ContactUsPageTest extends Configuration {

    Header header = new Header(driver);
    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @Before
    public void openTheUrl(){
        header.navigateTo("https://www.automationexercise.com/");
        homePage.verifyHomePageIsVisibleSuccessfully();
        header.clickOnContactUs();
        contactUsPage.verifyUserIsOnContactUsPage();
    }

    @Test
    public void contactUsForm_T6() {
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
}
