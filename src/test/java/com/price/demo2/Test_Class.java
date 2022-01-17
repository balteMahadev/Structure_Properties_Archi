package com.price.demo2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_Class extends Actions_Class
{
    @Test
    public void run() throws InterruptedException
    {
        Actions_Class actions_class = new Actions_Class();
        actions_class.Read_Properties();
        actions_class.Open_Browser(actions_class.properties.getProperty("base_url"));
        String Search_Box_Xpath = actions_class.properties.getProperty("search_box");
        WebElement element = driver.findElement(By.xpath(Search_Box_Xpath));
        actions_class.Search_Box(element,driver);
        String Enter_Value = actions_class.properties.getProperty("search");
        actions_class.Enter_Value_Search_Box(element,driver,Enter_Value);
        String Products_Name_Xpath = actions_class.properties.getProperty("products_list");
        String Products_Price_Xpath = actions_class.properties.getProperty("products_price");
        actions_class.Products(Products_Name_Xpath,Products_Price_Xpath);
        actions_class.Close_Browser(driver);
    }
}
