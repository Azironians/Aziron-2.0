package Controllers;

import Main.Sound;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.AzironGame.soundFon;
import static Main.BuildStage.*;
import static Controllers.ControllerChoiceHero.battle;
import static Controllers.ControllerChoiceHero.player1;
import static Controllers.ControllerChoiceHero.player2;

public class ControllerTotalMatch implements Initializable {
    @FXML
    private Button btnPlayAgain;
    @FXML
    private Button btnBackToMenu;
    //Статистика:
    @FXML
    private Text textPlayer1Name;
    @FXML
    private Text textPlayer2Name;
    @FXML
    private Text textPlayer1DealDamage;
    @FXML
    private Text textPlayer2DealDamage;
    @FXML
    private Text textPlayer1RestoreHitPoints;
    @FXML
    private Text textPlayer2RestoreHitPoints;
    @FXML
    private Text textPlayer1ReachedLevel;
    @FXML
    private Text textPlayer2ReachedLevel;
    @FXML
    private Text textPlayer1UsedSkills;
    @FXML
    private Text textPlayer2UsedSkills;
    @FXML
    private Text textPlayer1FavouriteBonus;
    @FXML
    private Text textPlayer2FavouriteBonus;
    @FXML
    private Text textPlayer1RemainingTime;
    @FXML
    private Text textPlayer2RemainingTime;
    @FXML
    private Text textPlayer1Result;
    @FXML
    private Text textPlayer2Result;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Костя передаёт сюда данные из окна матча...
        //Локальные данные матча выводятся на экран...
        //Глобальные данные матча записываются в файлы профиля...
        soundFon.stop();
        soundFon = new Sound(new File("src\\Sounds\\menu.wav"));
        soundFon.play();
        soundFon.setRepeat(true);
        //Игрок 1:
        textPlayer1Name.setText(profile1.getName());
        textPlayer1DealDamage.setText(String.valueOf(player1.getDealDamage()));
        textPlayer1RestoreHitPoints.setText(String.valueOf(player1.getRestoredHitPoints()));
        textPlayer1ReachedLevel.setText(String.valueOf(player1.getReachedLevel()));
        textPlayer1UsedSkills.setText(String.valueOf(player1.getUsedSkills()));
        textPlayer1FavouriteBonus.setText(String.valueOf(player1.getFavouriteBonus()));
        textPlayer1RemainingTime.setText(String.valueOf(player1.getRemainingTime()));
        if (player1.isWinner()) {
            textPlayer1Result.setText("Победа");
        } else {
            textPlayer1Result.setText("Поражение");
        }

        //Игрок 2:
        textPlayer2Name.setText(profile2.getName());
        textPlayer2DealDamage.setText(String.valueOf(player2.getDealDamage()));
        textPlayer2RestoreHitPoints.setText(String.valueOf(player2.getRestoredHitPoints()));
        textPlayer2ReachedLevel.setText(String.valueOf(player2.getReachedLevel()));
        textPlayer2UsedSkills.setText(String.valueOf(player2.getUsedSkills()));
        textPlayer2FavouriteBonus.setText(String.valueOf(player2.getFavouriteBonus()));
        textPlayer2RemainingTime.setText(String.valueOf(player2.getRemainingTime()));
        if (player2.isWinner()) {
            textPlayer2Result.setText("Победа");
        } else {
            textPlayer2Result.setText("Поражение");
        }
        //Коррекция статистики учетных записей профилей:


        player1 = null;
        player2 = null;
        battle = null;
        profile1 = null;
        profile2 = null;
        profileController = 0;
        btnPlayAgain.setOnMouseClicked(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAuthorization.fxml")), 1280, 720));
                Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                ImageCursor imageCursor = new ImageCursor(cursor);
                azironStage.getScene().setCursor(imageCursor);

            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });

        btnBackToMenu.setOnMouseClicked(event -> {
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


    }


    //Изменяем ранг профию:

}
