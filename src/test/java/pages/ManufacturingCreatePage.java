package pages;

import org.openqa.selenium.WebDriver;
import pages.objects.ManufacturingCreatePageObjects;
import pages.objects.ManufacturingMainPageObjects;

import java.util.Map;

public class ManufacturingCreatePage {
    private WebDriver driver;
    MainMenuPage mainMenuPage;
    ManufacturingMainPage manufacturingMainPage;
    ManufacturingCreatePageObjects manufacturingCreatePageObjects;

    // Constructor
    public ManufacturingCreatePage(WebDriver driver) {
        this.driver=driver;
        mainMenuPage = new MainMenuPage(driver);
        manufacturingMainPage = new ManufacturingMainPage(driver);
        manufacturingCreatePageObjects = new ManufacturingCreatePageObjects(this.driver);
    }

    public void createManufacturingOrder(Map<String, String> productObj){
        navigateToManufacturingCreatePage();
        manufacturingCreatePageObjects.inputOrderInfo(productObj);
        manufacturingCreatePageObjects.clickSaveBtn();
        manufacturingCreatePageObjects.assertSavingOrderSuccessfully();
    }

    public void markOrderAsDoneProcess(Map<String, String> productObj){
        manufacturingCreatePageObjects.markOrderStatusToDone();
        manufacturingCreatePageObjects.assertOrderInfoIsCorrect(productObj.get("product_name"));
    }

    public void navigateToManufacturingCreatePage(){
        mainMenuPage.navigateToHomeMenu();
        mainMenuPage.navigateToManufacturingPage();
        manufacturingMainPage.navigateToManufacturingCreatePage();
    }
}
