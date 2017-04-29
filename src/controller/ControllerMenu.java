package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.BuildStage.azironStage;

public class ControllerMenu implements Initializable {
    @FXML ImageView windowMenu;
    //1. Кнопки:
    @FXML ImageView buttonOnLocMch;
    @FXML ImageView buttonOffLocMch;
    @FXML ImageView buttonOffExitProgramm;
    @FXML ImageView buttonOnExitProgramm;

    @FXML ImageView panel;
    @FXML ImageView buttonOffGameTwo;

    @FXML ImageView buttonOnGameTwo;
    @FXML ImageView buttonOffBack;
    @FXML ImageView buttonOnBack;
    //2. Панели:
    @FXML Pane panelLocMch;
    @FXML Pane paneButtons;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
                System.out.println("efef");
                azironStage.setScene(sceneAutorize);
                azironStage.show();
            });


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}



//if (!buttonOffLocMch.isHover()){
//        buttonOffLocMch.setVisible(true);
//        buttonOnLocMch.setVisible(false);
//        }System.out.println("efef");