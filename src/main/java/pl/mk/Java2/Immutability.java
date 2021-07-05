package pl.mk.Java2;

//Testowanie immutability
public final class Immutability {
//    private final String name;  //pole nie może zostać final i bez możliwości zainicjalizowania (np. w konstr.)
    private final int age = 9;
    final int speed;  //gdyby była static musiałbym inicjalizować NIE w kontruktorze, a w linii 
    String modelName;


    public Immutability(int speed) {
      this.speed = speed;   //jeśli inicjalizuje wyżej w polu to już nie moge zmienić w konstr.
    }


//    public Immutability() {
//        speed = 34;   //jeśli inicjalizuje wyżej w polu to już nie moge zmienić w konstr.
//    }


    @Override
    public String toString() {
        return "Immutability{" +
                "age=" + age +
                ", speed=" + speed +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
