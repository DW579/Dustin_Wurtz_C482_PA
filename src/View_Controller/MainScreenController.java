package View_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainScreenController {
    public Button SearchParts;
    public TextField SearchTextParts;
    public TableColumn PartID;
    public TableColumn PartName;
    public TableColumn InventoryLevelParts;
    public TableColumn PriceParts;
    public Button SearchProducts;
    public TextField SearchTextProducts;
    public TableColumn ProductID;
    public TableColumn ProductName;
    public TableColumn InventoryLevelProducts;
    public TableColumn PriceProducts;

    public void searchHandlerParts(ActionEvent actionEvent) {
    }

    public void addHandlerParts(ActionEvent actionEvent) throws IOException {
        System.out.println("Add a part");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
        Parent rootAddPart = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Add Part");
        stage.setScene(new Scene(rootAddPart));
        stage.show();
    }

    public void modifyHandlerParts(ActionEvent actionEvent) {
    }

    public void deleteHandlerParts(ActionEvent actionEvent) {
    }

    public void searchHandlerProducts(ActionEvent actionEvent) {
    }

    public void addHandlerProducts(ActionEvent actionEvent) {
        System.out.println("Add a product");
    }

    public void modifyHandlerProducts(ActionEvent actionEvent) {
    }

    public void deleteHandlerProducts(ActionEvent actionEvent) {
    }

    public void exitHandler(ActionEvent actionEvent) {
        System.out.println("exit button clicked");
        System.exit(0);
    }
}
