package test;

import java.util.ArrayList;

public class Assert {

    private static String outcome = "";
    private static ArrayList<String[]> outcomes;
    private static final String PASSED = "Passed.";
    private static final String FAILED = "Failed.";

    public static void assertEquals(String actual, String expected, int num1, int num2, String op) {
        if (actual.equals(expected)) {
            outcome =  PASSED;
        } else {
            outcome = FAILED;
        }
        System.out.println(num1 + op + num2 + " = " + actual + "... " + outcome);
        if (outcome.equals(FAILED)) {
            System.out.println("\tExpected " + expected + ", but was " + actual + ".");
        }
    }

    public static void assertEquals(String actual, String expected, String test, String input) {
        if (actual.equals(expected)) {
            outcome =  PASSED;
        } else {
            outcome = FAILED;
        }
        System.out.println(test + ": " + input + " -> " + actual + "... " + outcome);
        if (outcome.equals(FAILED)) {
            System.out.println("\tExpected " + expected + ", but was " + actual + ".");
        }
    }

    public static void assertEquals(String actual1, long actual2, long actual3,
                                    long actual4, long actual5,
                                    String expected1, long expected2, long expected3,
                                    long expected4, long expected5,
                                    String title1, String title2, String title3,
                                    String title4, String title5,
                                    String test) {
        outcomes = new ArrayList<>();
        if (!actual1.equals(expected1)) {
            outcome = FAILED;
            outcomes.add((title1 + "~" + actual1 + "~" + expected1).split("~"));
        }
        if (actual2 != expected2){
            outcome = FAILED;
            outcomes.add((title2 + "~" + actual2 + "~" + expected2).split("~"));
        }
        if (actual3 != expected3) {
            outcome = FAILED;
            outcomes.add((title3 + "~" + actual3 + "~" + expected3).split("~"));
        }
        if (actual4 != expected4){
            outcome = FAILED;
            outcomes.add((title4 + "~" + actual4 + "~" + expected4).split("~"));
        }
        if (actual5 != expected5){
            outcome = FAILED;
            outcomes.add((title5 + "~" + actual5 + "~" + expected5).split("~"));
        }
        System.out.println(test + "... " + outcome);
        if (outcome.equals(FAILED)) {
            for (String[] outcome : outcomes) {
                System.out.println("\tFor " + outcome[0] + ", expected " + outcome[2] +
                        ", but was " + outcome[1] + ".");
            }
        }
    }

    public static void assertEquals(String actual, String expected, String test) {
        if (actual.equals(expected)) {
            outcome =  PASSED;
        } else {
            outcome = FAILED;
        }
        System.out.println(test + "... " + outcome);
        if (outcome.equals(FAILED)) {
            System.out.println("\tExpected " + expected + ", but was " + actual + ".");
        }
    }

}
