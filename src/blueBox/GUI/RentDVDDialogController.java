package blueBox.GUI;

import blueBox.MovieType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jarred on 11/9/16.
 */
public class RentDVDDialogController extends RentalStoreGUIController implements Initializable{

    @FXML ComboBox<MovieType> cbMovie;

    @FXML Button cancel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {}


    @FXML
    public void handleCancelButtonAction (ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
