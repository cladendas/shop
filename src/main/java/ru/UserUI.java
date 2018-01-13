package ru;

//класс для взаимодействия с пользователем
public class UserUI extends Input{

    // ссылка на инстанс Tracker
    Tracker tracker = new Tracker();

    // переменные для хранения пунктов меню
    String menuSectionADD = ". Add\n";
    String menuSectionREMOVE = ". Remove\n";
    String menuSectionCHANGE = ". Change\n";
    String menuSectionFIND = ". Find\n";
    String menuSectionSHOWALL = ". Show all\n";
    String menuSectionEXIT = ". Exit\n";

    //переменная для хранения ключа меню ADD - добавление продукта
    final int ADD = 0;
    //переменная для хранения ключа меню REMOVE - удаление продукта
    final int REMOVE = 1;
    //переменная для хранения ключа CHANGE - изменение продукта
    final int CHANGE = 2;
    //переменная для хранения ключа FIND - поиск продукта
    final int FIND = 3;
    //переменная для хранения ключа SHOWALL - вывод всех продуктов в консоль
    final int SHOWALL = 4;
    //переменная для хранения ключа EXIT - выход из программы
    final int EXIT = 5;

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

    // переменная для хранения имени пользователя
    String name;

    public static void main(String[] args) {

        new UserUI().welcome();

    }

    // метод для знакомства с пользователей
    public void welcome() {

        // вывод в консоль первого сообщения-указания для определения имени пользователя
        String hello = "Представься...";
        System.out.println(hello);

        // считываение введеных данных и занесение их в переменную name, по которой к пользователю будут обращаться, как по имени
        name = inputString();

        // вызов метода, отвечающего за вывод меню
        init();
    }

    // метод для вывода стартового меню и обработки команд, относящихся к нему
    public void init() {

        // цикл для реализации работы с исключением и возобновления работы программы после возникновения исключения
        // вывод в консоль второго сообщения-указания для выбора дальнейших действий
        String whatDo = ", что сделать?";
        System.out.println(name + whatDo);

        // вывод в консоль меню и сообщения-указания "Select:"
        System.out.println(menuStart + "\nSelect:");

        // переменная для хранения введенного пользователем числа, указывающего на его выбор конкретного пункта меню
        menuChoice(inputInt());  // передача команды пользователя на обработку в метод menuChoice()
    }
    
    // метод для обработки команды пользователя
    public void menuChoice(int choice) {
        
        // проверка, что введеное пользователем число находится в диапазоне чисел, соответствующих пунктам меню
        if(choice > 5 || choice < 0) {

            // сообщение на необходимость введения числа в соответствии с пунктами меню
            System.out.println(mustWrite);

            // возврат к меню
            init();
            
            // введеная команда соответствует пункту меню ADD
        } else if (choice == ADD) {

            youWriteChoice(choice);

            // вывод сообщения о необходимости ввести имя продукта, цену продукта и артикул продукта
            System.out.println(forThisShouldNamePriceId);
            tracker.addProduct(new Product(writeNameProduct(), writePriceProduct(), writeIdProduct()));
            init();

            // введеная команда соответствует пункту меню REMOVE
        } else if (choice == REMOVE) {

            youWriteChoice(choice);

            // вывод сообщения о необходимости ввести имя продукта и артикул продукта
            System.out.println(forThisShouldNameId);
            // передача введеных пользователем данных для обработки с введенной командой
            tracker.removeProduct(writeNameProduct() ,writeIdProduct());

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню CHANGE
        } else if (choice == CHANGE) {

            youWriteChoice(choice);

            System.out.println(forChangeShouldNameId);

            // передача введеных пользователем данных для обработки с введенной командой
            tracker.changeProductMethod(writeNameProduct() ,writeIdProduct());

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню FIND
        } else if (choice == FIND) {
            youWriteChoice(choice);
            // вывод сообщения о необходимости ввести имя продукта и артикул продукта
            System.out.println(forThisShouldNameId);
            // передача введеных пользователем данных для обработки с введенной командой
            int indexProduct = tracker.findProduct(writeNameProduct(), writeIdProduct());
            if(indexProduct != -1) {
                System.out.println("такой продукт имеется в списке");
            } else {
                System.out.println("в списке такой продукт отсутствует");
            }

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню SHOWALL
        } else if (choice == SHOWALL) {
            youWriteChoice(choice);
            tracker.showAllProduct();
            init();

            // введеная команда соответствует пункту меню EXIT
        } else if (choice == EXIT) {
            youWriteChoice(choice);
        }
    }

    private void youWriteChoice(int choice) {

        System.out.println(youWrite + choice);

    }

    private String writeNameProduct() {
        System.out.println(name + writeName);
        String nameProduct = inputString();
        return nameProduct;
    }

    private int writePriceProduct() {
                System.out.println(name + writePrice);
                int priceProduct = inputInt();
                return priceProduct;
    }

    private int writeIdProduct() {
                System.out.println(name + writeId);
                int idProduct = inputInt();
                return idProduct;
    }

}