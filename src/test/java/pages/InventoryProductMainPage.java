package pages;

import org.openqa.selenium.WebDriver;
import pages.objects.InventoryProductMainPageObjects;

public class InventoryProductMainPage {
    private WebDriver driver;
    InventoryProductMainPageObjects inventoryProductMainPageObjects;

    // Constructor
    public InventoryProductMainPage(WebDriver driver) {
        this.driver=driver;
        inventoryProductMainPageObjects = new InventoryProductMainPageObjects(this.driver);
    }

    public void navigateToProductsCreatePage(){
        inventoryProductMainPageObjects.clickCreateButton();
        inventoryProductMainPageObjects.assertCreateProductLblIsDisplayed();
    }

}
