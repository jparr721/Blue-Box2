package blueBox.GUI;

import blueBox.MovieType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Jarred on 11/9/16.
 */
public class RentDVDDialogController extends RentalStoreGUIController implements Initializable{

    /** Movie ComboBox ID's **/
    @FXML private ObservableList<MovieType>  cbMovieOptions;
    @FXML private ComboBox<MovieType> cbMovie;

    /** Text Field Options **/
    @FXML private TextField nameField, rentedOnField, dueBackField;

    /** String for NameField **/
    String name, rentedOn, dueBack;

    /** Stage for closing GUI **/
    private Stage currentStage;

    /** Button Objects **/
    @FXML Button cancel;

    /** Counter for check out dialogue **/
    int movieCounter;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /** Select Movie **/
        cbMovieOptions = FXCollections.observableArrayList();
        for (MovieType m : MovieType.values()) { cbMovieOptions.addAll(m); }
        cbMovie.getItems().addAll(cbMovieOptions);

    }

    public String getName() {
        name = nameField.getText();

        try {

            String[] firstLast = name.split(" ");
            String firstName = firstLast[0];
            String lastName = firstLast[1];

        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }

    public String getDVD() {
        return cbMovie.getSelectionModel().getSelectedItem().toString();
    }

    public String getRentedOn() throws ParseException {

        rentedOn = rentedOnField.getText();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date rentedOnDate = format.parse(rentedOn);

        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.setTime(rentedOnDate);

        try {

            cal.getTime();

        } catch (Exception e) {
            System.exit(0);
        }

        return rentedOn;
    }

    public String getDueBack() throws ParseException {

        dueBack = dueBackField.getText();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dueBackDate = format.parse(dueBack);

        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.setTime(dueBackDate);

        try {

            cal.getTime();

        } catch (Exception e) {
            System.exit(0);
        }

        return dueBack;
    }

    public String storePurchaseData() throws ParseException{
        movieCounter++;
        String toList = getName() + " | " + getDVD() +  " | " + getRentedOn() + " | " + getDueBack();

        return toList;
    }

    @FXML
    public void handleCancelButtonAction (ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addToCartButton(ActionEvent event) throws ParseException {
        appendTextArea(storePurchaseData());
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }
}
