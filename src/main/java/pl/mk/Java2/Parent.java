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
    public void printBook(int a) {
        System.out.println("metoda przeciążona z int");
    }
    public void printBook(long a) {
        System.out.println("metoda przeciążona z long");
    }                                                     //method overloading changing only type from int to long

    public final void testFinal(){
        System.out.println("test final");
    }
    public void testFinal(int a){                //I can overload final methods
        System.out.println();
    }

    public void testPolyMorphismParent(Parent parent){
        System.out.println("test Poly Parent");
    }
    public void testPolyMorphismParent2(Parent parent){
        System.out.println("test Poly2 Parent");
    }

    public static void hiddenMethod() {
        System.out.println("ParentHiddenMethod");
    }
}
