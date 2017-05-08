package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.BuildStage.azironStage;

public class ControllerInitialization implements Initializable{
    @FXML ImageView background;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        background.setOnMouseMoved(event -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowMenu.fxml")), 1280, 720));
            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });
    }
}
