package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpOrLogInPage extends CommonActions {

    public SignUpOrLogInPage(WebDriver driver){
        this.driver= driver;
        initElement();
    }
    public static String c_name = "Jolly";

    @FindBy(xpath = "//div[@class='login-form']/h2")
    WebElement text_logInToYourAccount;

    @FindBy(name = "name")
    WebElement signUp_name;

    @FindBy(xpath = "//div[@class='signup-form']/descendant::input[@name='email']")
    WebElement signUp_email;

    @FindBy(xpath = "//div[@class='login-form']/descendant::input[@name='email']")
    WebElement signIn_email;

    @FindBy(xpath = "//div[@class='login-form']/descendant::input[@name='password']")
    WebElement signIn_password;

    @FindBy(xpath = "//div[@class='signup-form']/descendant::button[@type='submit']")
    WebElement btn_signUp;

    @FindBy(xpath = "//div[@class='login-form']/descendant::button[@type='submit']")
    WebElement btn_signIn;

    @FindBy(xpath = "//div[@class='login-form']/descendant::p")
    WebElement text_incorrectMsg;

    @FindBy(xpath = "//div[@class='signup-form']/h2")
    WebElement text_newUserSignUp;

    @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/p")
    WebElement text_emailAlreadyExist;

   public void verifyUserIsOnSignUpOrLogInPage(){
       verify("Automation Exercise - Signup / Login", getTextOfPageTitle());
   }

   public void verifyNewUserSignUpTextIsVisible(){
       verify("New User Signup!",text_newUserSignUp.getText());
   }

   public void enterRegisteredNameToSignup(){
       typeText(signUp_name,c_name);
   }

    public void enterNameToSignup(){
        typeText(signUp_name,c_name);
    }

   public void enterEmailToSignUp(){
       String recipientName = getRandomString(3);
       typeText(signUp_email,recipientName+"@test.com");
   }

   public void clickObSignupButton(){
       clickOn(btn_signUp);
   }

   public void verifyLogIntoYourAccountTextIsVisible(){
       verify("Login to your account", text_logInToYourAccount.getText());
   }

   public void enterUserEmailAddress(String userName){
       typeText(signIn_email,userName);
   }
    public void enterUserARegisteredEmailAddress(String userName){
        typeText(signUp_email,userName);
    }

    public void enterPassword(String passWord){
        typeText(signIn_password,passWord);
    }

    public void clickOnLogInButton(){
       clickOn(btn_signIn);
    }

    public void verifyErrorYourEmailOrPasswordMsgIsVisible(){
       verify("Your email or password is incorrect!", text_incorrectMsg.getText());
    }

    public void verifyEmailAlreadyExistsTextIsVisible(){
       verify("Email Address already exist!",text_emailAlreadyExist.getText());
    }
}
