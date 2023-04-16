import java.time.LocalDate;
import java.util.ArrayList;

public class Horse extends OtherAnimals implements Runable {

    public Horse(String name, LocalDate birthday, ArrayList<String> commands) {
        super(name, birthday, commands);      
    }

    @Override
    public String run() {
        return String.format("Привет! Я %s. Я умею скакать 'Рысью'", this.name);
    }

}
