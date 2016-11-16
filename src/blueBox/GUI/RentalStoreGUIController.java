package blueBox.GUI;

import blueBox.DVD;
import blueBox.MovieType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;

/**
 * Created by Jarred on 11/8/16.
 */
public class RentalStoreGUIController {

    @FXML public double DvdCounter = 0;
    @FXML public double GameCounter = 0;

    @FXML private TextField listArea, totalDue;

    @FXML
    public void rentDVD(){
        DvdCounter++;
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/RentDVDDialog.fxml"));

            Scene scene = new Scene(root);

            Stage newStage = new Stage();

            newStage.setScene(scene);
            newStage.setTitle("Movie Rental v1.0");
            newStage.setResizable(false);
            newStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    public void rentGame(){
        GameCounter++;
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

    @FXML public void calculateTotal(){

        double gameTotal = (GameCounter * 5);
        double movieTotal = (DvdCounter * 1.2);
        double total = gameTotal + movieTotal;

        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();
        totalDue.setText(dollarFormat.format(total));
    }
}
