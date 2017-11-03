package com.ac.mylib.util;

import static org.junit.Assert.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MMBCommonsUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMmbGetHMACSignature() {
        String retVal = null;
        try {
            retVal = MMBCommonsUtil.mmbGetHMACSignature();
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(retVal);
    }

}
