package Steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.BitSet;

public class LoginStep extends BaseUtil {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("I navigate to login page");
        base.Driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
        base.Driver.findElement(By.id("login-button")).click();
    }

    @And("^I enter the nric as \"([^\"]*)\", name as \"([^\"]*)\", uen as \"([^\"]*)\" and role as \"([^\"]*)\"$")
    public void iEnterTheNricAsNameAsUenAsAndRoleAs(String nric, String name, String uen, String role) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am going to login with nric as " + nric + " name as " + name + " uen as " + uen + " role as " + role);
        base.Driver.findElement(By.name("CPUID")).clear();
        base.Driver.findElement(By.name("CPUID")).sendKeys("S1234567A");

        base.Driver.findElement(By.name("CPUID_FullName")).clear();
        base.Driver.findElement(By.name("CPUID_FullName")).sendKeys("Tan Ah Kow");

        base.Driver.findElement(By.name("CPEntID")).clear();
        base.Driver.findElement(By.name("CPEntID")).sendKeys("BGPQEDEMO");

        Select drpRole = new Select(base.Driver.findElement(By.name("CPRole")));
        drpRole.selectByVisibleText("Acceptor");
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        System.out.println("I click login button");
        //base.Driver.findElement(By.xpath("/html/body/div[2]/form[2]/button")).click();
        base.Driver.findElement(By.xpath("//form[2]/button[@type='submit']")).click();
    }

    @Then("^I should see My Grants page$")
    public void iShouldSeeMyGrantsPage() {
        String url = base.Driver.getCurrentUrl();
        Assert.assertEquals("https://bgp-qa.gds-gov.tech/dashboard", url);
        System.out.println("I see my grants page");
    }


}
