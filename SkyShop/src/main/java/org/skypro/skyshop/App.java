package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.ProductBasket;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Product p1 = new SimpleProduct("Хлеб", 40);
        Product p2 = new DiscountedProduct("Молоко", 100, 20);
        Product p3 = new FixPriceProduct("Книга");
        Product p4 = new SimpleProduct("Яблоки", 60);
        Product p5 = new FixPriceProduct("Кружка");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(p1);
        basket.addProduct(p2);
        basket.addProduct(p3);
        basket.addProduct(p4);
        basket.addProduct(p5);
        basket.printBasket();

        List<Product> removed = basket.removeByName("Молоко");
        if (!removed.isEmpty()) {
            System.out.println("Удалены продукты:");
            for (Product product : removed) {
                System.out.println(product.getStringRepresentation());
            }
        }
        basket.printBasket();

        List<Product> removedNone = basket.removeByName("Кофе");
        if (removedNone.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.printBasket();

        // Статьи
        Product a1 = new Product("Как выбрать молоко", "Разбираемся в составе и видах молока") {
            @Override public int getPrice() { return 0; }
            @Override public boolean isSpecial() { return false; }
        };
        Product a2 = new Product("Польза яблок", "Почему яблоки важны для здоровья") {
            @Override public int getPrice() { return 0; }
            @Override public boolean isSpecial() { return false; }
        };
        Product a3 = new Product("Скидки на хлеб", "Новые акции на хлебобулочные изделия") {
            @Override public int getPrice() { return 0; }
            @Override public boolean isSpecial() { return false; }
        };

        SearchEngine engine = new SearchEngine();
        engine.add(p1);
        engine.add(p2);
        engine.add(p3);
        engine.add(p4);
        engine.add(p5);
        engine.add(a1);
        engine.add(a2);
        engine.add(a3);

        printSearchResults(engine.search("молоко"));
        printSearchResults(engine.search("яблок"));
        printSearchResults(engine.search("хлеб"));
        printSearchResults(engine.search("скидки"));
    }

    private static void printSearchResults(List<Searchable> results) {
        System.out.println("Результаты поиска:");
        if (results.isEmpty()) {
            System.out.println("(ничего не найдено)");
        }
        for (Searchable result : results) {
            System.out.println(result.getStringRepresentation());
        }
        System.out.println();
    }

    static {
        try {
            SimpleProduct сок = new SimpleProduct("Сок", -20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
