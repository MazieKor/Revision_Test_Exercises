package pl.mk.Java2;

public class PolymorphismFieldsTest {
    public static void main(String[] args) {
        Parent parentChild = new Child();
        Child childGrChild = new GrandChild();
        Parent parentGrChild = new GrandChild();
        Parent parent = new Parent();
        Child child = new Child();
        GrandChild grandChild = new GrandChild();

        System.out.println("No polymorphism test:");
        System.out.println(parent.str1);
        System.out.println(parent.str2);
//        System.out.println(parent.str3);    //no such field in Parent so can't see
        System.out.println(parent.str4);

        System.out.println(child.str1);
        System.out.println(child.str2);
        System.out.println(child.str3);
        System.out.println(child.str4);     //refers to Parent (this field is only in Parent and GrandChild)

        System.out.println(grandChild.str1);
        System.out.println(grandChild.str2);   //refers to Child (this field is in Parent and Child)
        System.out.println(grandChild.str3);
        System.out.println(grandChild.str4);

        System.out.println("\n" + "Polymorphism test:");
        System.out.println(parentChild.str1);   //no polymorphysm so all refers to Parent
        System.out.println(parentChild.str2);
//        System.out.println(parentChild.str3);   //polymorphism doesn't apply. No such field in Parent so can't see, even if object is Child and in Child there is str3
        System.out.println(parentChild.str4);

        System.out.println(childGrChild.str1);    //no polymorphysm so all refers to Child
        System.out.println(childGrChild.str2);
        System.out.println(childGrChild.str3);
        System.out.println(childGrChild.str4);    //There is no str3 in Child. no polymorphism so doesnt refer to str4 in GrandChild. Refers to str4 in parent

        System.out.println(parentGrChild.str1);   //no polymorphysm so all refers to Parent
        System.out.println(parentGrChild.str2);
        // System.out.println(parentGrChild.str3);  //as in parentChild. Polymorphism doesn't apply. No such field in Parent so can't see, even if object is GrandChild and in GrandChild there is str3
        System.out.println(parentGrChild.str4);

        System.out.println("\n" + "Tests of getter: ");
        System.out.println(parent.getStr1Private());              //str1 Parent
        System.out.println(child.getStr1Private());              //Child
        System.out.println(grandChild.getStr1Private());          //no such method in GrChild so also Child
        System.out.println(parentChild.getStr1Private());           //polymorphysm so Child
        System.out.println(childGrChild.getStr1Private());          //Child (no method in GrChild)
        System.out.println(parentGrChild.getStr1Private());         //Child (!)  (no method in GrChild)

    }

}
