package lesson24_HomeWork_DownloadReadWrite;

import lesson20.GaragePage;
import lesson20.HillelAutoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GaragePageDownloadReadWriteTest {
    private HillelAutoPage hillelAutoPage;
    private static WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        String downloadFilepath = "/Users/tetianariabovych/Documents/hillel-IT"; // путь к корню проекта

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.default_directory", downloadFilepath); // корень проекта
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("plugins.always_open_pdf_externally", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
        hillelAutoPage = new HillelAutoPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            hillelAutoPage = null;
        }
    }

    @Test
    public void downloadFileOnGaragePageTest() {
        hillelAutoPage.clickGuestLogInButton();
        String expectedUrl = "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage";
        String actualUrl = driver.getCurrentUrl();

        // проверка урла
        Assert.assertEquals(actualUrl, expectedUrl);

        GaragePage garagePage = new GaragePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(garagePage.getInstructionsButton()));
        garagePage.clickInstructionsButton();

        By linkLocator = By.xpath("//a[contains(@href, 'Front windshield wipers on Audi TT.pdf')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkLocator));
        WebElement downloadButtonFrontWindshieldAudiTT = driver.findElement(linkLocator);
        downloadButtonFrontWindshieldAudiTT.click();


        File downloadedFile = new File("/Users/tetianariabovych/Documents/hillel-IT/Front windshield wipers on Audi TT.pdf");

        wait.until(driver -> downloadedFile.exists() && downloadedFile.length() > 0);

        Assert.assertTrue(downloadedFile.exists());
    }

    @Test
    public void writeToFileFromGaragePageTest() throws IOException {
        hillelAutoPage.clickGuestLogInButton();
        String expectedUrl = "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage";
        String actualUrl = driver.getCurrentUrl();

        // проверка урла
        Assert.assertEquals(actualUrl, expectedUrl);

        GaragePage garagePage = new GaragePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(garagePage.getInstructionsButton()));
        garagePage.clickInstructionsButton();

        By linkLocator = By.cssSelector("button#brandSelectDropdown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkLocator));
        WebElement selectCarDropdown = driver.findElement(linkLocator);
        selectCarDropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul > li.brand-select-dropdown_item")));


        List<WebElement> options = driver.findElements(By.cssSelector("ul > li.brand-select-dropdown_item"));
        List<String> optionTexts = options.stream()
                .map(WebElement::getText)
                .filter(text -> !text.isBlank())
                .collect(Collectors.toList());

        Path filePath = Paths.get("/Users/tetianariabovych/Documents/hillel-IT/brand_car_options.txt");
        Files.write(filePath, optionTexts);

        String expectedText = "Audi\nBMW\nFord\nPorsche\nFiat";
        File file = filePath.toFile();
        if (file.exists() && file.isFile()) {
            System.out.println("File is created");

            // проверяю текст файла
            try {
                List<String> fileContent = Files.readAllLines(filePath);

                StringBuilder actualText = new StringBuilder();
                for (String line : fileContent) {
                    actualText.append(line).append("\n");
                }

                if (actualText.toString().trim().equals(expectedText)) {
                    System.out.println("File contains expected text");
                } else {
                    System.out.println("File does not contain expected text");
                }
            } catch (IOException e) {
                System.out.println("Error while reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist in project");
        }
    }
}
