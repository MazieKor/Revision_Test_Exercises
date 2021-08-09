package pl.mk.Java2;

public class StringFormatTest {

    public static void main(String[] args) {
        String test1 = "My answer is %09.4f";
        String result1 = String.format(test1, 123.89);   //works with d at the end
        System.out.println(result1);

        String test2 = "My answer is %09d";
        String result2 = String.format(test2, 12345);    //can't be decimal
        System.out.println(result2);

        String test3 = "My answer is %5s !";
        String result3 = String.format(test3, "12");    //can't be decimal
        System.out.println(result3);



    }
}
