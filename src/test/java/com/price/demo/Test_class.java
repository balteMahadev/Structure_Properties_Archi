package com.price.demo;

import org.testng.annotations.Test;

@Test
public class Test_class extends Action
{
    Action action = new Action();
    Utility utility = new Utility();

    @Test
    public void run()
    {
        Utility utility = new Utility();
        utility.getProperties();
        utility.search_box();
        utility.list_of_products();
    }


}
