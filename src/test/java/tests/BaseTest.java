package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

//ctrl+shift+o = remove unwanted imports
public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        //set chrome path

        //BROWSER - chrome / firefox
        //HUB-HOST - localhost / any hostname

        DesiredCapabilities dc;
        //dc.setCapability("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

        //System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        //this.driver = new ChromeDriver();

//        ChromeOptions cap = new ChromeOptions();
//        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
//                UnexpectedAlertBehaviour.IGNORE);
        String host = "localhost";

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);

        this.driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
