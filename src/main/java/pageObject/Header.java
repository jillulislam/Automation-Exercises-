package pageObject;

import commons.CommonActions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.ls.LSOutput;

public class Header extends CommonActions {

    public Header(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
    WebElement products;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[3]/a")
    WebElement cart;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]/a")
    WebElement text_signupOrLogin;

    @FindBy(xpath = "//div[@class='shop-menu pull-right']/ul/li[9]/a")
    WebElement text_loggedInAsUser;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[5]")
    WebElement delete_account;

    @FindBy(xpath = "//div[@class='col-sm-8']/descendant::li[4]")
    WebElement logOut;

    @FindBy(xpath = "//*[@id='header']/descendant::li[7]/a")
    WebElement contactUS;

    @FindBy(xpath = "//*[@id='header']/descendant::li[5]/a")
    WebElement testCase;


    public void clickOnProducts(){
        clickOn(products);
    }

    public void clickOnSignUpOrLogin(){
        clickOn(text_signupOrLogin);
    }

    public void verifyLoggedInAsUserNameIsVisible(){
        verify("Logged in as " + SignUpOrLogInPage.c_name , getTextOfAnElement(text_loggedInAsUser));
    }

    public void clickOnDeleteButton(){
        clickOn(delete_account);
    }

    public void clickOnLogOut(){
        clickOn(logOut);
    }

    public void clickOnContactUs(){
        clickOn(contactUS);
    }

    public void clickOnTestcase(){
        clickOn(testCase);
    }

    public void clickOnCart(){
        clickOn(cart);
    }
}
