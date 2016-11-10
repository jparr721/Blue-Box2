package blueBox.GUI;

import blueBox.GameType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jarred on 11/9/16.
 */
public class RentGameDialogController implements Initializable{

    @FXML TextField nameField, rentedOn, dueBack;
    @FXML ComboBox<GameType> cbGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbGame = new ComboBox<>();
    }

    @FXML
    public void gameChoice(){

        cbGame.setItems(FXCollections.observableArrayList(GameType.values()));
        cbGame.getItems().setAll(GameType.values());

    }
}
