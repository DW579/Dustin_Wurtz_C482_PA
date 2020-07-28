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

    public void inHouseHandler(ActionEvent actionEvent) {
    }

    public void outsourcedHandler(ActionEvent actionEvent) {
    }

    public void idHandler(ActionEvent actionEvent) {
    }

    public void saveHandler(ActionEvent actionEvent) {
        System.out.println(NameField.getText());

        InHouse newPart = new InHouse(1, "The Name", 12.34, 2, 1, 15, 0);
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
