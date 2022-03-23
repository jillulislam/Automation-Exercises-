package pageObject;
import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends CommonActions {

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//div[@class=\"contact-form\"]/h2")
    WebElement text_getInTouch;

    @FindBy(name = "name")
    WebElement name_field;

    @FindBy(name = "email")
    WebElement email_field;

    @FindBy(name = "subject")
    WebElement subject_field;

    @FindBy(id = "message")
    WebElement message_field;

    @FindBy(name = "upload_file")
    WebElement btn_uploadFile;

    @FindBy(name = "submit")
    WebElement btn_submit;

    @FindBy(xpath = "//div[@id='form-section']/a/span")
    WebElement btn_home;

    @FindBy(xpath = "//div[2]/div[1]/div/div[2]")
    WebElement text_successMsg;

    public void verifyUserIsOnContactUsPage(){
        verify("GET IN TOUCH",text_getInTouch.getText());
    }

    public void enterYourName(String username){
        typeText(name_field,username);
    }

    public void enterYourEmail(String email){
        typeText(email_field,email);
    }

    public void subject(){
        typeText(subject_field,"Test case no 6");
    }

    public void writeYourMessage(){
        typeText(message_field,"This is test case no 6 where we are uploading a file");
    }

    public void uploadAFileButton(){
        typeText(btn_uploadFile,"C:\\Users\\jillu\\OneDrive\\Desktop\\Automation exercise\\Hi.docx");
    }

    public void clickOnSubmitButton(){
        clickOn(btn_submit);
    }

    public void clickOnAlert(){
        acceptAlert();
    }

    public void verifySuccessMessageIsDisplaying(){
        verify("Success! Your details have been submitted successfully.", text_successMsg.getText());
    }

    public void clickOnHomeButton(){
        clickOn(btn_home);
    }
}
