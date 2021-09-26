package pl.mk.Java1;

import pl.mk.Java2.OrderChild;


public class TestInherFromOtherPackage extends OrderChild {

    String testInher2 = inherTest;  //I have access to grandparent class' (class is default) field (field is protected)
    //String d2 = d; //I don't have acces to default parent field


    public TestInherFromOtherPackage(){
    }

    protected void testOverrideInDiffPackage(){
        System.out.println("Test if method overriden = GrandChild");
    }


    public void testProtectedChild(){
//        OrderChild testInher2 = new OrderChild();  //I cant make an object if constructor protected
//        testInher2.testProtectedParent();  //no access to protected method from superclass object (even if OrderChild constructor public)

        TestInherFromOtherPackage testInher3 = new TestInherFromOtherPackage();
        testInher3.testProtectedParent();  //access via subclass type
    }

    public static void main(String[] args) {
        TestInherFromOtherPackage test = new TestInherFromOtherPackage();

//        OrderChild testInher2 = new OrderChild();  //if access modifier of OrderChild constructor protected I don't have access from subclass
//        testInher2.testProtectedParent();
        //int b = testInher2.test;   //as in methods no access if field protected

        TestInherFromOtherPackage testInher3 = new TestInherFromOtherPackage();
        testInher3.testProtectedParent();  //access via subclass type

        
        OrderChild testInher4 = new TestInherFromOtherPackage();
//        testInher4.testProtectedParent();  //no access via superclass type (though subclass object)

        TestInherFromOtherPackageChild testInher5 = new TestInherFromOtherPackageChild();
        testInher5.testProtectedParent();     //I have access from granChild type

        TestInherFromOtherPackage testInher6 = new TestInherFromOtherPackageChild();
        testInher6.testProtectedParent();
    }

}
