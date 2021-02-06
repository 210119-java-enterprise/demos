package com.revature.util;

import org.junit.*;

// A class that encapsulates one or more test methods is known as a "test suite"
public class JUnitDemo {

    /*
        Basic JUnit Annotations
            - @BeforeClass; runs once before all test methods (must be a static method)
            - @AfterClass; runs once after all test methods (must be a static method)
            - @Before; runs once before each test method (non-static)
            - @After; runs once after each test method
            - @Test; designates a test method
            - @Ignore; indicates to JUnit to not run this test

        All test suite methods will return void (maybe some rare exceptions to that rule)
     */

    @BeforeClass
    public static void runBeforeTestSuite() {
        System.out.println("called runBeforeTestSuite()");
    }

    @AfterClass
    public static void runAfterTestSuite() {
        System.out.println("called runAfterTestSuite()");
    }

    @Before
    public void runBeforeEachTestCase() {
        System.out.println("called runBeforeEachTestCase()");
    }

    @After
    public void runAfterEachTestCase() {
        System.out.println("called runAfterEachTestCase()");
    }

    @Test
    public void test1() {
        System.out.println("called test1()");
    }

    @Test
    public void test2() {
        System.out.println("called test2()");
    }

    @Ignore("You can give a reason why this test is ignored.")
    public void test3() {
        System.out.println("called test3()");
    }

}
