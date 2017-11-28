package shop;

// класс для считывания введных данных с консоли
import java.util.Scanner;

//класс для взаимодействия с пользователем
public class UserUI {

    Tracker tracker = new Tracker();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new UserUI().init();

    }

    public void init() {

        System.out.println("Представься...");

        String name = scanner.nextLine();

        System.out.printf("%s, что сделать?\n", answer);

        String menuSection0 = ". Add\n";
        String menuSection1 = ". Remove\n";
        String menuSection2 = ". Change\n";
        String menuSection3 = ". Find\n";
        String menuSection4 = ". Exit\n";

        String menuStart = 0 + menuSection0 + 1 + menuSection1 + 2 + menuSection2 + 3 + menuSection3 + 4 + menuSection4;

        System.out.println(menuStart + "\nSelect:");

        int answerMenuStart = scanner.nextInt();

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
            tracker.addProduct(new Product(nameProduct, priceProduct));

        } else if (answerMenuStart == 1) {
            System.out.println("Вы ввели: " + answerMenuStart);
            System.out.println("Для этого действия необходимо ввести наименование продукта или его артикул,\n если какой-то из пунктов неизвестен, то пропустите его нажав ENTER...");
            System.out.println(name + " , введи наименование...");
            String nameProduct = scanner.nextLine();
            System.out.println(name + " , а теперь введи артикул...");
            int idProduct = scanner.nextInt();
            tracker.removeProduct(new Product(nameProduct, null, idProduct));

        } else if (answerMenuStart == 2) {
            System.out.println("Вы ввели: " + answerMenuStart);
        } else if (answerMenuStart == 3) {
            System.out.println("Вы ввели: " + answerMenuStart);
        } else if (answerMenuStart == 4) {
            System.out.println("Вы ввели: " + answerMenuStart);
        }

    }


}
