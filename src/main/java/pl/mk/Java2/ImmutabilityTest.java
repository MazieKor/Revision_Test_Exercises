package pl.mk.Java2;

public class ImmutabilityTest {

    public static void main(String[] args) {
        Immutability imm = new Immutability(10);
        System.out.println("1: " + imm.toString());
        int test = imm.speed;
        System.out.println("test: " + test);
        Immutability imm2 = new Immutability(500); //inna zmienna
        System.out.println("2: " + imm2.toString());
        imm = new Immutability(1000); //ta sama zmienna
        System.out.println("3: " + imm.toString()); //ta sama zmienna, ale inna, nowa wartość speed
        System.out.println("test po zmianie: " + test); //jest przywiązana do pierwotnej wartości zmiennej (10)
        Immutability immKopia = imm;  //Nie mogę zmienić speed bo jt final
        System.out.println("4 - kopia: " + immKopia.toString());

        final int intFinal = 5;
        int second = intFinal;
        second = 999;

        final String strFinal = "old";
        String secondString = strFinal;
        secondString = "new";  //tworzę nowy obiekt chyba
        System.out.println("string final: " + strFinal);  //old
        System.out.println("string second: " + secondString);  //new

        String testStr = new String("Pierwszy napis");
        String testStr2 = testStr;
        testStr = "Drugi napis";
        System.out.println("testStr: " + testStr);
        System.out.println("testStr2: " + testStr2);  //mogę zmienić pierwszą zmienną, ale w drugiej pozostaje bez zmian

        String testStr3 = "Pirwszy Literał";
        String testStr4 = testStr3;
        testStr3 = "Drugi literał";
        System.out.println("testStr3: " + testStr3);
        System.out.println("testStr4: " + testStr4);

        StringBuilder strB = new StringBuilder("Pierwszy Builder");
        StringBuilder strB2 = strB;
        strB = strB.append("Drugi Builder");   //w przeciwieństwie do Stringa ten mogę zmienić przez zmianę obiektu (a nie stworzenie nowego)
        System.out.println("StrBuilder 1: " + strB);  //oba dają ten sam wynik bo zmieniam obiekt pierwotny, a nie tworzę nowy
        System.out.println("StrBuilder 2: " + strB2);

        StringBuilder strB3 = new StringBuilder("Trzeci Builder");
        StringBuilder strB4 = strB3;
        strB3 = new StringBuilder("Czwarty Builder");
        System.out.println("StrBuilder 3: " + strB3);  //Nowy obiekt więc oba souty pokazują co innego (ta samo jak w Stringu)
        System.out.println("StrBuilder 4: " + strB4);

        StringBuilder strB5 = new StringBuilder("Piąty Builder");
        StringBuilder strB6 = strB5;
        strB5 = strB5.replace(0, strB5.length(), "Szósty Builder");
        System.out.println("StrBuilder 5: " + strB5); // ten sam w obu wypadkach napis
        System.out.println("StrBuilder 6: " + strB6);
        strB5.insert(2, "XXX");
        System.out.println("StringBuilser 5 po insert: " + strB5);

        strB5.setLength(3);
        System.out.println("StrBuilder po zmianie długości: " + strB5); //Wyświetli tylko "S"

    }
}
