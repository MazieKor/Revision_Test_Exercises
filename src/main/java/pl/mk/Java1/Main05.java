package pl.mk.Java1;

import pl.mk.Java2.OrderChild;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {

        StringBuilder strB = new StringBuilder(" Nowy String Builder");
        System.out.println("Wynik StrBuildera: " + strB);



        //Suma śladu macierzy z jedną pętlą for


        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(j == i){
                    sum += matrix[i][j];
                    break;
                }
            }
        }
        System.out.println("suma: "+ sum);
        int sum2 = 0;
        for (int i = 0, j =0; i < matrix.length; i++, j++){
            sum2 += matrix[i][j];
        }
        System.out.println("2. rozwiązanie: "+ sum2);
//        Locale.setDefault(Locale.ENGLISH);
//        int a = 345,567;// nawet w Locale.Englich się nie da

        double scan2 = new Scanner("456,78").nextDouble(); //w Locale polskim moge to sparsować do Doubla (456.78 powoduje błąd)
        //Locale.setDefault(Locale.ENGLISH); // jeśli to mam włączone to w skanerze mogę podać 345,567 i zinterpretuje jako tysiące
        System.out.println("skan bezp. ze Stringa: " + scan2);
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj wartość");

        int first = scan.nextInt(); ///345 456 zinterpretuje jako dwie liczby, a 345_456 zrobi błąd
        String second = scan.next();
        System.out.println("wynik skanowania: "+ first + " " + second); //spacji nie traktuje jak znaku do skanowania

//        while(scan.hasNext()){   //pod komentarz, bo nieprzerwana pętla
//            if(scan.hasNextInt()){
//                System.out.println("Found Int: "+scan.next());  }
//            else
//                scan.next();    //cały czas scan się odnosi do tego co wprowadzony na początku (po while)
//        }

        pl.mk.Java1.Main01.testOfmethodsInt(2); //nazwa kwalifik.; samo Main01. też by starczyło (jeśli biorę coś z Java2, to by nie starczyło - musiałbym ścieżkę podać)

        File file = new File("txt.txt");
//        Scanner scan = new Scanner(file);   // Program się zawiesza, pokazuje widoku Build (nie Run) - nie zrobiłem w try
//        file.createNewFile(); // jedyny z file chyba, który muszę tryem (oprócz scanu)

//        Path path3 = Paths.get("src/main/java/pl/mk/Java1/Main01.java ");  //nie muszę try tutaj, ale zakańczając na spację wyskakuje błąd i exit code 1
        Path path1 = Paths.get("src/main/java/pl");
        Path path2 = Paths.get("src/main/java33/pl");
        System.out.println(Files.isSymbolicLink(path1));

//        Files.copy(path1, path2);  //poza metodami zwracającymi true/false w innych musze dawać try

//        OrderParent op = new OrderParent();   //I can't create if constructor is default (not public)


    }
        void nr1 (){
            nr2(); //mogę się odwołać wpisując sama nazwę
        }

        void nr2() {

        }

        int exepct(int a){
        if(a >0){
            throw new IllegalArgumentException();
        } else{
            throw new IllegalArgumentException("mniejsze niż 0");  //wyjątki zastępują return
        }

        }

}
