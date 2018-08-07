package com.ac.mylib.util;

// import static是静态导入，这样就不用输入Assert.assertEquals("", retVal);只用assertEquals();就好
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {

    String departureTime;
    
    @Before
    public void setUp() throws Exception {
        departureTime = "2017-12-22";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMmbTimeFormat() {
        String retVal;
        retVal = DateUtil.mmbTimeFormat(departureTime);
        System.out.println(retVal);
        assertEquals("22 Dec 2017, Fri", retVal);
    }
    
    @Test
    public void testGetSysDate() {
    	System.out.println(DateUtil.getSysDate());
    }

}
