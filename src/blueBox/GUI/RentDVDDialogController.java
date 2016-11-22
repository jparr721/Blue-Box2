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
    @FXML Button cancel, addToCart;

    /** Counter for check out dialogue **/
    int movieCounter;

    /*******************************************************
     * Method to initialize whatever method is placed within it
     * which runs the code before the GUI is called, which in this
     * case loads the Combo Box options and stores them in the GUI
     *
     * @param location is not used in this context
     * @param resources is not used in this context
     *******************************************************/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /** Select Movie **/
        cbMovieOptions = FXCollections.observableArrayList();
        for (MovieType m : MovieType.values()) { cbMovieOptions.addAll(m); }
        cbMovie.getItems().addAll(cbMovieOptions);

    }

    /*********************************************************
     * Retreives the name stored within the nameField  Text Field
     * and returns it so it can be used in the main GUI Text Field
     *
     * @return name
     *********************************************************/
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

    /***************************************************************
     * Gets the user selected DVD from the Combo Box
     *
     * @return Selected Combo Box item
     ***************************************************************/

    public String getDVD() {
        return cbMovie.getSelectionModel().getSelectedItem().toString();
    }

    /**************************************************************
     * This method takes the date the DVD is to be rented on in the GUI
     * and then stores it in the rentedOn String variable.
     *
     * There is also a test written to convert it to date format, and
     * check if it is a real date. If wrong date, Text Field says
     * "ERROR"
     *
     * @return rentedOn
     * @throws ParseException to check for invalid dates in the
     * rentedOnField
     **************************************************************/

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
            rentedOnField.setText("ERROR");
        }

        return rentedOn;
    }

    /****************************************************************
     * This method takes the date the DVD is to be returned on in the GUI
     * an then stores it in the dueBack String variable.
     *
     * There is also a test written that converts dueBack into date format,
     * then checks if the date is real. If it's the wrong date, then the
     * Text Field says "ERROR"
     *
     * @return dueBack
     * @throws ParseException to check for invalid dates in the dueBackField
     ****************************************************************/

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
            dueBackField.setText("ERROR");
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
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void addToCartButton(ActionEvent event) throws ParseException {
        appendTextArea(storePurchaseData());
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }
}
