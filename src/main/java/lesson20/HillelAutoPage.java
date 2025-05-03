package lesson20;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.awt.*;
import java.time.Duration;


public class HillelAutoPage {
    private WebDriver driver;

    @FindBy(css = "div > button.header-link")
    private WebElement guestLogInButton;
    @FindBy(css = "div > button.header_signin")
    private WebElement signInButton;
    @FindBy(css = "button.hero-descriptor_btn")
    private WebElement signUpButton;
    @FindBy(css = "a.header_logo > svg ")
    private WebElement logo;
    @FindBy(css = "iframe.hero-video_frame")
    private WebElement videoFrame;

    public HillelAutoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Click Guest Login button")
    public void clickGuestLogInButton() {
        Actions actions = new Actions(driver);
        actions.click(guestLogInButton).build().perform();  // попробувала через Actions
    }

    @Step("Waiting for title")
    public void waitTitle() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.titleIs("Hillel Qauto"));
    }

    @Step("Waiting for element to become clickable")
    public void waitElementClickable(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    @Step("Transform the color from rgba format to hex")
    public String rgbaToHex(String rgba) {
        String[] values = rgba.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(values[0].trim());
        int g = Integer.parseInt(values[1].trim());
        int b = Integer.parseInt(values[2].trim());

        return String.format("#%02x%02x%02x", r, g, b);
    }

    @Step("Get back to the tab with opened main page")
    public void getBackToMainPage() throws InterruptedException {
        for (String windowHandle : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowHandle).getTitle();
            Thread.sleep(3000);
            if (title.toLowerCase().contains("hillel qauto")) {
                break;
            }
        }
    }

    public WebElement getVideoFrame() {
        return videoFrame;
    }
}
