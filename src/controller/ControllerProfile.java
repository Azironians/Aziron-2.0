package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static Main.BuildStage.*;

public class ControllerProfile implements Initializable {
    @FXML ImageView background;
    @FXML ImageView buttonOffLogOut;
    @FXML ImageView buttonOnLogOut;
    @FXML ImageView buttonOffShowStatistics;
    @FXML ImageView buttonOnShowStatistics;
    @FXML ImageView buttonOffChoiceHeroes;
    @FXML ImageView buttonOnChoiceHeroes;
    @FXML ImageView Devourer;
    @FXML ImageView LordVamp;
    @FXML ImageView OrcBasher;

    @FXML Text textFavouriteHero;
    @FXML Text textProfileName;
    @FXML Text textPlayer;

    @FXML Pane paneStatistics;
    @FXML Text textRank;
    @FXML Text textRating;
    @FXML Text textWins;
    @FXML Text textLoses;
    @FXML Text textWinsDevourer;
    @FXML Text textWinsLV;
    @FXML Text textWinsOrcBasher;

    @FXML ImageView buttonOffCloseStatistics;
    @FXML ImageView buttonOnCloseStatistics;
    @FXML ImageView panelStatistics;







    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Инициализация окна:
            textPlayer.setText("Игрок " + profileController);
            textProfileName.setText(profile.getName());
            List<Integer> listWinsOfHeroes = Arrays.asList(
                    profile.getWinForDevourer(),
                    profile.getWinForLV(),
                    profile.getWinForOrcBacher()
            );
            if (max(listWinsOfHeroes).equals(profile.getWinForDevourer()) && profile.getWinForDevourer() != 0){
                Devourer.setVisible(true);
                textFavouriteHero.setText("Любимый герой: Пожиратель");
            }
            if (max(listWinsOfHeroes).equals(profile.getWinForLV()) && profile.getWinForLV() != 0){
                LordVamp.setVisible(true);
                textFavouriteHero.setText("Любимый герой: Лорд Вампир");
            }
            if (max(listWinsOfHeroes).equals(profile.getWinForOrcBacher()) && profile.getWinForOrcBacher() != 0){
                OrcBasher.setVisible(true);
                textFavouriteHero.setText("Любимый герой: Орк-Оглушитель");
            }
            favouriteHero = textFavouriteHero.getText();

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
            } catch (IOException e) {
                e.printStackTrace();
            }
            profileController--;
            profile.setName("");
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });

    }

    public Integer max(List<Integer> list){
        Integer maxValue = 0;
        for (Integer win: list){
            if (maxValue < win){
                maxValue = win;
            }
        }
        return maxValue;
    }
}
