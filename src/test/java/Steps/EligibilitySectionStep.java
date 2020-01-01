package Steps;

import Base.BaseUtil;
import Pages.EligibilitySection;
import Pages.MyGrants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class EligibilitySectionStep extends BaseUtil {

    private BaseUtil base;

    public EligibilitySectionStep(BaseUtil base) {
        this.base = base;
    }

    @When("^I click Proceed on the draft form$")
    public void iClickProceedOnTheDraftForm() {
        MyGrants myGrants = new MyGrants(base.Driver);

        // Wait for page to load
        WebDriverWait waitForPageLoad = new WebDriverWait(base.Driver, 200);

        // Wait for Drafts tab to show up
        waitForPageLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div/div[2]/section[2]/div/div[1]/div[3]/section[1]/ul/li[2]/a")));

        // Click on Drafts tab
        myGrants.draftsTab.click();

        // Click on an application
        myGrants.firstDraftApplication.click();

        // Click on proceed button
        WebDriverWait waitForProceedBtn = new WebDriverWait(base.Driver, 200);
        waitForProceedBtn.until(ExpectedConditions.visibilityOfElementLocated(By.id("keyPage-form-button")));
        myGrants.btnProceed.click();
    }

    @Then("^I should see the eligibility section with 4 questions$")
    public void iShouldSeeTheEligibilitySectionWithQuestions() {

        EligibilitySection eligibilitySection = new EligibilitySection(base.Driver);

        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        // Wait for "Check your Eligibility" to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/h2")));

        eligibilitySection.firstQuestion.isDisplayed();
        Assert.assertEquals("First question is not displayed correctly.", eligibilitySection.txtFirstQuestion, eligibilitySection.firstQuestion.getText());

        eligibilitySection.secondQuestion.isDisplayed();
        Assert.assertEquals("Second question is not displayed correctly.", eligibilitySection.txtSecondQuestion, eligibilitySection.secondQuestion.getText());

        eligibilitySection.thirdQuestion.isDisplayed();
        Assert.assertEquals("Third question is not displayed correctly.", eligibilitySection.txtThirdQuestion, eligibilitySection.thirdQuestion.getText());

        eligibilitySection.fourthQuestion.isDisplayed();
        Assert.assertEquals("Fourth question is not displayed correctly.", eligibilitySection.txtFourthQuestion, eligibilitySection.fourthQuestion.getText());

    }

    @Then("I should see yes and no radio buttons for each question")
    public void iShouldSeeYesAndNoRadioButtonsForEachQuestion() {
        EligibilitySection eligibilitySection = new EligibilitySection(base.Driver);

        eligibilitySection.radioBtnFirstQuestionYes.isDisplayed();
        eligibilitySection.radioBtnFirstQuestionNo.isDisplayed();
        System.out.println("Radio buttons for first question is displayed.");

        eligibilitySection.radioBtnSecondQuestionYes.isDisplayed();
        eligibilitySection.radioBtnSecondQuestionNo.isDisplayed();
        System.out.println("Radio buttons for second question is displayed.");

        eligibilitySection.radioBtnThirdQuestionYes.isDisplayed();
        eligibilitySection.radioBtnThirdQuestionNo.isDisplayed();
        System.out.println("Radio buttons for third question is displayed.");

        eligibilitySection.radioBtnFourthQuestionYes.isDisplayed();
        eligibilitySection.radioBtnFourthQuestionNo.isDisplayed();
        System.out.println("Radio buttons for fourth question is displayed.");
    }

    @And("I click No for any question")
    public void iClickNoForAnyQuestion() {
        EligibilitySection eligibilitySection = new EligibilitySection(base.Driver);

        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        // Wait for "Check your Eligibility" to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-eligibility-sg_registered_check-false")));

        // Click on No for the first question
        base.Driver.findElement(By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[4]/div/div[2]/label[2]/span[1]")).click();
    }

    @Then("I should see a warning message displayed")
    public void iShouldSeeAWarningMessageDisplayed() {
        EligibilitySection eligibilitySection = new EligibilitySection(base.Driver);
        eligibilitySection.msgEligibilityAdvice.isDisplayed();
        System.out.println("Warning message is displayed when user select No to question 1.");
    }

    @And("I click the link in the warning message")
    public void iClickTheLinkInTheWarningMessage() {
        EligibilitySection eligibilitySection = new EligibilitySection(base.Driver);
        eligibilitySection.linkExternalWebsite.click();
    }

    @Then("I should see the website launch in a new window tab")
    public void iShouldSeeTheWebsiteLaunchInANewWindowTab() {

        ArrayList<String> newTab = new ArrayList<String>(base.Driver.getWindowHandles());
        System.out.println(newTab);
        System.out.println(newTab.size());
        base.Driver.switchTo().window(newTab.get(1));
        Assert.assertEquals("External site URL does not match.", "https://www.smeportal.sg/content/smeportal/en/moneymatters.html#saText", base.Driver.getCurrentUrl());
    }

    @And("I click Save and reload the page")
    public void iClickSaveAndReloadThePage() {
        base.Driver.findElement(By.xpath("//*[@id=\"save-btn\"]")).click();
    }

    @Then("I should see my applicant's response saved")
    public void iShouldSeeMyApplicantSResponseSaved() {
        base.Driver.navigate().refresh();
        // No should be selected for the first question
        base.Driver.findElement(By.xpath("//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[4]/div/div[2]/label[2]/span[1]")).isSelected();
    }
}
