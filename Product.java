package shop;

// класс Product
// описывает объект продукт
// поле name - наименование продукта, поле price - цена продукта, поле id - артикул продукта
// есть явно заданный конструктор
// методы для возврата и установки имени
// меотды для возврата и установки цены
public class Product {
    // перемененная для описания имени продукта
    private String name;
    // переменная для описания цены продукта
    private int price;
    // переменная для описания артикула продукта
    private int id;
    // конструктор класса
    // принимает имя и цену продукта
    public Product(String name, int price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }
    // метод для возврата имени
    public String getName() {
        return name;
    }
    // метод для утсановки именя
    public void setName(String name) {
        this.name = name;
    }
    // метод для возврата цены
    public int getPrice() {
        return price;
    }
    // метод для возврата цены
    public void setPrice(int price) {
        this.price = price;
    }
}