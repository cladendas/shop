package shop;

// класс для считывания введных данных с консоли
import java.util.Scanner;

//класс для взаимодействия с пользователем
public class UserUI {

// ссылка на инстанс Tracker
   Tracker tracker = new Tracker();
// ссылка на класс Scaner для возможности ввода пользоателем данных
   Scanner scanner = new Scanner(System.in);

// переменные для хранения пунктов меню
    String menuSection0 = ". Add\n";
    String menuSection1 = ". Remove\n";
    String menuSection2 = ". Change\n";
    String menuSection3 = ". Find\n";
    String menuSection4 = ". Show all\n";
    String menuSection5 = ". Exit\n";
// переменная для хранения всех пунктов меню в сборе и с указанием номера каждого пункта
    String menuStart = 0 + menuSection0 + 1 + menuSection1 + 2 + menuSection2 + 3 + menuSection3 + 4 + menuSection4 + 5 + menuSection5;

    String name;



    public static void main(String[] args) {

        new UserUI().welcome();

    }



    public void welcome() {
// вывод в консоль первого сообщения-указания для определения имени пользователя
        String hello = "Представься...";
        System.out.println(hello);
// считываение введеных данных и занесение их в переменную name, по которой к пользователю будут обращаться, как по имени
        name = scanner.nextLine();

        init();
    }

    public void init() {
// вывод в консоль второго сообщения-указания для выбора дальнейших действий
        String whatDo = ", что сделать?";
        System.out.println(name + whatDo);

// вывод в консоль меню и сообщения-указания "Select:"
        System.out.println(menuStart + "\nSelect:");
// переменная для хранения введенного пользователем числа, указывающего на его выбор конкретного пункта меню
        int answerMenuStart = scanner.nextInt();

// передача введенного пользователем числа в Tracker
        tracker.menuChoise(answerMenuStart);

    }


}
