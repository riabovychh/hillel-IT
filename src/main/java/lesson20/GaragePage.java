package lesson20;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
    @FindBy(css = "a[routerlink='instructions']")
    private WebElement instructionsButton;
    @FindBy(css = "a.text-danger")
    private WebElement logOutButton;
    @FindBy(css = "button.btn-primary")
    private WebElement addCarButton;
    @FindBy(css = "app-add-car-modal")
    private WebElement addCarModalWindow;
    @FindBy(id = "addCarBrand")
    private WebElement carBrandInput;
    @FindBy(id = "addCarModel")
    private WebElement carModelInput;
    @FindBy(id = "addCarMileage")
    private WebElement mileageInput;
    @FindBy(css = "div.modal-footer > button.btn-primary")
    private WebElement addButton;
    @FindBy(css = "div.jumbotron")
    private WebElement addedCarCard;
    @FindBy(xpath = ".//p[contains(text(),'Audi TT')]")
    private WebElement childCardTag;
    @FindBy(css = "p.car_update-mileage")
    private WebElement updatedMileageWithDate;
    @FindBy(css = "p.car_update-mileage")
    private WebElement cardDate;
    @FindBy(css = "input.update-mileage-form_input")
    private WebElement milesInputInCarCard;
    @FindBy(css = "img.car-logo_img")
    private WebElement carLogoImage;


    public GaragePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Click 'Garage' button")
    public void clickGarageButton() {
        Actions actions = new Actions(driver);
        actions.click(garageButton).build().perform();
    }

    @Step("Click 'Add car' button")
    public void clickAddCarButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCarButton);
//        Actions actions = new Actions(driver);
//        actions.click(addCarButton).build().perform();
    }

    public WebElement getAddCarButton() {
        return addCarButton;
    }

    @Step("Click 'Instructions' button")
    public void clickInstructionsButton() {
        instructionsButton.click();
    }

    public WebElement getAddCarModalWindow() {
        return addCarModalWindow;
    }

    public WebElement getInstructionsButton() {
        return instructionsButton;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getMileageInput() {
        return mileageInput;
    }

    public WebElement getCarBrandInput() {
        return carBrandInput;
    }

    public WebElement getCarModelInput() {
        return carModelInput;
    }

    public WebElement getAddedCarCard() {
        return addedCarCard;
    }

    public WebElement getChildCardTag() {
        return childCardTag;
    }

    public WebElement getUpdatedMileageWithDate() {
        return updatedMileageWithDate;
    }

    public WebElement getCardDate() {
        return cardDate;
    }

    public WebElement getMilesInputInCarCard() {
        return milesInputInCarCard;
    }

    public WebElement getCarLogoImage() {
        return carLogoImage;
    }
}
