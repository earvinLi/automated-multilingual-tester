package factory;

import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
  public WebDriver webDriver;

  public WebDriver initWebDriver(String browserName, Properties properties) {
    System.out.println("browser name is : " + browserName);

    switch (browserName.toLowerCase()) {
      case "chrome" -> {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
      }
      case "firefox" -> {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
      }
      case "safari" -> webDriver = new SafariDriver();
      default -> System.out.println("please pass the right browser name : " + browserName);
    }

    webDriver.get(properties.getProperty("url"));
    webDriver.manage().deleteAllCookies();
    webDriver.manage().window().maximize();

    return webDriver;
  }
}
