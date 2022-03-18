package pages;

import org.openqa.selenium.WebDriver;
import pages.objects.InventoryMenuPageObjects;
import pages.objects.MainMenuPageObjects;


public class MainMenuPage {
    private WebDriver driver;
    MainMenuPageObjects mainMenuPageObjects;
    InventoryMenuPageObjects inventoryMenuPageObjects;

    // Constructor
    public MainMenuPage(WebDriver driver) {
        this.driver=driver;
        mainMenuPageObjects = new MainMenuPageObjects(this.driver);
        inventoryMenuPageObjects = new InventoryMenuPageObjects(this.driver);

    }

    public void navigateToDiscussPage(){
        mainMenuPageObjects.selectDiscussMenu();
        // writing assert title discuss menu later
    }

    public void navigateToManufacturingPage(){
        mainMenuPageObjects.selectManufacturingMenu();
        // writing assert title Manufacturing menu later
    }

    public void navigateToInventoryPage(){
        mainMenuPageObjects.selectInventoryMenu();
        inventoryMenuPageObjects.assertInventoryMainLblIsDisplayed();
    }

    public void navigateToHomeMenu(){
        inventoryMenuPageObjects.clickHomeMenuBtn();
        inventoryMenuPageObjects.assertHomeMenuLblIsDisplayed();
    }

}
