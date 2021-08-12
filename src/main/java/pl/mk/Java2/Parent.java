package pl.mk.Java2;

public class Parent {
    private String name;
    public int age =9;
//Testing fields:
    static String str1 = "str1 PARENT";
    private String str1Private = "str1 PARENT Private";
    String str2 = "str2 PARENT";
    private String str2Private = "str2 PARENT Private";
    String str4 = "str4 PARENT";
    private String str4Private = "str4 PARENT Private";
    private String nameTest = "Parent Name: Parent";

    public String getStr1Private() {
        return str1Private;
    }

    public Parent(){
        System.out.println("Test: konstruktor bezarg Parent");
    }
    public Parent(String name, int age){
        System.out.println("Konstruktor argumentowy parent");
        this.name = name;
        this.age = age;
    }

    public String getNameTest(){
        return nameTest;
    }
    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
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

    public void testSuper(){
        System.out.println("test super method, PARENT");
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

    public static void main(String[] args) {
//         Parent parent = new Parent();
//         Child.testPolyMorphismParent(parent);   //I can invoke (if static) Parent version method or Child version (depending if I use Child.method or Parent.method)
        System.out.println("testing Parent main method");

    }

}
