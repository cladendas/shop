package ru;

import java.util.HashMap;
import java.util.Map;

/*  класс Tracker
    реализует логику работы с Product
    поиск, удаление, добавление, изменение
    содержит множество для хранения продуктов
    данный класс наследуется от класса Input, который реализует считывание данных с клавиатуры
*/
public class Tracker extends Input{

    /*  создание ссылки на множество
        ключом является артикул продукта и ключ имеет тип Integer
        значением является объект продукта с типом Product
     */
    static Map<Integer, Product> products = new HashMap();

    /*  метод для добавления продукта в множество
        аргументом является объект продукта
     */
    public void addProduct(Product prod) {

        /*  для добавления в множество используется метод put() класса HashMap
            в качестве ключа используется артикул продукта
            в качестве значения объект продукта
         */
        products.put(prod.getId(), prod);
    }

    /*  метод для удаления продукта из множество
        аргументом является артикул продукта
     */
    public void removeProduct(int id) {

        /*  для удаления продукта из множества используется метод remove() класса HashMap
            в качестве ключа используется артикул продукта введеный пользователем
         */
        products.remove(id);
    }

    /*  метод для поиска продукта в множестве
        аргументом является артикул продукта
        возвращает булевое значение
     */
    public boolean findProduct(int id) {

        /*  при выполнении условия выводит на экран, что продукт с указанным артикулом имеется в списке
            также выводится его наименование и артикул
            затем возвращается значение true
         */
        if(products.containsKey(id)) {
            System.out.println("Продукт с артикулом " + id + " имеется в списке\n" + "Его наименование и цена: " +
                    products.get(id).getName() + " " + products.get(id).getPrice());
            return true;

        /*  если условие не выполняется. то продукт с указанным артикулом отсутствует в списке
            затем возвращается значение false
         */
        } else {
            System.out.println("Продукт с артикулом " + id + " отсутствует в списке");
            return false;
        }
    }

    /*  метод для изменения продукта в множестве
        аргументом является артикул продукта
     */
    public void changeProductMethod (int id) {

        /*  непосредственно логика изменения продукта в множестве перенесена в класс TrackerChangeProduct
            здесь создается инстанс класса TrackerChangeProduct
         */
        TrackerChangeProduct changeProduct = new TrackerChangeProduct();

        // артикул продукта передается методу changeProductThereIs() для определения наличия такого продукта в множестве
        // управление передается классу TrackerChangeProduct
        changeProduct.changeProductThereIs(id);
    }

    // метод для вывода на экран всех продуктов из множества с указанием их наименований, цен и артикулов
    public void showAllProduct() {
        for (Product prod : products.values()) {
            System.out.println(prod.getName() + " " + prod.getPrice() + " " + prod.getId());
        }
    }
}