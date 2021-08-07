package pl.mk.Java2;

public class GrandChild extends Child {
//Testing Fields:
    String str1 = "str1 GRANDCHILD";
    private String str1Private = "str1 GRANDCHILD Private";
    String str3 = "str3 GRANDCHILD";
    private String str3Private = "str3 GRANDCHILD Private";
    String str4 = "str4 GRANDCHILD";
    private String str4Private = "str4 GRANDCHILD Private";

    public void testSuperGrandChild(){
        super.printBook(1);
    }

    public void testPolyMorphismGrandChild(GrandChild grandChild){
        System.out.println("test Poly Grandchild");
    }

    public void testPolyMorphismParent2(Parent parent){
        System.out.println("test Poly2 - GRANDChild class");
    }
}
