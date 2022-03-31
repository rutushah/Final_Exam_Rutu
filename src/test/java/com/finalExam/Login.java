package com.finalExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends BrowserConfigurations{


    //-------------------Variable Declaration Section---------------
    public static String _pageTitle = "Swag Labs";
    public static String _username = "standard_user";
    public static String _password = "secret_sauce";
    public static String _invalidUserError = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void verifyPageTitle(){
        System.out.println("TC - 01 :: Verify the Title of The Page");
        String getPageTitle = driver.getTitle();
        Assert.assertEquals(getPageTitle, _pageTitle);
    }

    public static void login(String _username, String _password){
        pause(2);
        //Locator's definition section
        WebElement txtUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));

        System.out.println("Enter Username : " + _username);
        txtUserName.sendKeys(_username);

        System.out.println("Enter Password : " + _password);
        txtPassword.sendKeys(_password);
        btnLogin.click();
        pause(2);

    }

    @Test
    public void verifyInvalid(){
        System.out.println("TC - 02 :: Verify Invalid login username and password.");
        login("Invalid user name","InvalidPassword");
        pause(1);
        WebElement invalidCredentials = driver.findElement(By.xpath("//h3[@data-test='error']"));
        if (invalidCredentials.getText().equalsIgnoreCase(_invalidUserError)){
         System.out.println("Passed");
        }else {
         System.out.println("Failed");
        }
    }

    @Test
    public void verifyLoginLogout(){
        System.out.println("TC - 03 :: Verify user can perform Login and Logout successfully.");
        login(_username,_password);
        WebElement dashboardMenu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));

        System.out.println("To verify user is Login Successfully");
        if (dashboardMenu.isDisplayed() == true){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        dashboardMenu.click();

        pause(1);

        WebElement btnLogout = driver.findElement(By.xpath("//nav[@class='bm-item-list']//a[@id='logout_sidebar_link']"));
        btnLogout.click();

        pause(1);
    }

}
