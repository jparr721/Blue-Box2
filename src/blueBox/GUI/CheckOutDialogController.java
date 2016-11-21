package blueBox.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

/**
 * Created by Jarred on 11/9/16.
 */
public class CheckOutDialogController extends RentalStoreGUIController implements Initializable{

    /** Stage for closing GUI **/
    private Stage currentStage;

    @FXML TextField changeField;

    @FXML Button ok;

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    

    @FXML
    public void okButton() {
        currentStage = (Stage) ok.getScene().getWindow();
        currentStage.close();
    }


}
