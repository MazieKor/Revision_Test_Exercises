package pl.mk.Java1;

import pl.mk.Java2.Parent;

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
    }
}
