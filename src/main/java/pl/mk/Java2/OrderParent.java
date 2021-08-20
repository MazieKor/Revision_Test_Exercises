package pl.mk.Java2;

 class OrderParent {
    static  String parentCity = "Zabrze";
    static {
        System.out.println(parentCity);
    }

    static String staticParentName = "staticParentName";
    static {
        System.out.println(staticParentName);
    }

    OrderParent() {         //If only one constructor private - class cant be extended
        System.out.println("Parent Field2 is: " + test2);
        System.out.println("Parent Constr");
        staticParentName = "staticParent name in Constructor";
        System.out.println(staticParentName);
        methodTest2();    //I can make methodTest2 private for not overridden
    }

//    private OrderParent(int x){
//    }

    int test2 = 2323;
    protected String inherTest;
    static String parentName = "parentName";   //the same behavour will be with non-static
    {
        System.out.println(parentName);
    }

    void methodTest2() {
        System.out.println("Method2 Parent, field2 is " + test2);
    }

    void methodTest3(String... test){

    }

    public static void main(String[] args) {
        OrderParent p = new OrderChild();
        System.out.println();
        p.methodTest2();          //if methodTest2 private then it invokes method not from child like here but from parent
        String[] testVarArgs = new String[2];
        p.methodTest3(testVarArgs);  //but can't add any String more

        OrderParent parent = new OrderParent();
//        OrderChild child = (OrderChild) parent;  //throws ClassCastException
//        Child child11 = (Child) parent; // cannot cast to Child if not extended
        OrderChild child2 = new OrderChild();
        OrderParent parent2 = (OrderParent) child2; //possible but redundant
    }
}
