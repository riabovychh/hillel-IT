package lesson19_HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLesson19 {
    private WebDriver driver;

    @BeforeMethod
    public void preConditions (){
        driver = new ChromeDriver();
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @Test
    public void testDisplayedLogo () {
        // захотiла ще обробити випадок, що логотипу взагалi нема на сайтi
        try {
            WebElement logo = driver.findElement(By.xpath("//a[@class=\"header_logo\"]/*[@xmlns='http://www.w3.org/2000/svg']"));

            if (logo.isDisplayed()) {
                System.out.println("Logo displayed");
            } else {
                System.out.println("Logo does not displayed");
            }

            Assert.assertTrue(logo.isDisplayed());

        } catch (NoSuchElementException e) {
            System.out.println("Елемент не знайдено на сайтi");
        }
    }

    @Test
    public void testButtonBackgroundColor () {
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(@class,\"hero-descriptor_btn\")]"));
        String backgroundColor = signUpButton.getCssValue("background-color");

        String hexBackgroundColor = rgbaToHex(backgroundColor);
        String expectedBackgroundColor = "#0275d8";

        if (hexBackgroundColor.equals(expectedBackgroundColor)) {
            System.out.println("Background color of Sign up button is correct.");
        } else {
            System.out.println("Background color of Sign up button is incorrect");
        }

        Assert.assertEquals(hexBackgroundColor, expectedBackgroundColor);
    }

    private String rgbaToHex(String rgba) {
        String[] values = rgba.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(values[0].trim());
        int g = Integer.parseInt(values[1].trim());
        int b = Integer.parseInt(values[2].trim());

        return String.format("#%02x%02x%02x", r, g, b);
    }

    @AfterMethod
    public void postConditions () {
        driver.quit();
    }
}
