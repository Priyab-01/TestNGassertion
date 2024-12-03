package com.qf;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertionsfailandpass {
    @Test
    public void assertionpass() {
        int a=2, b=2;
        int c = a+b;
        System.out.println(c);
        Assert.assertEquals(c,4,"Test Case passed");
    }
    @Test
    public void assertionfail() {
        int a=3, b=5;
        int c = a+b;
        System.out.println(c);
        Assert.assertEquals(c,7,"Test Case failed");
    }
}
