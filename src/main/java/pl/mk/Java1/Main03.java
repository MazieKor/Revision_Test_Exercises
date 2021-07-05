package pl.mk.Java1;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("readText.txt");
        try {
            Scanner scan = new Scanner(file1);   //try with resources też zadziałało
            scan.close();
        } catch (FileNotFoundException e) {
        }
        System.out.println("czy istnieje pierwszy: " + file1.exists());
        File file2 = new File("newFile.txt");
        System.out.println("czy jt plikiem: " + file1.isFile());
        System.out.println("czy jt plikiem: " + file2.isFile());
        System.out.println("czy istnieje: " + file2.exists());
        System.out.println("czy jt katalogiem: " + file2.isDirectory());

        File file3 = new File("src/main/java/pl/mk/JavaTestFile/nowy/podkt/pl.Nowy.txt");
//        System.out.println("czy stworzył: " + file3.mkdirs());
//        file3.delete();
        System.out.println("czy istnieje trzeci: " + file3.exists());
        System.out.println("czy jest plikiem trzeci: " + file3.isFile());
        System.out.println("czy jest katalogiem trzeci: " + file3.isDirectory());

        File file4 = new File("src/main/java/pl/mk/Java1    ");  //jakby sam trimuje
        String[] direction = file4.list();
        System.out.println("lista katalogów: " + Arrays.toString(direction));

        Path path = Paths.get("newFile.txt");
        Path path2 = Paths.get("src/main/java/newFile2.txt");
        System.out.println("path: " + path.getName(0));

        System.out.println("Files - czy istnieje: " + Files.exists(path));
        System.out.println(Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING));
        System.out.println("czy link symboliczny: " + Files.isSymbolicLink(path));
//        StringBuilder strBuilder = new StringBuilder();
//        strBuilder.append(Files.readAllLines(path));
//        String stringStrBuilder = strBuilder.toString();
//        System.out.println(stringStrBuilder);

//        String directory = "/nowykatalog";
//        File file = new File(directory);
//        file.createNewFile();
//        System.out.println("czy istnieje na D: " + file.exists());  //działa na D

//        String directory = "nowykatalog.txt";
//        File file = new File(directory);
//        file.createNewFile();         //Nie tworzy jesli juz istnieje

        Path paths = Paths.get("src/main/java/pl/mk/JavaTestFile/nowy2/nowyFile.txt");  //jeśli już istnieje to błąd

//        System.out.println("stworzone directory: " + Files.createDirectory(paths));  //zwraca ścieżkę jak stworzy
//        System.out.println("stworzone directories: " + Files.createDirectories(paths));  //jeśli directory już istnieje to nic nie robi i zwraca ścieżkę
//        System.out.println("stworzone File: " + Files.createFile(paths));  //jak już istnieje to błąd

//        System.out.println("stworzone File: " + Files.delete(paths));  //delete zdaje się nic nie zwraca
//        String deleeee = String.valueOf(Files.delete(paths));

        PrintWriter printWriter = new PrintWriter("nowYPlik.txt");
            printWriter.println("Nowość");
            printWriter.close();  //muszę zamknąć bo inaczej nie zapisze

        String check = "uwaga.pierwsze.wyst.txt";
        System.out.println("index kropki: " + check.lastIndexOf("."));
        Path path1 = Paths.get("src/main/java/pl");
        Path path3 = Paths.get("src/main/java/pl/mk/Java1/Main01.java");
//        System.out.println("relativize: " + path3.relativize(path1));
        System.out.println("subpath: " + path1.subpath(0, path1.getNameCount()-1));
        System.out.println("Parent: " + path3.getParent());  //pokaże ścieżkę do Java1
        System.out.println("String.valueOf: "+ String.valueOf(path3)); //pokaże całą ścieżkę
        String strPath = String.valueOf(path3);
        System.out.println("Resolve: " + path1.resolve(path3)); //dołączenie pełnej ścieżki path3 do path1


        Path path4 = Path.of("writeFile.txt");
        String readString = Files.readString(path4);
        System.out.println("Funkcja readString: " + readString);




//        Files.delete(path2);

//        try {
//            PrintWriter printWriter = new PrintWriter("newFile.txt");
//            printWriter.close();
//        } catch (FileNotFoundException e) {
//
//        }
    }
}
