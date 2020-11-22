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

    public static void lookupPart(int partId) {
        allParts.forEach(part -> {
            if(part.getId() == partId) {
                System.out.println(part);
            }
        });
    }

    public static void lookupPart(String partName) {
        allParts.forEach(part -> {
            if(part.getName() == partName) {
                System.out.println(part);
            }
        });
    }

    public static void updatePart(int index, Part newPart) {
        System.out.println(index);
        System.out.println(newPart);
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

    public static void lookupProduct(int productId) {
        allProducts.forEach(product -> {
            if(product.getId() == productId) {
                System.out.println(product);
            }
        });
    }

    public static void lookupProduct(String productName) {
        allProducts.forEach(product -> {
            if(product.getName() == productName) {
                System.out.println(product);
            }
        });
    }

    public static void updateProduct(int index, Product newProduct) {
        System.out.println(index);
        System.out.println(newProduct);
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    public static void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
    }
}
