package View_Controller;

import Model.Inventory;
import Model.Part;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddProductController {
    @FXML
    private TextField SearchField;
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

    public Button Search;
    public Label ID;
    public Label Name;
    public Label Inv;
    public Label Price;
    public Label Max;
    public Label Min;
    public TableColumn PartIDIncluded;
    public TableColumn PartNameIncluded;
    public TableColumn InventoryLevelIncluded;
    public TableColumn PriceIncluded;
    public Button Cancel;

    FilteredList<Part> filteredPartsData = new FilteredList<>(Inventory.getAllParts(), p -> true);

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

    public void idHandler(ActionEvent actionEvent) {
    }

    public void nameHandler(ActionEvent actionEvent) {
    }

    public void invHandler(ActionEvent actionEvent) {
    }

    public void priceHandler(ActionEvent actionEvent) {
    }

    public void maxHandler(ActionEvent actionEvent) {
    }

    public void minHandler(ActionEvent actionEvent) {
    }

    public void addhandler(ActionEvent actionEvent) {
    }

    public void deleteHandler(ActionEvent actionEvent) {
    }

    public void cancelHandler(ActionEvent actionEvent) {
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.close();
    }

    public void saveHandler(ActionEvent actionEvent) {
    }

    @FXML
    private void initialize() {
        // Initialize and update parts table
        PartIDAdd.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        PartNameAdd.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        InventoryLevelAdd.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        PriceAdd.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        PartsTableView.setItems(Inventory.getAllParts());
    }
}
