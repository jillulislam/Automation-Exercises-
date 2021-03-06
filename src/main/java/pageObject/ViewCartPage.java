package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends CommonActions {

    public ViewCartPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//*[@id='product-1']/td[2]/h4/a")
    WebElement text_product1;

    @FindBy(xpath = "//*[@id='product-2']/td[2]/h4/a")
    WebElement text_product2;

    @FindBy(xpath = "//*[@id='product-1']/td[3]/p")
    WebElement text_price1;

    @FindBy(xpath = "//*[@id='product-2']/td[3]/p")
    WebElement text_price2;

    @FindBy(xpath = "//*[@id='product-1']/td[4]/button")
    WebElement text_qnt1;

    @FindBy(xpath = "//*[@id='product-2']/td[4]/button")
    WebElement text_qnt2;

    @FindBy(xpath = "//*[@id='product-1']/td[5]/p")
    WebElement text_totalPro1;

    @FindBy(xpath = "//*[@id='product-2']/td[5]/p")
    WebElement text_totalPro2;

    public int getPriceOfFirstProduct(){
        String price = text_price1.getText();
        String[] price1 = price.split(" ");
        String price2 = price1[1];
        int productPrice = Integer.parseInt(price2);
        return productPrice;
    }

    public int getPriceOfSecondProduct(){
        String price = text_price2.getText();
        String[] price1 = price.split(" ");
        String price2 = price1[1];
        int productPrice = Integer.parseInt(price2);
        return productPrice;
    }

    public String getTheTotalQtyOfProduct(){
        String qty1 = getTextOfAnElement(text_qnt1);
        int getQty1 = Integer.parseInt(qty1);

        String qty2 = getTextOfAnElement(text_qnt2);
        int getQty2 = Integer.parseInt(qty2);

        int getTotalQty = getQty1+getQty2;
        System.out.println("Total qty"+getTotalQty);

        String  s =  String.valueOf(getTotalQty);
        return s;
    }

    public String getTheQtyOfProduct() {
        String qty = getTextOfAnElement(text_qnt1);
        return qty;
    }

    public void verifyCartPageIsDisplayed() {
        verify("1",getTheQtyOfProduct());
    }

    public void verifyTheTotalQtyIsCorrect(){
        verify("2", getTheTotalQtyOfProduct());
    }

    public void verifyTheQtyIsCorrect(String qty){
        verify(qty, getTheQtyOfProduct());
    }

    public void verifyProductPricesAreCorrect(){
        ProductPage productPage = new ProductPage(driver);
        verify(productPage.getFirstProductPrice(),getPriceOfFirstProduct());
    }
}
