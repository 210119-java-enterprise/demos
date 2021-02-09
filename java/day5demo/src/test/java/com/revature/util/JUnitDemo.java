package com.revature.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Class that encapsulates 1+ test methods is known as a test suite
 */
public class JUnitDemo {

    /**
     * Basic JUnit annotations
     *      - @BeforeClass : runs once before all test methods (must be static method) 
     *      - @AfterClass : runs once after all test methods (must be static method) 
     *      - @Before : runs once before each test method
     *      - @After : runs once after each test method
     *      - @Test : indicates a test method
     *      - @Ignore : indicates to JUnit to not run this test
     * 
     * All test suite methods will return void (with few exceptions)
     */

     @BeforeClass
    public static void runBeforeTestSuite() {
        System.out.println("ran before test suite");
    }

    @AfterClass
    public static void runAfterTestSuite() {
        System.out.println("ran after test suite");

    }

    @Before
    public void runBeforeEachTestCase() {
        System.out.println("ran before each test");
    }

    @After
    public void runAfterEachTestCase() {
        System.out.println("ran after each test");
    }

    @Test
    public void test1() {
        System.out.println("Called test 1");
    }

    @Ignore("You can give reason why test is ignored")
    public void test2() {
        System.out.println("Called test 2");
    }

    @Test
    public void test3() {
        System.out.println("Called test 3");
    }
}
