package pages;

import org.openqa.selenium.WebDriver;
import pages.objects.UpdateQuantityPageObjects;


public class UpdateQuantityPage {
    private WebDriver driver;
    UpdateQuantityPageObjects updateQuantityPageObjects;

    // Constructor
    public UpdateQuantityPage(WebDriver driver) {
        this.driver=driver;
        updateQuantityPageObjects = new UpdateQuantityPageObjects(this.driver);
    }

    public void createQuantityRecord(String quantity){
        updateQuantityPageObjects.selectUpdateQuantityTab();
        updateQuantityPageObjects.clickCreateBtn();
        updateQuantityPageObjects.inputQuantity(quantity);
        updateQuantityPageObjects.clickSaveBtn();
        updateQuantityPageObjects.assertRecordIsUpdated(quantity);
    }
}
