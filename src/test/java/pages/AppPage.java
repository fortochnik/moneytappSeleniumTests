package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

import java.util.List;

/**
 * Created by mipan on 26.02.2016.
 */
public class AppPage extends BasePage {

    @FindAll(@FindBy (css = ".adplace-row>td:first-child"))
    public List<WebElement> adPlaceNameList;

   @FindAll(@FindBy (css = ".adplace-row>td:nth-child(2) button"))
    public List<WebElement> statusList;

}
