import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep {
    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
    }

    @And("^I enter the nric as S(\\d+)A, name as Tan Ah Kow, uen as BGPQEDEMO and role as Acceptor$")
    public void iEnterTheNricAsSANameAsTanAhKowUenAsBGPQEDEMOAndRoleAsAcceptor(int arg0) {
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
    }

    @Then("^I should see My Grants page$")
    public void iShouldSeeMyGrantsPage() {
    }
}
