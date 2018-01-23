package ru;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// класс Tracker
// реализует логику работы с Product
// поиск, удаление, добавление, изменение
// содержит массив для хранения продуктов
public class Tracker extends Input{

    static Map<Integer, Product> products = new HashMap();

    public void addProduct(Product prod) {
        products.put(prod.getId(), prod);
    }

    public void removeProduct(String nameProduct, int id) {
        products.remove(id);
    }

    public void findProduct(String nameProduct, int id) {
        if(products.containsKey(id)) {
            System.out.println("Продукт с артикулом " + id + " имеется в списке");
        } else {
            System.out.println("Продукт с артикулом " + id + " отсутствует в списке");
        }
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
     //   changeProduct.changeProductFindIndex(prod);
    }


    // метод для вывода в консоль всех продуктов
    // выводяся имена, цены и артикулы продуктов
    // каждый продукт с новой строки
    // если какая-то ячейка массива пуста, то выводитя сообщение, что ячейка пуста
    public void showAllProduct() {
        System.out.println(products);
    }
}