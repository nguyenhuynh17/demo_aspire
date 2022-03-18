package pages.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.Data;

public class ManufacturingMenuPageObjects {
    private WebDriver driver;
    public BasePage basePage;
    public Data data = new Data();

    //Locators

    //Main menu: Overview, Operations, Products, Reporting, Configuration
    @FindBy(xpath = "//a[@title='Home menu']")
    private WebElement HomeMenuBtn;

    @FindBy(xpath = "//button[@title='Operations']")
    private WebElement OperationsBtn;

    @FindBy(xpath = "//button[@title='Planning']")
    private WebElement PlanningBtn;

    @FindBy(xpath = "//button[@title='Reporting']")
    private WebElement ReportingBtn;

    @FindBy(xpath = "//button[@title='Products']")
    private WebElement ProductsBtn;

    //Constructor
    public ManufacturingMenuPageObjects(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    public void selectProductsButton() {
        basePage.click(ProductsBtn);
    }


    public void clickHomeMenuBtn(){
        basePage.click(HomeMenuBtn);
    }

    public void assertManufacturingTitleIsDisplayed(){
        basePage.waitTitleContains(data.manuTitle);
    }
}
