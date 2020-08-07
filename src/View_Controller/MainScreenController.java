package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController {
    // Search Parts table
    @FXML
    private TextField SearchTextParts;

    // Parts Table View
    @FXML
    private TableView<Part> PartsTableView;
    @FXML
    private TableColumn<Part, Integer> PartID;
    @FXML
    private TableColumn<Part, String> PartName;
    @FXML
    private TableColumn<Part, Integer> InventoryLevelParts;
    @FXML
    private TableColumn<Part, Double> PriceParts;

    // Product Table View
    @FXML
    private TableView<Product> ProductsTableView;
    @FXML
    private TableColumn<Product, Integer> ProductID;
    @FXML
    private TableColumn<Product, String> ProductName;
    @FXML
    private TableColumn<Product, Integer> InventoryLevelProducts;
    @FXML
    private TableColumn<Product, Double> PriceProducts;

    public Button SearchParts;
    public Button SearchProducts;
    public TextField SearchTextProducts;

    FilteredList<Part> filteredPartsData = new FilteredList<>(Inventory.getAllParts(), p -> true);

    public void searchHandlerParts(ActionEvent actionEvent) {
        filteredPartsData.setPredicate(part -> {
            // If filter text is empty, display all persons.
            if (SearchTextParts.getText() == "") {
                return true;
            }

            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = SearchTextParts.getText().toLowerCase();

            if (part.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            else if (Integer.toString(part.getId()).contains(lowerCaseFilter)) {
                return true; // Filter matches last name.
            }
            return false; // Does not match.
        });

        SortedList<Part> sortedPartsData = new SortedList<>(filteredPartsData);

        sortedPartsData.comparatorProperty().bind(PartsTableView.comparatorProperty());

        PartsTableView.setItems(sortedPartsData);
    }

    public void addHandlerParts(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
        Parent rootAddPart = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add Part");
        stage.setScene(new Scene(rootAddPart));
        stage.show();
    }

    public void modifyHandlerParts(ActionEvent actionEvent) throws IOException {
        // Show Modify page
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
        Parent rootModifyPart = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Modify Part");
        stage.setScene(new Scene(rootModifyPart));
        stage.show();

        // Get ID of selected table row
        Part part = PartsTableView.getSelectionModel().getSelectedItem();

        // Pass part id to ModifyPartController
        ModifyPartController modifyPartController = fxmlLoader.getController();
        modifyPartController.selectedPart(part.getId());
    }

    public void deleteHandlerParts(ActionEvent actionEvent) {
        // Get selected table row
        Part selectedPart = PartsTableView.getSelectionModel().getSelectedItem();
        // Delete selectedPart
        Inventory.deletePart(selectedPart);
        // Update the Table view
        PartsTableView.setItems(Inventory.getAllParts());

    }

    public void searchHandlerProducts(ActionEvent actionEvent) {

    }

    public void addHandlerProducts(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
        Parent rootAddProduct = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add Product");
        stage.setScene(new Scene(rootAddProduct));
        stage.show();
    }

    public void modifyHandlerProducts(ActionEvent actionEvent) throws IOException {
        System.out.println("Modify products");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
        Parent rootModifyProduct = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Modify Product");
        stage.setScene(new Scene(rootModifyProduct));
        stage.show();
    }

    public void deleteHandlerProducts(ActionEvent actionEvent) {
    }

    public void exitHandler(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    private void initialize() {
        // Initialize and update Parts table
        PartID.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        PartName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        InventoryLevelParts.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        PriceParts.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        PartsTableView.setItems(Inventory.getAllParts());

        // Initialize and update Products table
        ProductID.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        ProductName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        InventoryLevelProducts.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        PriceProducts.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        ProductsTableView.setItems(Inventory.getAllProducts());
    }


}
