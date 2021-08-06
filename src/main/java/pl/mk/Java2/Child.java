package pl.mk.Java2;

public class Child extends Parent {
    int ageChild = 99 + age;

    public Child (){
//        super("bezargumentowy", 1);  //If I have only argument-constructor in parent I must use super in class; If I un-comment this line non-argument constructor of parent will not be invoked (only argument construcor of Parent will be invoked + this one from Child)
        System.out.println("konstruktor bezargumentowy dziecko");
    }
    public Child (String str){
//        super("argumentowy", 2);
        System.out.println("konstr argumrntowy: " + str);
    }
    public Child (int ageChildParam){
//        super("argumentowy", 2);
        age = ageChildParam;
    }

    public static void hiddenMethod() {
        System.out.println("ChildHiddenMethod");
    }
//    public static void hiddenMethod(int a) {System.out.println("ChildHiddenMethod"); }  //checking overloading
//    public static void hiddenMethod(char a) {System.out.println("ChildHiddenMethod"); }

//    public void testFinal(){          // I can't add even if the method is 100% the same as final method in Parent
//        System.out.println("test final");
//    }

    public void testSuper(){
//        super("test",2); //can't use constructor-super in method
        super.printBook(2);
    }

}
