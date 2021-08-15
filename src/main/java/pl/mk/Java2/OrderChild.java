package pl.mk.Java2;

public class OrderChild extends OrderParent{
    int test;

    OrderChild() {
        methodTest();
        test = 7;
        methodTest();
        System.out.println("Child Constr");
    }

    void methodTest() {
        System.out.println("Method, field is " + test);
    }

    public static void main(String[] args) {
            OrderChild oc = new OrderChild();
    }

}
