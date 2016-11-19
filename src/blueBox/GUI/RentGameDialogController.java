package blueBox.GUI;

import blueBox.GameType;
import blueBox.MovieType;
import blueBox.PlayerType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    /** Button ID's **/
    @FXML Button cancel, addToCart;

    /** Counter for calculating total **/
    int counter;

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

    public void getName(){
        name = nameField.getText();

        try {

            String[] firstLast = name.split(" ");
            String firstName = firstLast[0];
            String lastName = firstLast[1];

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getGame() {
        GameType gameChoice = cbGame.getSelectionModel().getSelectedItem();
    }

    public void getConsole() {
        PlayerType player = cbConsole.getSelectionModel().getSelectedItem();
    }

    public void getRentedOn() throws ParseException {

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

    }

    public void getDueBack() throws ParseException {

        dueBack = dueBackField.getText();

        DateFormat format = new SimpleDateFormat("dd?MM/yyyy");
        Date dueBackDate = format.parse(dueBack);

        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.setTime(dueBackDate);

        try {

            cal.getTime();
            
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public void storePurchaseData() {
        counter++;


    }


    @FXML
    public void handleCancelButtonAction (ActionEvent event) {
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void addToCartButton (ActionEvent event) {
        storePurchaseData();
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }
}
