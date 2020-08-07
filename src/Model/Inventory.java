package Model;

import View_Controller.ModifyPartController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    // Part calls
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static void lookupPart(Part partId) {
        System.out.println(partId);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }

    // Product calls
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public static void lookupProduct(Product productId) {
        System.out.println(productId);
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    public static void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
    }
}
