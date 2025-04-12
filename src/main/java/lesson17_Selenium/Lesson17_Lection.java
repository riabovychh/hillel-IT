package lesson17_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
public class Lesson17_Lection {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        try {
            WebDriver browser = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(browser::quit));
            Thread.sleep(2000);
            browser.get("https://privatbank.ua/");
            String title = browser.getTitle();
            System.out.println(title);

            WebElement exchangeButton = browser.findElement(By.cssSelector("button.exchange-rate.btn[plerdy-tracking-id=\"70644246501\"]"));
            exchangeButton.click();
            List<WebElement> currencies = browser.findElements(By.cssSelector("td[id$=_buy]"));
            for (WebElement currency : currencies) {
                System.out.println(currency.getText());
            }
//        System.out.println(currencies);

            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("was exception" + e.getMessage());
        }
        System.out.println("Finish");
    }
}
