package com.price.demo2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Validations
{
    public Boolean isElementPresent(WebElement element)
    {
        if(element.isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean  valueInTextBox(WebElement element,String text)
    {
        Boolean b ;
        if(isElementPresent(element))
        {
            element.click();
            element.sendKeys(text);
            element.sendKeys(Keys.ENTER);
            b = true;
        }
        else
        {
            System.out.println("Element");
            b = false;
        }
        return b;
    }
}
