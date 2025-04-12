package lesson20;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;


public class HillelAutoPage {
    private WebDriver driver;

    @FindBy (css = "div > button.header-link")
    private WebElement guestLogInButton;
    @FindBy (css = "div > button.header_signin")
    private WebElement signInButton;
    @FindBy (css = "button.hero-descriptor_btn")
    private WebElement signUpButton;

    public HillelAutoPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickGuestLogInButton() {
        Actions actions = new Actions(driver);
        actions.click(guestLogInButton).build().perform();  // попробувала через Actions
    }

    public void waitTitle() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.titleIs("Hillel Qauto"));
    }

    public void waitElementClickable(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
