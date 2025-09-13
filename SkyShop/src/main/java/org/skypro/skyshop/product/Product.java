package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    private final String description;

    protected Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getStringRepresentation() {
        return name + " (" + getPrice() + " руб.)";
    }
}
