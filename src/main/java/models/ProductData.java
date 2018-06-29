package models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;
import java.util.Random;

/**
 * Hold Product information that is used among tests.
 */
public class ProductData {
    private String name;
    private float price;
    private String description = "Test description";

    public ProductData(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String nameInCart() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ProductData withName(String name) {
        this.name = name;
        return this;
    }

    public ProductData withPrice(float price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return Float.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price);
    }

    /**
     * @return New Product object with random name, quantity and price values.
     */
    public static ProductData generate() {
        Random random = new Random();
        return new ProductData(
                "New Product " + System.currentTimeMillis(),
                (float) Math.round(random.nextInt(100_00) + 1) / 100);
    }
}
