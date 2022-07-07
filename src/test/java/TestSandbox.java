import amazon.config.EnvFactory;
import amazon.pages.BurgerMenu;
import amazon.pages.FilterOptions;
import amazon.pages.Homepage;
import amazon.factories.DriverFactory;
import amazon.pages.ProductDetail;
import amazon.pages.SearchResults;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterAll;


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
        assertEquals("Online Shopping site   in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
    }
    @Test
    void navigateToHamburger(){

        // Step 1. Open https://www.amazon.in/.
        driver.get(HOME_PAGE_URL);

        // Step 2. Click on the hamburger menu in the top left corner.
        Homepage homePage = new Homepage(driver);
        homePage.clickOnHamburgerButton();

        // Step 3. Scroll own and then Click on the TV, Appliances and Electronics link under Shop by Department section.
        BurgerMenu burgerMenu = new BurgerMenu(driver);
        burgerMenu.clickOnDepartment("TV, Appliances and Electronics");

        // Step 4. Then click on Televisions under Tv, Audio & Cameras sub section.
        burgerMenu.clickOnSubsection("Televisions");

        // Step 5. Scroll down and filter the results by Brand ‘Samsung’.
        burgerMenu.clickOnBrand("Samsung");

        // Step 6. Sort the Samsung results with price High to Low.
        FilterOptions filterMenu = new FilterOptions(driver);
        filterMenu.ClickOnFilter("Price: High to Low");

        // Step 7. Click on the second highest priced item (whatever that maybe at the time of automating).
        // Step 8. Switch the Window
        SearchResults resultsPage = new SearchResults(driver);
        resultsPage.clickOnProduct(2);

        // Step 9. Assert that “About this item” section is present and log this section text to console/report.
        ProductDetail productDetail = new ProductDetail(driver);
        assertEquals("About this item", productDetail.getAboutLabel());
        System.out.println(productDetail.aboutThisItemText());

    }

    @AfterAll
    public static void afterAllTestMethods() {
        // Invoked once after all test methods"
        driver.close();
        driver.quit();
    }
}
