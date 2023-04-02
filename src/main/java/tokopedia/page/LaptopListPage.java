package tokopedia.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaptopListPage {

    private WebDriver driver;

    // By Locators
    private By ProductTabLocator = By.xpath("//span[text()='Produk']");
    private By ProductSectionLocator = By.xpath("(//div[@class='css-y5gcsw'])[5]");


    // Constructor
    public LaptopListPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Methods/ Actions
    public boolean checkProductTab() {
        return driver.findElement(ProductTabLocator).isDisplayed();
    }

    public void clickProduct() {
        // Scroll down by 500 pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // WebElement productSection = driver.findElement(ProductSectionLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-y5gcsw'])[5]")));
        productSection.click();
    }

}
