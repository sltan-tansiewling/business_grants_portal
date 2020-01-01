package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EligibilitySection {
    public EligibilitySection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[4]/div/div[1]/div/label")
    public WebElement firstQuestion;
    public String txtFirstQuestion = "Is the applicant registered in Singapore?\n" + " *";

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[5]/div/div[1]/div/label")
    public WebElement secondQuestion;
    public String txtSecondQuestion = "Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200?\n" + " *";

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[6]/div/div[1]/div/label")
    public WebElement thirdQuestion;
    public String txtThirdQuestion = "Does the applicant have at least 30% local equity?\n" + " *";

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div[7]/div/div[1]/div/label")
    public WebElement fourthQuestion;
    public String txtFourthQuestion = "Are all the following statements true for this project?\n" + " *\n" +
                                        "The applicant has not started work on this project\n" +
                                        "The applicant has not made any payment to any supplier, vendor, or third party prior to applying for this grant\n" +
                                        "The applicant has not signed any contractual agreement with any supplier, vendor, or third party prior to applying for this grant";

    @FindBy(how = How.ID, using = "react-eligibility-sg_registered_check-true")
    public WebElement radioBtnFirstQuestionYes;

    @FindBy(how = How.ID, using = "react-eligibility-sg_registered_check-false")
    public WebElement radioBtnFirstQuestionNo;

    @FindBy(how = How.ID, using = "react-eligibility-turnover_check-true")
    public WebElement radioBtnSecondQuestionYes;

    @FindBy(how = How.ID, using = "react-eligibility-turnover_check-false")
    public WebElement radioBtnSecondQuestionNo;

    @FindBy(how = How.ID, using = "react-eligibility-global_hq_check-true")
    public WebElement radioBtnThirdQuestionYes;

    @FindBy(how = How.ID, using = "react-eligibility-global_hq_check-false")
    public WebElement radioBtnThirdQuestionNo;

    @FindBy(how = How.ID, using = "react-eligibility-started_project_check-true")
    public WebElement radioBtnFourthQuestionYes;

    @FindBy(how = How.ID, using = "react-eligibility-started_project_check-false")
    public WebElement radioBtnFourthQuestionNo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/span[1]/div")
    public WebElement msgEligibilityAdvice;

    @FindBy (how = How.XPATH, using = "//*[@id=\"js-app\"]/div/div/div[2]/div[2]/div/div/div[1]/span[1]/div/span/a")
    public WebElement linkExternalWebsite;
}
