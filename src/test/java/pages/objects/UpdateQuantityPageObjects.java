package pages.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.BasePage;

import java.util.Map;

public class UpdateQuantityPageObjects {
    private WebDriver driver;
    public BasePage basePage;

    //Title name
    private String updateQuantityTitle = "Odoo - Update Quantity";
    //Locators
    @FindBy(xpath = "//button[@name='action_update_quantity_on_hand']")
    private WebElement UpdateQuantityTab;

    @FindBy(xpath = "//button[@data-original-title='Create record']")
    private WebElement CreateBtn;

    @FindBy(xpath = "//input[@name='inventory_quantity']")
    private WebElement QuantityField;

    @FindBy(xpath = "//button[@title='Save record']")
    private WebElement SaveBtn;

    @FindBy(xpath = "//td[@name='inventory_diff_quantity']")
    private WebElement InventoryDiffQuantityField;


    //Constructor
    public UpdateQuantityPageObjects(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void selectUpdateQuantityTab(){
        basePage.click(UpdateQuantityTab);
    }
    public void clickSaveBtn(){
        basePage.click(SaveBtn);
    }
    public void clickCreateBtn(){
        basePage.click(CreateBtn);
    }

    public void inputQuantity(String number){
        basePage.writeText(QuantityField,number);
    }

    public void assertRecordIsUpdated(String quantity){
        basePage.waitVisibility(InventoryDiffQuantityField);
        double actualData = Double.parseDouble(InventoryDiffQuantityField.getText());
        double expectedData = Double.parseDouble(quantity);
        Assert.assertEquals( actualData,expectedData);
    }
}
