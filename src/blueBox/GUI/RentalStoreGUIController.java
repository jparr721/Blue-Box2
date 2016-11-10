package blueBox.GUI;

import blueBox.DVD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Jarred on 11/8/16.
 */
public class RentalStoreGUIController {

    @FXML private TextField listArea, totalDue;

    @FXML
    public void rentDVD(){

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/RentDVDDialog.fxml"));

            Scene scene = new Scene(root);

            Stage newStage = new Stage();

            newStage.setScene(scene);
            newStage.setTitle("Movie Rental v1.0");
            newStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    public void rentGame(){

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/RentGameDialog.fxml"));

            Scene scene = new Scene(root);

            Stage newStage = new Stage();

            newStage.setScene(scene);
            newStage.setTitle("Game Rental v1.0");
            newStage.setResizable(false);
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void checkOut(){

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/CheckOutDialog.fxml"));

            Scene scene = new Scene(root);

            Stage newStage = new Stage();

            newStage.setScene(scene);
            newStage.setTitle("Check Out v1.0");
            newStage.setResizable(false);
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calculateTotal(){

    }
}
