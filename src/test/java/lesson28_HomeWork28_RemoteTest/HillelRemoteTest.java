package lesson28_HomeWork28_RemoteTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lesson26_Selenide.HillelAutoSelenidePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HillelRemoteTest {
    @DataProvider
    public Object[][] credentials() {
        return new Object[][] {
                {"test@hillel.ua", "1111"}
        };
    }


    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }



    @Test(dataProvider = "credentials")
    public void logInChromeTest(String email, String password) {
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote="http://localhost:4444/";
        Configuration.browser="chrome";
        Selenide.open("https://guest:welcome2qauto@qauto.forstudy.space/");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();

        HillelAutoSelenidePage hillelSelenidePage = new HillelAutoSelenidePage();
        hillelSelenidePage.clickSignInButton();

        hillelSelenidePage.enterLoginEmail(email);
        hillelSelenidePage.enterLoginPassword(password);

        hillelSelenidePage.clickLoginButton();

        String expectedErrorMessage = "Wrong email or password";
        Assert.assertEquals(hillelSelenidePage.getWrongCredentialNotificationText(), expectedErrorMessage);
    }

    @Test(dataProvider = "credentials")
    public void logInFirefoxTest(String email, String password) {
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote="http://localhost:4444/";
        Configuration.browser="firefox";
        Selenide.open("https://guest:welcome2qauto@qauto.forstudy.space/");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();

        HillelAutoSelenidePage hillelSelenidePage = new HillelAutoSelenidePage();
        hillelSelenidePage.clickSignInButton();

        hillelSelenidePage.enterLoginEmail(email);
        hillelSelenidePage.enterLoginPassword(password);

        hillelSelenidePage.clickLoginButton();

        String expectedErrorMessage = "Wrong email or password";
        Assert.assertEquals(hillelSelenidePage.getWrongCredentialNotificationText(), expectedErrorMessage);
    }
}
