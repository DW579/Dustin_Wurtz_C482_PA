package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyProductController {
    public TextField SearchField;
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

    // All Parts from Inventory
    @FXML
    private TableView<Part> PartsTableView;
    @FXML
    private TableColumn<Part, Integer> PartIDAdd;
    @FXML
    private TableColumn<Part, String> PartNameAdd;
    @FXML
    private TableColumn<Part, Integer> InventoryLevelAdd;
    @FXML
    private TableColumn<Part, Double> PriceAdd;

    // Selected Parts for Product
    @FXML
    private TableView<Part> PartsTableViewIncluded;
    @FXML
    private TableColumn<Part, Integer> PartIDIncluded;
    @FXML
    private TableColumn<Part, String> PartNameIncluded;
    @FXML
    private TableColumn<Part, Integer> InventoryLevelIncluded;
    @FXML
    private TableColumn<Part, Double> PriceIncluded;

    // Filter for Parts table
    FilteredList<Part> filteredPartsData = new FilteredList<>(Inventory.getAllParts(), p -> true);

    // List of added Parts
    private final ObservableList<Part> addedParts = FXCollections.observableArrayList();

    public void selectedProduct(int id) throws IOException {
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

                product.getAllAssociatedParts().forEach(part -> {
                    addedParts.add(part);
                });
            }
        });


    }

    public void searchHandler(ActionEvent actionEvent) {
        filteredPartsData.setPredicate(part -> {
            if (SearchField.getText() == "") {
                return true;
            }

            String lowerCaseFilter = SearchField.getText().toLowerCase();

            if (part.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            else if (Integer.toString(part.getId()).contains(lowerCaseFilter)) {
                return true;
            }
            return false;
        });

        SortedList<Part> sortedPartsData = new SortedList<>(filteredPartsData);

        sortedPartsData.comparatorProperty().bind(PartsTableView.comparatorProperty());

        PartsTableView.setItems(sortedPartsData);
    }

    public void addHandler(ActionEvent actionEvent) {
    }

    public void deleteHandler(ActionEvent actionEvent) {
        Part selectedPart = PartsTableViewIncluded.getSelectionModel().getSelectedItem();

        if(selectedPart != null) {
            addedParts.remove(selectedPart);
        }
        else {
            System.out.println("No part selected");
        }
    }

    public void cancelHandler(ActionEvent actionEvent) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void saveHandler(ActionEvent actionEvent) {
    }

    @FXML
    private void initialize() {
        // Initialize and update table for all Parts from Inventory
        PartIDAdd.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        PartNameAdd.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        InventoryLevelAdd.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        PriceAdd.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        PartsTableView.setItems(Inventory.getAllParts());

        // Initialize and update table for included Parts from Product object
        PartIDIncluded.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        PartNameIncluded.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        InventoryLevelIncluded.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        PriceIncluded.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        PartsTableViewIncluded.setItems(addedParts);
    }
}
