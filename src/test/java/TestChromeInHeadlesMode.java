import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestChromeInHeadlesMode {

    private WebDriver driver;

    private final static String URL = "https://duckduckgo.com";

    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void homeWorkTest1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By searchInput = By.id("search_form_input_homepage");
        By searchButton = By.id("search_button_homepage");
        By firstLink = By.xpath("//article[@id='r1-0']");

        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchInput)));
        driver.findElement(searchInput).sendKeys("ОТУС");
        driver.findElement(searchButton).click();
        Assertions.assertTrue(driver.findElement(firstLink).getText().contains("Otus"));
    }

    @AfterEach
    public void close(){
        if(driver != null)
            driver.quit();
    }

}
