package utilities;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public Map<String,String> generateProductObj(){
        Map<String, String> productObj = new HashMap<>();
        productObj.put("product_name", generateRandomString(10));
        productObj.put("product_unit_of_measure", "kg");
        productObj.put("sales_price", "10");
        productObj.put("product_category", "All");
        productObj.put("product_type", "Storable Product");
        productObj.put("product_quantity", "20");
        return productObj;
    }

    public Map<String,String> updateProductObj(Map<String, String> productObj, String key, String value){
        try {
            productObj.replace(key, value);
            return productObj;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String generateRandomString(int length){
        String generatedString = RandomStringUtils.randomAlphanumeric(length);
        return generatedString;
    }

    //Title name
    public String manuTitle = "Odoo - Manufacturing Orders";
    public String manuCreateTitle = "Odoo - New";
    public String inventoryTitle = "Odoo - Inventory Overview";
    public String productsTitle = "Odoo - Products";
    public String homeTitle = "Odoo";
    public String productCreateTitle = "Odoo - New";
}
