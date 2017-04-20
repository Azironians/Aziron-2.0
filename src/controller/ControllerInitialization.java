package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class ControllerInitialization {

    @FXML
    private Button button;

    @FXML
    public void onClickMethod() {
        button.setText("Thanks!");
    }

    @FXML
    public void initialize() {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("sdfsdf");
            }
        });
    }
}

//должен загрузить Загрузку и музыку
