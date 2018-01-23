package ru;

public class TrackerChangeProduct extends Tracker{

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

    public void changeProductFindIndex(int id) {
        if (findProduct(id)) {
            changeProductMenu(id);
        }
        System.out.println("совпадений не найдено");

        // выводим основное меню
        new UserUI().init();
    }

    private void changeProductMenu(int id) {

        // переменная для сбора меню
        String menuChangeStart = nameChange + menuChangeSectionNAME + priceChange + menuChangeSectionPRICE +
                idChange + menuChangeSectionID + cancelChange + menuChangeSectionCANCEL;

        // цикл для вывода меню
        // после выполнения какого-либо из пунктов меню будет выводиться до тех пор,
        // пока не поступит команда ОТМЕНА
        System.out.println("Что изменить в найденом продукте...");
        System.out.println(menuChangeStart);

        int choiceChange = inputInt();
        changeProductField(choiceChange, id);

    }

    private void changeProductField(int choiceChange, int id) {
        if (choiceChange > 3 || choiceChange < 0) {
            System.out.println("Необходимо указать цифру, соответствующую выбранному полю меню...");
        } else if (choiceChange == nameChange) {

            System.out.println("Введи новое имя...");
            changeProductName(inputString(), id);
            changeProductMenu(id);
        }
    }
//
//        } else if (choiceChange == priceChange) {
//
//            System.out.println("Введи новую цену...");
//            changeProductPrice(inputInt());
//            changeProductMenu();
//
//        } else if (choiceChange == idChange) {
//
//            System.out.println("Введи новый артикул...");
//            changeProductId(inputInt());
//            changeProductMenu();
//
//        } else if (choiceChange == cancelChange) {
//            new UserUI().init();
//        }
//
//    }

    public void changeProductName(String nameNew, int id) {
        Product prod = products.get(id);
        prod.setName(nameNew);
        products.put(id, prod);
    }
//
//    public void changeProductPrice(int priceNew) {
//        products[changeProductIndex].setPrice(priceNew);
//    }
//
//    public void changeProductId(int idNew) {
//        products[changeProductIndex].setId(idNew);
    }

