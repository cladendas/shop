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
    // если совпадений нет, то возвращаем полученный аргумент
    public void removeProduct(Product prod) {
        for (Product pr : products) {
            if (prod.equals(pr)) {
                pr = null;
            }
        }
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
                return pr;
            }
        }
        return null;
    }
// метод для вывода в консоль всех продуктов
    public void showAllProduct() {
        for(Product prod : products) {
            if (null != prod) {
                System.out.println(prod.getName() + " " + prod.getPrice()+ " " + prod.getId());
            }
        }
    }
}