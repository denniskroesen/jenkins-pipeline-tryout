package nl.jenkins.test.demo.annotation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dennis on 6-6-17.
 */
public class AnnotationOutline {

    WebDriver driver = null;

    @Given("^I am on Facebook login page$")
    public void goToFacebook() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver/geckodriver");

        URL url = new URL("http://localhost:9515");
        WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
    }

    @When("^I enter username as \"(.*)\"$")
    public void enterUsername(String arg1) {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @When("^I enter password as \"(.*)\"$")
    public void enterPassword(String arg1) {
        driver.findElement(By.id("pass")).sendKeys(arg1);
        driver.findElement(By.id("u_0_v")).click();
    }

    @Then("^Login should fail$")
    public void checkFail() {
        if (driver.getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
            System.out.println("Test1 Pass");
        } else {
            System.out.println("Test1 Failed");
        }
        driver.close();
    }

    @Then("^Relogin option should be available$")
    public void checkRelogin() {
        if (driver.getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Failed");
        }
        driver.close();
    }


}
