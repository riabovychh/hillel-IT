package lesson25_HomeWork_PageObjectWithAllure;

import io.qameta.allure.*;
import lesson20.GaragePage;
import lesson20.HillelAutoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Owner("Tetiana Riabovych")
public class GaragePageWithAllureTest {

    private HillelAutoPage hillelAutoPage;
    private static WebDriver driver;
    private WebDriverWait wait;
    private GaragePage garagePage = new GaragePage(driver);
    private SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    @Step("Opening the main page in Google Chrome")
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        hillelAutoPage = new HillelAutoPage(driver);
    }

    @AfterClass
    @Step("Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            hillelAutoPage = null;
        }
    }

    @DataProvider
    public Object[][] carData() {
        return new Object[][] {
                {"Audi", "TT", "20"}
        };
    }

    @Test
    @Description("Adding car in Garage page")
    @Link(name = "HomeWork25", url = "https://lms.ithillel.ua/groups/67406e2394b2c83dff14cbaf/homeworks/680fe3bdad66d86c0cff8a0a")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Open Garage Page through Guest Login button")
    public void openGaragePageTest() {
        hillelAutoPage.clickGuestLogInButton();
        String expectedUrl = "https://qauto.forstudy.space/panel/garage";
        String actualUrl = driver.getCurrentUrl();

        // проверка урла
        softAssert.assertEquals(actualUrl, expectedUrl);
    }


    @Test(dependsOnMethods = "openGaragePageTest")
    @Step ("Open 'Add car' modal window")
    public void addCarModalWindowTest() {
        this.garagePage = new GaragePage(driver);
        garagePage.clickAddCarButton();

        softAssert.assertTrue(garagePage.getAddCarModalWindow().isEnabled());
    }

    @Test(dataProvider = "carData", dependsOnMethods = "addCarModalWindowTest")
    @Step("Add car brand")
    public void addCarBrandTest(String carBrand, String carModel, String miles) {
        if (!garagePage.getCarBrandInput().isEnabled()) {
            wait.until(driver -> garagePage.getCarBrandInput().isEnabled());
        }
        Select carBrandDropdown = new Select(garagePage.getCarBrandInput());
        carBrandDropdown.selectByVisibleText(carBrand);

        softAssert.assertEquals(garagePage.getCarBrandInput().getText(), carBrand);
    }

    @Test(dataProvider =  "carData", dependsOnMethods = "addCarBrandTest")
    @Step("Add car model")
    public void addCarModelTest(String carBrand, String carModel, String miles) {
        if (!garagePage.getCarModelInput().isEnabled()) {
            wait.until(driver -> garagePage.getCarModelInput().isEnabled());
        }
        Select carModelDropdown = new Select(garagePage.getCarModelInput());
        carModelDropdown.selectByVisibleText(carModel);

        softAssert.assertEquals(garagePage.getCarModelInput().getText(), carModel);
    }

    @Test(dataProvider =  "carData", dependsOnMethods = "addCarModelTest")
    @Step ("Add car mileage")
    public void addCarMileage(String carBrand, String carModel, String miles) {
        garagePage.getMileageInput().click();
        garagePage.getMileageInput().sendKeys("20");

        softAssert.assertEquals(garagePage.getMileageInput().getText(), miles);
    }

    @Test(dependsOnMethods = "addCarMileage")
    @Step ("Check the 'Add' button is available with all inputs filled")
    public void addButtonIsAvailableTest() {
        softAssert.assertTrue(garagePage.getAddButton().isEnabled(), "Add button is not enabled after all inputs are filled");
    }



    @Test(dependsOnMethods = "addButtonIsAvailableTest")
    @Step("Add car and check the card with added car appear")
    public void addCarTest() {
        garagePage.getAddButton().click();
        wait.until(ExpectedConditions.visibilityOf(garagePage.getAddedCarCard()));  // жду, что появилась карточка машины

        softAssert.assertNotNull(garagePage.getChildCardTag());
    }

    @Test(dependsOnMethods = "addCarTest")
    @Step("Check the date in the car's card")
    public void checkCardDateTest() {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        softAssert.assertTrue(garagePage.getCardDate().getText().contains(currentDate));
    }

    @Test(dataProvider = "carData", dependsOnMethods = "addCarTest")
    @Step("Check the car's card contains the entered amount of miles")
    public void addedCarCardMilesAmountTest(String carBrand, String carModel, String miles) {
        String milesAmountInCarCard = garagePage.getMilesInputInCarCard().getCssValue("value");

        softAssert.assertEquals(milesAmountInCarCard, miles);
    }

    @Test(dependsOnMethods = "addCarTest")
    @Step("Check the car's card has displayed logo image")
    public void carsCardLogoImageTest() {
        softAssert.assertTrue(garagePage.getCarLogoImage().isDisplayed());
    }

    @Test(dependsOnMethods = "addCarTest")
    @Step("Check the car's card logo image has 'audi.png' part in link")
    public void carsCardLogoLinkTest() {
        softAssert.assertTrue(garagePage.getCarLogoImage().getCssValue("src").endsWith("audi.png"));
    }
}
