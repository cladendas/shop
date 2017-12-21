package shop;

// класс для считывания введных данных с консоли
import java.util.Scanner;

// класс Tracker
// реализует логику работы с Product
// поиск, удаление, добавление, изменение
// содержит массив для хранения продуктов

public class Tracker {
    // массив products типа Product хранит прожукты (5 штук)
    Product[] products = new Product[5];

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
  //  Scanner scanner = new Scanner(System.in);





    // метод для добавления продукта в массив Product
    // продукт добавляется в ячейку массива в соответствии со значением переменной index
    // при добавлении элемента также инкрементируется значение переменной index
    public void addProduct(Product prod) {
        products[index++] = prod;
    }
    // метод для удаления продукта из массива Product
    // принимает продукт необходимый к удалению
    // сравниваем каждый элемент массива с аргументов метода
    // если в массиве Product найден искомый prod, то найденной ячейке массива присваиваем null
    // если совпадений нет, то возвращаем сообщение об отсутствии совпадений
    public void removeProduct(String nameProduct, int id) {
        Product prod = new Product (nameProduct, 0, id);

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && prod.equals(products[i])) {
                products[i] = null;
            } else {
                System.out.println("совпадений не найдено");
            }
        }
    }
    // метод для поиска продукта в массиве Product
    // принимает продукт необходимый к поиску
    // если в массиве Product найден искомый prod, то возвращаем продукт из массива
    // если не найден, то возвращаем null
    public void findProduct(String nameProduct, int id) {
        Product prod = new Product (nameProduct, 0, id);
        for (int i = 0; i < products.length; i++) {
            if (prod.equals(products[i])) {
                System.out.println(products[i].getName() + " " + products[i].getPrice() + " " + products[i].getName());
            } else {
                System.out.println("совпадений не найдено");
            }
        }
    }

    // метод для изменения продукта в массиве Product
    // принимает продукт необходимый к изменению
    // если в массиве Product найден искомый prod, то заменяем найденный продукт на prod
    // если не найден, то возвращаем null
    public void changeProduct (String nameProduct, int id) {
        Product prod = new Product (nameProduct, 0, id);

        final String menuChangeSectionNAME = ". Наименование\n";
        final String menuChangeSectionPRICE = ". Цена\n";
        final String menuChangeSectionID = ". Артикул\n";
        final String menuChangeSectionCANCEL = ". Отмена\n";

        final int nameChange = 0;
        final int priceChange = 1;
        final int idChange = 2;
        final int cancelChange = 3;

        int findChangeProdIndex = 0;

        String menuChangeStart = nameChange + menuChangeSectionNAME + priceChange + menuChangeSectionPRICE +
                idChange + menuChangeSectionID + cancelChange + menuChangeSectionCANCEL;


        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && prod.equals(products[i])) {
                findChangeProdIndex = i;
                System.out.println("продукт для изменения найден");
                System.out.println(products[i].getName() + " " + products[i].getPrice() + " " + products[i].getId());
            }
        }



        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Что изменить в найденом продукте...");
            System.out.println(menuChangeStart);

            int choiceChange = scanner.nextInt();

            if (choiceChange > 3 || choiceChange < 0) {
                System.out.println("Необходимо указать цифру, соответствующую выбранному полю меню...");
                continue;
            } else if (choiceChange == nameChange) {
                System.out.println("Введи новое имя...");

                scanner.nextLine();  // для отчистки буфера от \n

                String choiceNewName = scanner.nextLine();

                products[findChangeProdIndex].setName(choiceNewName);
                continue;

            } else if (choiceChange == priceChange) {
                System.out.println("Введи новую цену...");

                int choiceNewPrice = scanner.nextInt();

                products[findChangeProdIndex].setPrice(choiceNewPrice);
                continue;
            } else if (choiceChange == idChange) {
                System.out.println("Введи новый артикул...");

                int choiceNewId = scanner.nextInt();

                products[findChangeProdIndex].setId(choiceNewId);
                continue;
            } else if (choiceChange == cancelChange) {
                break;
            }

        }

    }
// метод для вывода в консоль всех продуктов
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