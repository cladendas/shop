package ru;

// класс для считывания введных данных с консоли
import java.util.InputMismatchException;
import java.util.Scanner;

// класс Tracker
// реализует логику работы с Product
// поиск, удаление, добавление, изменение
// содержит массив для хранения продуктов
public class Tracker {
    // массив products типа Product хранит прожукты (5 штук)
    Product[] products = new Product[5];

    // переменная index необходима для занесения продуктов в массив products поочередно в каждую ячейку
    // недочет: index будет увеличиваться при добавлении новых элементов в массив products,
    // но, когда будет один элемент удален из массива, его индекс не будет учтен при добавлении очередного
    private int index = 0;

    // метод для добавления продукта в массив Product
    // продукт добавляется в ячейку массива в соответствии со значением переменной index
    // при добавлении элемента также инкрементируется значение переменной index
    public void addProduct(Product prod) {
        products[index++] = prod;
    }

    // метод для удаления продукта из массива Product
    // принимает имя и артикул продукта, на их основании создает инстанс продукта с 0 ценой
    // для дальнейшего использования этого инстанса в работе метода
    // сравниваем каждый элемент массива с созданным инстансом
    // если в массиве products найден искомый prod, то найденной ячейке массива присваиваем null
    // если совпадений нет, то выводим сообщение об отсутствии совпадений
    public void removeProduct(String nameProduct, int id) {

        // инстанс, в его конструктор передаются входящие параметры метода с 0 ценой
        Product prod = new Product (nameProduct, 0, id);

        // цикл для сравнения элементов массива products с созданным инстансом
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && prod.equals(products[i])) {
                products[i] = null;
            } else {
                System.out.println("совпадений не найдено");
            }
        }
    }

    // метод для поиска продукта в массиве products
    // принимает имя и артикул продукта, на их основании создает инстанс продукта с 0 ценой
    // для дальнейшего использования этого инстанса в работе метода
    // сравниваем каждый элемент массива с созданным инстансом
    // если в массиве products найден искомый prod, то выводим имя продукта, его цену, артикул
    // если не найден, то ввыводим сообщение об отсутствии совпадений
    public boolean findProduct(String nameProduct, int id) {

        // инстанс, в его конструктор передаются входящие параметры метода с 0 ценой
        Product prod = new Product (nameProduct, 0, id);

        // цикл для сравнения элементов массива products с созданным инстансом
        for (int i = 0; i < products.length; i++) {
            if (prod.equals(products[i]))
                //System.out.println(products[i].getName() + " " + products[i].getPrice() + " " + products[i].getId());
            return true;
        }
        return false;
    }

    // метод для изменения продукта в массиве products
    // принимает имя и артикул продукта, на их основании создает инстанс продукта с 0 ценой
    // для дальнейшего использования этого инстанса в работе метода
    // после создания инстанса метода создаются переменные для хранения пунктов меню
    // создаются переменные для хранения нумерации пунктов меню
    // все переменные собираются в меню метода для изменения данных продукта в массиве products
    // сравниваем каждый элемент массива с созданным инстансом
    // если в массиве products найден искомый prod, то выводим сообщение, что продукт для изменения найден
    // в следующей строчке выводим имя продукта, его цену, артикул
    // если не найден, то ввыводим сообщение об отсутствии совпадений и выводим основное меню
    // когда продукт найден, выводится меню с пунктами возможных действий с данными искомого продукта
    // после выбора какого-либо пункта меню, пользователю указывют на необходимость ввода данных,
    // необходимых для выполнения введенной команды
    public void changeProduct (String nameProduct, int id) {

        // инстанс, в его конструктор передаются входящие параметры метода с 0 ценой
        Product prod = new Product (nameProduct, 0, id);

        // ссылка на класс Scanner для считывания введеных пользователем данных
        Scanner scanner = new Scanner(System.in);

        // переменные для хранения пунктов меню
        final String menuChangeSectionNAME = ". Наименование\n";
        final String menuChangeSectionPRICE = ". Цена\n";
        final String menuChangeSectionID = ". Артикул\n";
        final String menuChangeSectionCANCEL = ". Отмена\n";

        // переменные для хранения нумерации пунктов меню
        final int nameChange = 0;
        final int priceChange = 1;
        final int idChange = 2;
        final int cancelChange = 3;

        // переменная для сбора меню
        String menuChangeStart = nameChange + menuChangeSectionNAME + priceChange + menuChangeSectionPRICE +
                idChange + menuChangeSectionID + cancelChange + menuChangeSectionCANCEL;

        // переменная для хранения индекса элемента массива, данные которого необходимо изменить
        int findChangeProdIndex = 0;

        // цикл для сравнения элементов массива products с созданным инстансом
        // индекс элемента, который соответствует созданному инстансу, заносится в переменную findChangeProdIndex
        // затем выводится сообщение, что искомый элемент найден
        // затем выводятся его данные: имя, цена и артикул
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && prod.equals(products[i])) {
                findChangeProdIndex = i;
                System.out.println("продукт для изменения найден");
                System.out.println(products[i].getName() + " " + products[i].getPrice() + " " + products[i].getId());
                break;
            } else {
                System.out.println("совпадений не найдено");

                // выводим основное меню
                new UserUI().init();
            }
        }

        // цикл для вывода меню
        // после выполнения какого-либо из пунктов меню будет выводиться до тех пор,
        // пока не поступит команда ОТМЕНА
        while(true) {
            System.out.println("Что изменить в найденом продукте...");
            System.out.println(menuChangeStart);

            // проверка на возникновение исключения, если пользователь введет не целое положительное число
            try {
                // переменная для хранения введенного пользователем пункта меню
                int choiceChange = scanner.nextInt();

                // проверка, что введеное пользователем число находится в диапазоне чисел, соответствующих пунктам меню
                if (choiceChange > 3 || choiceChange < 0) {
                    System.out.println("Необходимо указать цифру, соответствующую выбранному полю меню...");
                    continue;

                } else if (choiceChange == nameChange) {
                    // сообщение-указание на необходимость ввода нового имени
                    System.out.println("Введи новое имя...");

                    scanner.nextLine();  // для отчистки буфера от \n

                        // переменная для хранения введенного пользователем нового имени
                        String choiceNewName = scanner.nextLine();

                    // изменение имени искомого продукта с использованием индекса этого продукта и метода
                    // класса Product для изменения имени продукта на введеное пользователем имя
                    // после изменения имени, цикл начинается заново с меню метода для изменения продукта
                    products[findChangeProdIndex].setName(choiceNewName);
                    continue;


                } else if (choiceChange == priceChange) {
                    // сообщение-указание на необходимость ввода новой цены
                    System.out.println("Введи новую цену...");

                    // проверка на возникновение исключения, если пользователь введет не целое положительное число
                    try {
                    // переменная для хранения введенной пользователем новой цены
                    int choiceNewPrice = scanner.nextInt();

                    // изменение цены искомого продукта с использованием индекса этого продукта и метода
                    // класса Product для изменения цены продукта на введеную пользователем цену
                    // после изменения цены, цикл начинается заново с меню метода для изменения продукта
                    products[findChangeProdIndex].setPrice(choiceNewPrice);
                    continue;
                    }
                    catch (InputMismatchException e) {  // ловля исключения и вывод в консоль сообщения-указания
                        System.out.println("ВВЕДИ ЧИСЛО");
                        scanner.nextLine();  // для отчистки буфера от \n
                    }

                } else if (choiceChange == idChange) {
                    // сообщение-указание на необходимость ввода нового артикула
                    System.out.println("Введи новый артикул...");

                    try {
                    // переменная для хранения введенной пользователем новой цены
                    int choiceNewId = scanner.nextInt();

                    // изменение артикула искомого продукта с использованием индекса этого продукта и метода
                    // класса Product для изменения артикула продукта на введеный пользователем артикул
                    // после изменения артикула, цикл начинается заново с меню метода для изменения продукта
                    products[findChangeProdIndex].setId(choiceNewId);
                    continue;
                    }
                    catch (InputMismatchException e) {  // ловля исключения и вывод в консоль сообщения-указания
                        System.out.println("ВВЕДИ ЧИСЛО");
                        scanner.nextLine();  // для отчистки буфера от \n
                    }

                    // выход из метода изменения продукта
                } else if (choiceChange == cancelChange) {
                    break;
                }
            }
            catch (InputMismatchException e) {  // ловля исключения и вывод в консоль сообщения-указания
                System.out.println("ВВЕДИ ЧИСЛО");
                scanner.nextLine();  // для отчистки буфера от \n
            }

            }
    }

    // метод для вывода в консоль всех продуктов
    // выводяся имена, цены и артикулы продуктов
    // каждый продукт с новой строки
    // если какая-то ячейка массива пуста, то выводитя сообщение, что ячейка пуста
    public void showAllProduct() {
        for(Product prod : products) {
            if (prod != null) {
                System.out.println(prod.getName() + " " + prod.getPrice()+ " " + prod.getId());
            } else {
                System.out.println("ячейка пуста");
            }
        }
    }
}