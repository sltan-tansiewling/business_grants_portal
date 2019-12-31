package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "login-button")
    public WebElement btnLogin;

    @FindBy(how = How.NAME, using = "CPUID")
    public WebElement txtNric;

    @FindBy(how = How.NAME, using = "CPUID_FullName")
    public WebElement txtName;

    @FindBy(how = How.NAME, using = "CPEntID")
    public WebElement txtUen;

    @FindBy(how = How.NAME, using = "CPRole")
    public WebElement ddlRole;

    @FindBy(how = How.XPATH, using = "//form[2]/button[@type='submit']")
    public WebElement btnLoginOnForm;
}
