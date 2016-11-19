package blueBox.GUI;

import blueBox.MovieType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    /** Movie ComboBox ID's **/
    @FXML ObservableList<MovieType>  cbMovieOptions;
    @FXML ComboBox<MovieType> cbMovie;

    /** Text Field Options **/
    @FXML private TextField nameField, rentedOn, dueBack;

    /** String for NameField **/
    String name;

    /** Stage for closing GUI **/
    private Stage currentStage;

    /** Button Objects **/
    @FXML Button cancel;

    /** Counter for check out dialogue **/
    int counter;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cbMovieOptions = FXCollections.observableArrayList();
        for (MovieType m : MovieType.values()) { cbMovieOptions.addAll(m); }
        cbMovie.getItems().addAll(cbMovieOptions);

    }

    public void getName() {
        name = nameField.getText();

        try {

            String[] firstLast = name.split(" ");
            String firstName = firstLast[0];
            String lastName = firstLast[1];

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDVD() {
        MovieType movieChoce = cbMovie.getSelectionModel().getSelectedItem();
    }


    @FXML
    public void handleCancelButtonAction (ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addToCartButton(ActionEvent event) {

    }
}
