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
        System.out.println("Inf + -Inf: "+ (x+y));   //NaN
        System.out.println("-Inf - Inf: "+ (y-x));    //-Inf
        System.out.println("-Inf - -Inf: "+ (y-y));   //NaN
        System.out.println("NaN/NaN: "+ (Double.NaN / Double.NaN));   //Nan
        System.out.println("NaN!=NaN: "+(Double.NaN != Double.NaN));   //true

        double nan1 = 0/0.0;
        double nan2 = x+y;
        double nan3 = 0.0/0.0;
        double nan4 = Double.NaN;
        System.out.println("NaN == NaN2: " + (nan1==nan2));   //false
        System.out.println("NaN != NaN2: " + (nan1!=nan2));   //true
        System.out.println("NaN ToLong NaN2: " + (Double.doubleToLongBits(nan1) == Double.doubleToLongBits(nan2)));   //true
        System.out.println("NaN ToRawLong NaN2: "+(Double.doubleToRawLongBits(nan1) == Double.doubleToRawLongBits(nan2)));  //false
        System.out.println("NaN ToRawLong NaN3: "+(Double.doubleToRawLongBits(nan1) == Double.doubleToRawLongBits(nan3)));  //true
        System.out.println("NaN ToLong Double.N: " + (Double.NaN == Double.doubleToLongBits(nan4)));        //false   (same for nan4), because one side is NaN and we compare with ==
        System.out.println("NaN ToRawLong Double.N: " + (Double.NaN == Double.doubleToRawLongBits(nan2)));  //false
        System.out.println("NaN compare NaN2: " + (Double.compare(nan1,nan2)));   //true (0)
        System.out.println("NaN compare Double.NaN: " + (Double.compare(nan1,Double.NaN)));   //true (0) (nan4 the same)


        System.out.println();

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

        double k = 1.000001;
        double l = 0.000001;
        double kResult = k - l;
        System.out.println("Result of subtraction is: " + kResult);   //0.99
        BigDecimal one = new BigDecimal(1.0);
        System.out.println("1.0 in BigDecimal is: " + one);   //1
        System.out.println("Is 1 = 1 "+(kResult==1.0));  //false
        System.out.println("Is 1 = 1 (compare method): "+(Double.compare(1.0,kResult)==0));  //false
        System.out.println("Is 1 = 1 (toLongBits): "+(Double.doubleToLongBits(kResult)==Double.doubleToLongBits(1.0)));  //false
        System.out.println("Is NaN = NaN (compare method): "+(Double.compare(Double.NaN, Double.NaN)));   //true
        System.out.println("Is 0 = -0 (compare method): "+(Double.compare(-0.0, 0.0)));   //-1, false


    }
}
