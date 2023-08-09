package com.company;

public class Leete {
    public static int divide(int dividend, int divisor) {
        // Handle division by zero
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // Convert the dividend and divisor to positive
        long positiveDividend = Math.abs((long) dividend);
        long positiveDivisor = Math.abs((long) divisor);

        // Perform bitwise division
        int quotient = 0;
        while (positiveDividend >= positiveDivisor) {
            long temp = positiveDivisor;
            int shift = 0;

            while (positiveDividend >= (temp << 1)) {
                temp <<= 1;
                shift++;
            }

            positiveDividend -= temp;
            quotient += 1 << shift;
        }

        return sign * quotient;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;

        int result = divide(dividend, divisor);

        System.out.println("Quotient: " + result);
    }
}
