package pl.mk.Java2;

public class Child extends Parent {

    public Child (){
//        super();
        System.out.println("konstruktor bezargumentowy dziecko");
    }
    public Child (String str){
        System.out.println("konstr argumrntowy: " + str);
    }

    public static void hiddenMethod() {
        System.out.println("ChildHiddenMethod");
    }

}
