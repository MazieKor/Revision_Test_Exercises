package pl.mk.Java1;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.Fraction;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

public class Main02 {
    public static void main (String[] args) {
        try {
          printMessage(null);
        System.out.println("wiadomość została wydrukowana");
        } catch (ArithmeticException e) {
//            System.out.println("wystąpił wyjątek");
//            System.out.println(e.getMessage());
//            System.out.println(e);

            e.printStackTrace();
        }
        System.out.println("wiadomość po catchu");
        String[] newArray = {"Tomek", "Arek", "Iwona"};
        System.out.println("test wyswietlania: " + Arrays.toString(newArray));

        Locale defaultLocale = Locale.getDefault();


        System.out.println("Default locale: " + defaultLocale);
        System.out.println("\tLanguage: " + defaultLocale.getLanguage());
        System.out.println("\tCountry: " + defaultLocale.getCountry());

        String testStrUtils = "testuję StringUtils";
//        testStrUtils = testStrUtils.repeat(3);
        System.out.println(testStrUtils);
        StringUtils.replace(testStrUtils, "t", "VV");
        StringUtils.replace(testStrUtils,  "t",  "VV");
        System.out.println(testStrUtils);
        System.out.println("isNumeric - 23,6: " + StringUtils.isNumeric("23,6"));
        System.out.println("isNumeric 2 १२३: " + StringUtils.isNumeric("१२३"));
        System.out.println("isDigits १२३: " + NumberUtils.isDigits("१२३"));
        System.out.println("isParsable: १२३: " + NumberUtils.isParsable("१२३"));
        String przykład = "alfab    etdirfrtdarx";
        System.out.println("containsAny: " + StringUtils.containsAny(przykład, "dif", "ret"));
        System.out.println("containsIgnCase: " + StringUtils.containsIgnoreCase(przykład, "dif"));
        System.out.println("containsNone: " + StringUtils.containsNone(przykład, "ert"));
        System.out.println("equalsAny: " + StringUtils.equalsAny(przykład, "etd"));
        System.out.println("remove: " + StringUtils.remove(przykład, "di"));
        System.out.println("original po remove: " + przykład);
        System.out.println("countM: " + StringUtils.countMatches(przykład, "d"));
        System.out.println("capitalize: " + StringUtils.capitalize("mała"));
        System.out.println("reverseDelim: " + StringUtils.reverseDelimited("  mała myszka        robi    siku pod ", ' '));
//        System.out.println("reverseDelim: " + StringUtils.reverseDelimited(przykład, ' '));
        System.out.println("reverseDelim: " + StringUtils.reverseDelimited(StringUtils.reverseDelimited("  mała myszka        robi    siku pod ", ' '), ' '));
        System.out.println("reverseDelim: " + "  mała myszka        robi    siku pod ");

        String[] newArr = {"3", "der", "nowy", "Array", "nowy"};
        String[] newArr2 = {"4", "derr", "nowy2", "Array2"};

        System.out.println("toString z nulla: "+ ArrayUtils.toString(null));
        System.out.println(ArrayUtils.hashCode(newArr));
        System.out.println("index nr: " + ArrayUtils.indexOf(newArr,"der", 1));
        System.out.println("add nr: " + Arrays.toString(ArrayUtils.add(newArr,2,"add")));
        System.out.println("addAll: " + Arrays.toString(ArrayUtils.addAll(newArr,newArr2    )));
        ArrayUtils.addAll(newArr,newArr2);
        System.out.println("oldArr: " + Arrays.toString(newArr)); //Dodanie drugiej tablicy nie zmienia starej
        ArrayUtils.removeElement(newArr,"nowy");
        System.out.println("po remove El: " + Arrays.toString(newArr)); //nie zmienia tablicy oryginalnej
        newArr = ArrayUtils.removeElement(newArr,"nowy");
        System.out.println("po remove El 2: " + Arrays.toString(newArr)); //zmienia tablicę po przypisaniu

        System.out.println("przed reverse: " + Arrays.toString(newArr));
        ArrayUtils.reverse(newArr, 1, 3);
        System.out.println("po reverse: " + Arrays.toString(newArr));
        ArrayUtils.shift(newArr, 1,4,1);
        System.out.println("po shift: " + Arrays.toString(newArr));
        System.out.println("subarray: " + Arrays.toString(ArrayUtils.subarray(newArr, 1,3)));
        System.out.println("po subarray: " + Arrays.toString(newArr)); //subarray nie zmienia bez przypisania
        ArrayUtils.swap(newArr,0, 2, 2);
        System.out.println("po swap: " + Arrays.toString(newArr));

        String[] strArrayZZZ = new String[]{"1", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem"};
        System.out.println("strArray: " + Arrays.toString(strArrayZZZ));
        Arrays.fill(strArrayZZZ, 1,4,"NOWE"); //Nic nie zwraca, nie mogę też od razu w soucie (i Arrays.toString)
        System.out.println("strArray: " + Arrays.toString(strArrayZZZ));

//        strArrayZZZ = ArrayUtils.swap(strArrayZZZ,2,4); //Nie moge bezpośrdnio przypisać
//        System.out.println(Arrays.toString(strArrayZZZ));
//NumberUtils i inne z Apache Common

        int num1 = 2;
        long num2 = 4L;

        System.out.println("compare: " + (num1==num2)); //tak tez porownam double, przy NumberUtils nie

        System.out.println("compare: " + NumberUtils.compare(num1,num2));
        double fromNumUtils = NumberUtils.createDouble("2345");
        System.out.println(fromNumUtils);
        System.out.println("isDigits: " + NumberUtils.isDigits("23,4"));  //kropka daje false
        System.out.println("isParsable: " + NumberUtils.isParsable("0023.4")); //kropka i zera wcześniej dają true
        String parsowa = "48L"; //takiej na longa nie potrafi sparsować
        String parsowa2 = "48d"; //ale taką sparsuje
//        double parsowana = Double.parseDouble(parsowa2);
        int parsowana = Integer.parseInt("0048");
        System.out.println("po parsowaniu: " + parsowana);  //pokaże 48

        byte[] numUtArr = {3, 5, 7, 0};
//        String[] numUtArrStr = {"e", "r", "f"};  //tablicy Stringów nie mogę wrzucić
        System.out.println("min/ max: " + NumberUtils.min(numUtArr));
        Fraction fr1 = Fraction.getFraction(0.333);
        System.out.println("fraction: " + fr1);
        System.out.println("systemUtils: " + SystemUtils.getJavaHome());
        File fl = SystemUtils.getJavaHome();
        System.out.println("User Name: " + SystemUtils.getUserName());
        System.out.println("User Home: " + SystemUtils.getUserHome());
        System.out.println("Java ver: " + SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_RECENT));
        System.out.println(JavaVersion.JAVA_RECENT);



//        System.out.println("compare: " + NumberUtils);


//        System.out.println(ArrayUtils.isSameLength());
//        System.out.println(ArrayUtils.toMap(newArr));   //tablica musi być 2-wymiarowa




    }

    public static void printMessage(String message) {
//        int c = 4/0;
        if (message == null) {
            throw new ArithmeticException ("wiadomosć inna");
        }
        else {
            System.out.println(message);
        }
        System.out.println("na samym koncu");
    }
}
