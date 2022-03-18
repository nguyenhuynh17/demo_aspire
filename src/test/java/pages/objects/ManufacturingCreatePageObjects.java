package pages.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import utilities.Data;

import java.util.Map;

public class ManufacturingCreatePageObjects {
    private WebDriver driver;
    public BasePage basePage;
    //Locators

    @FindBy(xpath = "//li[@class='ui-menu-item']/a[1]")
    private WebElement ProductItem;

    @FindBy(xpath = "//div[@name='product_id']//input")
    private WebElement ProductNameField;

    @FindBy(xpath = "//input[@name='product_qty']")
    private WebElement ProductQuantityField;

    @FindBy(xpath = "//button[@title='Save record']")
    private WebElement SaveBtn;

    @FindBy(xpath = "//button[@name='action_confirm']")
    private WebElement ConfirmBtn;

    @FindBy(xpath = "//button[@data-original-title='Additional actions']")
    private WebElement AddActionsBtn;

    @FindBy(xpath = "(//button[@name='button_mark_done'])[4]")
    private WebElement MarkAsDoneBtn;

    @FindBy(xpath = "//span[text()='Ok']")
    private WebElement PopupOkBtn;

    @FindBy(xpath = "//span[text()='Apply']")
    private WebElement PopupApplyBtn;

    @FindBy(xpath = "//button[@aria-checked='true' and @data-value='done']")
    private WebElement CheckedDoneLbl;


    @FindBy(xpath = "//a[@name='product_id']/span")
    private WebElement ProductIDLbl;

    @FindBy(xpath = "//span[@name='product_qty']")
    private WebElement ProductQtyLbl;



    //Constructor
    public ManufacturingCreatePageObjects(WebDriver driver) {
        this.driver = driver;
        basePage = new BasePage(this.driver);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickPopupApplyBtn(){
        basePage.click(PopupApplyBtn);
    }

    public void clickPopupOkBtn(){
        basePage.click(PopupOkBtn);
    }

    public void inputProductName(String name){
        basePage.writeText(ProductNameField,name);
        basePage.click(ProductItem);
    }

    public void clickSaveBtn(){
        basePage.click(SaveBtn);
    }

    public void clickConfirmBtn(){
        basePage.click(ConfirmBtn);
    }

    public void clickMarkAsDoneBtn(){
        basePage.click(MarkAsDoneBtn);
    }

    public void assertSavingOrderSuccessfully(){
        basePage.waitVisibility(AddActionsBtn);
    }

    public void assertStatusOrderIsDone(){
        basePage.waitVisibility(CheckedDoneLbl);
    }

    public void assertOrderInfoIsCorrect(String productName){
        Assert.assertEquals(ProductIDLbl.getText(),productName);
    }

    public void inputOrderInfo(Map<String, String> productObj){
        inputProductName(productObj.get("product_name"));
    }

    public void markOrderStatusToDone(){
        clickConfirmBtn();
        clickMarkAsDoneBtn();
        clickPopupOkBtn();
        clickPopupApplyBtn();
        assertStatusOrderIsDone();
    }
}
