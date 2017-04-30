package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static Main.BuildStage.*;

public class ControllerChoiceHero implements Initializable{

    @FXML ImageView spotLightDev;
    @FXML ImageView spotLightLV;
    @FXML ImageView spotLightBHR;
    @FXML ImageView btnOffLeft;
    @FXML ImageView btnOnLeft;
    @FXML ImageView btnOnRight;
    @FXML ImageView btnOffRight;
    @FXML ImageView currentBackground;
    @FXML Button btnChoiceHero;
    @FXML Button btnBackToProfile;
    @FXML Pane paneMessage;
    @FXML Pane paneControls;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(favouriteHero);
        switch (favouriteHero){
            case "Любимый герой: Пожиратель":
                currentBackground.setImage(spotLightDev.getImage());
                break;
            case "Любимый герой: Лорд Вампир":
                currentBackground.setImage(spotLightDev.getImage());
                break;
            case "Любимый герой: Орк-Оглушитель":
                currentBackground.setImage(spotLightBHR.getImage());
                break;
                default:
                    currentBackground.setImage(spotLightDev.getImage());
                    break;
        }
        //Фон:
        currentBackground.setOnMouseMoved(event -> {
            btnOnRight.setVisible(false);
            btnOffRight.setVisible(true);
            btnOnLeft.setVisible(false);
            btnOffLeft.setVisible(true);
        });
        //Влево:
        btnOffLeft.setOnMouseMoved(event -> {
            btnOffLeft.setVisible(false);
            btnOnLeft.setVisible(true);
        });

        btnOnLeft.setOnMouseClicked(event -> {
            if (currentBackground.getImage().equals(spotLightBHR.getImage())){
                currentBackground.setImage(spotLightDev.getImage());
            } else {
                if (currentBackground.getImage().equals(spotLightLV.getImage())){
                    currentBackground.setImage(spotLightBHR.getImage());
                } else {
                    if (currentBackground.getImage().equals(spotLightDev.getImage())){
                        currentBackground.setImage(spotLightLV.getImage());
                    }
                }
            }
        });


        //Вправо:
        btnOffRight.setOnMouseMoved(event -> {
            btnOffRight.setVisible(false);
            btnOnRight.setVisible(true);
        });

        btnOnRight.setOnMouseClicked(event -> {
            if (currentBackground.getImage().equals(spotLightBHR.getImage())){
                currentBackground.setImage(spotLightLV.getImage());
            } else {
                if (currentBackground.getImage().equals(spotLightLV.getImage())){
                    currentBackground.setImage(spotLightDev.getImage());
                } else {
                    if (currentBackground.getImage().equals(spotLightDev.getImage())){
                        currentBackground.setImage(spotLightBHR.getImage());
                    }
                }
            }
        });

        btnBackToProfile.setOnMouseClicked(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowProfile.fxml")), 1280, 720));
            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });

        btnChoiceHero.setOnMouseClicked(event -> {
            if (profileController == 1){
                try {
                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAutorization.fxml")), 1280, 720));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                azironStage.show();
            } else {
                btnOffLeft.setVisible(false);
                btnOnLeft.setVisible(false);
                btnOnRight.setVisible(false);
                btnOffRight.setVisible(false);
                btnChoiceHero.setVisible(false);
                btnBackToProfile.setVisible(false);
                paneMessage.setVisible(true);
                //Запуск матча... (используется сцена Кости)
            }
        });
    }
}
