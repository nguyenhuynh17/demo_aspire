package pages.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.Data;

public class InventoryProductMainPageObjects {
    private WebDriver driver;
    public BasePage basePage;
    public Data data = new Data();

    //Locators

    @FindBy(xpath = "//button[@title='Create record']")
    private WebElement CreateBtn;

    @FindBy(xpath = "//button[@title='Search for records'")
    private WebElement SearchField;



    //Constructor
    public InventoryProductMainPageObjects(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void inputSearchString(String data){
        basePage.writeText(SearchField,data);
    }
    public void searchProduct(String searchData){
        inputSearchString(searchData);
        driver.findElement(By.xpath("//ul[@role='menu']/li[1]/a/strong[text()='"+searchData+"']")).click();
    }

    public void clickCreateButton(){
        basePage.click(CreateBtn);
    }

    public void assertCreateProductLblIsDisplayed(){
        basePage.waitTitleContains(data.productCreateTitle);
    }

}
