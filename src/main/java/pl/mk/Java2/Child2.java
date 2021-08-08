package pl.mk.Java2;

public class Child2 extends Parent2{
    public static int childValue = 1;
    public Child2() {
        System.out.println("Child constructor");
    }

    public static void showInfo() {
        System.out.println("childValue: " + childValue);
    }
}
