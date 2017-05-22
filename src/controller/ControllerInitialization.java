package controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.BuildStage.azironStage;

public class ControllerInitialization implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    private ImageView Aziron;
    @FXML
    private Button btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(9500), new Rectangle(-10, -10, 1, 1));
        transition.setByX(2);
        transition.setCycleCount(1);
        transition.setOnFinished(event -> {
            Aziron.setVisible(true);
            background.setVisible(false);
            TranslateTransition transition2 = new TranslateTransition(Duration.millis(500), new Rectangle(-10, -10, 1, 1));
            transition2.setByX(2);
            transition2.setCycleCount(1);
            transition2.setOnFinished(event2 -> {
                try {
                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowMenu.fxml")), 1280, 720));
                    Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                    ImageCursor imageCursor = new ImageCursor(cursor);
                    azironStage.getScene().setCursor(imageCursor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                azironStage.show();
            });
            transition2.play();
        });
        btn.setOnKeyPressed(event -> transition.jumpTo(Duration.millis(9499)));
        transition.play();
    }
}
