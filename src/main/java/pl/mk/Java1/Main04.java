package pl.mk.Java1;

import pl.mk.Java2.Parent;

import java.util.Arrays;
import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Parent pr = new Parent();
        pr.printBook();
        Main02 main = new Main02();

        String test = "1";
        String test2;
        test: while (true) {
            switch (test) {
                case "1":
                    test2 = "wynik to 1";
//                    break;
                case "2":
                    test2 = "wynik to 2";
                    break;
                default:
                    System.out.println("podałeś nieprawidłowe dane. Jeśli chcesz dodać nowe dane do istniejących w pliku wybierz 1. Jeśli chcesz zastąpić istniejące dane wybierz 2.");
                    test2 = "błąd";
                    continue;
            }
            break;
        }
        System.out.println("wynik to: " + test2);

        String testSlitString = "testuje split rozdzielany wg spacji";

        String[] testSplit1 = testSlitString.split(" ");
        System.out.println("test nr 1: " + Arrays.toString(testSplit1));
        String[] testSplit2;
        testSplit2 = testSlitString.split(" ");
        System.out.println("test nr 2: " + Arrays.toString(testSplit2));
        String[] testSplit3 = new String[0];
        testSplit3 = testSlitString.split(" ");
        System.out.println("test nr 3: " + Arrays.toString(testSplit3));

        char nul = '\0';
        System.out.println("char nul wynik:"+nul+".");
        String s = "food".replace('o', '\0');
        System.out.println(s);
        String fill = "÷";
        System.out.println(Arrays.toString(fill.toCharArray()) + fill.length() );
        char fillCh = fill.charAt(0);
        System.out.println((int)fillCh);
        char rec = '\u9608';
        System.out.println(rec);
        System.out.println( "\\u" + Integer.toHexString('÷' | 0x10000).substring(1) );

        String charTab = new String(new char[10]);
        StringBuilder strr = new StringBuilder("uwaga");
        strr.replace(1,4, "m");
        System.out.println("Stringbuilder: " + strr); //uma
        strr.delete(1,20);
        System.out.println("Stringbuilder: " + strr + ". Length: " + strr.length());  //u
        System.out.println("charTab: " + charTab);

    }
}
