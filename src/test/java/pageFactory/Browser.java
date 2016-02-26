package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mipan on 29.01.2016.
 */
public class Browser {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriverWait getWait() {
        if (wait == null){
            wait = new WebDriverWait(driver(), 15);
        }
        return wait;
    }

    public static WebDriver driver() {
        if (driver == null) {
            driver = new FirefoxDriver();

        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {driver.quit();}
    }


}
