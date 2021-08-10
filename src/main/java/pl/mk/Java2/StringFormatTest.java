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

        String test4 = "My answer is %h !";
        String result4 = String.format(test4, "rdt");    //gives hexadecimal 1b882
        System.out.println(result4);

        String test5 = "My answer is %c !";
        String result5 = String.format(test5, 56);     //gives 8
        System.out.println(result5);

        String test6 = "My answer %n is %f !";
        String result6 = String.format(test6, 17688.9899999d);     //gives automatically 8 decimal places + next line
        System.out.println(result6);

        String test7 = "My answer %nis %% %.4s !";
        String result7 = String.format(test7, "NOWY ARG");     //limits signs in string
        System.out.println(result7);

        String test8 = "My answer is %f and %f !";
        String result8 = String.format(test8, 142d, 99d);     //without direct pointing an argument ($)
        System.out.println(result8);

    }
}