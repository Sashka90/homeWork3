import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test2 {

    private WebDriver driver;

    private final static String URL = "https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";

    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }

    @Test
    public void homeWorkTest2() {
        By image = By.xpath("//li[@class = 'portfolio-item2 content'][2]");
        By popup = By.xpath("//*[@class = 'pp_content_container']");

        driver.get(URL);
        driver.findElement(image).click();
        Assertions.assertTrue(driver.findElement(popup).isDisplayed());
    }

    @AfterEach
    public void close(){
        if (driver != null)
            driver.quit();
    }


}
