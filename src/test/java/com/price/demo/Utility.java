package com.price.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.*;
public class Utility extends Action
{
    Action action = new Action();
   @BeforeTest
    public void Url()
    {
        getProperties();
        String url = properties.getProperty("base_url");
        action.Lunch_Url(url);
    }
    public void search_box()
    {
     WebElement element = driver.findElement(By.id(properties.getProperty("search_box")));
     action.valueInTextBox(element,properties.getProperty("search"));
    }
    public void list_of_products()
    {
        String product_name;
        String product_price;
        double least;


        List<WebElement> products_list = driver.findElements(By.xpath(properties.getProperty("products_list")));
        List<WebElement> products_price = driver.findElements(By.xpath(properties.getProperty("products_price")));


        Map<Double, String> productPrice = new LinkedHashMap<>();
        for (int count =0;count< products_list.size();count++){
            product_name = products_list.get(count).getText();
            product_price = products_price.get(count).getText();
            product_price= product_price.replaceAll("[^0-9]","");
            least = Double.parseDouble(product_price);
            productPrice.put(least,product_name);
        }
        Set<Double> set = productPrice.keySet();
        ArrayList<Double> list = new ArrayList<>(set);
        Collections.sort(list);
        Double low_price = list.get(0);
        System.out.println(productPrice.get(low_price));
        System.out.println(low_price);

    }
    @AfterTest
    public void Close_Browser()
    {
        driver.quit();
    }
    @Test
    public void run()
    {
        Utility utility = new Utility();
        utility.getProperties();
        utility.search_box();
        utility.list_of_products();
    }
}
