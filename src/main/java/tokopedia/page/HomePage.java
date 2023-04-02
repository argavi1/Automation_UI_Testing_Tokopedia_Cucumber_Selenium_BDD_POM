package tokopedia.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // By Locators
    private By searchBarLocator = By.xpath("//input[@type='search']");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Methods/ Actions
    public void inputProduct(String productName) {
        WebElement productInput = driver.findElement(searchBarLocator);
        productInput.sendKeys(productName);
        productInput.sendKeys(Keys.ENTER);
    }

}