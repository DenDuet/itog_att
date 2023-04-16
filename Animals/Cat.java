import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends HomeAnimals implements Playable {

    public Cat(String name, LocalDate birthday, ArrayList<String> commands) {
        super(name, birthday, commands);      
    }

    @Override
    public String play() {
        return String.format("Привет! Я %s. Давай поиграем!", this.name);
    }

}
