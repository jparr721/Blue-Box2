package blueBox.GUI;

import blueBox.DVD;
import blueBox.GameType;
import blueBox.MovieType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

/**
 * Created by Jarred on 11/8/16.
 */
public class RentalStoreGUIController implements Initializable{

    @FXML public double DvdCounter = 0;
    @FXML public double GameCounter = 0;
    public GameType gameType;

    @FXML private TextField listArea, totalDue;

    @FXML private Menu menu;
    @FXML private MenuBar menuBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menu = new Menu("File");
        menu.getItems().add(new MenuItem("Close"));
        menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
    }

    @FXML
    public void appendTextArea(String purchase){
        System.out.println(purchase);
        //listArea.setText(purchase);

    }

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

        calculateTotal();
    }

    @FXML public void calculateTotal(){

        double gameTotal = (GameCounter * 5);
        double movieTotal = (DvdCounter * 1.2);
        double total = gameTotal + movieTotal;

        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();
        totalDue.setText(dollarFormat.format(total));
    }

}
