package pl.mk.Java2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberTests {

    public static void main(String[] args) {
        System.out.println(4.0/0);
        System.out.println(0.0/0);
        double x = Double.POSITIVE_INFINITY;
        double y = Double.NEGATIVE_INFINITY;
        System.out.println("Inf == -Inf: " + (x==y));
        System.out.println("Inf + -Inf: "+ (x+y));
        System.out.println("-Inf - Inf: "+ (y-x));
        System.out.println("-Inf - -Inf: "+ (y-y));
        System.out.println("NaN/NaN: "+ (Double.NaN / Double.NaN));
        System.out.println("NaN!=NaN: "+(Double.NaN != Double.NaN));

        double dd = 0.35;
        BigDecimal a = new BigDecimal(dd);
        System.out.println("BigDecimal 0.35: " + a);  //0.3499999....77....
        double dd2 = 0.1;
        BigDecimal a2 = new BigDecimal(dd2);
        System.out.println("double 0.1: " + a2);
        BigDecimal d = new BigDecimal("1");
        BigDecimal e = new BigDecimal("3");
        BigDecimal f = BigDecimal.valueOf(3.4);
        System.out.println(d.add(e));
//        System.out.println(d.divide(e));  //error
        System.out.println(d.divide(e, 25, RoundingMode.HALF_UP));
        double h = 10000.0;
        double i = 0.000001;
        double result = h+i;
        System.out.println("100 + 0.0001: " + result);

    }
}
