package pages;

import org.openqa.selenium.WebDriver;
import pages.objects.InventoryProductMainPageObjects;
import pages.objects.ManufacturingMainPageObjects;

public class ManufacturingMainPage {
    private WebDriver driver;
    ManufacturingMainPageObjects manufacturingMainPageObjects;

    // Constructor
    public ManufacturingMainPage(WebDriver driver) {
        this.driver=driver;
        manufacturingMainPageObjects = new ManufacturingMainPageObjects(this.driver);
    }

    public void navigateToManufacturingCreatePage(){
        manufacturingMainPageObjects.clickCreateBtn();
        manufacturingMainPageObjects.assertManufacturingCreateTitleIsDisplayed();
    }
}
