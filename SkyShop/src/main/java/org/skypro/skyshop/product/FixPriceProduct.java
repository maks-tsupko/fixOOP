package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name, "Товар с фиксированной ценой");
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
