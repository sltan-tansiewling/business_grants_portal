package Pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsSection {

    public ContactDetailsSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"js-app\"]/div/div/div[2]/div[1]/div/div/ul/li[2]/a")
    public WebElement contactDetailsTab;

    @FindBy(how = How.ID, using = "react-contact_info-name")
    public WebElement txtName;

    @FindBy(how = How.ID, using = "react-contact_info-designation")
    public WebElement txtJobTitle;

    @FindBy(how = How.ID, using = "react-contact_info-phone")
    public WebElement txtContactNo;

    @FindBy(how = How.ID, using = "react-contact_info-primary_email")
    public WebElement txtPrimaryEmail;

    @FindBy(how = How.ID, using = "react-contact_info-secondary_email")
    public WebElement txtSecondaryEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[4]/div/div[2]")
    public WebElement mailingAddressSection;

    @FindBy(how = How.ID, using = "react-contact_info-correspondence_address-postal")
    public WebElement txtPostalCode;

    @FindBy(how = How.ID, using = "react-contact_info-correspondence_address-block")
    public WebElement txtAddressBlock;

    @FindBy(how = How.ID, using = "react-contact_info-correspondence_address-street")
    public WebElement txtAddressStreet;

    @FindBy(how = How.ID, using = "react-contact_info-correspondence_address-copied")
    public WebElement radioBtnAddressCopied;

    @FindBy(how = How.ID, using = "react-contact_info-correspondence_address-level")
    public WebElement txtAddressLevel;

    @FindBy(how = How.ID, using = "react-contact_info-correspondence_address-unit")
    public WebElement txtAddressUnit;

    @FindBy(how = How.XPATH, using = "//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[4]/div/div[3]")
    public WebElement letterOfOfferAddresseeSection;

    @FindBy(how = How.ID, using = "react-contact_info-offeree_name")
    public WebElement txtOffereeName;

    @FindBy(how = How.ID, using = "react-contact_info-offeree_designation")
    public WebElement txtOffereeDesignation;

    @FindBy(how = How.ID, using = "react-contact_info-offeree_email")
    public WebElement txtOffereeEmail;
}
