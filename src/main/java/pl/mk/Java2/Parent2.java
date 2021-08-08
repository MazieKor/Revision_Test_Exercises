package pl.mk.Java2;

public class Parent2 {
    public static int parentValue = 456;
    public Parent2() {
        System.out.println("Parent constructor");
        showInfo();
    }
    public static void showInfo() {
        System.out.println("ParentValue: " + parentValue);
    }

}
