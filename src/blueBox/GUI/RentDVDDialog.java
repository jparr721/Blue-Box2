package blueBox.GUI;

/**
 * Created by Jarred on 11/9/16.
 */

import blueBox.MovieType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class RentDVDDialog extends Application {

    /****************************************************
     * Overriden method that is called by JavaFX when an
     * application is started.
     * @throws Exception thrown whenever there is an error
     * loading the FXML file, or generating a new scene
     * @param primaryStage The stage that the program starts
     * with. JavaFX handles this part.
     ***************************************************/

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/RentDVDDialog.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("DVD Rental v1.0");
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
