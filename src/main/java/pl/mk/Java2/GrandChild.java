package pl.mk.Java2;

public class GrandChild extends Child {


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
