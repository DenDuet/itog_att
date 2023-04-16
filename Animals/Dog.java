import java.time.LocalDate;
import java.util.ArrayList;

public class Dog extends HomeAnimals implements Runable {
    public Dog(String name, LocalDate birthday, ArrayList<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String run() {    
        return String.format("Я %s. Могу бежать со скоростью 50 км/ч", this.name);
    }
}