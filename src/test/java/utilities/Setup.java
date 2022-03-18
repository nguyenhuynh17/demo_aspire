package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
    WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://aspireapp.odoo.com/web/login";

    public WebDriver createDriver(String driverName, String browserVersion){
       WebDriver driver = null;
        try {
           WebDriverManager wdm;
           if(driverName.equals("chrome")){
               wdm = WebDriverManager.chromedriver()
                       .driverVersion(browserVersion);
               wdm.setup();
               driver = new ChromeDriver();
           }

           if(driverName.equals("firefox")){
               wdm = WebDriverManager.firefoxdriver()
                       .driverVersion(browserVersion);
               wdm.setup();
               driver = new FirefoxDriver();
           }

           if(driverName.equals("edge")){
               wdm = WebDriverManager.edgedriver()
                       .driverVersion(browserVersion);
               wdm.setup();
               driver = new EdgeDriver();
           }

           return driver;
       }
        catch (Exception e){
            e.printStackTrace();
        }
       return driver;
    }

    public WebDriver OpenBrowser(String browserName, String browserVersion){
        driver = createDriver(browserName, browserVersion);

        //Open browser
        driver.get(PAGE_URL);

        //Mazimize current window
        driver.manage().window().maximize();
        return driver;
    }

    public void TearDown(WebDriver driver){
//        driver.close();
        driver.quit();
    }
}
