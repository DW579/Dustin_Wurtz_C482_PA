package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Part;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


    public Button SearchParts;
    public TextField SearchTextParts;
    public Button SearchProducts;
    public TextField SearchTextProducts;
    public TableColumn ProductID;
    public TableColumn ProductName;
    public TableColumn InventoryLevelProducts;
    public TableColumn PriceProducts;

    public void searchHandlerParts(ActionEvent actionEvent) {
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
        System.out.println("Modify parts");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
        Parent rootModifyPart = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Modify Part");
        stage.setScene(new Scene(rootModifyPart));
        stage.show();
    }

    public void deleteHandlerParts(ActionEvent actionEvent) {
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
        PartID.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        PartName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        InventoryLevelParts.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        PriceParts.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        PartsTableView.setItems(Inventory.getAllParts());
    }

}
