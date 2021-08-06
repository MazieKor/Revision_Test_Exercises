package pl.mk.Java2;

import java.util.ArrayList;
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


        child2.hiddenMethod();


        Object stringInstance = "string";
        String realString = (String) stringInstance;


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
        if(child == parent){                 //I can compare without compilation error if there are parent - child relationship
            System.out.println("równe");
        } else
            System.out.println("nierówne");
        parent.printBook(3);
        parent.printBook(3L);  //testing overloaded methods with long vs int

        Fields fields = new Fields("test argumentowego konstr");  //only constructor with arguments is invoked

    }



}
