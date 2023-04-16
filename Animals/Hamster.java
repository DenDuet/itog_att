import java.time.LocalDate;
import java.util.ArrayList;

public class Hamster extends HomeAnimals implements Runable {
    public Hamster(String name, LocalDate birthday, ArrayList<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String run() {    
        return String.format("Я %s. Могу бегать быстро и долго", this.name);
    }
}