package pages;
import org.openqa.selenium.WebDriver;
import pages.objects.InventoryProductCreatePageObjects;

import java.util.Map;

public class InventoryProductCreatePage {
    private WebDriver driver;
    InventoryProductCreatePageObjects inventoryProductCreatePageObjects;
    MainMenuPage mainMenuPage;
    InventoryMenuPage inventoryMenuPage;
    InventoryProductMainPage inventoryProductMainPage;
    UpdateQuantityPage updateQuantityPage;

    // Constructor
    public InventoryProductCreatePage(WebDriver driver) {
        this.driver=driver;
        mainMenuPage = new MainMenuPage(driver);
        inventoryMenuPage = new InventoryMenuPage(driver);
        inventoryProductMainPage = new InventoryProductMainPage(driver);
        updateQuantityPage = new UpdateQuantityPage(driver);
        inventoryProductCreatePageObjects = new InventoryProductCreatePageObjects(this.driver);
    }

    public void createProduct(Map<String, String> productObj) throws InterruptedException {
        inventoryProductCreatePageObjects.inputProductInfo(productObj);
        inventoryProductCreatePageObjects.clickSaveBtn();
        inventoryProductCreatePageObjects.assertActionBtnIsDisplayed();
    }

    private void goToCreateProductPage(){
        mainMenuPage.navigateToInventoryPage();
        inventoryMenuPage.navigateToProductsPage();
        inventoryProductMainPage.navigateToProductsCreatePage();
    }

    public Map<String, String> processToCreateProduct(Map<String, String> productObj) throws InterruptedException {
        //2.1 Go to Product create page
        goToCreateProductPage();
        //2.3 create a new product
        createProduct(productObj);
        //3. Update the quantity of new product is more than 10
        updateQuantityPage.createQuantityRecord(productObj.get("product_quantity"));

        return productObj;
    }
}
