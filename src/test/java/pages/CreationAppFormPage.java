package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

import java.util.Date;
import java.util.List;

/**
 * Created by mipan on 26.02.2016.
 */
public class CreationAppFormPage extends BasePage {

    @FindBy(css = ".modal-dialog.modal-lg")
    public WebElement modalForm;

    @FindBy(css = ".btn.btn-lg.btn-success")
    public WebElement saveButton;

    @FindBy (id = "name")
    private WebElement appNameField;

    @FindAll(@FindBy (css = "#categoryTree span[class*=\"checkbox\"]"))
    private List<WebElement> categoryCheckboxList;

   /*selects the first category for simplicity
    @return name of new App
    */
    public String createApp() {
        String appName = "App "+createName();
        appNameField.sendKeys(appName);
        categoryCheckboxList.get(0).click();
        saveButton.click();
        return appName;
    }

    private String createName() {
        return String.valueOf(new Date().getTime());
    }


}
