package blueBox.GUI;

import blueBox.GameType;
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
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * Created by Jarred on 11/9/16.
 */
public class RentGameDialogController extends RentalStoreGUIController implements Initializable{

    @FXML private TextField nameField, rentedOn, dueBack;
    @FXML String name;
    @FXML GregorianCalendar rented, due;
    @FXML ComboBox<GameType> cbGame;
    @FXML Button cancel, addToCart;
    @FXML int counter = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rentedOn = new TextField();
        dueBack = new TextField();

        rented = new GregorianCalendar();
        due = new GregorianCalendar();

        cbGame = new ComboBox<>();
    }

    @FXML
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


    @FXML
    public void handleCancelButtonAction (ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addToCartButton (ActionEvent event) {
        Stage stage = (Stage) addToCart.getScene().getWindow();
        getName();
        counter++;
        stage.close();


    }
}
