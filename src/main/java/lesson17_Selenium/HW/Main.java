package lesson17_Selenium.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        System.out.println();

        WebDriver browser = new ChromeDriver();
        Thread.sleep(2000);

        try {
        browser.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        Thread.sleep(2000);

        WebElement guestLoginButton = browser.findElement(By.xpath("//button[text()='Guest log in'] "));
        guestLoginButton.click();
        Thread.sleep(2000);

        List<WebElement> borderMenuElements = browser.findElements(By.cssSelector("nav.sidebar > a"));

        for (WebElement borderElement : borderMenuElements) {
            System.out.println(borderElement.getText());
        }

        browser.quit();

        } catch (Exception e) {
            System.out.println("It was exception: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Finish");
    }
}
