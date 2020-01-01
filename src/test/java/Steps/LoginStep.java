package Steps;

import Base.BaseUtil;
import Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("ALL")
public class LoginStep extends BaseUtil {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("I navigate to login page");
        base.Driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech");

        LoginPage loginPage = new LoginPage(base.Driver);
        loginPage.btnLogin.click();
    }

    @And("^I enter the nric as \"([^\"]*)\", name as \"([^\"]*)\", uen as \"([^\"]*)\" and role as \"([^\"]*)\"$")
    public void iEnterTheNricAsNameAsUenAsAndRoleAs(String nric, String name, String uen, String role) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am going to login with nric as " + nric + " name as " + name + " uen as " + uen + " role as " + role);
        LoginPage loginPage = new LoginPage(base.Driver);

        loginPage.txtNric.clear();
        loginPage.txtNric.sendKeys("S1234567A");

        loginPage.txtName.clear();
        loginPage.txtName.sendKeys("Tan Ah Kow");

        loginPage.txtUen.clear();
        loginPage.txtUen.sendKeys("BGPQEDEMO");

        Select drpRole = new Select(loginPage.ddlRole);
        drpRole.selectByVisibleText("Acceptor");
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        System.out.println("I click login button");
        LoginPage loginPage = new LoginPage(base.Driver);

        loginPage.btnLoginOnForm.click();
    }

    @Then("^I should see My Grants page$")
    public void iShouldSeeMyGrantsPage() {
        String url = base.Driver.getCurrentUrl();
        Assert.assertEquals("https://bgp-qa.gds-gov.tech/dashboard", url);
        System.out.println("I see my grants page");
    }
}