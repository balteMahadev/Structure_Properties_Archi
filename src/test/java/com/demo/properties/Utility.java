package com.demo.properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class Utility extends Action
{


    @BeforeSuite
    public void Url()
    {
        getProperties();
        Lunch_Url(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
    @AfterSuite
    public void CloseBrowser()
    {
        driver.quit();
    }
    public void LoginBox()
    {
//        getProperties();
        WebElement element1 = driver.findElement(By.id(properties.getProperty("login_id")));
        ValueInTextBox(element1,"Mahadev");
        System.out.println("1");
    }
    public void PasswordBox()
    {
//        getProperties();
        WebElement element2 = driver.findElement(By.id(properties.getProperty("password_id")));
        ValueInTextBox(element2,"Mahadev");
        System.out.println("1");
    }
    public void PressButton()
    {
//        getProperties();
        WebElement element = driver.findElement(By.name(properties.getProperty("Login_click")));
        element.click();
        System.out.println("1");
    }
    @Test
    public void run()
    {
        Utility utility = new Utility();
//        utility.getProperties();
        utility.LoginBox();
        utility.PasswordBox();
        utility.PressButton();
    }
}
