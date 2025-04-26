package lesson20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class GaragePage {
    private WebDriver driver;
//    public static File DOWNLOADS = new File("/Users/tetianariabovych/Documents/hillel-IT");

    @FindBy(css = "a[routerlink='garage']")
    private WebElement garageButton;
    @FindBy(css = "a[routerlink='expenses']")
    private WebElement fuelExpensesButton;

    public WebElement getInstructionsButton() {
        return instructionsButton;
    }

    @FindBy(css = "a[routerlink='instructions']")
    private WebElement instructionsButton;
    @FindBy(css = "a.text-danger")
    private WebElement logOutButton;
    @FindBy(css = "button.btn-primary")
    private WebElement addCarButton;

    public GaragePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickGarageButton() {
        Actions actions = new Actions(driver);
        actions.click(garageButton).build().perform();
    }

    public void clickAddCarButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCarButton);
//        Actions actions = new Actions(driver);
//        actions.click(addCarButton).build().perform();
    }

    public WebElement getAddCarButton() {
        return addCarButton;
    }

    public void clickInstructionsButton() {
        instructionsButton.click();
    }

}
