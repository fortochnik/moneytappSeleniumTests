package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

import java.util.List;

/**
 * Created by mipan on 26.02.2016.
 */
public class AppListPage extends BasePage {

    @FindBy(css = ".btn.btn-success.pull-right.frontButton")
    public WebElement newAppButton;

    @FindAll(@FindBy(css = "#apps>tbody tr>td:first-child>a"))
    public List<WebElement> listAppNames;

    public void open() {
        driver().get("http://ui.moneytapp.vas61t.test.i-free.ru/webui-rc/apps/list");
    }

    public void openCreatedApp (String appName) {
        for (WebElement listAppName : listAppNames) {
            if (listAppName.getText().equals(appName)){
                listAppName.click();
                break;
            }
        }
    }





}
