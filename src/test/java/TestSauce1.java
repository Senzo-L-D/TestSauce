import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSauce1 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("web-driver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.saucedemo.com/");
        WebElement inputsLink = driver.findElement(By.id("login-button"));
        driver.manage().window().maximize();
    }

    @Test (priority = 1)
    //Get to SwagLabs
    public void loginPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    //adding item to cart
    public void addItemToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(1000);
    }


    @Test (priority = 3)
    //viewing basket
    public void goToBasket() throws InterruptedException {
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(1000);
    }

    @Test (priority = 4)
    //checkout to bill page
    public void checkOut(){
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @Test (priority = 5)
    //Fill personal information
    public void personalInfo() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Senzo");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Damane");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("7140");
        Thread.sleep(1000);
    }

    @Test (priority = 6)
    //payment
    public void continueToPay() throws InterruptedException {
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 7)
    //done
    public void finish() throws InterruptedException {
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
