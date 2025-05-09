package lesson27_HomeWork_DataProviders;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lesson26_Selenide.HillelAutoSelenidePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HillelDataProvidersTest {
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
    public Object[][] credentials() {
        return new Object[][] {
                {"test@hillel.ua", "1111"},
                {"test@hillel.ua", "1234"}
        };
    }

    @Test(dataProvider = "credentials")
    public void logInTest(String email, String password) {
        HillelAutoSelenidePage hillelSelenidePage = new HillelAutoSelenidePage();
        hillelSelenidePage.clickSignInButton();

        hillelSelenidePage.enterLoginEmail(email);
        hillelSelenidePage.enterLoginPassword(password);

        hillelSelenidePage.clickLoginButton();

        String expectedErrorMessage = "Wrong email or password";
        Assert.assertEquals(hillelSelenidePage.getWrongCredentialNotificationText(), expectedErrorMessage);
        //Assert.assertTrue(hillelSelenidePage.getWrongCredentialNotificationText().contains(expectedErrorMessage));
    }
}
