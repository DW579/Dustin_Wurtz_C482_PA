package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static int lookUpPart(String term) {
        return 1;
    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
