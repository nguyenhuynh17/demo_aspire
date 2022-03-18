package pages.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import utilities.Data;

public class InventoryMenuPageObjects {
    private WebDriver driver;
    public BasePage basePage;
    public Data data = new Data();

    //Locators

    //Main menu: Overview, Operations, Products, Reporting, Configuration
    @FindBy(xpath = "//a[@title='Home menu']")
    private WebElement HomeMenuBtn;

    @FindBy(xpath = "//a[@title='Overview']")
    private WebElement OverviewBtn;

    @FindBy(xpath = "//button[@title='Operations']")
    private WebElement OperationsBtn;

    @FindBy(xpath = "//button[@title='Products']")
    private WebElement ProductsBtn;

    @FindBy(xpath = "//button[@title='Reporting']")
    private WebElement ReportingBtn;

    @FindBy(xpath = "//button[@title='Configuration']")
    private WebElement ConfigurationBtn;

    // Configuration Options: Warehouses, Locations, Routes, Rules, Operations Types, Putaway Rules, Product
    // Categories, Product Packagings, Reordering Rules, UoM Categories

    @FindBy(xpath = "//a[text()='Warehouses']")
    private WebElement ConfigWarehousesOption;

    @FindBy(xpath = "//a[text()='Locations']")
    private WebElement ConfigLocationsOption;

    @FindBy(xpath = "//a[text()='Routes']")
    private WebElement ConfigRoutesOption;

    @FindBy(xpath = "//a[text()='Rules']")
    private WebElement ConfigRulesOption;

    @FindBy(xpath = "//a[text()='Operations Types']")
    private WebElement ConfigOperationOption;

    @FindBy(xpath = "//a[text()='Putaway Rules']")
    private WebElement ConfigPutawayOption;

    @FindBy(xpath = "//a[text()='Product Categories']")
    private WebElement ConfigProCateOption;

    @FindBy(xpath = "//a[text()='Product Packagings']")
    private WebElement ConfigProPackOption;

    @FindBy(xpath = "//a[text()='Reordering Rules']")
    private WebElement ConfigReorderingOption;

    @FindBy(xpath = "//a[text()='UoM Categories']")
    private WebElement ConfigUoMCateOption;

    // Reporting Options: Warehouse Analysis, Inventory Report, Forecasted Inventory, Product Moves
    @FindBy(xpath = "//a[text()='Warehouse Analysis']")
    private WebElement ReportingWarehouseOption;

    @FindBy(xpath = "//a[text()='Inventory Report']")
    private WebElement ReportingInventoryOption;

    @FindBy(xpath = "//a[text()='Forecasted Inventory']")
    private WebElement ReportingForecastedOption;

    @FindBy(xpath = "//a[text()='Product Moves']")
    private WebElement ReportingProductOption;

    // Products Options: Products, SerialNumbers
    @FindBy(xpath = "//a[text()='Products']")
    private WebElement ProductsProductsOption;

    @FindBy(xpath = "//a[text()='Lots/Serial Numbers']")
    private WebElement ProductsSerialNumbersOption;

    // Operator Options: Transfers, Replenishment, Inventory Adjustments, Scrap, Run Scheduler
    @FindBy(xpath = "//a[text()='Transfers']")
    private WebElement OperationsTransferOption;

    @FindBy(xpath = "//a[text()='Replenishment']")
    private WebElement OperationsReplenishmentOption;

    @FindBy(xpath = "//a[text()='Inventory Adjustments']")
    private WebElement OperationsInventoryAdjustmentsOption;

    @FindBy(xpath = "//a[text()='Scrap']")
    private WebElement OperationsScrapOption;

    @FindBy(xpath = "//a[text()='Run Scheduler']")
    private WebElement OperationsRunSchedulerOption;

    // Page title labels
    @FindBy(xpath = "//title[text()='Odoo - Products']")
    private WebElement ProductMainLbl;

    @FindBy(xpath = "//title[text()='Odoo - Inventory Overview']")
    private WebElement InventoryMainLbl;


    //Constructor
    public InventoryMenuPageObjects(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void selectOverviewButton() {
        basePage.click(OverviewBtn);
    }

    public void selectProductsButton() {
        basePage.click(ProductsBtn);
    }

    public void selectOptionProductsFromProductsMenu(){
        selectProductsButton();
        basePage.click(ProductsProductsOption);
    }

    public void clickHomeMenuBtn(){
        basePage.click(HomeMenuBtn);
    }
    public void assertProductMainLblIsDisplayed(){
        basePage.waitTitleContains(data.productsTitle);
    }

    public void assertInventoryMainLblIsDisplayed(){
        basePage.waitTitleContains(data.inventoryTitle);
    }
    public void assertHomeMenuLblIsDisplayed(){
        basePage.waitTitleContains(data.homeTitle);
    }

}
