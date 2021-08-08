package pl.mk.Java2;

public class PolymorphismTest {
    public static void main(String[] args) {
        Parent parent = new Child();
        Child child = new GrandChild();
        Parent parentGrChild = new GrandChild();
//        Child child2 = new Parent();   // it that direction doesn't work (without casting)
//        Child child2 = (Child) new Parent();      ClassCastException
        Child childChild = new Child();
        GrandChild grandChild = new GrandChild();
        Parent parentParent = new Parent();
        String string = "test";

        System.out.println("Testing using different arguments: ");
        Child.testPolyMorphismChild(grandChild);  //I can use grandChild, as it is also Child type
        // Child.testPolyMorphismChild(parent);      //I can't use it because this object is of Parent type, and Parent is not Child type
        Child.testPolyMorphismChild(child);      // I can of course use of type Child (object Grandchild)
//        Child.testPolyMorphismChild(child2);     // I can finally also use child2 (also type Child if casted)

        System.out.println("Testing referring to different METHODS - Grandchild");
        grandChild.testPolyMorphismGrandChild(grandChild);
        grandChild.testPolyMorphismParent(grandChild); // I see methods of Parent but use overriden in Child method and I can use grChild as argument
        grandChild.testPolyMorphismChild(grandChild);  //static method

        System.out.println("Testing referring to different METHODS - Parent");
        parentParent.testPolyMorphismParent(parent);  //normal use, from Parent (although method is overriden in Child)
//        parentParent.testPolyMorphismChild(child);  //I can't use child method

        System.out.println("Testing referring to different METHODS - polymorphism Parent");
        parent.testPolyMorphismParent(parent);     //Child if overriden in Child, if not- parent. If methods were static - no polymrphism, so parent method
        //parent.testPolyMorphismChild(child);    //I can't use child method, although object is Child
        parent.testPolyMorphismParent2(parent);   //Child, but if it were overriden only in Grandchild and not in Child - parent method was used (not Grandchild). If methods were static - no polymrphism, so parent method

        System.out.println("Testing referring to different METHODS - polymorphism Child");
        child.testPolyMorphismParent(parent);             //child if overriden in Child, if not- parent
        child.testPolyMorphismChild(child);               //I use child method
        //child.testPolyMorphismGrandChild(grandChild);  //I can't use grandchild method, although object is GrandChild

        System.out.println("Testing referring to different METHODS - polymorphism, overriden method, Child");
        grandChild.testPolyMorphismParent(parentParent);  //grandchild refers to child method (not Parent)
        childChild.testPolyMorphismParent(parentParent);  //child also refers to child method
        parentParent.testPolyMorphismParent(parentParent);  //of course refers to parent method
        child.testPolyMorphismParent(parentParent);       //also refers to child method
        parent.testPolyMorphismParent(parentParent);      //parent but refers to child method. If methods were static - no polymrphism, so parent method

        System.out.println("Testing referring to different METHODS - polymorphism2, overriden method, Child and GrandChild");
        grandChild.testPolyMorphismParent2(childChild);  //grandchild refers to grandchild method (not Child or Parent)
        childChild.testPolyMorphismParent2(childChild);  //child refers to child method
        parentParent.testPolyMorphismParent2(childChild);  //refers to parent method
        child.testPolyMorphismParent2(childChild);       //refers to GrandChild method. If methods were static - no polymrphism, so Child method
        parent.testPolyMorphismParent2(childChild);       //parent, refers to child method (not GrandChild). If methods were static - no polymrphism, so parent method
        parentGrChild.testPolyMorphismParent2(childChild);  //parent 2, refers to GrandChildmethod. If methods were static - no polymrphism, so parent method

//        System.out.println("Testing STATIC invoking");
//        Parent.testPolyMorphismParent(parent);                //uses parent method
//        Child.testPolyMorphismParent(parent);                 //uses child method

        System.out.println("Testing methods in constructor: ");
        Child2 child2 = new Child2();    //bug, but if childvalue is static shows correctly 1; if showinfo() method were static: it displays ParentValue: 456

    }

}