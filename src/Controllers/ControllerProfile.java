package Controllers;

import Main.Clock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static Controllers.ControllerChoiceHero.devourer;
import static Controllers.ControllerChoiceHero.lordVamp;
import static Controllers.ControllerChoiceHero.orgBasher;
import static Main.BuildStage.*;

public class ControllerProfile implements Initializable {
    @FXML
    AnchorPane anchorPane;
    @FXML
    private ImageView background;
    @FXML
    private ImageView buttonOffLogOut;
    @FXML
    private ImageView buttonOnLogOut;
    @FXML
    private ImageView buttonOffShowStatistics;
    @FXML
    private
    ImageView buttonOnShowStatistics;
    @FXML
    private ImageView buttonOffChoiceHeroes;
    @FXML
    private ImageView buttonOnChoiceHeroes;
    @FXML
    private Text textFavouriteHero;
    @FXML
    private Text textProfileName;
    @FXML
    private Text textPlayer;

    @FXML
    private Pane paneStatistics;
    @FXML
    private Text textRank;
    @FXML
    private Text textRating;
    @FXML
    private Text textWins;
    @FXML
    private Text textLoses;
    @FXML
    private Text textWinsDevourer;
    @FXML
    private Text textWinsLV;
    @FXML
    private Text textWinsOrcBasher;

    @FXML
    private ImageView buttonOffCloseStatistics;
    @FXML
    private ImageView buttonOnCloseStatistics;
    @FXML
    private ImageView panelStatistics;
    @FXML
    private Button btn;
    @FXML
    private Text time;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Инициализация окна:
        Clock.launchTimer(time).start();
        textPlayer.setText("Игрок " + profileController);
        textProfileName.setText(profile.getName());
        List<Integer> listWinsOfHeroes = Arrays.asList(
                profile.getWinForDevourer(),
                profile.getWinForLV(),
                profile.getWinForOrcBacher()
        );

        ImageView currentImage = new ImageView();
//        currentImage.setFitHeight();
//        currentImage.setFitWidth();
        if (max(listWinsOfHeroes).equals(profile.getWinForDevourer()) && profile.getWinForDevourer() != 0) {
            textFavouriteHero.setText("Любимый герой: Пожиратель");
            currentImage.setImage(devourer.getImageView().getImage());
        }
        if (max(listWinsOfHeroes).equals(profile.getWinForLV()) && profile.getWinForLV() != 0) {
            textFavouriteHero.setText("Любимый герой: Лорд Вампир");
            currentImage.setImage(lordVamp.getImageView().getImage());
        }
        if (max(listWinsOfHeroes).equals(profile.getWinForOrcBacher()) && profile.getWinForOrcBacher() != 0) {
            textFavouriteHero.setText("Любимый герой: Орк-Оглушитель");
            currentImage.setImage(orgBasher.getImageView().getImage());
        }
        favouriteHero = textFavouriteHero.getText();
        anchorPane.getChildren().add(currentImage);

        //Статистика профиля:
        textRank.setText("Ранг: " + profile.getRank().toString());
        textRating.setText("Рейтинг: " + profile.getMMR().toString());
        textWins.setText("Побед: " + profile.getWin().toString());
        textLoses.setText("Поражений: " + profile.getLose().toString());
        textWinsDevourer.setText("Побед за Пожирателя: " + profile.getWinForDevourer().toString());
        textWinsLV.setText("Побед за Лорда Вампа: " + profile.getWinForLV().toString());
        textWinsOrcBasher.setText("Побед за Орка-Оглушителя: " + profile.getWinForOrcBacher().toString());


        //Фон:
        background.setOnMouseMoved(event -> {
            buttonOffLogOut.setVisible(true);
            buttonOnLogOut.setVisible(false);

            buttonOffShowStatistics.setVisible(true);
            buttonOnShowStatistics.setVisible(false);

            buttonOffChoiceHeroes.setVisible(true);
            buttonOnChoiceHeroes.setVisible(false);
        });


        // Кнопка "Выйти":
        buttonOffLogOut.setOnMouseMoved(event -> {
            buttonOffLogOut.setVisible(false);
            buttonOnLogOut.setVisible(true);
            buttonOnShowStatistics.setVisible(false);
            buttonOffShowStatistics.setVisible(true);
        });

        buttonOnLogOut.setOnMouseClicked(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAutorization.fxml")), 1280, 720));
                Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                ImageCursor imageCursor = new ImageCursor(cursor);
                azironStage.getScene().setCursor(imageCursor);

            } catch (IOException e) {
                e.printStackTrace();
            }
            profileController--;
            profile.setName();
            azironStage.show();
        });


        //Кнопка "Статистика профиля":
        buttonOffShowStatistics.setOnMouseMoved(event -> {
            buttonOffShowStatistics.setVisible(false);
            buttonOnLogOut.setVisible(false);
            buttonOnShowStatistics.setVisible(true);
            buttonOffLogOut.setVisible(true);
        });

        buttonOnShowStatistics.setOnMouseClicked(event -> {
            paneStatistics.setVisible(true);
            background.setDisable(true);
            buttonOnShowStatistics.setVisible(false);
            buttonOffShowStatistics.setVisible(false);
            buttonOnChoiceHeroes.setVisible(false);
            buttonOffChoiceHeroes.setVisible(false);
            buttonOnLogOut.setVisible(false);
            buttonOffLogOut.setVisible(false);

        });

        buttonOffCloseStatistics.setOnMouseMoved(event -> {
            buttonOffCloseStatistics.setVisible(false);
            buttonOnCloseStatistics.setVisible(true);
        });
        buttonOnCloseStatistics.setOnMouseClicked(event -> {
            paneStatistics.setVisible(false);
            buttonOffLogOut.setVisible(true);
            buttonOffChoiceHeroes.setVisible(true);
            buttonOffShowStatistics.setVisible(true);
        });

        panelStatistics.setOnMouseMoved(event -> {
            buttonOffCloseStatistics.setVisible(true);
            buttonOnCloseStatistics.setVisible(false);
        });


        //Кнопка "перейти к выбору героя":
        buttonOffChoiceHeroes.setOnMouseMoved(event -> {
            buttonOffChoiceHeroes.setVisible(false);
            buttonOnChoiceHeroes.setVisible(true);
        });

        buttonOnChoiceHeroes.setOnMouseClicked(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowChoiceHero.fxml")), 1280, 720));
                Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                ImageCursor imageCursor = new ImageCursor(cursor);
                azironStage.getScene().setCursor(imageCursor);

            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });
        btn.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowChoiceHero.fxml")), 1280, 720));
                    Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                    ImageCursor imageCursor = new ImageCursor(cursor);
                    azironStage.getScene().setCursor(imageCursor);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                azironStage.show();
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                try {
                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAutorization.fxml")), 1280, 720));
                    Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                    ImageCursor imageCursor = new ImageCursor(cursor);
                    azironStage.getScene().setCursor(imageCursor);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                profileController--;
                profile.setName();
                azironStage.show();
            }
        });
    }

    private Integer max(List<Integer> list) {
        Integer maxValue = 0;
        for (Integer win : list) {
            if (maxValue < win) {
                maxValue = win;
            }
        }
        return maxValue;
    }
}
