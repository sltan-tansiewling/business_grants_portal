package Steps;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


@SuppressWarnings("ALL")
public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        System.out.println("Opening Firefox browser");

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Test_Automation\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        base.Driver = new FirefoxDriver(firefoxOptions);

    }

    @After
    public void TearDownTest() {
        System.out.println("Closing Firefox browser");
    }
}
