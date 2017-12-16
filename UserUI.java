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
    String menuSectionADD = ". Add\n";
    String menuSectionREMOVE = ". Remove\n";
    String menuSectionCHANGE = ". Change\n";
    String menuSectionFIND = ". Find\n";
    String menuSectionSHOWALL = ". Show all\n";
    String menuSectionEXIT = ". Exit\n";

    //переменная для хранения ключа меню ADD - добавление продукта
    private static final int ADD = 0;
    //переменная для хранения ключа меню REMOVE - удаление продукта
    private static final int REMOVE = 1;
    //переменная для хранения ключа CHANGE - изменение продукта
    private static final int CHANGE = 2;
    //переменная для хранения ключа FIND - поиск продукта
    private static final int FIND = 3;
    //переменная для хранения ключа SHOWALL - вывод всех продуктов в консоль
    private static final int SHOWALL = 4;
    //переменная для хранения ключа EXIT - выход из программы
    private static final int EXIT = 5;

    // переменная для хранения всех пунктов меню в сборе и с указанием номера каждого пункта
    String menuStart = ADD + menuSectionADD + REMOVE + menuSectionREMOVE + CHANGE + menuSectionCHANGE + FIND + menuSectionFIND +
            SHOWALL + menuSectionSHOWALL + EXIT + menuSectionEXIT;

    //переменные для хранения текстовых сообщений для пользователя
    String mustWrite = "Необходимо указать цифру, соответствующую выбранному полю меню...";
    String select = "\nSelect:";
    String youWrite = "Вы ввели: ";
    String forThisShouldNamePriceId = "Для этого действия необходимо ввести наименование продукта, его цену и артикул...";
    String writeName = " , введи наименование...";
    String writePrice = " , введи цену...";
    String writeId = " , введи артикул...";
    String forThisShouldNameId = "Для этого действия необходимо ввести наименование продукта и его артикул...";
    String forChangeShouldNameId = "Для этого действия необходимо ввести наименование и артикул продукта, данные которого хотите изменить...";



    static String name;




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
        scanner.nextLine();  // для отчистки буфера от \n

// передача введенного пользователем числа в Tracker
        menuChoise(answerMenuStart);

    }

    public void menuChoise(int choise) {

        if(choise > 5 || choise < 0) {
            System.out.println(mustWrite);

            init();

        } else if (choise == ADD) {
            System.out.println(youWrite + choise);
            System.out.println(forThisShouldNamePriceId);
            System.out.println(name + writeName);

                String nameProduct = scanner.nextLine();

            System.out.println(name + writePrice);

                int priceProduct = scanner.nextInt();

            System.out.println(name + writeId);

                int idProduct = scanner.nextInt();

            tracker.addProduct(new Product(nameProduct, priceProduct, idProduct));

            init();

        } else if (choise == REMOVE) {
            System.out.println(youWrite + choise);
            System.out.println(forThisShouldNameId);
            System.out.println(name + writeName);
            String nameProduct = scanner.nextLine();
            System.out.println(name + writeId);
            int idProduct = scanner.nextInt();

            tracker.removeProduct(nameProduct ,idProduct);


           // System.out.println("позиция с наименованием \"" + nameProduct + "\" удалена");



            init();

        } else if (choise == CHANGE) {
            System.out.println(youWrite + choise);
            System.out.println(forChangeShouldNameId);
            System.out.println(name + writeName);
            String nameProduct = scanner.nextLine();
            System.out.println(name + writeId);
            int idProduct = scanner.nextInt();

            tracker.changeProduct(nameProduct ,idProduct);

            init();

        } else if (choise == FIND) {
            System.out.println(youWrite + choise);
            System.out.println(forThisShouldNameId);
            System.out.println(name + writeName);
            String nameProduct = scanner.nextLine();
            System.out.println(name + writeId);
            int idProduct = scanner.nextInt();
            tracker.findProduct(nameProduct, idProduct);

            init();


        } else if (choise == SHOWALL) {
            tracker.showAllProduct();
            init();

        } else if (choise == EXIT) {
            System.out.println(youWrite + choise);

        }

    }


}
