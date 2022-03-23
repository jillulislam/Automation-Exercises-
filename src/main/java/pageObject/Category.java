package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;

public class Category extends CommonActions {

    public Category(WebDriver driver){
        this.driver = driver;
        initElement();
    }
}
