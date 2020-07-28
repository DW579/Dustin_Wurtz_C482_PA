package View_Controller;

//import com.sun.javafx.tk.quantum.SceneState;
import Model.InHouse;
import Model.Inventory;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPartController {
    public RadioButton InHouse;
    public RadioButton Outsourced;
    public TextField IdField;
    public TextField NameField;
    public TextField InvField;
    public TextField PriceField;
    public TextField MinField;
    public TextField MaxField;
    public TextField CompanyNameField;
    public Button Cancel;

    private static int dynamicPartId = 0;

    public void inHouseHandler(ActionEvent actionEvent) {
    }

    public void outsourcedHandler(ActionEvent actionEvent) {
    }

    public void idHandler(ActionEvent actionEvent) {
    }

    public void saveHandler(ActionEvent actionEvent) {
        double priceDouble = Double.parseDouble(PriceField.getText());
        int stockInt = Integer.parseInt(InvField.getText());
        int minInt = Integer.parseInt(MinField.getText());
        int maxInt = Integer.parseInt((MaxField.getText()));
        dynamicPartId += 1;

        InHouse newPart = new InHouse(dynamicPartId, NameField.getText(), priceDouble, stockInt, minInt, maxInt, 0);
        Inventory.addPart(newPart);

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
