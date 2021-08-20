package pl.mk.Java2;

import pl.mk.Java1.TestInherFromOtherPackage;

public class OrderChild extends OrderParent{
    static String staticParentName = "staticChildName";
    static {
        System.out.println(staticParentName);
    }
    static String staticChildCity = "Gliwice";
    static {
        System.out.println(staticChildCity);
    }
    int test;
    int test2 = 222;
    int test3 = 333;
    String d;

     protected OrderChild() {
        methodTest();
        test = 7;
        test2 = 222222222;
        methodTest();
        System.out.println("Child Constr");
    }

    {
        System.out.println(test2);
    }

    void methodTest() {
        System.out.println("Method, field is " + test);
        System.out.println("Method, field2 is " + test2);
    }

    void methodTest2() {
        System.out.println("Method2, field2 is " + test2);
    }

    protected void testProtectedParent(){

    }

    protected void testOverrideInDiffPackage(){
        System.out.println("Test if method overriden = Child");
    }

    public static void main(String[] args) {
            OrderChild oc = new OrderChild();
        System.out.println();
        System.out.println();
        OrderChild oc2 = new OrderChild();
        OrderParent op = new OrderParent();   //have access hence the same package
        TestInherFromOtherPackage testInher2 = new TestInherFromOtherPackage();  //if access modifier of constructor protected I don't have access from parent class
//        testInher2.testOverrideInDiffPackage();  //protected, hence not accessible
    }

}
