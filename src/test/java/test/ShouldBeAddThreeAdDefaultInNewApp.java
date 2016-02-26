package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageFactory.Browser;
import pages.AppListPage;
import pages.AppPage;
import pages.CreationAppFormPage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

/**
 * Created by mipan on 29.01.2016.
 */
public class ShouldBeAddThreeAdDefaultInNewApp {

    private String nameApp = null;

    protected static WebDriverWait wait;

    private LoginPage loginPage = new LoginPage();
    private AppListPage appListPage = new AppListPage();
    private CreationAppFormPage creationAppFormPage = new CreationAppFormPage();
    private AppPage appPage = new AppPage();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        wait = Browser.getWait();
    }

    @BeforeClass
    public void loginAndCreateApp() {
        loginPage.open();
        loginPage.login();
        appListPage.open();
        appListPage.newAppButton.click();
        wait.until(ExpectedConditions.visibilityOf(creationAppFormPage.modalForm));
        nameApp = creationAppFormPage.createApp();
        wait.until(ExpectedConditions.titleContains(nameApp));
    }


    @Test
    public void specificAdDefaultNameTest() {
        openCreatedAppPage();
        assertThat(appPage.adPlaceNameList, contains(hasText("Banner"), hasText("Fullscreen"), hasText("Video")));
    }

    @Test
    public void threeAdDefaultTest() {
        openCreatedAppPage();
        assertThat(appPage.adPlaceNameList, hasSize(3));
    }

    @Test
    public void statusAdDefaultTest() {
        openCreatedAppPage();
        assertThat(appPage.statusList, everyItem(hasText("Testing")));
    }

    @AfterSuite(alwaysRun = true)
    public void shutDown(){
        Browser.closeDriver();
    }

    private void openCreatedAppPage() {
        appListPage.open();
        wait.until(ExpectedConditions.titleContains("Application List"));
        appListPage.openCreatedApp(nameApp);
        wait.until(ExpectedConditions.titleContains(nameApp));
    }
}
