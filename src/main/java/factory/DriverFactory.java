package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driver;

    public WebDriver init_driver(String browser) {
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().deleteAllCookies();
            //driver.manage().window().maximize();
        }
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
