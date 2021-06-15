package base;

import java.util.Scanner;

/*  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Marc-Anthony Cross
 */

/*
 * Simple interest is something you use only when making a quick guess.
 * Most investments use a compound interest formula, which will be much more accurate.
 * And this formula requires you to incorporate exponents into your programs.
 *
 * Write a program to compute the value of an investment compounded over time.
 * The program should ask for the starting amount, the number of years to invest, the interest rate,
 * and the number of periods per year to compound.
 *
 * The formula you’ll use for this is A = P(1 + r/n)^(n*t) where
 *
 *     P is the principal amount.
 *     r is the annual rate of interest.
 *     t is the number of years the amount is invested.
 *     n is the number of times the interest is compounded per year.
 *     A is the amount at the end of the investment.
 *
 * Example Output
 *
 * What is the principal amount? 1500
 * What is the rate? 4.3
 * What is the number of years? 6
 * What is the number of times the interest is compounded per year? 4
 * $1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.
 *
 * Constraints
 *
 *     Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
 *     Ensure that fractions of a cent are rounded up to the next penny.
 *     Ensure that the output is formatted as money.
 *
 * Challenges
 *
 *     Ensure that all of the inputs are numeric and that the program will not let the user proceed without
 *     valid inputs.
 *     Create a version of the program that works in reverse, so you can determine the initial amount you’d need
 *     to invest to reach a specific goal.
 *     Implement this program as a GUI app that automatically updates the values when any value changes.
 *
 */

public class App {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String principal = myApp.getPrincipal();
        String rate = myApp.getRate();
        String num_years = myApp.getNumYears();
        String annual_compounds = myApp.getTimesPerYear();
        String decimal_rate = myApp.convertToDecimal(rate);
        String finalamount = myApp.calculateFinal(principal, decimal_rate, annual_compounds, num_years);
        String outputString = myApp.generateOutput(principal, rate, num_years, annual_compounds, finalamount);
        myApp.printOutput(outputString);
    }

    private void printOutput(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutput(String principal, String rate, String num_years, String annual_compounds,
                                                                                        String finalamount) {
        return String.format("$%d invested at %.1f%% for %d years compounded %d times per year is $%.2f.",
                                Integer.parseInt(principal), Double.parseDouble(rate), Integer.parseInt(num_years),
                                Integer.parseInt(annual_compounds), Double.parseDouble(finalamount));
    }

    private String calculateFinal(String principal, String decimal_rate, String annual_compounds, String num_years) {
        double base = (1 + (Double.parseDouble(decimal_rate) / Integer.parseInt(annual_compounds)));
        double exponent = Integer.parseInt(annual_compounds) * Integer.parseInt(num_years);
        double finalamount = Math.pow(base, exponent) * Double.parseDouble(principal);
        return String.valueOf(finalamount);
    }

    private String convertToDecimal(String rate) {
        double decimal_rate = Double.parseDouble(rate) / 100;
        return String.valueOf(decimal_rate);
    }

    private String getPrincipal() {
        System.out.print("What is the principal amount? ");
        return in.nextLine();
    }

    private String getRate() {
        System.out.print("What is the rate? ");
        return in.nextLine();
    }

    private String getNumYears() {
        System.out.print("What is the number of years? ");
        return in.nextLine();
    }

    private String getTimesPerYear() {
        System.out.print("What is the number of times the interest is compounded per year? ");
        return in.nextLine();
    }
}
