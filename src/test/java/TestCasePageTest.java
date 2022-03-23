import commons.Configuration;
import org.junit.Before;
import org.junit.Test;
import pageObject.Header;
import pageObject.HomePage;
import pageObject.ProductPage;
import pageObject.TestCasesPage;

public class TestCasePageTest extends Configuration {

    Header header = new Header(driver);
    HomePage homePage = new HomePage(driver);
    TestCasesPage testCasesPage = new TestCasesPage(driver);

    @Before
    public void openTheUrl(){
        header.navigateTo("https://www.automationexercise.com/");
        homePage.verifyHomePageIsVisibleSuccessfully();
    }

    @Test
    public void verifyTestCasePage_T7(){
        header.clickOnTestcase();
        testCasesPage.verifyUserNavigatedToTestCasesPageSuccessfully();
    }
}
