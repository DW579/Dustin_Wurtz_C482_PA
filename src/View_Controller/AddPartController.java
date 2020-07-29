package View_Controller;

//import com.sun.javafx.tk.quantum.SceneState;
import Model.InHouse;
import Model.Outsourced;
import Model.Inventory;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPartController {
    @FXML
    private RadioButton InHouse;
    @FXML
    private RadioButton Outsourced;
    @FXML
    private Label SourceLabel;
    @FXML
    private TextField SourceField;

    public TextField IdField;
    public TextField NameField;
    public TextField InvField;
    public TextField PriceField;
    public TextField MinField;
    public TextField MaxField;
    public Button Cancel;

    private static int dynamicPartId = 0;

    @FXML
    private void initialize() {
        InHouse.setSelected(false);
        Outsourced.setSelected(true);
    }

    public void inHouseHandler(ActionEvent actionEvent) {
        // Switch radio buttons
        InHouse.setSelected(true);
        Outsourced.setSelected(false);

        SourceLabel.setText("Machine ID");
        SourceField.setPromptText("Mach ID");
    }

    public void outsourcedHandler(ActionEvent actionEvent) {
        // Switch radio buttons
        InHouse.setSelected(false);
        Outsourced.setSelected(true);

        SourceLabel.setText("Company Name");
        SourceField.setPromptText("Comp Nm");
    }

    public void idHandler(ActionEvent actionEvent) {
    }

    public void saveHandler(ActionEvent actionEvent) {
        double priceDouble = Double.parseDouble(PriceField.getText());
        int stockInt = Integer.parseInt(InvField.getText());
        int minInt = Integer.parseInt(MinField.getText());
        int maxInt = Integer.parseInt(MaxField.getText());
        dynamicPartId += 1;

        // If InHouse is true, else Outsourced is true
        if(InHouse.isSelected()) {
            // Set machine id
            int machineId = Integer.parseInt(SourceField.getText());

            // Create new part to add to inventory
            InHouse newPart = new InHouse(dynamicPartId, NameField.getText(), priceDouble, stockInt, minInt, maxInt, machineId);

            // Add new part to inventory
            Inventory.addPart(newPart);
        }
        else {
            // Set company name
            String companyName = SourceField.getText();

            // Create new part to add to inventory
            Outsourced newPart = new Outsourced(dynamicPartId, NameField.getText(), priceDouble, stockInt, minInt, maxInt, companyName);

            // Add new part to inventory
            Inventory.addPart(newPart);
        }

        // Close save window after save
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.close();
    }

    public void cancelHandler(ActionEvent actionEvent) {
        // Close save window on cancel
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.close();
    }
}
