package pl.mk.Java2;

import pl.mk.Java1.TestInherFromOtherPackage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main01 {

    public static void main(String[] args) {
        Child child = new Child();  // 2 no-arguments constr. are invoked. There MUST BE a no-argument constr. in Parent to create child object (or no constr. in Parent at all)
        System.out.println("KONIEC TWORZENIA OBIEKTU CHILD");
        Child child2 = new Child("uwaga na konstruktry"); //no-argumrnt constr from Parent and argument constr from child
        System.out.println("KONIEC TWORZENIA OBIEKTU CHILD2");
        GrandChild grandChild = new GrandChild();
        System.out.println("KONIEC TWORZENIA OBIEKTU GRANDCHILD");
        Child child3 = new Child(1000);
        System.out.println(child3.age);  //can use this field age of parent; =1000
        System.out.println(child3.ageChild);  //=108
        System.out.print("testowanie super z GrandChild: ");
        grandChild.testSuperGrandChild();   // I can use super also with grandparent method


        child2.hiddenMethod();      //ChildHiddenMethod


        Object stringInstance = "string";
        String realString = (String) stringInstance;
        System.out.println("Casting: " + realString);    //prints "string"


        int test = 9;
        test = 14;
        System.out.println("int zwykły: " + test);
        final int TEST_F = 9;
//        TEST_F = 14;
        String testString = "Immutable";
        testString = "NotImmutable";
        System.out.println("String: " + testString);
        String testString2 = new String("NewImm");
        System.out.println("String z new: " + testString2);
        testString2 = "NewImm3";
        System.out.println("String z new po zmianie: " + testString2);

        Parent parent = new Parent();
        if (child == parent) {                 //I can compare without compilation error if there are parent - child relationship. Result = "nierówne"
            System.out.println("równe");
        } else
            System.out.println("nierówne");
        parent.printBook(3);
        parent.printBook(3L);  //testing overloaded methods with long vs int

        Fields fields = new Fields("test argumentowego konstr");  //only constructor with arguments is invoked

//Testing new Exception
        int testException = 101;
        try {                                                     //I can also use "throws" and try-catch higher (if newTestException extended RuntimeException - I wouldn't have to throws nor try-catch)
            if (testException > 100) {
                throw new newTestException(45L);
            } else {
                System.out.println("Exception Test: everything is OK");
            }
        } catch (newTestException e){
            System.out.println(e);              //displays message defined in Exception class + 45 number
            System.out.println("Exception Test: Caught new Exception");
        }

        DecimalFormat form = new DecimalFormat("#.00");
        String totalSumFormatted = form.format(0);
        System.out.println(totalSumFormatted);

        System.out.println(OrderParent.parentCity);
        OrderParent p = new OrderParent();   //static blocks only once invoked

        String tstRef = "testing references";
        String tstRef2 = tstRef;
        tstRef = "testing NEW references";     //creating new object
        System.out.println(tstRef + "\n" + tstRef2);

        String[] testRefArr = {"test", "ref", "arr"};
        String[] testRefArr2 = testRefArr;
        testRefArr[1] = "NEW REF";    //changing same object
        System.out.println(Arrays.toString(testRefArr) + "\n" + Arrays.toString(testRefArr2));

        System.out.println();
        OrderChild testInher= new TestInherFromOtherPackage();
        testInher.testOverrideInDiffPackage();

        TestInherFromOtherPackage testInher2 = new TestInherFromOtherPackage();
    }

}
