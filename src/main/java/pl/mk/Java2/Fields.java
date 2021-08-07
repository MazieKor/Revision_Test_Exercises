package pl.mk.Java2;

public class Fields {
    static int age = 20;
    final static int volume = 20;
    int height;  // = 0 (do testu metody 7)


    Fields(){
        System.out.println("konstr bezarg. Fields");
    }
    Fields(String display){
        System.out.println("konstr. argumentowy Fields " + display);
    }

    public static void main(String[] args) {
//        age = 30;
////        height = -90;  //nie mam dostępu do non-static
//        int volume = 50; //mogę nazwać zmienną tak jak pole final
////        int age = 40;
//        int speed = 20;

        Fields fields = new Fields();
//        fields.height = 88; //mam dostęp do non-static. Bez stworzenia obiektu miałbym dostęp tylko do static
//        fields.age = 14;  //mam dostęp do static
//        System.out.println("static age z obiektem = 14: " + age);
//
//        method2(speed);
//        method4(age);
//        System.out.println("field age Main: " + age); //40; jeśli int age dam pod komentarz to 50
        fields.method6();
//        System.out.println("field age=777: " + age); //zmiana age w metodzie niestatycznej, przy przypisaniu do obiektu

        fields.age = 999;
        fields.height = 999;
        fields.method7(); // jeśli do tego testu inne rzeczy zakomentuje dostanę w wyniku ten sam wynik (choć w metodzie jedno dodawanie jest age + height - inaczej niż w teście 6 chyba dlatego, że tu wywołuję metodę na danym obiekcie)

    }

    static void method2(int speed){
        age = 40;
    }

    static void method3(int age){
        age = 40;
    }
    static void method4(int ageOfMethod){
        age = 50;
        ageOfMethod = 900;
        System.out.println("field age: " + age);
        System.out.println("field ageOfMethod: " + ageOfMethod);

    }
    static void method5(int volume){ //zmienna o takiej samej nazwie jak final
        age = 50;
        volume = 90;
        int c = age + volume;

    }

    void method6(){   //z metod non-static mam dostę do poł zarówno static jak i non-static
        height = 99;
        age = 999;
        System.out.println("method6: height=99: " + height); //99
        Fields fields = new Fields();
        fields.height = 77;
        fields.age = 777;
        System.out.println("method6: height=?: " + height);  //99
        System.out.println("method6: height=77: " + fields.height); //77
    }

    void method7(){
        int test1 = this.age + this.height;
        System.out.println("1 test: this.age + this.height: " + test1);
        int test2 = age + height;
        System.out.println("2 test: age + height: " + test2);
    }

}
