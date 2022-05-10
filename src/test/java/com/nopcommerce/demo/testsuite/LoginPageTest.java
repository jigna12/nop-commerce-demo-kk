package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        // creating Object. when my test run that time i will crate Object
        homePage = new HomePage();
        // intilize element runtime first
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }
 /*1.userShouldNavigateToLoginPageSuccessFully().
Click on login link
verify that "Welcome, Please Sign In!" message display*/

    @Test(groups = {"sanity", "regression"},priority = 0)
    public void userShouldNavigateToLoginPageSuccessFully() {
        //Click on login link
        homePage.clickOnLoginLink();
        //verify that "Welcome, Please Sign In!" message display
        loginPage.verifyWelcomText("Welcome,Please Sign In!");
    }

/*2. verifyTheErrorMessageWithInValidCredentials().
Click on login link
Enter EmailId
Enter Password
Click on Login Button
Verify that the Error message*/

    @Test(groups = {"sanity", "smoke", "regression"},priority = 1)
    public void verifyTheErrorMessageWithInvalidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.randomEmailId();
        //Enter Password

        loginPage.enterPassword("Prime");
        //Click on Login Button
        loginPage.ClickOnLoginButton();
        //Verify that the Error message
        loginPage.verifyErrorMessage("Login was unsucessful.Please correct the errors and try again");
    }

/*3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
Click on login link
Enter EmailId
Enter Password
Click on Login Button
Verify that LogOut link is display*/

    @Test(groups = {"sanity", "smoke", "regression"},priority = 2)
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.randomEmailId();
        //Enter Password
        loginPage.enterPassword("prime123");
        //Click on Login Button
        loginPage.ClickOnLoginButton();
        //Verify that LogOut link is display
        loginPage.verifyErrorMessage("Unsuccesful login");
    }

/*4. VerifyThatUserShouldLogOutSuccessFully()
Click on login link
Enter EmailId
Enter Password
Click on Login Button
Click on LogOut Link
Verify that LogIn Link Display*/

    @Test(groups = {"sanity", "smoke", "regression"},priority = 3)
    public void VerifyThatUserShouldLogOutSuccessFully() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.randomEmailId();
        //Enter Password
        loginPage.enterPassword("Prime123");
        //Click on Login Button
        loginPage.ClickOnLoginButton();
        //Verify that LogIn Link Display
        loginPage.verifyErrorMessage("Unsuccesful login");
    }
}

