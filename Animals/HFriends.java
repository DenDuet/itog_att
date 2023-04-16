import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class HFriends implements AutoCloseable {
    Scanner sc = new Scanner(System.in);
    public List<Animal> animals;
    public HFriends() {
        ArrayList<String> command =  new ArrayList<>(Arrays.asList("бежать","прыгать"));
        ArrayList<String> command1 =  new ArrayList<>(Arrays.asList("играть","голос"));
        animals = new ArrayList<>(Arrays.asList(
            new Cat("Кис-кисыч", LocalDate.parse("2022-01-01"),command),
            new Dog("Лайма", LocalDate.parse("2020-10-17"),command1),
            new Hamster("Хома", LocalDate.parse("2021-11-11"),command),
            new Horse("Мерин", LocalDate.parse("2019-04-01"), command),
            new Donkey("Алдар", LocalDate.parse("2020-11-01"),command1)
            ));
        }

    public void play() {
        for (Playable animal : getPlayable()) {
            System.out.printf("%s\n", animal.play());
        }
    }

    public List<Playable> getPlayable() {
        List<Playable> result = new ArrayList<>();
        for (Animal playable : animals) {
            if (playable instanceof Playable) {
                result.add((Playable) playable);
            }
        }
        return result;
    }

    public List<Runable> getRunable() {
        List<Runable> result = new ArrayList<>();
        for (Animal runable : animals) {
            if (runable instanceof Runable) {
                result.add((Runable) runable);
            }
        }
        return result;
    }

    public void run() {
        for (Runable animal : getRunable()) {
            System.out.printf("%s\n", animal.run());
        }
    }

    public void printCommands() {
        for (Animal animal : animals) {
            System.out.printf("\n(%s) Имя: %s, дата рождения: %s, возраст (лет): %d, команды, которые, умеет выполнять: ", animal.getClass(), 
                    animal.name, animal.birthday, ChronoUnit.YEARS.between(animal.birthday,LocalDate.now()));
                    int size = animal.getCommands().size();
                    for (Object obj : animal.getCommands()) {
                        System.out.print(obj);
                        if (size > 1) {
                            System.out.print(", ");
                            size--;
                        }
                    }
           }
        System.out.println("\n");
    }    
 
    public String inputName() {
        System.out.println("Введите имя: ");
        String p = sc.nextLine();
        return p;           
    }

    public LocalDate inputBirthday() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Введите дату рождения (YYYY-MM-DD): ");
        String date = sc.nextLine();
        try {
            localDate = LocalDate.parse(date);
        } catch (Exception e) {
            System.out.println("\nНеправильно введена дата рождения! Записана сегодняшняя дата.");
        }
        return localDate;
    }

    public ArrayList<String> inputCommands() {
        System.out.println("Введите команды через запятую: ");
        String p = sc.nextLine();
        return new ArrayList<>(Arrays.asList(p.split(",")));  
    }

    public void add(int var) {
        System.out.println("\nВыберите тип животного: \n   1 - Кот \n   2 - Собака \n   3 - Хомяк \n   4 - Лошадь\n   5 - Осел\n");
        switch (sc.nextLine()) {
            case ("1") :
                if (var==0) {
                    System.out.println("Добавляем кота. ");
                    animals.add(new Cat(inputName(),inputBirthday(),inputCommands()));
                } else {

                }
                break;
            case ("2") :
                if (var==0) {
                System.out.println("Добавляем собаку. ");
                animals.add(new Dog(inputName(),inputBirthday(),inputCommands()));
                } else {

                }
                break;
            case ("3") :
                if (var==0) {
                    System.out.println("Добавляем хомяка. ");
                    animals.add(new Hamster(inputName(),inputBirthday(),inputCommands()));
                } else {

                }
                break;
            case ("4") :
                if (var==0) {
                    System.out.println("Добавляем лошадь. ");
                    animals.add(new Horse(inputName(),inputBirthday(),inputCommands()));
                } else {

                }
                break;
            case ("5") :
                if (var==0) {
                    System.out.println("Добавляем осла. ");
                    animals.add(new Donkey(inputName(),inputBirthday(),inputCommands()));
                } else {

                }
                break;
            default :
                System.out.println("Неправильный ввод..");
            }                      
    }

    public void addNewCommands() {
        int res=0;
        System.out.println("Введите имя животного, которому вы хотите добавить навыков: ");
        String name = sc.nextLine();
        for (Animal animal : animals) {
            if (animal.name.equals(name)) {
                System.out.printf("\n(%s) Имя: %s, дата рождения: %s, возраст (лет): %d, команды, которые, умеет выполнять: ", animal.getClass(), 
                    animal.name, animal.birthday, ChronoUnit.YEARS.between(animal.birthday,LocalDate.now()));
                    int size = animal.getCommands().size();
                    for (Object obj : animal.getCommands()) {
                        System.out.print(obj);
                        if (size > 1) {
                            System.out.print(", ");
                            size--;
                        }
                    }
                System.out.println("\n");
                ArrayList<String> newCommands = inputCommands();
                for (String string : newCommands) {
                    animal.commands.add(string);
                }
                res=1;
            } 
        }
        if (res==0) {
            System.out.println("Такого имени нет.");
        } else {
            System.out.println("Данные успешно добавлены.");
        }      
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    }

