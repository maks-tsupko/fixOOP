package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeByName(String name) {
        return products.getOrDefault(name, new ArrayList<>());
    }

    public void printBasket() {
        System.out.println("Содержимое корзины:");
        if (products.isEmpty()) {
            System.out.println("(пусто)");
            return;
        }
        for (List<Product> group : products.values()) {
            for (Product p : group) {
                System.out.println(p.getStringRepresentation());
            }
        }
        System.out.println();
    }
}
