package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("ALL")
public class ApplyNewGrantStep extends BaseUtil {

    private BaseUtil base;
    private String myGrants;

    public ApplyNewGrantStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I am on My Grants page$")
    public void iAmOnMyGrantsPage() {
        myGrants = base.Driver.getCurrentUrl();
        System.out.println(myGrants);
        Assert.assertEquals("https://bgp-qa.gds-gov.tech/dashboard", myGrants);
    }

    @And("^I click Get new grant$")
    public void iClickGetNewGrant() {
        System.out.println("I'm clicking get new grant.");

        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"grants\"]/div[2]/div/a[2]/section/div/div[2]/h4")));
        base.Driver.findElement(By.xpath("//*[@id=\"grants\"]/div[2]/div/a[2]/section/div/div[2]/h4")).click();
    }

    @And("^I select a Sector$")
    public void iSelectASector() {
        System.out.println("I select sector.");

        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[3]/div/label/div/div")));
        base.Driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[3]/div/label/div/div")).click();
    }

    @And("^I select a Development Area$")
    public void iSelectADevelopmentArea() {
        System.out.println("I select development area.");

        base.Driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/label/div/div")).click();
    }

    @And("^I select a Functional Area$")
    public void iSelectAFunctionalArea() {
        System.out.println("I select functional area.");

        base.Driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/label/div")).click();
    }

    @And("^I click Apply button$")
    public void iClickApplyButton() {
        System.out.println("I click apply.");

        base.Driver.findElement(By.xpath("//*[@id=\"go-to-grant\"]")).click();
    }

    @Then("^a draft form for the Grant should be created$")
    public void aDraftFormForTheGrantShouldBeCreated() {

        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keyPage-form-button")));
        base.Driver.findElement(By.id("keyPage-form-button")).isDisplayed();
        System.out.println("Draft form created.");
    }
}