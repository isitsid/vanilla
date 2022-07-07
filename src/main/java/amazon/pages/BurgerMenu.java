package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BurgerMenu {
    static By appliancesButton = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a/div");
    static By televisionButton = By.xpath("//a[contains(text(),'Televisions')]");
    static By brandButton = By.xpath("//*/text()[normalize-space(.)='Samsung']/parent::*");
    private final WebDriver driver;


    public BurgerMenu(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public void clickOnDepartment(String selection){
        // TOD0: modify selector based on selection
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(appliancesButton));
        driver.findElement(appliancesButton).click();
    }

    public void clickOnSubsection(String subsection){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(televisionButton));
        driver.findElement(televisionButton).click();
    }

    public void clickOnBrand(String brand){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(brandButton));
        driver.findElement(brandButton).click();
    }
}
