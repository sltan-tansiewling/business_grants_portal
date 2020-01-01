package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyGrants {
    public MyGrants(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div[2]/div/div/div/div[2]/section[2]/div/div[1]/div[3]/section[1]/ul/li[2]/a")
    public WebElement draftsTab;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div[2]/div/div/div/div[2]/section[2]/div/div[1]/div[3]/section[2]/div/div[2]/div/div/table/tbody/tr[1]/td[2]/a/div")
    public WebElement firstDraftApplication;

    @FindBy(how = How.ID, using = "keyPage-form-button")
    public WebElement btnProceed;
}
