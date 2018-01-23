package ru;

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

    public void removeProduct(int id) {
        products.remove(id);
    }

    public boolean findProduct(int id) {
        if(products.containsKey(id)) {
            System.out.println("Продукт с артикулом " + id + " имеется в списке\n" + "Его наименование и цена: " +
                    products.get(id).getName() + " " + products.get(id).getPrice());
            return true;
        } else {
            System.out.println("Продукт с артикулом " + id + " отсутствует в списке");
            return false;
        }
    }

    public void changeProductMethod (int id) {
        TrackerChangeProduct changeProduct = new TrackerChangeProduct();
        changeProduct.changeProductFindIndex(id);
    }

    public void showAllProduct() {
        for (Product prod : products.values()) {
            System.out.println(prod.getName() + " " + prod.getPrice() + " " + prod.getId());
        }
    }
}