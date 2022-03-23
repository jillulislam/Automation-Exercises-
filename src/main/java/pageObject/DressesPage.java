package pageObject;

import commons.CommonActions;
import org.openqa.selenium.WebDriver;

public class DressesPage extends CommonActions {

    public DressesPage(WebDriver driver){
        this.driver = driver;
        initElement();
    }
    
}
