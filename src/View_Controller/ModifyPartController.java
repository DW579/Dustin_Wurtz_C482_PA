package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

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

    public void inHouseHandler(ActionEvent actionEvent) {
        InHouse.setSelected(true);
        Outsourced.setSelected(false);
        SourceName.setText("Machine ID");
    }

    public void outsourcedHandler(ActionEvent actionEvent) {
        InHouse.setSelected(false);
        Outsourced.setSelected(true);
        SourceName.setText("Company Name");
    }

    public void saveHandler(ActionEvent actionEvent) {
        ObservableList<Part> allPartsData = Inventory.getAllParts();

        allPartsData.forEach((part) -> {
            if( part.getId() == Integer.parseInt(IdField.getText())) {
                int partId = Integer.parseInt(IdField.getText());
                String partName = NameField.getText();
                double partPrice = Double.parseDouble(PriceField.getText());
                int partStock = Integer.parseInt(InvField.getText());
                int partMax = Integer.parseInt(MaxField.getText());
                int partMin = Integer.parseInt(MinField.getText());

                // Check to see if source has changed, if so delete part in current class and then create a new object in the other class with modified data
                if(part instanceof Model.InHouse && SourceName.getText() == "Company Name") {

                    String partCompanyName = SourceField.getText();

                    // New modified part
                    Outsourced modifiedPart = new Outsourced(partId, partName, partPrice, partStock, partMin, partMax, partCompanyName);

                    // Add modified part into Inventory and delete current part out of Inventory
                    Inventory.addPart(modifiedPart);
                    Inventory.deletePart(part);
                }
                else if(part instanceof Model.Outsourced && SourceName.getText() == "Machine ID") {
                    int partMachineId = Integer.parseInt(SourceField.getText());

                    InHouse modifiedPart = new InHouse(partId, partName, partPrice, partStock, partMin, partMax, partMachineId);

                    // Add modified part into Inventory and delete current part out of Inventory
                    Inventory.addPart(modifiedPart);
                    Inventory.deletePart(part);
                }
                else {
                    part.setName(partName);
                    part.setPrice(partPrice);
                    part.setStock(partStock);
                    part.setMax(partMax);
                    part.setMin(partMin);

                    if(SourceName.getText() == "Machine ID") {
                        int partMachineId = Integer.parseInt(SourceField.getText());
                        ((InHouse) part).setMachineId(partMachineId);
                    }
                    else {
                        String partCompanyName = SourceField.getText();
                        ((Outsourced) part).setCompanyName(partCompanyName);
                    }
                }

            }
        });

        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void cancelHandler(ActionEvent actionEvent) {
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDelete.initModality(Modality.NONE);
        confirmDelete.setTitle("Cancel?");
        confirmDelete.setHeaderText("Cancel?");
        confirmDelete.setContentText("Are you sure you want to cancel?");
        Optional<ButtonType> userChoice = confirmDelete.showAndWait();

        if(userChoice.get() == ButtonType.OK) {
            // Close save window on cancel
            Stage stage = (Stage) CancelButton.getScene().getWindow();
            stage.close();
        }
    }
}
