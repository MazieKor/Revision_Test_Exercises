package pl.mk.Java3;

public class Test {

    public static void main(String[] args) {
        Main01 test1 = new Main01();
        Main02 test2 = new Main02();
        System.out.println(test2.str);
        test2.str = test1.str;
        System.out.println(test2.str);
        System.out.println(test1.str);
        test2.str.append("Completely new StringBuilder");
        System.out.println(test2.str);
        System.out.println(test1.str);

    }

}
