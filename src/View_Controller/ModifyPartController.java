package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyPartController {
    @FXML
    private RadioButton InHouse;
    @FXML
    private RadioButton Outsourced;
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
    @FXML
    private Label SourceName;

    public Button CancelButton;

    public void selectedPart(int id) throws IOException {
        ObservableList<Part> allPartsData = Inventory.getAllParts();
        allPartsData.forEach((part) -> {
            if( part.getId() == id) {
                // Insert data into text field depending on id selected
                IdField.setText(Integer.toString(part.getId()));
                NameField.setText(part.getName());
                InvField.setText(Integer.toString(part.getStock()));
                PriceField.setText(Double.toString(part.getPrice()));
                MaxField.setText(Integer.toString(part.getMax()));
                MinField.setText(Integer.toString(part.getMin()));

                // Insert either InHouse or Outsourced data in text field
                if(part instanceof Model.InHouse) {
                    // Radio Button
                    InHouse.setSelected(true);
                    Outsourced.setSelected(false);
                    SourceName.setText("Machine ID");
                    SourceField.setText(Integer.toString(((InHouse) part).getMachineId()));
                }
                else {
                    //Radio button
                    InHouse.setSelected(false);
                    Outsourced.setSelected(true);
                    SourceName.setText("Company Name");
                    SourceField.setText(((Outsourced) part).getCompanyName());
                }
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
