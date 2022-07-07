import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        driver.get(HOME_PAGE_URL);
        assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());
    }
    @Test
    void test_television_about_product(){
        driver.get(HOME_PAGE_URL);
        WebElement hamburgerButton = getElement("//*[@id=\"nav-hamburger-menu\"]");
        hamburgerButton.click();
        WebElement tvSubsectionButton = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a/div"));
        tvSubsectionButton.click();
        WebElement televisionButton = driver.findElement(By.xpath("//a[contains(text(),'Televisions')]"));
        televisionButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/text()[normalize-space(.)='Samsung']/parent::*")));

        WebElement samsungElement = driver.findElement(By.xpath("//*/text()[normalize-space(.)='Samsung']/parent::*"));
        samsungElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[1]")));
        WebElement sortbyFilter = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[1]"));
        sortbyFilter.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s-result-sort-select_2\"]")));
        WebElement sortbyPriceHighToLow = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_2\"]"));
        sortbyPriceHighToLow.click();
        // Second Search Result
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]")));
        WebElement searchItem = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]"));
        searchItem.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"feature-bullets\"]/h1")));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"feature-bullets\"]/ul")).getText());
        assertEquals("About this item", driver.findElement(By.xpath("//*[@id=\"feature-bullets\"]/h1")).getText());
    }

    private WebElement getElement(String locator) {
        return driver.findElement(By.xpath( "//*[@id=\"nav-hamburger-menu\"]"));
    }

    @AfterAll
    public static void afterAllTestMethods() {
        System.out.println("Invoked once after all test methods");
        driver.close();
        driver.quit();
    }
}


