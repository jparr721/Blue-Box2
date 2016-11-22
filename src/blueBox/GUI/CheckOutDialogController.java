package blueBox.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

/**
 * Created by Jarred on 11/9/16.
 */
public class CheckOutDialogController extends RentalStoreGUIController implements Initializable{

    /** Stage for closing GUI **/
    private Stage currentStage;

    @FXML TextField changeField, paymentField;

    @FXML Button ok, pay;

    RentalStoreGUIController g = new RentalStoreGUIController();

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    public void payButton() {

        double totalPayment = parseDouble(paymentField.getText());
        double change = (totalPayment - g.calculateTotal());
        changeField.setText(Double.toString(change));


    }

    @FXML
    public void okButton() {
        currentStage = (Stage) ok.getScene().getWindow();
        currentStage.close();
    }


}
