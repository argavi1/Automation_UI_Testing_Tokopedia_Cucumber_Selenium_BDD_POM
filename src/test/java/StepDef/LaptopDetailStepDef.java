package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tokopedia.page.HomePage;
import tokopedia.page.LaptopListPage;
import tokopedia.page.LaptopDetailPage;
import java.time.Duration;


public class LaptopDetailStepDef {

    private WebDriver driver;
    private HomePage homePage;
    private LaptopListPage laptopListPage;
    private LaptopDetailPage laptopDetailPage;


    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am on Tokopedia website home page")
    public void i_am_on_tokopedia_website_home_page() {
        driver.get("https://www.tokopedia.com/");
        homePage = new HomePage(driver);
    }

    @And("I search Laptop Asus on searching bar")
    public void i_search_laptop_asus_on_searching_bar() {
        homePage.inputProduct("Laptop Asus");
    }

    @And("I directed into List of Laptop Asus page")
    public void i_directed_into_list_of_laptop_asus_page() {
        // Wait for the 'Product' tab to be visible before verified
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Produk']")));
        Assert.assertTrue(productTab.isDisplayed());

        // Verify that the 'Product' tab is displayed
        laptopListPage = new LaptopListPage(driver);
        Assert.assertTrue(laptopListPage.checkProductTab());
    }

    @When("I click detail product")
    public void i_click_detail_product() {

        laptopListPage.clickProduct();
    }


    @Then("I directed into product's detail page")
    public void i_directed_into_products_detail_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the 'Detail' tab to be visible before verified
        WebElement tabDetailProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Detail']")));
        Assert.assertTrue(tabDetailProduct.isDisplayed());

        // Wait for the 'Products name' to be visible before verified
        WebElement productsName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-testid='lblPDPDetailProductName']")));
        Assert.assertTrue(productsName.isDisplayed());

        // Verify that the 'Detail' tab and product name are displayed
        laptopDetailPage = new LaptopDetailPage(driver);
        Assert.assertTrue(laptopDetailPage.checkTabDetailProduct());
        Assert.assertTrue(laptopDetailPage.checkProductName());
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}
