package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

/**
 * Created by mipan on 25.02.2016.
 */
public class LoginPage extends BasePage {

// TODO add login and password!
    private static final String EMAIL_LOGIN = "";
    private static final String PASSWORD = "";

    private String URL_LOGIN = "http://ui.moneytapp.vas61t.test.i-free.ru/webui-rc/login";

    @FindBy (id = "j_username")
    private WebElement emailLogin;

    @FindBy (id = "j_password")
    private WebElement password;

    @FindBy (css = "input.force-right ")
    private WebElement logIn;

    public void open() {
        driver().get(URL_LOGIN);
    }

    public void login() {
        login(EMAIL_LOGIN, PASSWORD);
    }

    private void login(String login, String pass) {
        emailLogin.sendKeys(login);
        password.sendKeys(pass);
        logIn.click();
    }
}
