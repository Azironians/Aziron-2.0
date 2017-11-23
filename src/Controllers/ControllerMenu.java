package Controllers;

import Main.AzironGame;
import Main.Clock;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.BuildStage.*;

public class ControllerMenu implements Initializable {
    @FXML
    private ImageView windowMenu;
    @FXML
    private ImageView buttonOnLocMch;
    @FXML
    private ImageView buttonOffLocMch;
    @FXML
    private ImageView buttonOffExitProgramm;
    @FXML
    private ImageView buttonOnExitProgramm;
    @FXML
    private ImageView panel;
    @FXML
    private ImageView buttonOffGameTwo;
    @FXML
    private ImageView buttonOnGameTwo;
    @FXML
    private ImageView buttonOffBack;
    @FXML
    private ImageView buttonOnBack;
    @FXML
    private ImageView buttonOffVersusComputer;
    @FXML
    private ImageView buttonOnVersusComputer;
    @FXML
    private Pane panelLocMch;
    @FXML
    private Pane paneButtons;
    @FXML
    private Pane paneMessage;
    @FXML
    private Text time;
    @FXML
    private Button buttonVersusComputerKey;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Clock.launchTimer(time).start();

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
            buttonOnExitProgramm.setOnMouseClicked(event -> System.exit(1));

            //4. Панель:
            panel.setOnMouseMoved(event -> {
                buttonOnBack.setVisible(false);
                buttonOffBack.setVisible(true);
                buttonOnGameTwo.setVisible(false);
                buttonOffGameTwo.setVisible(true);
                buttonOnVersusComputer.setVisible(false);
                buttonOffVersusComputer.setVisible(true);
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

            //7. Кнопка "Против ИИ"
            buttonOffVersusComputer.setOnMouseMoved(event -> {
                buttonOffVersusComputer.setVisible(false);
                buttonOnVersusComputer.setVisible(true);
            });

            buttonOnVersusComputer.setOnMouseClicked(event -> {
                    AzironGame.getControllerBot().setGameWithPC(true);
                    paneButtons.setVisible(true);
                    paneButtons.setDisable(false);
                    panelLocMch.setVisible(false);
                    panelLocMch.setDisable(true);
                    profileController = (byte) 2;
                    AzironGame.getControllerBot().installGameWithBot();
                    azironStage.setScene(sceneAutorize);
                    azironStage.show();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
