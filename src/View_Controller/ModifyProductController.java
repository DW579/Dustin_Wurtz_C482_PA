package View_Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyProductController {
    public Button Search;
    public TextField SearchField;
    public TableColumn PartIDAdd;
    public TableColumn PartNameAdd;
    public TableColumn InventoryLevelAdd;
    public TableColumn PriceAdd;
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
    public Button CancelButton;

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

    public void addHandler(ActionEvent actionEvent) {
    }

    public void deleteHandler(ActionEvent actionEvent) {
    }

    public void cancelHandler(ActionEvent actionEvent) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void saveHandler(ActionEvent actionEvent) {
    }
}
