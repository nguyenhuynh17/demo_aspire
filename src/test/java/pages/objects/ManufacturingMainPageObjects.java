package pages.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.Data;

public class ManufacturingMainPageObjects {
    private WebDriver driver;
    public BasePage basePage;
    public Data data = new Data();
    //Locators

    @FindBy(xpath = "//button[@data-original-title='Create record']")
    private WebElement CreateBtn;

    //Constructor
    public ManufacturingMainPageObjects(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickCreateBtn(){
        basePage.click(CreateBtn);
    }

    public void assertManufacturingCreateTitleIsDisplayed(){
        basePage.waitTitleContains(data.manuCreateTitle);
    }

}
