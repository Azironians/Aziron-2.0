package controller;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Heroes.HeroOrcBasher;
import Main.Sound;
import Match.Battle;
import Match.Player;
import javafx.animation.FadeTransition;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.AzironGame.soundFon;
import static Main.BuildStage.*;
import static Main.Sound.playSound;


public class ControllerChoiceHero implements Initializable {
    public static Battle battle;
    public static Player player1;
    public static Player player2;

    @FXML
    private ImageView spotLightDev;
    @FXML
    private ImageView spotLightLV;
    @FXML
    private ImageView spotLightBHR;
    @FXML
    private ImageView btnOffLeft;
    @FXML
    private ImageView btnOnLeft;
    @FXML
    private ImageView btnOnRight;
    @FXML
    private ImageView btnOffRight;
    @FXML
    private ImageView currentBackground;
    @FXML
    private Button btnChoiceHero;
    @FXML
    private Button btnBackToProfile;
    @FXML
    private Pane paneMessage;
    @FXML
    private ImageView btnOffBack;
    @FXML
    private ImageView btnOnBack;
    @FXML
    private ImageView btnOffChoiceHero;
    @FXML
    private ImageView btnOnChoiceHero;

    private File SDev1 = new File("src\\Sounds\\SoundDevourer\\DevGreetings-1.wav");
    private File SDev2 = new File("src\\Sounds\\SoundDevourer\\DevGreetings-2.wav");
    private File SLV1 = new File("src\\Sounds\\SoundLordVampire\\LVGreetings-1.wav");
    private File SLV2 = new File("src\\Sounds\\SoundLordVampire\\LVGreetings-2.wav");
    private File SOB1 = new File("src\\Sounds\\SoundOrcBasher\\BhrGreetings-1.wav");
    private File SOB2 = new File("src\\Sounds\\SoundOrcBasher\\BhrGreetings-2.wav");

    private void ok() {
        if (profileController == 1) {

            if (currentBackground.getImage().equals(spotLightDev.getImage())) {
                profile.setPlayer(new Player(profile.getName(), new HeroDevourer(true)));
            }
            if (currentBackground.getImage().equals(spotLightLV.getImage())) {
                profile.setPlayer(new Player(profile.getName(), new HeroLordVamp(true)));
            }
            if (currentBackground.getImage().equals(spotLightBHR.getImage())) {
                profile.setPlayer(new Player(profile.getName(), new HeroOrcBasher(true)));
            }
            profile1 = profile;
            paneMessage.setVisible(true);
            TranslateTransition transition2 = new TranslateTransition(Duration.millis(1), new Rectangle(-10, -10, 1, 1));
            transition2.setByX(1);
            transition2.setCycleCount(1);
            transition2.setOnFinished(event1 -> {
                try {
                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAutorization.fxml")), 1280, 720));
                    Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                    ImageCursor imageCursor = new ImageCursor(cursor);
                    azironStage.getScene().setCursor(imageCursor);
                    azironStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            transition2.play();


        } else {
            if (currentBackground.getImage().equals(spotLightDev.getImage())) {
                profile.setPlayer(new Player(profile.getName(), new HeroDevourer(false)));
            }
            if (currentBackground.getImage().equals(spotLightLV.getImage())) {
                profile.setPlayer(new Player(profile.getName(), new HeroLordVamp(false)));
            }
            if (currentBackground.getImage().equals(spotLightBHR.getImage())) {
                profile.setPlayer(new Player(profile.getName(), new HeroOrcBasher(false)));
            }
            profile2 = profile;


            btnOffLeft.setVisible(false);
            btnOnLeft.setVisible(false);
            btnOnRight.setVisible(false);
            btnOffRight.setVisible(false);
            btnChoiceHero.setVisible(false);
            btnBackToProfile.setVisible(false);
            paneMessage.setVisible(true);
            TranslateTransition transition2 = new TranslateTransition(Duration.millis(1), new Rectangle(-10, -10, 1, 1));
            transition2.setByX(1);
            transition2.setCycleCount(1);
            transition2.setOnFinished(event1 -> {
                ImageView fon = new ImageView(new Image("file:src\\Picture\\Windows\\WindowInitialization.jpg"));
                ImageView load = new ImageView(new Image("file:src\\Picture\\Windows\\load.gif"));
                fon.setFitHeight(720);
                fon.setFitWidth(1280);
                load.setFitWidth(150);
                load.setFitHeight(150);
                load.setLayoutX(640 - 75);
                load.setLayoutY(570);

                Pane pane = new Pane(fon, load);
                Scene sceneMenu = new Scene(pane, 1280, 720);
                //2. Окно меню:
                azironStage.setScene(sceneMenu);
                Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                ImageCursor imageCursor = new ImageCursor(cursor);
                azironStage.getScene().setCursor(imageCursor);
                soundFon.stop();
                soundFon = new Sound(new File("src\\Sounds\\game.wav"));
                soundFon.play();
                soundFon.setRepeat(true);
                player1 = profile1.getPlayer();
                player2 = profile2.getPlayer();
                battle = new Battle();
                battle.battleProcess(player1, player2);
                //Запуск матча...
            });
            transition2.play();
        }
    }

    private void left() {
        if (currentBackground.getImage().equals(spotLightBHR.getImage())) {
            if (Math.random() > 0.5) playSound(SDev1);
            else playSound(SDev2);
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), spotLightBHR);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setCycleCount(1);
            spotLightDev.setOpacity(0);
            currentBackground.setImage(spotLightDev.getImage());
            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(500), spotLightDev);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(1);
            fadeTransition2.setCycleCount(1);
            fadeTransition2.play();
            fadeTransition.play();
        } else {
            if (currentBackground.getImage().equals(spotLightLV.getImage())) {
                if (Math.random() > 0.5) playSound(SOB1);
                else playSound(SOB2);
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), spotLightLV);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.setCycleCount(1);
                spotLightBHR.setOpacity(0);
                currentBackground.setImage(spotLightBHR.getImage());
                FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(500), spotLightBHR);
                fadeTransition2.setFromValue(0);
                fadeTransition2.setToValue(1);
                fadeTransition2.setCycleCount(1);
                fadeTransition2.play();
                fadeTransition.play();
            } else {
                if (currentBackground.getImage().equals(spotLightDev.getImage())) {
                    if (Math.random() > 0.5) playSound(SLV1);
                    else playSound(SLV2);
                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), spotLightDev);
                    fadeTransition.setFromValue(1);
                    fadeTransition.setToValue(0);
                    fadeTransition.setCycleCount(1);
                    spotLightLV.setOpacity(0);
                    currentBackground.setImage(spotLightLV.getImage());
                    FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(500), spotLightLV);
                    fadeTransition2.setFromValue(0);
                    fadeTransition2.setToValue(1);
                    fadeTransition2.setCycleCount(1);
                    fadeTransition2.play();
                    fadeTransition.play();
                }
            }
        }
    }

    private void right() {
        if (currentBackground.getImage().equals(spotLightBHR.getImage())) {
            if (Math.random() > 0.5) playSound(SLV1);
            else playSound(SLV2);
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), spotLightBHR);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setCycleCount(1);
            spotLightLV.setOpacity(0);
            currentBackground.setImage(spotLightLV.getImage());
            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(500), spotLightLV);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(1);
            fadeTransition2.setCycleCount(1);
            fadeTransition2.play();
            fadeTransition.play();
        } else {
            if (currentBackground.getImage().equals(spotLightLV.getImage())) {
                if (Math.random() > 0.5) playSound(SDev1);
                else playSound(SDev2);
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), spotLightLV);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.setCycleCount(1);
                spotLightDev.setOpacity(0);
                currentBackground.setImage(spotLightDev.getImage());
                FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(500), spotLightDev);
                fadeTransition2.setFromValue(0);
                fadeTransition2.setToValue(1);
                fadeTransition2.setCycleCount(1);
                fadeTransition2.play();
                fadeTransition.play();
            } else {
                if (currentBackground.getImage().equals(spotLightDev.getImage())) {
                    if (Math.random() > 0.5) playSound(SOB1);
                    else playSound(SOB2);
                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), spotLightDev);
                    fadeTransition.setFromValue(1);
                    fadeTransition.setToValue(0);
                    fadeTransition.setCycleCount(1);
                    spotLightBHR.setOpacity(0);
                    currentBackground.setImage(spotLightBHR.getImage());
                    FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(500), spotLightBHR);
                    fadeTransition2.setFromValue(0);
                    fadeTransition2.setToValue(1);
                    fadeTransition2.setCycleCount(1);
                    fadeTransition2.play();
                    fadeTransition.play();
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(favouriteHero);
        spotLightLV.setVisible(true);
        spotLightLV.setOpacity(0);
        spotLightBHR.setVisible(true);
        spotLightBHR.setOpacity(0);
        spotLightDev.setVisible(true);
        spotLightDev.setOpacity(0);

        //Выбор героя:
        btnOffChoiceHero.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btnOffChoiceHero.setVisible(false);
            btnOnChoiceHero.setVisible(true);
        });
        btnOnChoiceHero.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            btnOffChoiceHero.setVisible(true);
            btnOnChoiceHero.setVisible(false);
        });
        btnOffBack.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btnOffBack.setVisible(false);
            btnOnBack.setVisible(true);
        });
        btnOnBack.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            btnOffBack.setVisible(true);
            btnOnBack.setVisible(false);
        });

        btnOnChoiceHero.setOnMouseClicked(event -> ok());
        btnOnBack.setOnMouseClicked(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowProfile.fxml")), 1280, 720));
            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });

        switch (favouriteHero) {
            case "Любимый герой: Пожиратель":
                currentBackground.setImage(spotLightDev.getImage());
                spotLightDev.setOpacity(1);
                break;
            case "Любимый герой: Лорд Вампир":
                currentBackground.setImage(spotLightLV.getImage());
                spotLightLV.setOpacity(1);
                break;
            case "Любимый герой: Орк-Оглушитель":
                currentBackground.setImage(spotLightBHR.getImage());
                spotLightBHR.setOpacity(1);
                break;
            default:
                currentBackground.setImage(spotLightDev.getImage());
                spotLightDev.setOpacity(1);
                break;
        }


        //Фон:
        currentBackground.setOnMouseEntered(event -> {
            btnOnRight.setVisible(false);
            btnOffRight.setVisible(true);
            btnOnLeft.setVisible(false);
            btnOffLeft.setVisible(true);
        });

        //Влево:
        btnOffLeft.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btnOffLeft.setVisible(false);
            btnOnLeft.setVisible(true);
        });

        btnOnLeft.setOnMouseClicked(event -> left());
        btnChoiceHero.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) left();
            if (event.getCode() == KeyCode.RIGHT) right();
            if (event.getCode() == KeyCode.ENTER) ok();
            if (event.getCode() == KeyCode.ESCAPE) {
                try {

                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowProfile.fxml")), 1280, 720));
                    Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                    ImageCursor imageCursor = new ImageCursor(cursor);
                    azironStage.getScene().setCursor(imageCursor);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                azironStage.show();
            }
        });
        btnBackToProfile.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) left();
            if (event.getCode() == KeyCode.RIGHT) right();
            if (event.getCode() == KeyCode.ENTER) ok();
            if (event.getCode() == KeyCode.ESCAPE) {
                try {
                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowProfile.fxml")), 1280, 720));
                    Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                    ImageCursor imageCursor = new ImageCursor(cursor);
                    azironStage.getScene().setCursor(imageCursor);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                azironStage.show();
            }
        });

        btnOnLeft.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            btnOffLeft.setVisible(true);
            btnOnLeft.setVisible(false);
        });


        //Вправо:
        btnOffRight.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btnOffRight.setVisible(false);
            btnOnRight.setVisible(true);
        });

        btnOnRight.setOnMouseClicked(event -> right());
        btnOnRight.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            btnOffRight.setVisible(true);
            btnOnRight.setVisible(false);
        });
        btnBackToProfile.setOnAction(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowProfile.fxml")), 1280, 720));
                Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                ImageCursor imageCursor = new ImageCursor(cursor);
                azironStage.getScene().setCursor(imageCursor);

            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });
        btnChoiceHero.setOnAction(event -> ok());
    }
}
