package org.bonn.se.ws15.uebung8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FibonacciUtil {
    private static BigDecimal zero = BigDecimal.valueOf(0);
    private static BigDecimal one = BigDecimal.valueOf(1);
    private static BigDecimal two = BigDecimal.valueOf(2);
    private static BigDecimal four = BigDecimal.valueOf(4);
    private static BigDecimal five = BigDecimal.valueOf(5);

    public static boolean isFibonacci(BigDecimal num) {
        if (num.compareTo(zero) <= 0) {
            return false;
        }

        BigDecimal base = num.multiply(num).multiply(five);
        BigDecimal possibility1 = base.add(four);
        BigDecimal possibility2 = base.subtract(four);


        return (isPerfectSquare(possibility1) || isPerfectSquare(possibility2));
    }

    public static boolean isPerfectSquare(BigDecimal num) {
        BigDecimal low = zero;
        BigDecimal high = num;

        while (low.compareTo(high) <= 0) {
            BigDecimal mid = low.add(high).divide(two).setScale(0, RoundingMode.DOWN);
            BigDecimal square = mid.multiply(mid);
            int comparison = square.compareTo(num);

            if (comparison == 0) {
                return true;
            } else if (comparison > 0) {
                high = mid.subtract(one);
            } else {
                low = mid.add(one);
            }

        }

        return false;
    }
}
