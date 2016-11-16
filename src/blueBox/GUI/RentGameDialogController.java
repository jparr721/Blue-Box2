package blueBox.GUI;

import blueBox.GameType;
import blueBox.PlayerType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * Created by Jarred on 11/9/16.
 */
public class RentGameDialogController extends RentalStoreGUIController implements Initializable{

    @FXML private TextField nameField, rentedOn, dueBack;
    String name;
    Date dateRentedOn, dateDue;
    GregorianCalendar rented, due;
    @FXML ComboBox<GameType> cbGame;
    @FXML ComboBox<PlayerType> cbConsole;
    @FXML Button cancel, addToCart;
    @FXML int counter = 0;
    private Stage currentStage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbGame.getItems().addAll(GameType.values());
        cbConsole.getItems().addAll(PlayerType.values());
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

    public void getRentedOn() throws ParseException {
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        dateRentedOn = format.parse(rentedOn.getText());
        rented.setTime(dateRentedOn);
    }

    public void getDueBack() throws ParseException {
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        dateDue = format.parse(dueBack.getText());
        due.setTime(dateDue);
    }


    @FXML
    public void handleCancelButtonAction (ActionEvent event) {
        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void addToCartButton (ActionEvent event) {

        currentStage = (Stage) cancel.getScene().getWindow();
        currentStage.close();
    }
}
