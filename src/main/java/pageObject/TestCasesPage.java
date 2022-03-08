package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends CommonActions {

    public TestCasesPage(WebDriver driver){
        this.driver=driver;
        initElement();
    }

    @FindBy(xpath = "//*[@id='form']/div/div[1]/div/h2/b")
        WebElement test_TestCases;


    public void verifyUserNavigatedToTestCasesPageSuccessfully(){
        verify("TEST CASES",test_TestCases.getText());
    }
}
