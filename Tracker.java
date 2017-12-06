package shop;

// класс для считывания введных данных с консоли
import java.util.Scanner;

// класс Tracker
// реализует логику работы с Product
// поиск, удаление, добавление, изменение
// содержит массив для хранения продуктов

public class Tracker {
    // массив products типа Product хранит прожукты (5 штук)
    private final Product[] products = new Product[5];
    // переменная idCount необходима для генерации id
    private int idCount = 0;
    // переменная index необходима для занесения продуктов в массив products поочередно в каждую ячейку
    // недочет: index будет увеличиваться при добавлении новых элементов в массив products,
    // но, когда будет один элемент удален из массива, его индекс не будет учтен при добавлении очередного
    private int index = 0;
    // метод для возврата id
    public int getId() {
        idCount++;
        return this.idCount;
    }

    // ссылка на класс Scanner для возможности ввода пользоателем данных
    Scanner scanner = new Scanner(System.in);

    private static final int ADD = 0;
    private static final int REMOVE = 1;
    private static final int CHANGE = 2;
    private static final int FIND = 3;
    private static final int SHOWALL = 4;
    private static final int EXIT = 5;


    public String menuChoise(int choise) {

        String menuStart = new UserUI().menuStart;
        String name = new UserUI().name;

        if(choise > 4 || choise < 0) {
            System.out.println("Необходимо указать цифру, соответствующую выбранному полю меню...");
            System.out.println(menuStart + "\nSelect:");
        } else if (choise == ADD) {
            System.out.println("Вы ввели: " + choise);
            System.out.println("Для этого действия необходимо ввести наименование продукта, его цену и артикул...");
            System.out.println(name + " , введи наименование...");
            String nameProduct = scanner.nextLine();
            System.out.println(name + " , введи цену...");
            int priceProduct = scanner.nextInt();
            System.out.println(name + " , введи артикул...");
            int idProduct = scanner.nextInt();
            addProduct(new Product(nameProduct, priceProduct, idProduct));

            System.out.println(menuStart + "\nSelect:");

        } else if (choise == REMOVE) {
            System.out.println("Вы ввели: " + choise);
            System.out.println("Для этого действия необходимо ввести наименование продукта или его артикул,\n если какой-то из пунктов неизвестен, то пропустите его нажав ENTER...");
            System.out.println(name + " , введи наименование...");
            String nameProduct = scanner.nextLine();
            System.out.println(name + " , а теперь введи артикул...");
            int idProduct = scanner.nextInt();
            removeProduct(new Product(nameProduct, 0, idProduct));

            System.out.println(menuStart + "\nSelect:");

        } else if (choise == CHANGE) {
            System.out.println("Вы ввели: " + choise);

            System.out.println(menuStart + "\nSelect:");
        } else if (choise == FIND) {
            System.out.println("Вы ввели: " + choise);
            System.out.println("Для этого действия необходимо ввести наименование продукта или его артикул,\n если какой-то из пунктов неизвестен, то пропустите его нажав ENTER...");
            String nameProduct = scanner.nextLine();
            System.out.println(name + " , а теперь введи артикул...");
            int idProduct = scanner.nextInt();
            Product prod = findProduct(new Product(nameProduct, 0, idProduct));
            String prodFind = prod.getName();

            System.out.println(menuStart + "\nSelect:");


        } else if (choise == SHOWALL) {
            showAllProduct();

        } else if (choise == EXIT) {
            System.out.println("Вы ввели: " + choise);

        }

        return menuStart;
    }

    // метод для добавления продукта в массив Product
    // продукт добавляется в ячейку массива в соответствии со значением переменной index
    // при добавлении элемента также инкрементируется значение переменной index
    public Product addProduct(Product prod) {
        products[index++] = prod;
        return prod;
    }
    // метод для удаления продукта из массива Product
    // принимает продукт необходимый к удалению
    // сравниваем каждый элемент массива с аргументов метода
    // если в массиве Product найден искомый prod, то найденной ячейке массива присваиваем null
    // если совпадений нет, то возвращаем полученный аргумент
    public Product removeProduct(Product prod) {
        for (Product pr : products) {
            if (pr.equals(prod)) {
                pr = null;
            } else {
                return prod;
            }
        }
        return prod;
    }
    // метод для поиска продукта в массиве Product
    // принимает продукт необходимый к поиску
    // если в массиве Product найден искомый prod, то возвращаем продукт из массива
    // если не найден, то возвращаем null
    public Product findProduct(Product prod) {
        for (Product pr : products) {
            if (pr.equals(prod)) {
                return pr;
            }
        }
        return null;
    }
    // метод для изменения продукта в массиве Product
    // принимает продукт необходимый к изменению
    // если в массиве Product найден искомый prod, то заменяем найденный продукт на prod
    // если не найден, то возвращаем null
    public Product changeProduct (Product prod) {
        for (Product pr : products) {
            if (pr.equals(prod)) {
                pr = prod;
                return prod;
            }
        }
        return null;
    }
// метод для вывода в консоль всех продуктов
    public void showAllProduct() {
        for(Product prod : products) {
            System.out.println(prod);
        }
    }
}