package pages.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utilities.Data;

import java.util.Map;

public class InventoryProductCreatePageObjects {
    private WebDriver driver;
    public BasePage basePage;
    public Data data = new Data();

    //Locators
    @FindBy(xpath = "//button[@title='Save record']")
    private WebElement SaveBtn;

    @FindBy(xpath = "//button[@title='Discard record'")
    private WebElement DiscardBtn;

    //Product information
    @FindBy(xpath = "//input[@name='name']")
    private WebElement ProductNameField;

    @FindBy(xpath = "//select[@name='detailed_type']")
    private WebElement ProductTypeDDL;

    @FindBy(xpath = "//div[@name='uom_id']//input")
    private WebElement UnitOfMeasureField;

    @FindBy(xpath = "//div[@name='list_price']//input")
    private WebElement SalesPriceField;

    @FindBy(xpath = "//div[@name='categ_id']//input")
    private WebElement ProductCategoryField;

    @FindBy(xpath = "//*[text()='Action']")
    private WebElement ActionBtn;

    //Constructor
    public InventoryProductCreatePageObjects(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }



    public Select getProductTypeOptions() {
        return new Select(ProductTypeDDL);
    }

    public void selectProductType(String typeName){
        Select options = getProductTypeOptions();
        options.selectByVisibleText(typeName);
    }

    public void inputProductName(String data) throws InterruptedException {
        basePage.writeTextWithSpanTime(ProductNameField,data);
    }

    public void inputUnitOfMeasure(String data) throws InterruptedException {
        UnitOfMeasureField.click();
        basePage.writeTextWithSpanTime(UnitOfMeasureField,data);
    }

    public void inputSalesPrice(String data) throws InterruptedException {
        basePage.writeTextWithSpanTime(SalesPriceField,data);
    }

    public void inputProductCategory(String data) throws InterruptedException {
        basePage.writeTextWithSpanTime(ProductCategoryField,data);
    }

    public void clickSaveBtn(){
        SaveBtn.click();
    }

    public void inputProductInfo(Map<String, String> productObj) throws InterruptedException {
        inputProductName(productObj.get("product_name"));
        selectProductType(productObj.get("product_type"));
        inputUnitOfMeasure(productObj.get("product_unit_of_measure"));
        inputSalesPrice(productObj.get("sales_price"));
        inputProductCategory(productObj.get("product_category"));
    }

    public void clickDiscardBtn(){
        DiscardBtn.click();
    }

    public void assertActionBtnIsDisplayed(){
        basePage.waitVisibility(ActionBtn);
    }

}
