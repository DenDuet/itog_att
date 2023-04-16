import java.time.LocalDate;
import java.util.ArrayList;

public class Donkey extends OtherAnimals implements Runable {

    public Donkey(String name, LocalDate birthday, ArrayList<String> commands) {
        super(name, birthday, commands);      
    }

    @Override
    public String run() {
        return String.format("А меня зовут %s и я могу медленно идти.", this.name);
    }

}
