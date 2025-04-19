package lesson22_HomeWork_Frames;

import lesson20.HillelAutoPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HillelAutoPageFrameTest {
    private HillelAutoPage hillelAutoPage;
    private static WebDriver driver;
    private final Map<String, String> expectedUrls = new HashMap<>();
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        expectedUrls.put("facebook", "https://www.facebook.com/Hillel.IT.School");
        expectedUrls.put("telegram", "https://t.me/ithillel_kyiv");
        expectedUrls.put("youtube", "https://www.youtube.com/user/HillelITSchool");
        expectedUrls.put("instagram", "https://www.instagram.com/hillel_itschool/");
        expectedUrls.put("linkedin", "https://www.linkedin.com/school/ithillel/");
        hillelAutoPage = new HillelAutoPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        hillelAutoPage = null;
        driver.quit();
    }

    @Test
    public void videoFrameTitleTest() {
        String expectedTitle = "Як потрапити у майбутнє? Трансформація навчання. - YouTube"; // я вставила правильний тайтл
        WebElement videoFrame = hillelAutoPage.getVideoFrame();
        // в домашкi сказано, шо якшо фрейм не вiдображений, то теж такий самий текст помилки
        Assert.assertTrue(videoFrame.isDisplayed(), "Title doesn’t equals to the expected result");

        driver.switchTo().frame(videoFrame);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String actualTitle = (String) jsExecutor.executeScript(
                "return document.title;"
        );

        Assert.assertEquals(actualTitle, expectedTitle, "Title doesn’t equals to the expected result");
        driver.switchTo().defaultContent();
    }

    @Test
    public void socialMediaButtonsTest() {
        WebElement divElement = driver.findElement(By.cssSelector("div.contacts_socials"));
        List<WebElement> socialMediaIcons = divElement.findElements(By.cssSelector("a.socials_link"));

        Assert.assertEquals(socialMediaIcons.size(), 5, "Social network block doesn’t contain 5 items");

        String mainTab = driver.getWindowHandle();

        for (WebElement icon : socialMediaIcons) {
            Set<String> tabsBeforeClick = driver.getWindowHandles();

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", icon);

            wait.until(ExpectedConditions.numberOfWindowsToBe(tabsBeforeClick.size() + 1));

            Set<String> tabsAfterClick = driver.getWindowHandles();
            tabsAfterClick.removeAll(tabsBeforeClick);
            String newTab = tabsAfterClick.iterator().next();

            driver.switchTo().window(newTab);

            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("")));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("consent.youtube.com") && currentUrl.contains("continue=")) {
                String actualTarget = java.net.URLDecoder.decode(
                        currentUrl.substring(currentUrl.indexOf("continue=") + "continue=".length()),
                        java.nio.charset.StandardCharsets.UTF_8
                );
                currentUrl = actualTarget;
            }
            if (currentUrl.contains("linkedin.com/authwall") && currentUrl.contains("sessionRedirect=")) {
                currentUrl = java.net.URLDecoder.decode(
                        currentUrl.substring(currentUrl.indexOf("sessionRedirect=") + "sessionRedirect=".length()),
                        java.nio.charset.StandardCharsets.UTF_8
                );
            }

            boolean correctUrl = expectedUrls.values().stream().anyMatch(currentUrl::startsWith);
            Assert.assertTrue(correctUrl, "Incorrect url of Social network: " + currentUrl);

            driver.close();
            driver.switchTo().window(mainTab);
        }
    }
}
