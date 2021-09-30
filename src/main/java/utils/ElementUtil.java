package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
  private WebDriver webDriver;

  public ElementUtil(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public WebElement getWebElement(By locator) {
    return webDriver.findElement(locator);
  }

  public WebElement getWebElement(String locatorType, String locatorValue) {
    return webDriver.findElement(getBy(locatorType, locatorValue));
  }

  public By getBy(String locatorType, String locatorValue) {
    By locator = null;

    switch (locatorType.toLowerCase()) {
      case "id" -> locator = By.id(locatorValue);
      case "name" -> locator = By.name(locatorValue);
      case "xpath" -> locator = By.xpath(locatorValue);
      case "css" -> locator = By.cssSelector(locatorValue);
      case "linkText" -> locator = By.linkText(locatorValue);
    }

    return locator;
  }
}
