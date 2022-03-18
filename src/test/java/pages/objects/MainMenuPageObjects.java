package pages.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class MainMenuPageObjects {
    private WebDriver driver;
    public BasePage basePage;
    //Locators
    @FindBy(xpath = "//a[@id='result_app_0']")
    private WebElement DiscussBtn;

    @FindBy(xpath = "//a[@id='result_app_1']")
    private WebElement InventoryBtn;

    @FindBy(xpath = "//a[@id='result_app_2']")
    private WebElement ManufacturingBtn;

    //Constructor
    public MainMenuPageObjects(WebDriver driver){
        this.driver=driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void selectDiscussMenu(){
        basePage.click(DiscussBtn);
    }

    public void selectInventoryMenu(){
        basePage.click(InventoryBtn);
    }

    public void selectManufacturingMenu(){
        basePage.click(ManufacturingBtn);
    }
}
