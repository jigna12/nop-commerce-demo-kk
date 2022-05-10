package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import com.nopcommerce.demo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Jay Vaghani
 */
public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    //@BeforeMethod(alwaysRun = true)

    @BeforeMethod(groups = {"sanity","smoke","regression"})
    public void setUp(){
        selectBrowser(browser);
    }

   // @AfterMethod(alwaysRun = true)
    @AfterMethod(groups = {"sanity","smoke","regression"})
    public void tearDown(){
        closeBrowser();
    }
}
