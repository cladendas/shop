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

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product prod = (Product) obj;
        if (! getName().equals(prod.getName()))
            return false;
        if (getId() != prod.getId())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + id;
        return result;
    }
}