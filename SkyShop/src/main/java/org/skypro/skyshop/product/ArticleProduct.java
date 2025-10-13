package org.skypro.skyshop.product;

public class ArticleProduct extends Product {

    private final String description;

    public ArticleProduct(String name, String description) {
        super(name);
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPrice() {
        return 0; // статьи бесплатные
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getStringRepresentation() {
        return "Статья: " + getName() + " — " + description;
    }
}