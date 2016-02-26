package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mipan on 29.01.2016.
 */
public class BasePage {
    public WebDriver driver(){
        return Browser.driver();
    }
    public BasePage() {
        PageFactory.initElements(driver(), this);
    }
}
