package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetail {
    static By aboutProductLabel = By.xpath("//*[@id=\"feature-bullets\"]/h1");
    static By aboutProductDetail = By.xpath("//*[@id=\"feature-bullets\"]/ul");
    private final WebDriver driver;


    public ProductDetail(WebDriver driver){

        this.driver = driver;

    }

    public String getAboutLabel(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutProductLabel));
        return driver.findElement(aboutProductLabel).getText();
    }

    public String aboutThisItemText(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutProductDetail));
        return driver.findElement(aboutProductDetail).getText();
    }
}
