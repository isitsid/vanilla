package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterOptions {

    //static By filterButton = By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[1]");
    static By filterButton = By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[2]/div/div/form/span/span/span/span");
    static By priceHighToLow = By.xpath("//*[@id=\"s-result-sort-select_2\"]");
    private final WebDriver driver;


    public FilterOptions(WebDriver driver){

        this.driver = driver;

    }


    public void ClickOnFilter(String filter){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterButton));
        driver.findElement(filterButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(priceHighToLow));
        driver.findElement(priceHighToLow).click();

    }


}
