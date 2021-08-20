package pl.mk.Java2;

public class GrandChild extends Child {
//Testing Fields:
    String str1 = "str1 GRANDCHILD";
    private String str1Private = "str1 GRANDCHILD Private";
    String str3 = "str3 GRANDCHILD";
    private String str3Private = "str3 GRANDCHILD Private";
    String str4 = "str4 GRANDCHILD";
    private String str4Private = "str4 GRANDCHILD Private";

//    GrandChild(){
//        System.out.println("konstruktor bezargumentowy wnuk");
//    }

    public void testSuperGrandChild(){
        super.printBook(1);
    }

    public void testSuper(){
        System.out.println("test super method, GRANDCHILD");
        super.testSuper();
    }
    public void testParentGrandchildPolymorphism(){
        System.out.println("GRANDCHILD method in Parent - Grandchild polimorph.");
    }
    public void testPolyMorphismGrandChild(GrandChild grandChild){
        System.out.println("test Poly Grandchild");
    }

    public void testPolyMorphismParent2(Parent parent){
        System.out.println("test Poly2 - GRANDChild class");
    }

    public static void main(String[] args) {                    //without main method here I use main method in higher classes (Child or Parent)
        System.out.println("testing GrandChild main method");
        GrandChild ch = new GrandChild();
//        testSuper();         //use method from Child
        ch.testSuper();
    }
}
