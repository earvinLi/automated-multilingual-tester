package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

public class HomePage {
  private WebDriver webDriver;
  private ElementUtil elementUtil;

  public HomePage(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.elementUtil = new ElementUtil(webDriver);
  }

  private WebElement getHeaderElement(String headerValue) {
    String headerXpathValue = "//a[contains(text(), '" + headerValue + "')]";
    return elementUtil.getWebElement("xpath", headerXpathValue);
  }

  public boolean isHeaderExist(String headerValue) {
    String header = getHeaderElement(headerValue).getText();
    System.out.println(header);
    return getHeaderElement(headerValue).isDisplayed();
  }

  private WebElement getContactElement(String contactValue) {
    String contactXpathValue = "//a[contains(text(), '" + contactValue + "')]";
    return elementUtil.getWebElement("xpath", contactXpathValue);
  }

  public boolean isContactExist(String contactValue) {
    String contact = getContactElement(contactValue).getText();
    System.out.println(contact);
    return getContactElement(contactValue).isDisplayed();
  }
}
