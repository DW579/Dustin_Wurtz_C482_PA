package View_Controller;

import Model.Inventory;
import Model.Part;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyPartController {
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
    @FXML
    private TextField SourceField;

    public RadioButton InHouse;
    public RadioButton Outsourced;
    public Label SourceName;
    public Button CancelButton;

    public void selectedPart(int id) throws IOException {
        ObservableList<Part> allPartsData = Inventory.getAllParts();
        allPartsData.forEach((part) -> {
            if( part.getId() == id) {
                IdField.setText(Integer.toString(part.getId()));
                NameField.setText(part.getName());
                InvField.setText(Integer.toString(part.getStock()));
                PriceField.setText(Double.toString(part.getPrice()));
                MaxField.setText(Integer.toString(part.getMax()));
                MinField.setText(Integer.toString(part.getMin()));
            }
        });
        
    }

    public void populateFields(int id, String name, int inv, double price, int max, int min) {
        System.out.println("populateFields called");
        System.out.println(name);
    }

    public void saveHandler(ActionEvent actionEvent) {
    }

    public void cancelHandler(ActionEvent actionEvent) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
}
