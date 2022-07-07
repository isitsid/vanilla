package amazon.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Homepage<driver> {

    static By hamburgerButton = By.xpath("//*[@id=\"nav-hamburger-menu\"]");
    private final WebDriver driver;


    public Homepage(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public void clickOnHamburgerButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerButton));
        driver.findElement(hamburgerButton).click();

    }

}
