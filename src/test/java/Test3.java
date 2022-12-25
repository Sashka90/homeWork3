import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Test3 {

    private WebDriver driver;

    private String login = "ceyogo9446@bitvoo.com";
    private String pass = "Ceyogo9446!";
    private static final String URL = "https://otus.ru";

    private static Logger log = LogManager.getLogger(Test3.class);

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void homeWorkTest3() {
        By signInButton = By.xpath("//button[@class = 'header3__button-sign-in']");
        By inputEmail = By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Электронная почта']");
        By inputPass = By.xpath("//*[@class='new-log-reg__form js-login']/descendant::*[@placeholder='Введите пароль']");
        By enterButton = By.xpath("//*[@class='new-log-reg__form js-login']/descendant::button");

        driver.get(URL);
        driver.findElement(signInButton).click();
        driver.findElement(inputEmail).sendKeys(login);
        driver.findElement(inputPass).sendKeys(pass);
        driver.findElement(enterButton).click();
        ArrayList<Cookie> cookies = new ArrayList<Cookie>();
        cookies.addAll(driver.manage().getCookies());
        for (Cookie x : cookies){
            log.info(x);
        }
    }

    @AfterEach
    public void close(){
        if (driver != null)
            driver.quit();
    }
}
