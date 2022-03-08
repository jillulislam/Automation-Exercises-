package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInformationPage extends CommonActions {
    public AccountInformationPage(WebDriver driver){
        this.driver=driver;
        initElement();
    }

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    WebElement text_accountInformation;

    @FindBy(id = "uniform-id_gender1")
    WebElement radio_mr;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement dropDown_date;

    @FindBy(id = "months")
    WebElement dropDown_month;

    @FindBy(id = "years")
    WebElement dropDown_year;

    @FindBy(name = "newsletter")
    WebElement checkBox_newsLetter;

    @FindBy(name = "optin")
    WebElement checkBox_option;

    @FindBy(name = "first_name")
    WebElement first_name;

    @FindBy(name = "last_name")
    WebElement last_name;

    @FindBy(name = "company")
    WebElement company;

    @FindBy(name = "address1")
    WebElement address;

    @FindBy(name = "address2")
    WebElement address2;

    @FindBy(name = "country")
    WebElement country;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "zipcode")
    WebElement zipcode;

    @FindBy(name = "mobile_number")
    WebElement mobile_number;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btn_createAccount;

    public void verifyEnterAccountInformationTextIsVisible(){
        verify("ENTER ACCOUNT INFORMATION",getTextOfAnElement(text_accountInformation));
    }

    public void clickOnMr(){
        clickOn(radio_mr);
    }

    public void enterPassword(){
        typeText(password,"jsghsf242323");
    }

    public void selectDate(){
        selectFromTheDropDown(dropDown_date,"22");
    }

    public void selectMonth(){
        selectFromTheDropDown(dropDown_month,"April");
    }

    public void selectYear(){
        selectFromTheDropDown(dropDown_year,"1982");
    }

    public void selectSignUpForOurNewsLetterCheckBox(){
        clickOn(checkBox_newsLetter);
    }

    public void selectReceiveSpecialOfferFromOurPartnersCheckBox(){
        clickOn(checkBox_option);
    }

    public void enterFirstName(){
        typeText(first_name,"Ali");
    }

    public void enterLastName(){
        typeText(last_name,"Ahmed");
    }

    public void enterCompanyName(){
        typeText(company,"Cityreed Limited");
    }

    public void enterAddress(){
        typeText(address,"Queen borough Terrace");
    }

    public void enterAddress2(){
        typeText(address2,"Astoria");
    }

    public void selectCountry(){
        selectFromTheDropDown(country,"United States");
    }

    public void enterState(){
        typeText(state,"New York");
    }

    public void enterCity(){
        typeText(city,"New York");
    }

    public void enterZipCode(){
        typeText(zipcode,"11101");
    }

    public void enterMobileNo(){
        typeText(mobile_number,"13153535345");
    }

    public void clickOnCreateAccountButton(){
        clickOn(btn_createAccount);
    }

}
