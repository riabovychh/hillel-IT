package lesson21_HomeWork;

import lesson20.HillelAutoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HillelAutoPage21Test {
    private HillelAutoPage hillelAutoPage;
    private static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // макс.час для пошуку елементу (неявне очiкування)
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        hillelAutoPage = new HillelAutoPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        hillelAutoPage = null;
        driver.quit();
    }

    @Test
    public void logoDisplayableTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOf(hillelAutoPage.getLogo()));
        Assert.assertTrue(logo.isDisplayed(), "Logo does not displayed");
    }

    @Test
    public void signUpButtonBackgroundColorTest() {
        String backgroundColor = hillelAutoPage.getSignUpButton().getCssValue("background-color");

        String hexBackgroundColor = hillelAutoPage.rgbaToHex(backgroundColor);
        String expectedBackgroundColor = "#0275d8";

        Assert.assertEquals(hexBackgroundColor, expectedBackgroundColor,
                "Background color of Sign up button is incorrect");
    }

}
