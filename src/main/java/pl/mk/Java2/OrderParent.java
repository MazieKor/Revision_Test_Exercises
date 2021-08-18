package pl.mk.Java2;

public class OrderParent {
    static  String parentCity = "Zabrze";
    static {
        System.out.println(parentCity);
    }

    static String staticParentName = "staticParentName";
    static {
        System.out.println(staticParentName);
    }

    OrderParent() {
        System.out.println("Parent Field2 is: " + test2);
        System.out.println("Parent Constr");
        staticParentName = "staticParent name in Constructor";
        System.out.println(staticParentName);
        methodTest2();
    }
    int test2 = 2323;
    static String parentName = "parentName";   //the same behavour will be with non-static
    {
        System.out.println(parentName);
    }

    void methodTest2() {
        System.out.println("Method2 Parent, field2 is " + test2);
    }
}
