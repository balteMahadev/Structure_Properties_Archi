package com.demo.properties;

import org.testng.annotations.Test;

public class TestCase
{
    Utility utility = new Utility();
    Action ac = new Action();


    @Test
    public void TestingLoginPage()
    {
        ac.getProperties();
        utility.LoginBox();
        utility.PasswordBox();
        utility.PressButton();
    }
}
