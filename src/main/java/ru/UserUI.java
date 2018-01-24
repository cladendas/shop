package ru;

/*  класс для взаимодействия с пользователем
    выводит на экран основное меню
    выводит сообщения-указания на необходимые дейсвтия со стороны пользователя
    данный класс наследуется от класса Input, который реализует считывание данных с клавиатуры
 */
public class UserUI extends Input{

    // ссылка на инстанс Tracker
    Tracker tracker = new Tracker();

    // переменные для хранения пунктов основного меню
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
    static final int EXIT = 5;

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
    String forThisShouldId = "Для этого действия необходимо ввести артикул продукта...";
    String forChangeShouldNameId = "Для этого действия необходимо ввести наименование и артикул продукта, данные которого хотите изменить...";

    // переменная для хранения имени пользователя
    static String name;

    public static void main(String[] args) {

        new UserUI().welcome();

    }

    // метод для знакомства с пользователей
    public void welcome() {

        // вывод в консоль первого сообщения-указания для определения имени пользователя
        String hello = "Представься...";
        System.out.println(hello);

        /*  считываение введеных данных и занесение их в переменную name, по которой к пользователю будут обращаться, как по имени
            в данном методе для считывания данных используется метод inputString() от класса предка Input
         */
        name = inputString();

        // вызов метода, отвечающего за вывод меню
        init();
    }

    // метод для вывода стартового меню и обработки команд, относящихся к нему
    public void init() {

        // вывод в консоль второго сообщения-указания для выбора дальнейших действий
        String whatDo = ", что сделать?";
        System.out.println(name + whatDo);

        // вывод в консоль меню и сообщения-указания "Select:"
        System.out.println(menuStart + select);

        /*  передача команды пользователя на обработку в метод menuChoice()
            в данном методе для считывания данных используется метод inputInt() от класса предка Input
         */
        menuChoice(inputInt());
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

            // сообщение о том, какую команду ввел пользователь
            youWriteChoice(choice);

            // вывод сообщения о необходимости ввести имя продукта, цену продукта и артикул продукта
            System.out.println(forThisShouldNamePriceId);

            /*  передача введенных данных методу addProduct класса Tracker
                в данном методе данные считываются с помощью методов writeNameProduct(), writePriceProduct(), writeIdProduct()
             */
            tracker.addProduct(new Product(writeNameProduct(), writePriceProduct(), writeIdProduct()));

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню REMOVE
        } else if (choice == REMOVE) {

            // сообщение о том, какую команду ввел пользователь
            youWriteChoice(choice);

            // вывод сообщения о необходимости ввести имя продукта и артикул продукта
            System.out.println(forThisShouldId);
            
            /*  передача введеных данных методу removeProduct() класса Tracker
                в данном методе данные считываются с помощью метода writeIdProduct()
             */
            tracker.removeProduct(writeIdProduct());

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню CHANGE
        } else if (choice == CHANGE) {

            // сообщение о том, какую команду ввел пользователь
            youWriteChoice(choice);

            // вывод сообщения о необходимости ввести артикул продукта
            System.out.println(forThisShouldId);

            /*  передача введеных данных методу changeProductMethod() класса Tracker
                в данном методе данные считываются с помощью метода writeIdProduct()
             */
            tracker.changeProductMethod(writeIdProduct());

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню FIND
        } else if (choice == FIND) {

            // сообщение о том, какую команду ввел пользователь
            youWriteChoice(choice);

            // вывод сообщения о необходимости ввести имя продукта и артикул продукта
            System.out.println(forThisShouldId);

            /*  передача введеных данных методу findProduct() класса Tracker
                в данном методе данные считываются с помощью метода writeIdProduct()
             */
            tracker.findProduct(writeIdProduct());

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню SHOWALL
        } else if (choice == SHOWALL) {

            // сообщение о том, какую команду ввел пользователь
            youWriteChoice(choice);

            // выполнение метода showAllProduct() класса Tracker
            tracker.showAllProduct();

            // возврат к меню
            init();

            // введеная команда соответствует пункту меню EXIT
        } else if (choice == EXIT) {

            // сообщение о том, какую команду ввел пользователь
            youWriteChoice(choice);
        }
    }

    // метод для вывода на экран введеной пользователем команды
    private void youWriteChoice(int choice) {

        System.out.println(youWrite + choice);

    }

    /*  метод для считывания введоного пользователем наименования продукта
        возвращает введеное наименование
     */
    private String writeNameProduct() {

        // вывод сообщения-указания о вводе наименования
        System.out.println(name + writeName);

        // для считывания данных используется метод inputInt() от класса предка Input
        String nameProduct = inputString();
        
        return nameProduct;
    }

    /*  метод для считывания введоную пользователем цену продукта
        возвращает введеную цену
     */
    private int writePriceProduct() {

        // вывод сообщения-указания о вводе цены
        System.out.println(name + writePrice);

        // в данном методе для считывания данных используется метод inputInt() от класса предка Input
        int priceProduct = inputInt();
        
        return priceProduct;
    }

    /*  метод для считывания введоного пользователем артикула продукта
        возвращает введеный артикул
     */
    private int writeIdProduct() {

        // вывод сообщения-указания о вводе артикула
        System.out.println(name + writeId);

        // в данном методе для считывания данных используется метод inputInt() от класса предка Input
        int idProduct = inputInt();
        
        return idProduct;
    }
}