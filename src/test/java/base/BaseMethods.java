package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.UUID;

public class BaseMethods {
    protected static String folderName;
    private final WebDriver driver = BaseSteps.getDriver();

    protected void clickWebElement(By locator) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            //takeScreenshot();
            e.printStackTrace();
        }
    }

    protected void sendText(By locator, String text) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        } catch (Exception e) {
            //takeScreenshot();
            e.printStackTrace();
        }
    }

    protected void clearText(By locator) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
        } catch (Exception e) {
            //takeScreenshot();
            e.printStackTrace();
        }
    }

    protected String getText(By locator) {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
    }

    public void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitDisplayingWebElement(By locator) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            //takeScreenshot();
            e.printStackTrace();
        }
    }

    protected void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    protected String getDurationWithName(String imageLink) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return window.performance.getEntries().filter(e=>e.name==='" + imageLink + "').map(item=>item.duration);").toString();
    }

    protected void scrollToWebElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locator);
    }

    protected void takeScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String _path =
                    "exportFile/screenshot/"
                            + getFolderName()
                            + "-"
                            + get_currentTime()
                            + "-"
                            + get_randomNumber()
                            + ".png";
            FileUtils.copyFile(scrFile, new File(_path));
        } catch (IOException e) {
            System.out.println("ScreenShot fail." + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getFolderName() {
        return folderName;
    }

    public String get_currentTime() {
        String pattern = "yyyy-MM-dd-hh-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public String get_randomNumber() {
        return UUID.randomUUID().toString();
    }
}
