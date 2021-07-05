package pl.mk.Java2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
//        Child child = new Child();
        Child child2 = new Child("uwaga na konstruktry");
        child2.hiddenMethod();

        Object stringInstance = "string";
        String realString = (String) stringInstance;


        int test = 9;
        test = 14;
        System.out.println("int zwykły: " + test);
        final int TEST_F = 9;
//        TEST_F = 14;
        String testString = "Immutable";
        testString = "NotImmutable";
        System.out.println("String: " + testString);
        String testString2 = new String("NewImm");
        System.out.println("String z new: " + testString2);
        testString2 = "NewImm3";
        System.out.println("String z new po zmianie: " + testString2);



    }



}
