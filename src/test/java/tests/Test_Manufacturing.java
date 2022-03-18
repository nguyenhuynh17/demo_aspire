package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import pages.*;
import utilities.Data;
import utilities.Retry;
import utilities.Setup;


public class Test_Manufacturing {
    WebDriver driver;
    Setup setup = new Setup();
    LoginPage loginPage;
    InventoryProductCreatePage inventoryProductCreatePage;
    ManufacturingCreatePage manufacturingCreatePage;

    @Parameters({"browserName", "browserVer"})
    @BeforeTest
    public void SetupTest(String browserName, String browserVer) throws IOException {
        this.driver = setup.OpenBrowser(browserName, browserVer);
        loginPage = new LoginPage(driver);
        inventoryProductCreatePage = new InventoryProductCreatePage(driver);
        manufacturingCreatePage = new ManufacturingCreatePage(driver);

        //1. Login to web application
        loginPage.LoginWithValidCredential();
    }

    @Test(retryAnalyzer = Retry.class)
    void Test_MarkManufacturingOrderDone() throws InterruptedException {

        //1 Generate Product object information
        Data dataObj = new Data();
        Map<String, String> productObj = dataObj.generateProductObj();

        //2 Create product object
        productObj = inventoryProductCreatePage.processToCreateProduct(productObj);

        //3.1 Navigate to `Manufacturing` feature, and create a new Manufacturing Order item for the created Product
        // on step #2
        manufacturingCreatePage.createManufacturingOrder(productObj);

        //3.2 Update the status to Done and validate the information
        manufacturingCreatePage.markOrderAsDoneProcess(productObj);
    }

    @AfterTest
    public void TearDownTest(){
        setup.TearDown(driver);
    }
}
