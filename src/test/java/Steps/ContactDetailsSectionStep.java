package Steps;

import Base.BaseUtil;
import Pages.ContactDetailsSection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactDetailsSectionStep extends BaseUtil {

    private BaseUtil base;

    public ContactDetailsSectionStep(BaseUtil base) {
        this.base = base;
    }

    @And("I click on Contact Details")
    public void iClickOnContactDetails() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);
        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        wait.until(ExpectedConditions.visibilityOf(contactDetailsSection.contactDetailsTab));
        contactDetailsSection.contactDetailsTab.click();
    }

    @Then("I should see the input fields: Name, Job Title, Contact No, Email, Alternate Contact Person's Email, Mailing Address")
    public void iShouldSeeTheInputFieldsNameJobTitleContactNoEmailAlternateContactPersonSEmailMailingAddress() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);

        contactDetailsSection.txtName.isDisplayed();
        contactDetailsSection.txtJobTitle.isDisplayed();
        contactDetailsSection.txtContactNo.isDisplayed();
        contactDetailsSection.txtPrimaryEmail.isDisplayed();
        contactDetailsSection.txtSecondaryEmail.isDisplayed();
        contactDetailsSection.mailingAddressSection.isDisplayed();
    }

    @And("I input a valid postal code")
    public void iInputAValidPostalCode() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);
        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        wait.until(ExpectedConditions.visibilityOf(contactDetailsSection.txtPostalCode));
        contactDetailsSection.txtPostalCode.sendKeys("059764");
    }

    @Then("block number and street details is auto-populated")
    public void blockNumberAndStreetDetailsIsAutoPopulated() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);

        System.out.println("Waiting for attribute ~~~");
        WebDriverWait wait = new WebDriverWait(base.Driver, 200);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(contactDetailsSection.txtAddressBlock, "value"));
        System.out.println("Complete waiting for attribute. Lets do the check!");

        System.out.println("Address Block Get Value: " + contactDetailsSection.txtAddressBlock.getAttribute("value"));
        System.out.println("Address Street Get Value: " + contactDetailsSection.txtAddressStreet.getAttribute("value"));

        Assert.assertEquals("Address block number does not match.", "18", contactDetailsSection.txtAddressBlock.getAttribute("value"));
        Assert.assertEquals("Address street details does not match.", "HAVELOCK ROAD", contactDetailsSection.txtAddressStreet.getAttribute("value"));
    }

    @And("I select same as registered address in company profile option")
    public void iSelectSameAsRegisteredAddressInCompanyProfileOption() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);

        WebDriverWait wait = new WebDriverWait(base.Driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactDetailsSection.chkAddressCopied));

        contactDetailsSection.chkAddressCopied.click();
    }

    @Then("mailing address is auto-populated")
    public void mailingAddressIsAutoPopulated() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);
        Assert.assertEquals("Postal Code is populated wrongly.", "453123", contactDetailsSection.txtPostalCode.getAttribute("value"));
        Assert.assertEquals("Block Number is populated wrongly.", "45", contactDetailsSection.txtAddressBlock.getAttribute("value"));
        Assert.assertEquals("Street Details is populated wrongly.", "CHOA CHU KANG CENTRAL", contactDetailsSection.txtAddressStreet.getAttribute("value"));
        Assert.assertEquals("Level is populated wrongly.", "03", contactDetailsSection.txtAddressLevel.getAttribute("value"));
        Assert.assertEquals("Unit is populated wrongly.", "19", contactDetailsSection.txtAddressUnit.getAttribute("value"));
    }

    @Then("I should see the Letter of Offer Addressee subsection with name, job title and email input fields")
    public void iShouldSeeTheLetterOfOfferAddresseeSubsectionWithNameJobTitleAndEmailInputFields() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);

        WebDriverWait wait = new WebDriverWait(base.Driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactDetailsSection.letterOfOfferAddresseeSection));

        contactDetailsSection.letterOfOfferAddresseeSection.isDisplayed();
        contactDetailsSection.txtOffereeName.isDisplayed();
        contactDetailsSection.txtOffereeDesignation.isDisplayed();
        contactDetailsSection.txtOffereeEmail.isDisplayed();
    }

    @And("I select Same as main contact person option")
    public void iSelectSameAsMainContactPersonOption() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);

        WebDriverWait wait = new WebDriverWait(base.Driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactDetailsSection.letterOfOfferAddresseeSection));

        contactDetailsSection.chkOffereeContactCopied.click();
    }

    @Then("I should see the same name, job title and email populated as entered in main contact person section")
    public void iShouldSeeTheSameNameJobTitleAndEmailPopulatedAsEnteredInMainContactPersonSection() {
        ContactDetailsSection contactDetailsSection = new ContactDetailsSection(base.Driver);

        Assert.assertEquals("Name does not match.", contactDetailsSection.txtName.getAttribute("value"), contactDetailsSection.txtOffereeName.getAttribute("value"));
        Assert.assertEquals("Job Title does not match.", contactDetailsSection.txtJobTitle.getAttribute("value"), contactDetailsSection.txtOffereeDesignation.getAttribute("value"));
        Assert.assertEquals("Email does not match.", contactDetailsSection.txtPrimaryEmail.getAttribute("value"), contactDetailsSection.txtOffereeEmail.getAttribute("value"));
    }

}
