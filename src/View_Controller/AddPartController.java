package View_Controller;

//import com.sun.javafx.tk.quantum.SceneState;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class AddPartController {
    public RadioButton InHouse;
    public RadioButton Outsourced;
    public Label ID;
    public Label Name;
    public Label Inv;
    public Label Price;
    public Label Max;
    public Label Min;
    public Label CompanyName;
    public Button Cancel;

    public void inHouseHandler(ActionEvent actionEvent) {
    }

    public void outsourcedHandler(ActionEvent actionEvent) {
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

    public void companyNameHandler(ActionEvent actionEvent) {
    }

    public void saveHandler(ActionEvent actionEvent) {
    }

    public void cancelHandler(ActionEvent actionEvent) {
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.close();
    }
}
