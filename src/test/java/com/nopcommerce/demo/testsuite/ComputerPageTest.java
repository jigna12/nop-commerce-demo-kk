package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)

public class ComputerPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    /*3. ComputerPageTest
    Inside ComputerPageTest class create following testmethods
    1. verifyUserShouldNavigateToComputerPageSuccessfully()
    Click on Computer tab
    Verify "Computer" text*/
    @Test(groups = {"Sanity", "regrestion"}, priority = 2)
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        // Click on Computer tab
        homePage.selectMenu("Computers");
        //Verify "Computer" text
        computerPage.verifyComputerText("Computers");
    }


    /*2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    Click on Computer tab
    Click on Desktops link
    Verify "Desktops" text*/
    @Test(groups = {"smoke", "regression"}, priority = 0)
    public void verifyUserShouldNavigateToDesktopPageSuccessfully() {
        //Click on Computer tab
        homePage.selectMenu("Computers");
        //Click on Desktops link
        computerPage.clickOnDeskTopLink();
        //Verify "Desktops" text
        desktopsPage.verifyDesktopText("Desktops");
    }

    /*3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
    processor, String ram, String hdd, String os, String software)
    Click on Computer tab
    Click on Desktops link
    Click on product name "Build your own computer"
    Select processor "processor"
    Select RAM "ram"
    Select HDD "hdd"
    Select OS "os"
    Select Software "software"
    Click on "ADD TO CART" Button
    Verify message "The product has been added to your shopping cart"*/

    @Test(dataProvider = "credentials", dataProviderClass = TestData.class, groups = {"regression"}, priority = 1)
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        // Click on Computer tab
        homePage.selectMenu("Computers");
        // Click on Desktops link
        computerPage.clickOnDeskTopLink();
        // Click on product name "Build your own computer"
        desktopsPage.productFromDesktopPage("Build your own computer");
        //Select processor "processor",Select RAM "ram",Select HDD "hdd",Select OS "os",Select Software "software"
        buildYourOwnComputerPage.selectProcessorFromDropDown("processor");
        buildYourOwnComputerPage.selectRAMFromDropDown("ram");
        buildYourOwnComputerPage.selectHDDRadioButton("hdd");
        buildYourOwnComputerPage.selectOSRadioButton("os");
        buildYourOwnComputerPage.selectSoftwareCheckBox("software");
        //Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickAddToCart();
        //Verify message "The product has been added to your shopping cart
        buildYourOwnComputerPage.verifyAddToCartText();
    }
}




