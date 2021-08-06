package pl.mk.Java2;

public class Parent {
    private String name;
    public int age =9;

    public Parent(){
        System.out.println("Test: konstruktor bezarg Parent");
    }
    public Parent(String name, int age){
        System.out.println("Konstruktor argumentowy parent");
        this.name = name;
        this.age = age;
    }


    public void printBook() {
        System.out.println("Test: Drukowanie " + "ebook");
    }
    public static void hiddenMethod() {
        System.out.println("ParentHiddenMethod");
    }
}
