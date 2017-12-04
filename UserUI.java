package shop;

// класс для считывания введных данных с консоли
import java.util.Scanner;

//класс для взаимодействия с пользователем
public class UserUI {

// ссылка на инстанс Tracker
    Tracker tracker = new Tracker();
// ссылка на класс Scaner для возможности ввода пользоателем данных
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new UserUI().init();

    }

    public void init() {
// вывод в консоль первого сообщения-указания для определения имени пользователя
        String hello = "Представься...";
        System.out.println(hello);
// считываение введеных данных и занесение их в переменную name, по которой к пользователю будут обращаться, как по имени
        String name = scanner.nextLine();
// вывод в консоль второго сообщения-указания для выбора дальнейших действий
        String whatDo = ", что сделать?";
        System.out.println(name + whatDo);

// переменные для хранения пунктов меню
        String menuSection0 = ". Add\n";
        String menuSection1 = ". Remove\n";
        String menuSection2 = ". Change\n";
        String menuSection3 = ". Find\n";
        String menuSection4 = ". Exit\n";
// переменная для хранения всех пунктов меню в сборе и с указанием номера каждого пункта
        String menuStart = 0 + menuSection0 + 1 + menuSection1 + 2 + menuSection2 + 3 + menuSection3 + 4 + menuSection4;
// вывод в консоль меню и сообщения-указания "Select:"
        System.out.println(menuStart + "\nSelect:");
// переменная для хранения введенного пользователем числа, указывающего на его выбор конкретного пункта меню
        int answerMenuStart = scanner.nextInt();
// логика обработки введенного пользователем числа


        if(answerMenuStart > 4 || answerMenuStart < 0) {
            System.out.println("Необходимо указать цифру, соответствующую выбранному полю меню...");
            System.out.println(menuStart + "\nSelect:");
        } else if (answerMenuStart == 0) {
            System.out.println("Вы ввели: " + answerMenuStart);
            System.out.println("Для этого действия необходимо ввести наименование продукта и его цену...");
            System.out.println(name + " , введи наименование...");
            String nameProduct = scanner.nextLine();
            System.out.println(name + " , а теперь введи цену...");
            int priceProduct = scanner.nextInt();
            tracker.addProduct(new Product(nameProduct, priceProduct, 999));

        } else if (answerMenuStart == 1) {
            System.out.println("Вы ввели: " + answerMenuStart);
            System.out.println("Для этого действия необходимо ввести наименование продукта или его артикул,\n если какой-то из пунктов неизвестен, то пропустите его нажав ENTER...");
            System.out.println(name + " , введи наименование...");
            String nameProduct = scanner.nextLine();
            System.out.println(name + " , а теперь введи артикул...");
            int idProduct = scanner.nextInt();
            tracker.removeProduct(new Product(nameProduct, 0, idProduct));

        } else if (answerMenuStart == 2) {
            System.out.println("Вы ввели: " + answerMenuStart);
        } else if (answerMenuStart == 3) {
            System.out.println("Вы ввели: " + answerMenuStart);
        } else if (answerMenuStart == 4) {
            System.out.println("Вы ввели: " + answerMenuStart);
        }

    }


}
