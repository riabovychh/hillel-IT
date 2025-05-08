package lesson26_Selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;


public class GarageSelenidePage {
    private SelenideElement garageButtonS = Selenide.$(Path.GARAGE_GARAGE_BUTTON);
    private SelenideElement fuelExpensesButtonS = Selenide.$(Path.GARAGE_FUEL_EXPENSES_BUTTON);
    private SelenideElement instructionsButtonS = Selenide.$(Path.GARAGE_INSTRUCTIONS_BUTTON);
    private SelenideElement logOutButtonS = Selenide.$(Path.GARAGE_LOGOUT_BUTTON);
    private SelenideElement addCarButtonS = Selenide.$(Path.GARAGE_ADD_CAR_BUTTON);
    private SelenideElement addCarModalWindowS = Selenide.$(Path.GARAGE_ADD_CAR_MODAL_WINDOW);
    private SelenideElement carBrandInputS = Selenide.$(Path.GARAGE_CAR_BRAND_INPUT);
    private SelenideElement carModelInputS = Selenide.$(Path.GARAGE_CAR_MODEL_INPUT);
    private SelenideElement mileageInputS = Selenide.$(Path.GARAGE_MILEAGE_INPUT);
    private SelenideElement addButtonS = Selenide.$(Path.GARAGE_ADD_BUTTON);
    private SelenideElement addedCarCardS = Selenide.$(Path.GARAGE_ADDED_CAR_CARD);
    private SelenideElement childCardTagS = Selenide.$x(Path.GARAGE_CHILD_CARD_TAG_XPATH);
    private SelenideElement updatedMileageWithDateS = Selenide.$(Path.GARAGE_UPDATED_MILEAGE_WITH_DATE);
    private SelenideElement cardDateS = Selenide.$(Path.GARAGE_CARD_DATE);
    private SelenideElement milesInputInCarCardS = Selenide.$(Path.GARAGE_MILES_INPUT_IN_CAR_CARD);
    private SelenideElement carLogoImageS = Selenide.$(Path.GARAGE_CAR_LOGO_IMAGE);

    public void clickAddCarButton() {
        addCarButtonS.click();
    }

    public void selectCarBrand(String carBrand) {
        carBrandInputS.shouldBe(enabled);
        carBrandInputS.click();
        Select carBrandDropdown = new Select(carBrandInputS);
        carBrandDropdown.selectByVisibleText(carBrand);
    }

    public void selectCarModel(String carModel) {
        carModelInputS.shouldBe(enabled);
        carModelInputS.click();
        Select carModelDropdown = new Select(carModelInputS);
        carModelDropdown.selectByVisibleText(carModel);
    }

    public void enterCarMileage(String mileage) {
        mileageInputS.click();
        mileageInputS.setValue(mileage);
    }

    public void clickAddButton(){
        addButtonS.shouldBe(enabled);
        addButtonS.click();
        addedCarCardS.shouldBe(visible);
    }

    public void checkVisibilityOfAddedCarCard() {
        addedCarCardS.shouldBe(visible);
        childCardTagS.shouldBe(visible);
    }

    public String getDateInAddedCarCard() {
        return updatedMileageWithDateS.getText();
    }

    public String  getMilesAmountFromCardMilesInput() {
        addedCarCardS.shouldBe(visible);
        childCardTagS.shouldBe(visible);
        milesInputInCarCardS.shouldBe(visible);
        return milesInputInCarCardS.getValue();
    }

    public SelenideElement getCarLogoImage() {
        carLogoImageS.shouldBe(visible);
        return carLogoImageS;
    }

    public String getCarLogoImageLink() {
        addedCarCardS.shouldBe(visible);
        carLogoImageS.shouldBe(visible);
        return carLogoImageS.getAttribute("src");
    }
}
