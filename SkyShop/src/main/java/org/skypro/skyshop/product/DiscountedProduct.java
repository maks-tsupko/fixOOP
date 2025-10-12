package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name, "Продукт со скидкой " + discount + "%");
        if (basePrice < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100%");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return discount > 0;
    }

    @Override
    public String getStringRepresentation() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }
}
