package com.revature.util;

import org.junit.*;

// A class that encapsulates one or more test methods is known as a "test suite"
public class JUnitDemo {

    /*
        Basi JUnit Annotations
            - @BeforeClass; runs once before all test methods (must be a static method)
            - @AfterClass; runs once after all test methods (must be a static method)
            - @Before; runs once before each test method (non-static)
            - @After; runs once after each test method
            - @Test; designates a test method
            @ Ignore; indicates to JUnit to not run this test

        All test suite methods will return void (maybe some rare exceptions)
     */

    @BeforeClass
    public static void runBeforeTestSuite() {
        System.out.println("called runsBeforeTestSuite()");
    }

    public static void runsAfterTestSuite() {
        System.out.println("called runAfterTestSuite");
    }

    @Before
    public static void runBeforeEachTestCase() {
        System.out.println("called runBeforeEachTestCase()");
    }

    @After
    public static void runsAfterEachTestMethod() {
        System.out.println("runs after each method");
    }

    @Test
    public void test1() {
        System.out.println("Called test1");
    }

    @Test
    public void test2() {
        System.out.println("Called test2");
    }

    @Ignore
    public void test3() {
        System.out.println("Called test3");
    }

    public static void main(String[] args) {
        JUnitDemo demo = new JUnitDemo();

        demo.test1();
        demo.test2();
    }
}
