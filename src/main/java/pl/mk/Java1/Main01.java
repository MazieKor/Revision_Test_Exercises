package pl.mk.Java1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

public class Main01 {

    public static void main(String[] args) {
        String check = "Ala maria i Iwona 2 koty i psa i mówi";
        System.out.println(check.indexOf("ma"));

        char[] test = new char[3];
        int[] testIntArr = new int[3];
        String[] testStringArr = new String[3];
        System.out.println("Tablica charów: "+Arrays.toString(test));
        System.out.println("Tablica intów: "+ Arrays.toString(testIntArr));
        System.out.println("Tablica Stringów: "+Arrays.toString(testStringArr));

        int test2 =12;
        System.out.println("Liczba przed wysłaniem: "+test2);
        int result = testOfmethodsInt(test2);
        System.out.println("Liczba po wysłaniu: "+test2);
        System.out.println("Nowa liczba: "+result);

        int[] testArrays = new int[]{1,2,3};
        System.out.println("Tablica przed wysłaniem: "+Arrays.toString(testArrays));
        int[] resultArrays = testOfmethodsArrays(testArrays);
        System.out.println("Tablica po wysłaniu: "+Arrays.toString(testArrays));
        System.out.println("Nowa tablica: "+Arrays.toString(resultArrays));

        String testString = new String("String testowy");
        System.out.println("String przed wysłaniem: "+testString);
        String resultString = testOfmethodsString(testString);
        System.out.println("String po wysłaniu: "+testString);
        System.out.println("String w soucie: " + testOfmethodsString(testString));
        System.out.println("String po wysłaniu: "+testString);
        System.out.println("Nowy String: "+resultString);

        String testStr2 = "Testowanie co zwraca metoda";
        String resultString2 = testOfmethodsString2(testStr2);
        System.out.println("Co zwróciła metoda- oryginał: " + testStr2); //Wysłanie stringa do metody nie zmienia oryginału
        System.out.println("Co zwróciła metoda: " + resultString2); //zwrócenie zmodyfikowanie Stringa i już zmodyfikowanego przypisanie

        String upper = "upper Case";
        System.out.println(upper.toUpperCase());

        String testOryg = "Test Oryginalny";
        String testKopia = testOryg;
        testKopia = "Test Kopia";
        System.out.println(testOryg+" vs. "+ testKopia);

        String chain = " sprawdzanie chainingu   ";
        int chainInt = chain.trim().length();  //zwraca długość po chainingu - chaining możliwy
        System.out.println("liczba po chainingu: " + chainInt);


        int num1 = 1;
        int num2 = 2 + ++num1;
        System.out.println("inkrementacja: " + num2);

        char testChar = 'l';
        testChar = Character.toUpperCase(testChar);
        System.out.println("test upperCase'a: "+ testChar);

        String replace = "do zastąpienia";
        replace = replace.replaceAll("\\s", "bb");
        System.out.println("replace: " + replace);
        replace.contains("\\s");


        char[] newCharArray = {'a', 'b', 'e', '5'};
        String fromCharArray = String.valueOf(newCharArray);
        System.out.println("String z charów: " + fromCharArray);

        String test3 = new String();   // inne opcje: = null, =""
        System.out.println("wydruk testowego Stringa: "+ test3 +"kropka");

        int a, b=3, c, d =5;
//        System.out.println(a, b, c, d); //a i c nie zainicjalizowane

        double dFormat = 2.34568;
        DecimalFormat format = new DecimalFormat("##.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        dFormat = Double.parseDouble(format.format(dFormat));
        System.out.println(dFormat);

        double n = 234_123.987;
        n= n+4;
        System.out.println(n);

        int binar = 0b11100;
        System.out.println("binar: " + binar); //wynik to 28

        short overflow = (short) 1_111_111;  //jeśli nie zrzutuję to kompilator pokaże błąd
        System.out.println("short: " + overflow);

        double dbl = 234678584784.9784757483837847484837383848444444444444444444838339393;
//        dbl = dbl + 0.985747758487484838393974848484;
        System.out.println("dbl: " + dbl); //pokazuje 2.3467...E11

        String aStr = "   22   ";
        double aInt = Double.parseDouble(aStr);
        System.out.println("parsowanie: " + aInt);


    }
    static int testOfmethodsInt(int test2){
        test2 += 355;
        return test2;
    }

    static int[] testOfmethodsArrays(int[] testArrays){
        for (int i = 0; i < testArrays.length; i++) {
            testArrays[i] = testArrays[i] + 10;
        }
        return testArrays;
    }

    static String testOfmethodsString(String testString){
        testString += " - zupełnie nowy String";
        return testString;
    }

    static String testOfmethodsString2(String testString){
        return testString.replace("a", "000");
    }

}
