package View_Controller;

import Model.Inventory;
import Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddProductController {

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
    public TextField SearchField;
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

    public void searchHandler(ActionEvent actionEvent) {
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
        PartIDAdd.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        PartNameAdd.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        InventoryLevelAdd.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        PriceAdd.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        PartsTableView.setItems(Inventory.getAllParts());
    }
}
