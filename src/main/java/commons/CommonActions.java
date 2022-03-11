package commons;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class CommonActions {

    public WebDriver driver;

    public void initElement(){
        PageFactory.initElements(driver,this);
    }

    protected void clickOn(WebElement element){
        element.click();
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    protected String getTextOfPageTitle(){
        return driver.getTitle();
    }

    public String getTextOfCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected void verify(String expected, String actual){
        Assert.assertEquals(expected,actual);
    }

    protected void verify(int expected, int actual){
        Assert.assertEquals(expected,actual);
    }

    protected void verify(boolean expected, boolean actual){
        Assert.assertEquals(expected,actual);
    }

    protected void typeText(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getTextOfAnElement(WebElement element){
        return element.getText();
    }

    protected void selectFromTheDropDown(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public String getAttributeValue(WebElement element, String attributeName){
        String value = "";
        value = element.getAttribute(attributeName);
        return value;
    }

    public void verifyText(String expected, String actual){
        Assert.assertTrue(actual.contains(expected));
    }

    protected void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public boolean productListIsVisible(List<WebElement> element){
        int count = 0;
        boolean visible = true;
        for (int i = 0; i<=element.size();i++){
            count = count+1;
        }
        if (count != 0){
            visible = true;
        }
        return visible;
    }

    public void waitFor(int millSec) throws InterruptedException {
        Thread.sleep(millSec);
    }

    public String getRandomString(int length) {
        Random random = new Random();
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

//    public boolean searchedProductAreVisible(List<WebElement> element){
//        int count = 0;
//        boolean visible;
//
//        for (int i = 0; i<=element.size(); i++){
//            if (element.contains("top")){
//                count = count+1;
//            }
//        }
//        if (count != 1){
//            visible = false;
//        }
//        return visible;
//    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void mouseHoverToAnElement(WebElement locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).build().perform();
    }
}
