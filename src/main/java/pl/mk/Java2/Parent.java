package pl.mk.Java2;

public class Parent {
    private String name;
    private int age;

    public Parent(){
        System.out.println("Test: konstruktor Parent");
    }
    public Parent(String name, int age){
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
