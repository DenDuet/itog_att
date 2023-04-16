import java.util.Scanner;

public class Program {
    public static void menu() {
        try (HFriends animal = new HFriends()) {
            try (Scanner sc = new Scanner(System.in)) {
                while (true) {
                    System.out.println("\nВыберите что делать: \n   1 - Завести новое животное \n   2 - Показать команды \n   3 - Добавить новые команды \n   4 - Вывести полный список животных\n   5 - Выход\n");
                    switch (sc.nextLine()) {
                        case ("1") :
                            System.out.println("Выберите тип животного: \n");
                            animal.add(0);
                            break;
                        case ("2") :
                            System.out.println("Команды, которые животные умеют выполнять: \n");
                            animal.printCommands();
                            break;
                        case ("3") :
                            System.out.println("Добавим новые команды: \n");
                            animal.addNewCommands();
                            break;
                        case ("4") :
                            System.out.println("Полный список: \n");
                            System.out.println("Всего животных: " + Counter.getCounter());
        
                            System.out.println("Из них: \n  Играют: ");
                            animal.play();
                            System.out.println("\n  Бегают: ");
                            animal.run();
                            break;
                        case ("5") :
                            System.exit(0);
                        default :
                            System.out.println("Неправильный ввод..");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // HFriends animal = new HFriends();
        

        
        menu();
       
    }

}
