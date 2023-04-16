import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal {
    protected String name;
    protected LocalDate birthday;
    protected ArrayList<String> commands;

    public Animal(String name, LocalDate birthday, ArrayList<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
        Counter.add();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return String.format("%s ", this.birthday);
    }

    public void setBirthday (LocalDate birthday) {
        this.birthday = birthday;
    }

    public ArrayList<String> getCommands() {      
        return commands;
    }

    @Override
    public String toString() {
        
        return String.format("%s ", this.name);
}
}