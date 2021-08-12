package pl.mk.Java2;

public class Child extends Parent {
    int ageChild = 99 + age;
//Testing Fields:
    static String str1 = "str1 CHILD";
    private String str1Private = "str1 CHILD Private";
    String str2 = "str2 CHILD";
    private String str2Private = "str2 CHILD Private";
    String str3 = "str3 CHILD";
    private String str3Private = "str3 CHILD Private";
    private String nameTest = "Child Name: Child";
    //str1 = "dd";      // I can't change the field (even if only declared earlier)


    public String getStr1Private() {
        return str1Private;  // if I put under comment str1Private in this class and make str1Private not private in Parent it will see field from Parent
    }

    public Child (){
//        super("bezargumentowy", 1);  //If I have only argument-constructor in parent I must use super in class; If I un-comment this line non-argument constructor of parent will not be invoked (only argument construcor of Parent will be invoked + this one from Child)
        System.out.println("konstruktor bezargumentowy dziecko");
        super.setNameTest(nameTest);
    }
    public Child (String str){
//        super("argumentowy", 2);
        System.out.println("konstr argumrntowy: " + str);
    }
    public Child (int ageChildParam){
//        super("argumentowy", 2);
        age = ageChildParam;
    }


    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public static void hiddenMethod() {
        System.out.println("ChildHiddenMethod");
    }
//    public static void hiddenMethod(int a) {System.out.println("ChildHiddenMethod"); }  //checking overloading
//    public static void hiddenMethod(char a) {System.out.println("ChildHiddenMethod"); }

//    public void testFinal(){          // I can't add even if the method is 100% the same as final method in Parent
//        System.out.println("test final");
//    }

//    public void testSuper(){
////        super("test",2); //can't use constructor-super in method
////        super.printBook(2);
////        testVarArg();   // can use without arguments
//
//        System.out.println("test super method, CHILD");
//    }

    public static void testVarArg(String... testString){
        System.out.println("Test varArg");
    }

    public static void testPolyMorphismChild(Child child){
        System.out.println("test Poly Child");
    }

    public void testPolyMorphismParent(Parent parent){
        System.out.println("test Poly - Child class, overrides Parent method");
    }
    public void testPolyMorphismParent2(Parent parent){
        System.out.println("test Poly2 - Child class, overrides Parent method");
    }

//    public static void main(String[] args) {
////        Parent parent = new Parent();
////        Parent.testPolyMorphismParent(parent);   //I can invoke (if static) Parent version method or Child version (depending if I use Child.method or Parent.method)
////        Child child = new Child();
//        testVarArg("jeden", "dwa");     //works also with 0 arguments
//        System.out.println("testing Child main method");
//
//    }
}
