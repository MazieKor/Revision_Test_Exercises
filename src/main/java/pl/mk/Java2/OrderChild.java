package pl.mk.Java2;

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

    OrderChild() {
        methodTest();
        test = 7;
        test2 = 222222222;
        methodTest();
        System.out.println("Child Constr");
    }

    void methodTest() {
        System.out.println("Method, field is " + test);
        System.out.println("Method, field2 is " + test2);
    }

    void methodTes2() {
        System.out.println("Method2, field2 is " + test2);
    }

    public static void main(String[] args) {
            OrderChild oc = new OrderChild();
    }

}
