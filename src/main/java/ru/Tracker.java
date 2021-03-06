package ru;

// класс Tracker
// реализует логику работы с Product
// поиск, удаление, добавление, изменение
// содержит массив для хранения продуктов
public class Tracker extends Input{

    //TrackerChangeProduct changeProduct = new TrackerChangeProduct();

    // массив products типа Product хранит прожукты (5 штук)
    static Product[] products = new Product[5];

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
    public int findProduct(String nameProduct, int id) {

        // инстанс, в его конструктор передаются входящие параметры метода с 0 ценой
        Product prod = new Product (nameProduct, 0, id);
        // цикл для сравнения элементов массива products с созданным инстансом
        for (int i = 0; i < products.length; i++) {
            if (prod.equals(products[i])) {
                return i;
            }
        }
        return -1;
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
    public void changeProductMethod (String nameProduct, int id) {
        Product prod = new Product(nameProduct, 0, id);
        TrackerChangeProduct changeProduct = new TrackerChangeProduct();
        changeProduct.changeProductFindIndex(prod);
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