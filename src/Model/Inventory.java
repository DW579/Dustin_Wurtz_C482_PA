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

    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
