package steps;

import base.BaseMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class BaseSteps extends BaseMethods {
    public static WebDriver driver;
    public WebDriverWait wait;

    @Before()
    public void setUp(Scenario scenario) {
        BaseMethods.folderName = scenario.getName();
        driver = Driver.get();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.apple.com/tr/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String _path =
                    "exportFile/screenshot/"
                            + getFolderName()
                            + "-"
                            + get_currentTime()
                            + "-"
                            + get_randomNumber()
                            + ".png";
            scenario.attach(screenshot, _path, scenario.getName());
            System.out.println("ScreenShot fail.");
        }
        Driver.closeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
