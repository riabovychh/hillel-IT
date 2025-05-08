package lesson26_HomeWork_Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lesson20.GaragePage;
import lesson20.HillelAutoPage;
import lesson26_Selenide.GarageSelenidePage;
import lesson26_Selenide.HillelAutoSelenidePage;
import lesson26_Selenide.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GaragePageTestWithSelenide {

        @BeforeMethod
        public void setUp() {
            Configuration.pageLoadStrategy = "eager";   // eager - быстрая загрузка, normal - обычная загрузкаю none - без ожидания
            Selenide.open("https://guest:welcome2qauto@qauto.forstudy.space/");
            Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        }

        @AfterMethod
        public void tearDown(){
            Selenide.closeWebDriver();
        }

        @DataProvider
        public Object[][] carData() {
            return new Object[][] {
                    {"Audi", "TT", "20"}
            };
        }

        @Test(dataProvider = "carData")
        public void addingAutoToGarageSelenideTest(String carBrand, String carModel, String miles) {
            HillelAutoSelenidePage hillelSelenidePage = new HillelAutoSelenidePage();
            hillelSelenidePage.clickGuestLoginButton();
//            Selenide.$(Path.GARAGE_GARAGE_BUTTON).click();

            $(Path.GARAGE_GARAGE_BUTTON).shouldBe(visible);

            String expectedUrl = "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage";
            String actualUrl = Selenide.webdriver().driver().getWebDriver().getCurrentUrl();

            // проверка урла
            Assert.assertEquals(actualUrl, expectedUrl);

            GarageSelenidePage garageSelenidePage = new GarageSelenidePage();
            garageSelenidePage.clickAddCarButton();

            // добавления авто в модалке
            garageSelenidePage.selectCarBrand(carBrand);
            garageSelenidePage.selectCarModel(carModel);
            garageSelenidePage.enterCarMileage(miles);

            garageSelenidePage.clickAddButton();

            // проверка, что есть карточка с добавленным авто
            garageSelenidePage.checkVisibilityOfAddedCarCard();

            // проверка, что в карточке текущая дата
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String updateMileageWithDate = garageSelenidePage.getDateInAddedCarCard();
            Assert.assertTrue(updateMileageWithDate.contains(currentDate));

            // проверка, что в инпуте миль - введенное значение 20
            Assert.assertEquals(garageSelenidePage.getMilesAmountFromCardMilesInput(), miles);

            // проверка, что есть изображение логотипа машины
            Assert.assertNotNull(garageSelenidePage.getCarLogoImage());

            // проверка, что ссылка на картинку содержит audi.png
            Assert.assertTrue(garageSelenidePage.getCarLogoImageLink().endsWith("audi.png"));
        }
}
