import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {

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
        By searchInput = By.id("search_form_input_homepage");
        By searchButton = By.id("search_button_homepage");
        By firstLink = By.xpath("(//*[@data-testid='result-title-a'])[1]");

        driver.get(URL);
        driver.findElement(searchInput).sendKeys("ОТУС");
        driver.findElement(searchButton).click();
        Assertions.assertTrue(driver.findElement(firstLink).getText().contains("Онлайн‑курсы для профессионалов, дистанционное обучение"));
    }

    @AfterEach
    public void close(){
        if(driver != null)
            driver.quit();
    }

}
