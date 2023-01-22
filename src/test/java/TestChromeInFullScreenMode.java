import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestChromeInFullScreenMode {

    private WebDriver driver;

    private String login = "ceyogo9446@bitvoo.com";
    private String pass = "Ceyogo9446!";
    private static final String URL = "https://otus.ru";

    private static Logger log = LogManager.getLogger(TestChromeInFullScreenMode.class);

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void homeWorkTest3() {
        By signInButton = By.xpath("//button[@class = 'header3__button-sign-in']");
        By inputEmail = By.xpath("//input[@type='text' and contains(@placeholder, 'Электронная почта')]");
        By inputPass = By.xpath("//input[@type='password' and contains(@placeholder, 'Введите пароль')]");
        By enterButton = By.xpath("//*[@class='new-log-reg__form js-login']/descendant::button");

        driver.get(URL);
        driver.findElement(signInButton).click();
        driver.findElement(inputEmail).sendKeys(login);
        driver.findElement(inputPass).sendKeys(pass);
        driver.findElement(enterButton).click();
        for (Cookie x: driver.manage().getCookies()){
            log.info(x);
        }
    }

    @AfterEach
    public void close(){
        if (driver != null)
            driver.quit();
    }
}
