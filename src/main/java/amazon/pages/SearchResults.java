package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SearchResults {

    static By secondSelectedItem = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]");
    private final WebDriver driver;


    public SearchResults(WebDriver driver){

        this.driver = driver;

    }

    public void clickOnProduct(int selection){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondSelectedItem));
        driver.findElement(secondSelectedItem).click();

        // Switch to window
        JavascriptExecutor js = (JavascriptExecutor)driver;
        ArrayList<String> all = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(all.get(1));

    }
}
