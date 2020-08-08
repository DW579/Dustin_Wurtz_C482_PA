package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyProductController {
    public Button Search;
    public TextField SearchField;
    public TableColumn PartIDAdd;
    public TableColumn PartNameAdd;
    public TableColumn InventoryLevelAdd;
    public TableColumn PriceAdd;
    public TableColumn PartIDIncluded;
    public TableColumn PartNameIncluded;
    public TableColumn InventoryLevelIncluded;
    public TableColumn PriceIncluded;
    public Button CancelButton;

    // Selected product data
    @FXML
    private TextField IdField;
    @FXML
    private TextField NameField;
    @FXML
    private TextField InvField;
    @FXML
    private TextField PriceField;
    @FXML
    private TextField MaxField;
    @FXML
    private TextField MinField;

    public void selectedProduct(int id) throws IOException {
        System.out.println(Inventory.getAllProducts());
        ObservableList<Product> allProdcutData = Inventory.getAllProducts();

        allProdcutData.forEach(product -> {
            if(product.getId() == id) {
                // Insert data into text field depending on id selected
                IdField.setText(Integer.toString(product.getId()));
                NameField.setText(product.getName());
                InvField.setText(Integer.toString(product.getStock()));
                PriceField.setText(Double.toString(product.getPrice()));
                MaxField.setText(Integer.toString(product.getMax()));
                MinField.setText(Integer.toString(product.getMin()));
            }
        });
    }

    public void searchHandler(ActionEvent actionEvent) {
    }

    public void addHandler(ActionEvent actionEvent) {
    }

    public void deleteHandler(ActionEvent actionEvent) {
    }

    public void cancelHandler(ActionEvent actionEvent) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void saveHandler(ActionEvent actionEvent) {
    }
}
