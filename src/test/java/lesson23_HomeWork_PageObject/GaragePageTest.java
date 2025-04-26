package lesson23_HomeWork_PageObject;

import lesson20.GaragePage;
import lesson20.HillelAutoPage;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class GaragePageTest {
    private HillelAutoPage hillelAutoPage;
    private static WebDriver driver;
    private WebDriverWait wait;

    @AfterMethod
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

    @Test (dataProvider =  "carData")
    public void addingAutoToGarageChromeTest(String carBrand, String carModel, String miles) {
        // перенесла setUp в сам метод
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        hillelAutoPage = new HillelAutoPage(driver);


        hillelAutoPage.clickGuestLoginButton();
        String expectedUrl = "https://qauto.forstudy.space/panel/garage";
        String actualUrl = driver.getCurrentUrl();

        // проверка урла
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl, expectedUrl);

        GaragePage garagePage = new GaragePage(driver);
        garagePage.clickAddCarButton();

        // добавления авто в модалке
        WebElement carBrandInput = driver.findElement(By.id("addCarBrand"));
        if (!carBrandInput.isEnabled()) {
            wait.until(driver -> carBrandInput.isEnabled());
        }
        Select carBrandDropdown = new Select(carBrandInput);
        carBrandDropdown.selectByVisibleText(carBrand);

        WebElement carModelInput = driver.findElement(By.id("addCarModel"));
        if (!carModelInput.isEnabled()) {
            wait.until(driver -> carModelInput.isEnabled());
        }
        Select carModelDropdown = new Select(carModelInput);
        carModelDropdown.selectByVisibleText(carModel);

        WebElement mileageInput = driver.findElement(By.id("addCarMileage"));
        mileageInput.click();
        mileageInput.sendKeys("20");

        WebElement addButton = driver.findElement(By.cssSelector("div.modal-footer > button.btn-primary"));

        // добавила еще проверку, что Add кликабельна
        softAssert.assertTrue(addButton.isEnabled(), "Add button is not enabled after all inputs are filled");

        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.jumbotron")));  // жду, что появилась карточка машины

        WebElement addedCarCard = driver.findElement(By.cssSelector("div.jumbotron"));
        WebElement childCardTag = addedCarCard.findElement(By.xpath(".//p[contains(text(),'Audi TT')]"));

        // проверка, что есть карточка с названием авто
        softAssert.assertNotNull(childCardTag);

        // проверка, что в карточке текущая дата
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String updateMileageWithDate = addedCarCard.findElement(By.cssSelector("p.car_update-mileage")).getText();

        softAssert.assertTrue(updateMileageWithDate.contains(currentDate));

        // проверка, что в инпуте миль - введенное значение 20
        String enteredMilesValue = miles;
        WebElement milesInputInCarCard = addedCarCard.findElement(By.cssSelector("input.update-mileage-form_input"));
        String milesAmountInCarCard = milesInputInCarCard.getCssValue("value");

        softAssert.assertEquals(milesAmountInCarCard, enteredMilesValue);

        // проверка, что есть изображение логотипа машины
        WebElement carLogo = addedCarCard.findElement(By.cssSelector("div.car_logo.car-logo"));
        WebElement carLogoImage = carLogo.findElement(By.cssSelector("img.car-logo_img"));

        softAssert.assertTrue(carLogoImage.isDisplayed());

        // проверка, что ссылка на картинку содержит audi.png
        softAssert.assertTrue(carLogoImage.getCssValue("src").endsWith("audi.png"));
    }

    @Test (dataProvider = "carData")
    public void addingAutoToGarageFirefoxTest(String carBrand, String carModel, String miles) {
        // перенесла setUp в сам метод
        String username = "guest";
        String password = "welcome2qauto";

        String encodedCreds = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);

        proxy.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().add("Authorization", "Basic " + encodedCreds);
            return null;
        });

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        FirefoxOptions options = new FirefoxOptions();
        options.setProxy(seleniumProxy);

        driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qauto.forstudy.space/");

        hillelAutoPage = new HillelAutoPage(driver);


        hillelAutoPage.clickGuestLoginButton();
        String expectedUrl = "https://qauto.forstudy.space/panel/garage";
        String actualUrl = driver.getCurrentUrl();

        // проверка урла
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl, expectedUrl);

        GaragePage garagePage = new GaragePage(driver);
        garagePage.clickAddCarButton();

        // добавления авто в модалке
        WebElement carBrandInput = driver.findElement(By.id("addCarBrand"));
        wait.until(ExpectedConditions.elementToBeClickable(carBrandInput));
        Select carBrandDropdown = new Select(carBrandInput);
        carBrandDropdown.selectByVisibleText(carBrand);

        WebElement carModelInput = driver.findElement(By.id("addCarModel"));
        wait.until(ExpectedConditions.elementToBeClickable(carModelInput));
        Select carModelDropdown = new Select(carModelInput);
        carModelDropdown.selectByVisibleText(carModel);

        WebElement mileageInput = driver.findElement(By.id("addCarMileage"));
        mileageInput.click();
        mileageInput.sendKeys(miles);

        WebElement addButton = driver.findElement(By.cssSelector("div.modal-footer > button.btn-primary"));

        // добавила еще проверку, что Add кликабельна
        softAssert.assertTrue(addButton.isEnabled(), "Add button is not enabled after all inputs are filled");

        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.jumbotron")));  // жду, что появилась карточка машины

        WebElement addedCarCard = driver.findElement(By.cssSelector("div.jumbotron"));
        WebElement childCardTag = addedCarCard.findElement(By.xpath(".//p[contains(text(),'Audi TT')]"));

        // проверка, что есть карточка с названием авто
        softAssert.assertNotNull(childCardTag);

        // проверка, что в карточке текущая дата
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String updateMileageWithDate = addedCarCard.findElement(By.cssSelector("p.car_update-mileage")).getText();

        softAssert.assertTrue(updateMileageWithDate.contains(currentDate));

        // проверка, что в инпуте миль - введенное значение 20
        String enteredMilesValue = "20";
        WebElement milesInputInCarCard = addedCarCard.findElement(By.cssSelector("input.update-mileage-form_input"));
        String milesAmountInCarCard = milesInputInCarCard.getCssValue("value");

        softAssert.assertEquals(milesAmountInCarCard, enteredMilesValue);

        // проверка, что есть изображение логотипа машины
        WebElement carLogo = addedCarCard.findElement(By.cssSelector("div.car_logo.car-logo"));
        WebElement carLogoImage = carLogo.findElement(By.cssSelector("img.car-logo_img"));

        softAssert.assertTrue(carLogoImage.isDisplayed());

        // проверка, что ссылка на картинку содержит audi.png
        softAssert.assertTrue(carLogoImage.getCssValue("src").endsWith("audi.png"));
    }
}
