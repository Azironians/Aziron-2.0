package controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

import static Main.BuildStage.azironStage;

public class ControllerMenu implements Initializable {
    @FXML ImageView windowMenu;
    @FXML ImageView buttonOnLocMch;
    @FXML ImageView buttonOffLocMch;
    @FXML ImageView buttonOffExitProgramm;
    @FXML ImageView buttonOnExitProgramm;
    @FXML ImageView panel;
    @FXML ImageView buttonOffGameTwo;
    @FXML ImageView buttonOnGameTwo;
    @FXML ImageView buttonOffBack;
    @FXML ImageView buttonOnBack;
    @FXML Pane panelLocMch;
    @FXML Pane paneButtons;
    @FXML Pane paneMessage;
@FXML Text time;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Timer ClockTimer = new Timer(500, e -> {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.dd.MM");
            Text text = new Text();
            text.setText(sdf.format(d));
            DateFormat df = new SimpleDateFormat("HH:mm");
            Date times = Calendar.getInstance().getTime();
            String reportDate = df.format(times);
            time.setText(reportDate); // FXML Text не позволяет сделать класс Clock static
        });
        ClockTimer.start();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(4000), paneMessage);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        try {
            Parent rootAutorization = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAutorization.fxml"));
            Scene sceneAutorize = new Scene(rootAutorization, 1280, 720);
            //1. Фон:
            windowMenu.setOnMouseMoved(event -> {
                buttonOnLocMch.setVisible(false);
                buttonOffLocMch.setVisible(true);
                buttonOnExitProgramm.setVisible(false);
                buttonOffExitProgramm.setVisible(true);
            });

            //2. Кнопка "Локальный матч"
            buttonOffLocMch.setOnMouseMoved(event -> {
                buttonOffLocMch.setVisible(false);
                buttonOnLocMch.setVisible(true);
                buttonOnExitProgramm.setVisible(false);
                buttonOffExitProgramm.setVisible(true);
            });
            buttonOnLocMch.setOnMouseClicked(event -> {
                paneMessage.setVisible(false);
                paneButtons.setVisible(false);
                paneButtons.setDisable(true);
                panelLocMch.setVisible(true);
                panelLocMch.setDisable(false);
            });

            //3. Кнопка выход из игры:
            buttonOffExitProgramm.setOnMouseMoved(event -> {
                buttonOffExitProgramm.setVisible(false);
                buttonOnExitProgramm.setVisible(true);

                buttonOnLocMch.setVisible(false);
                buttonOffLocMch.setVisible(true);
            });
            buttonOnExitProgramm.setOnMouseClicked(event -> {
                System.exit(1);
            });

            //4. Панель:
            panel.setOnMouseMoved(event -> {
                buttonOnBack.setVisible(false);
                buttonOffBack.setVisible(true);
                buttonOnGameTwo.setVisible(false);
                buttonOffGameTwo.setVisible(true);
            });

            //5. Кнопка "Назад":
            buttonOffBack.setOnMouseMoved(event -> {
                buttonOffBack.setVisible(false);
                buttonOnBack.setVisible(true);
            });
            buttonOnBack.setOnMouseClicked(event -> {
                paneMessage.setVisible(true);
                paneButtons.setVisible(true);
                paneButtons.setDisable(false);
                panelLocMch.setVisible(false);
                panelLocMch.setDisable(true);
            });

            //6. Кнопка "Игра на двоих":
            buttonOffGameTwo.setOnMouseMoved(event -> {
                buttonOffGameTwo.setVisible(false);
                buttonOnGameTwo.setVisible(true);
            });
            buttonOnGameTwo.setOnMouseClicked(event -> {
                paneButtons.setVisible(true);
                paneButtons.setDisable(false);
                panelLocMch.setVisible(false);
                panelLocMch.setDisable(true);

                azironStage.setScene(sceneAutorize);
                Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                ImageCursor imageCursor = new ImageCursor(cursor);
                azironStage.getScene().setCursor(imageCursor);

                azironStage.show();
            });
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
