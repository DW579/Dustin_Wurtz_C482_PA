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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AddProductController {
    // Search Parts from Inventory
    @FXML
    private TextField SearchField;

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

    public TextField nameField;
    public TextField invField;
    public TextField priceField;
    public TextField maxField;
    public TextField minField;
    public Button Search;
    public Button Cancel;

    // Initialize Product ID to be 0
    private static int dynamicProductId = 0;

    // Filter for Parts table
    FilteredList<Part> filteredPartsData = new FilteredList<>(Inventory.getAllParts(), p -> true);

    // List of added Parts
    private final ObservableList<Part> addedParts = FXCollections.observableArrayList();

    public void searchHandler(ActionEvent actionEvent) {
        filteredPartsData.setPredicate(part -> {
            // If filter text is empty, display all persons.
            if (SearchField.getText() == "") {
                return true;
            }

            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = SearchField.getText().toLowerCase();

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

    public void addHandler(ActionEvent actionEvent) {
        Part selectedPart = PartsTableView.getSelectionModel().getSelectedItem();

        if(selectedPart != null) {
            // Add part into the ObservableList<> addedParts
            addedParts.add(selectedPart);
        }
        else {
            System.out.println("No Part selected");
        }
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
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.close();
    }

    public void saveHandler(ActionEvent actionEvent) {
        double priceDouble = Double.parseDouble(priceField.getText());
        int stockInt = Integer.parseInt(invField.getText());
        int minInt = Integer.parseInt(minField.getText());
        int maxInt = Integer.parseInt(maxField.getText());
        dynamicProductId += 1;

        Product newProduct = new Product(dynamicProductId, nameField.getText(), priceDouble, stockInt, minInt, maxInt);

        // Add all selected parts to the product
        addedParts.forEach((part) -> {
            newProduct.addAssociatedPart(part);
        });

        Inventory.addProduct(newProduct);

        // Close save window after save
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.close();
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
