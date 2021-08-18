package pl.mk.Java2;

public class OrderParent {
    String parentName = "parentName";
    {
        System.out.println(parentName);
    }
    static  String parentCity = "Zabrze";
    static {
        System.out.println(parentCity);
    }

    static String staticParentName = "staticParentName";
    static {
        System.out.println(staticParentName);
    }
    int test2 = 2323;

    OrderParent() {
        System.out.println("Parent Field2 is: " + test2);
        System.out.println("Parent Constr");
        staticParentName = "staticParent name in Constructor";
        System.out.println(staticParentName);
        methodTes2();


    }

    void methodTes2() {
        System.out.println("Method2 Parent, field2 is " + test2);
    }
}
