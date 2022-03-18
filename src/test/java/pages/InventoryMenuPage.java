package pages;

import org.openqa.selenium.WebDriver;
import pages.objects.InventoryMenuPageObjects;


public class InventoryMenuPage {
    private WebDriver driver;
    InventoryMenuPageObjects inventoryMenuPageObjects;

    // Constructor
    public InventoryMenuPage(WebDriver driver) {
        this.driver=driver;
        inventoryMenuPageObjects = new InventoryMenuPageObjects(this.driver);
    }

    public void navigateToProductsPage(){
        inventoryMenuPageObjects.selectOptionProductsFromProductsMenu();
        inventoryMenuPageObjects.assertProductMainLblIsDisplayed();
    }

//    public void navigateToHomeMenu(){
//        inventoryMenuPageObjects.clickHomeMenuBtn();
//        inventoryMenuPageObjects.assertHomeMenuLblIsDisplayed();
//    }
}
