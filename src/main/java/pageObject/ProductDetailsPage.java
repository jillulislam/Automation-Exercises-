package pageObject;
import commons.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends CommonActions {

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement blueTop;

    public void verifyUserIsOnTheProductDetailPage(){
        verify("Automation Exercise - Product Details", getTextOfPageTitle());
    }
}
