package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
import java.util.Objects;

public abstract class Product implements Searchable {
    protected String name;

    public Product(String name, String s) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // ✅ equals и hashCode только по имени
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}