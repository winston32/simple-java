package com.example.simplejava;

/**
 * Simple app demonstrating addition of two numbers.
 */
public class App {

    /**
     * Add two integers.
     *
     * @param a first value
     * @param b second value
     * @return sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Main entry. Usage:
     *  - no args: uses 3 and 5
     *  - two integer args: uses those
     */
    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        if (args.length >= 2) {
            try {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer arguments, falling back to defaults (3 and 5).");
            }
        }

        int sum = add(a, b);
        System.out.printf("Adding %d + %d = %d%n", a, b, sum);
    }
}