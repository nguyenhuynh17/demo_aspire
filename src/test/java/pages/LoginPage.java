package pages;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import pages.objects.LoginPageObjects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {
    private WebDriver driver;
    LoginPageObjects loginObj;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        loginObj = new LoginPageObjects(this.driver);
    }

    public Map<String, String> getCredentials() throws IOException {

        //Read Credential file to get email and password data
        String data = new String(Files.readAllBytes(Paths.get("src/main/resources/.CREDENTIALS.json")));
        JSONObject credentialObj = new JSONObject(data);

        String email = credentialObj.getString("email");
        String password = credentialObj.getString("password");

        //Add email and password to userCredential object
        Map<String, String> userCredential = new HashMap<>();
        userCredential.put("email", email);
        userCredential.put("password", password);

        return userCredential;
    }

    public void InputCredential(Map<String, String> userCredential){
        loginObj.inputEmailField(userCredential.get("email"));
        loginObj.inputPasswordField(userCredential.get("password"));
    }

    public void LoginWithValidCredential() throws IOException {
        Map<String, String> userCredential = getCredentials();
        InputCredential(userCredential);
        loginObj.clickOnLoginButton();
        loginObj.assertDiscussLblIsDisplayed();
    }
}
