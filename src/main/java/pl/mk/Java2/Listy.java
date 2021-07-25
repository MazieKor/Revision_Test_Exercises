package pl.mk.Java2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Listy {

    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        listStr.add("pierwszy");
        listStr.add("dr");
        listStr.add("trz");
        listStr.add("czw");
        System.out.println("Lista 1: " + listStr);
        listStr.add("pia");
        System.out.println("Lista 1: " + listStr);
        listStr.set(1, "drPoZmianie");
        listStr.remove(4);
        System.out.println("Lista 1 po zmianach: " + listStr );

        List<String> listStrUnm = Collections.unmodifiableList(listStr);
        System.out.println("Lista niemodyfik: " + listStrUnm);
//        listStrUnm.add("szósty");  //lista niemodyfikowalna: jak chcę dodać wyskakuje błąd
//        listStrUnm.remove(2);  //jak chcę skasować wyskakuje błąd
        listStr.set(0, "pierwszyPoZmianie");
        System.out.println("Lista niemodyfik po zmianie modyfikowalnej: " + listStrUnm); //zmiana w modyfik. powoduje zmianę w niemodyfik.
//        listStrUnm.set(2, "trzPoZmianie");  //jak chcę zmienić setem element to też ten sam błąd
//        System.out.println("Lista niemodyfik po zmianie NIEmodyfikowalnej: " + listStrUnm);
    }
}
