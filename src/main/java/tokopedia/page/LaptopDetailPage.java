package tokopedia.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopDetailPage {

    private WebDriver driver;

    // By Locators
    private By TabDetailProductLocator = By.xpath("//p[text()='Detail']");
    private By ProductsNameLocator = By.xpath("//h1[@data-testid='lblPDPDetailProductName']");

    // Constructor
    public LaptopDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Methods/ Actions
    public boolean checkTabDetailProduct() {
        return driver.findElement(TabDetailProductLocator).isDisplayed();
    }

    public boolean checkProductName() {
        return driver.findElement(ProductsNameLocator).isDisplayed();
    }
}
