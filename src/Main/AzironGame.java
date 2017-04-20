package Main;

import InitializationGame.Initialization;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;


public class AzironGame extends Application {

    @Override
    public void start(Stage AzironStage) throws Exception {
        Initialization.windowInitialization(AzironStage);

    }



    public static void main(String[] args) {
        launch(args);
    }
}