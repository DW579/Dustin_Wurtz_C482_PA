package Model;

import javafx.beans.property.*;

public abstract class Part {
//    Original code
//    private int id;
//    private String name;
//    private double price;
//    private int stock;
//    private int min;
//    private int max;
//
//    public Part(int id, String name, double price, int stock, int min, int max) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.stock = stock;
//        this.min = min;
//        this.max = max;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public int getStock() {
//        return stock;
//    }
//
//    public void setStock(int stock) {
//        this.stock = stock;
//    }
//
//    public int getMin() {
//        return min;
//    }
//
//    public void setMin(int min) {
//        this.min = min;
//    }
//
//    public int getMax() {
//        return max;
//    }
//
//    public void setMax(int max) {
//        this.max = max;
//    }

    private final IntegerProperty id;
    private final StringProperty name;
    private final DoubleProperty price;
    private final IntegerProperty stock;
    private final IntegerProperty min;
    private final IntegerProperty max;

    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }

    // Get/Set/Property id
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    // Get/Set/Property name
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    // Get/Set/Property price
    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    // Get/Set/Property stock
    public int getStock() {
        return stock.get();
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    // Get/Set/Property min
    public int getMin() {
        return min.get();
    }

    public void setMin(int min) {
        this.min.set(min);
    }

    public IntegerProperty minProperty() {
        return min;
    }

    // Get/Set/Property max
    public int getMax() {
        return max.get();
    }

    public void setMax(int max) {
        this.max.set(max);
    }

    public IntegerProperty maxProperty() {
        return max;
    }
}
