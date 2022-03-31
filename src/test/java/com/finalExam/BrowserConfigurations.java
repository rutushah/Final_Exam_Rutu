package com.finalExam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Prepared By : Rutu Shah
 * Student ID :  2094023
 * Date : 30th March 2022
 * Project Name : Final_Exam_Rutu
 * */

public class BrowserConfigurations {

    //----------------------------Variable Declaration Section-------------------

    public static WebDriver driver;
    public static String baseURL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        pause(2);
    }

    /***
     *
     * This method is used to keep wait in selenium script using thread.sleep() function
     * @param seconds
     * @return
     */

    public static int pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return seconds;
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
