package blueBox.GUI;

import blueBox.GameType;
import blueBox.PlayerType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
public class RentGameDialogController extends RentalStoreGUIController implements Initializable{

    /** TextField Objects **/
    @FXML private TextField nameField, rentedOnField, dueBackField;

    /** String for NameField **/
    String name, rentedOn, dueBack;

    /** Game ComboBox ID's **/
    @FXML private ObservableList<GameType> cbGameOptions;
    @FXML private ComboBox<GameType> cbGame;

    /** Console ComboBox ID's **/
    @FXML private ObservableList<PlayerType> cbConsoleOptions;
    @FXML private ComboBox<PlayerType> cbConsole;

    /** GameType object **/
    private GameType game;

    /** PlayerType Object **/
    private PlayerType console;

    /** Button ID's **/
    @FXML Button cancel, addToCart;

    /** Counter for calculating total **/
    int gameCounter;

    /** Stage for closing GUI **/
    private Stage currentStage;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /** Select Console **/
        cbConsoleOptions = FXCollections.observableArrayList();
        for (PlayerType p : PlayerType.values()) { cbConsoleOptions.addAll(p); }
        cbConsole.getItems().addAll(cbConsoleOptions);

        /** Select Game **/
        cbGameOptions = FXCollections.observableArrayList();
        for (GameType g : GameType.values()){ cbGameOptions.addAll(g); }
        cbGame.getItems().addAll(cbGameOptions);

    }

    public String getName(){
        name = nameField.getText();

        try {

            String[] firstLast = name.split(" ");
            String firstName = firstLast[0];
            String lastName = firstLast[1];

        } catch (Exception e){
            e.printStackTrace();
        }

        return name;
    }

    public String getGame() {
        return cbGame.getSelectionModel().getSelectedItem().toString();
    }

    public String getConsole() {
        return cbConsole.getSelectionModel().getSelectedItem().toString();
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

    /*************************************
     * This is the method to call the other
     * String methods so their output can be
     * put into my main GUI
     *
     *
     * @return
     * @throws ParseException
     *************************************/

    public String storePurchaseData() throws ParseException {
        gameCounter++;
        String toList = getName() + " | " + getGame() + " | " + getConsole() + " | " +
                getRentedOn() + " | " + getDueBack();

        return toList;
    }


    @FXML
    public void handleCancelButtonAction (ActionEvent event) {
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void addToCartButton (ActionEvent event) throws ParseException {
        appendTextArea(storePurchaseData());
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }
}
