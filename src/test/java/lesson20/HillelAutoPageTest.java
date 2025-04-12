package lesson20;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class HillelAutoPageTest {
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
    public void hillelAutoPageDownloadTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String readyState = (String) js.executeScript("return document.readyState");
        assertTrue(readyState.equals("complete"), "Page did not load completely. ReadyState: " + readyState);
    }

    @Test
    public void waitTitleTest() {
        hillelAutoPage.waitTitle();
        String expectedTitle = "Hillel Qauto";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void clickGuestLoginButtonTest() {
        hillelAutoPage.clickGuestLogInButton();
        String expectedPage = "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage";
        String actualPage = driver.getCurrentUrl();

        Assert.assertEquals(actualPage, expectedPage);
    }

    @Test
    public void clickableAddCarButtonTest() {
        hillelAutoPage.clickGuestLogInButton();
        WebElement addCarButton = driver.findElement(By.cssSelector("button.btn-primary"));
        hillelAutoPage.waitElementClickable(addCarButton);

        Assert.assertTrue(addCarButton.isDisplayed() && addCarButton.isEnabled());
    }
}

