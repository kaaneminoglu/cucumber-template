package steps;

import base.BaseMethods;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginSteps extends BaseMethods {
    private final By txt_email = By.id("username");
    private final By txt_password = By.id("password");
    private final By btn_submit = By.id("kc-login");
    private final By lbl_error_message = By.id("input-error");

    @When("{string} and {string} are entered.")
    public void setMailAndPassword(String userName, String password) {
        waitDisplayingWebElement(txt_email);
        clearText(txt_email);
        sendText(txt_email, userName);
        clearText(txt_password);
        sendText(txt_password, password);
        clickWebElement(btn_submit);
    }

    @When("Error message is {string}")
    public void checkErrorMessage(String errorMessage) {
        if (!errorMessage.equals(getText(lbl_error_message))) {
            //takeScreenshot();
            Assert.fail("Failed to error message");
        }
    }
}