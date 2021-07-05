package pl.mk.Java2;

public class Child extends Parent {

    public Child (){
        System.out.println("konstruktor dziecko");
    }
    public Child (String str){
        System.out.println("konstr argumrntowy: " + str);
    }

    public static void hiddenMethod() {
        System.out.println("ChildHiddenMethod");
    }

}
