package pl.mk.Java1;

import pl.mk.Java2.OrderChild;

public class TestInherFromOtherPackage extends OrderChild {

    String testInher2 = inherTest;  //I have access to grandparent class' (class is default) field (field is protected)
    //String d2 = d; //I don't have acces to default parent field

    TestInherFromOtherPackage(){

    }

    public static void main(String[] args) {
        TestInherFromOtherPackage test = new TestInherFromOtherPackage();
    }

}
