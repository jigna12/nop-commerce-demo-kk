package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import com.nopcommerce.demo.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends Utility {

        HomePage homePage;
        LoginPage loginPage;
        RegisterPage registerPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt(){
            homePage = new HomePage();  // creating Object. when my test run that time i will crate Object
            loginPage = new LoginPage(); // intilize element runtime first
            registerPage = new RegisterPage();

/*1. verifyUserShouldNavigateToRegisterPageSuccessfully()
Click on Register Link
Verify "Register" text*/
        }
        @Test(groups = {"sanity","regression", "smoke"})
        public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
            //Click on Register Link
            homePage.clickOnRegisterLink();
            //Verify "Register" text
            registerPage.verifyRegisterPageText("Register");
/*2.
verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(
)
Click on Register Link
Click on "REGISTER" button
Verify the error message "First name is required."
Verify the error message "Last name is required."
Verify the error message "Email is required."
Verify the error message "Password is required."
Verify the error message "Password is required."*/
        }
        @Test(groups = {"smoke","regression"})
        public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
            //Click on Register Link
            homePage.clickOnRegisterLink();
            //Click on "REGISTER" button
            registerPage.registerButtonClick();
            //Verify the error message "First name is required."
            registerPage.verifyFirstNameErrorMessage("First name is required");
            //Verify the error message "Last name is required."
            registerPage.verifyLastNameErrorMessage("Last name is required");
            //Verify the error message "Email is required."
            registerPage.verifyEmailErrorMessage("Email is required");
            //Verify the error message "Password is required."
            registerPage.verifyPasswordErrorMessage("Password is required");
            //Verify the error message "Password is required
            registerPage.verifyConfirmPasswordErrorMessage("Password is required");
        }
/*2. verifyThatUserShouldCreateAccountSuccessfully()
Click on Register Link
Select gender "Female"
Enter firstname
Enter lastname
Select day
Select month
Select year
Enter email
Enter password
Enter Confirm Password
Click on "REGISTER" button
Verify message "Your registration completed"*/

        @Test(groups = {"regression"})
        public void verifyThatUsersShouldCreateAccountSuccessfully(){
            //Click on Register Link
            homePage.clickOnRegisterLink();
            //Select gender "Female"
            registerPage.selectGender("Female");
            //Enter firstname
            registerPage.firstNameClick("Meena");
            //Enter lastname
            registerPage.lastNameClick("Patel");
            // registerPage.selectDateOfBirth();
            registerPage.selectDateOfBirth("9","June","2010");
            //Enter email
            registerPage.enterEmailId(("Meena7@gmail.com"));
            //Enter password
            registerPage.passwordClick("Meena321");
            //Enter Confirm Password
            registerPage.confirmPasswordClick("Meena321");
            //Click on "REGISTER" button
            registerPage.registerButtonClick();
            //Verify message "Your registration completed
            registerPage.verifyRegisterPageText(" Your registration is completed");
        }
    }

