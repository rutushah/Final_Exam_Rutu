package com.finalExam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPage extends BrowserConfigurations{

    //-------------------Variable Declaration Section---------------

     public static String _itemName = "";
     public static String _itemPrice = "";
     public static String _firstName = "Rutu";
     public static String _lastName = "Shah";
     public static String _zipCode = "H3H 2N3";
     public static String _orderComplete = "THANK YOU FOR YOUR ORDER";

    //-------------------Test Method Declaration Section---------------

    public void cart(){
        Login.login(Login._username,Login._password);


        WebElement btnAddToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        btnAddToCart.click();
        WebElement lblItemName = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        _itemName = lblItemName.getText();

        WebElement lblItemPrice = driver.findElement(By.xpath("(//div[@class='pricebar'])[1]//div"));
        _itemPrice = lblItemPrice.getText();

        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();

        pause(1);
        WebElement lblItemOnAddToCartPage = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        WebElement lblItemPriceOnAddToCartPage = driver.findElement(By.xpath("(//div[@class='item_pricebar'])[1]//div"));

        System.out.println("Verify the product is added to cart successfully.");
        if (lblItemOnAddToCartPage.getText().equalsIgnoreCase(_itemName)==true &&
                lblItemPriceOnAddToCartPage.getText().equalsIgnoreCase(_itemPrice) == true){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }

    @Test
    public void addToCart(){
        System.out.println("TC - 04 :: To verify user can add Products to cart.");
        cart();
    }

    @Test
    public void removeProductFromCart(){
        System.out.println("TC - 05 :: To verify user can remove Product from the cart.");
        cart();
        WebElement btnRemove = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
        btnRemove.click();
    }

    @Test
    public void checkOut(){
        System.out.println("TC - 06 :: To verify user can perform checkout.");
        cart();
        WebElement btnCheckOut = driver.findElement(By.xpath("//button[@id='checkout']"));
        btnCheckOut.click();
        pause(2);
        WebElement txtFirstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        WebElement txtLastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        WebElement txtZipCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
        WebElement btnContinue = driver.findElement(By.xpath("//input[@id='continue']"));

        System.out.println("First Name : " + _firstName);
        txtFirstName.sendKeys(_firstName);

        System.out.println("Last Name : " + _lastName);
        txtLastName.sendKeys(_lastName);

        System.out.println("Zip Code : " + _zipCode);
        txtZipCode.sendKeys(_zipCode);

        btnContinue.click();
        pause(1);

        WebElement btnFinish = driver.findElement(By.xpath("//button[@id='finish']"));
        btnFinish.click();

        System.out.println("Verify order complete error.");
        WebElement lblCompleteOrder = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String orderComplete = lblCompleteOrder.getText();
        Assert.assertEquals(orderComplete,_orderComplete);

    }

    @Test
    public void continueShopping(){
        System.out.println("TC - 07 :: To verify user can continue shopping.");
        cart();
        WebElement btnContinue = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
        btnContinue.click();

        WebElement btnAddToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        btnAddToCart.click();
        pause(2);
    }
}
