package blueBox.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by Jarred on 11/9/16.
 */
public class CheckOutDialog extends Application{

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
                    getClass().getResource("/CheckOutDialog.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Check Out v1.0");
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { launch(args); }
}
