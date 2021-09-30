package mytests;

import configreader.ConfigPropReader;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Properties;

public class HomePageTest {
  ConfigPropReader configPropReader;
  Properties properties;
  DriverFactory driverFactory;
  WebDriver webDriver;
  HomePage homePage;

  @BeforeTest
  public void setup() {
    configPropReader = new ConfigPropReader();
    properties = configPropReader.initLanguageProperties("english");
    driverFactory = new DriverFactory();
    webDriver = driverFactory.initWebDriver("chrome", properties);
    homePage = new HomePage(webDriver);
  }

  @Test
  public void headerTest() {
    Assert.assertTrue(homePage.isHeaderExist(properties.getProperty("header")));
  }

  @Test
  public void contactFooterTest() {
    Assert.assertTrue(homePage.isContactExist(properties.getProperty("contact")));
  }

  @AfterTest
  public void tearDown() {
    webDriver.quit();
  }
}
