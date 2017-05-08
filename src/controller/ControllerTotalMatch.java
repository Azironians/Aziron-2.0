package controller;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Heroes.HeroOrcBasher;
import Main.Profile;
import Match.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.BuildStage.azironStage;
import static Main.BuildStage.profile1;
import static Main.BuildStage.profile2;
import static controller.ControllerChoiceHero.player1;
import static controller.ControllerChoiceHero.player2;

public class ControllerTotalMatch implements Initializable {
    @FXML Button btnPlayAgain;
    @FXML Button btnBackToMenu;
    //Статистика:
    @FXML Text textPlayer1Name;
    @FXML Text  textPlayer2Name;
    @FXML Text textPlayer1DealDamage;
    @FXML Text textPlayer2DealDamage;
    @FXML Text textPlayer1RestoreHitPoints;
    @FXML Text textPlayer2RestoreHitPoints;
    @FXML Text textPlayer1ReachedLevel;
    @FXML Text textPlayer2ReachedLevel;
    @FXML Text textPlayer1UsedSkills;
    @FXML Text textPlayer2UsedSkills;
    @FXML Text textPlayer1FavouriteBonus;
    @FXML Text textPlayer2FavouriteBonus;
    @FXML Text textPlayer1RemainingTime;
    @FXML Text textPlayer2RemainingTime;
    @FXML Text textPlayer1Result;
    @FXML Text textPlayer2Result;







    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Костя передаёт сюда данные из окна матча...
        //Локальные данные матча выводятся на экран...
        //Глобальные данные матча записываются в файлы профиля...


        //Игрок 1:
        textPlayer1Name.setText(profile1.getName());
        textPlayer1DealDamage.setText(String.valueOf(player1.getDealDamage()));
        textPlayer1RestoreHitPoints.setText(String.valueOf(player1.getRestoredHitPoints()));
        textPlayer1ReachedLevel.setText(String.valueOf(player1.getReachedLevel()));
        textPlayer1UsedSkills.setText(String.valueOf(player1.getUsedSkills()));
        textPlayer1FavouriteBonus.setText(String.valueOf(player1.getFavouriteBonus()));
        textPlayer1RemainingTime.setText(String.valueOf(player1.getRemainingTime()));
        if (player1.isWinner()){
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
        if (player2.isWinner()){
            textPlayer2Result.setText("Победа");
        } else {
            textPlayer2Result.setText("Поражение");
        }
        //Коррекция статистики учетных записей профилей:
        try {
            correctStatistics(player1, profile1, profile2);
            correctStatistics(player2, profile2, profile1);
        } catch (IOException e){
            System.out.println("Непредвиденная ошибка");
        }

        btnPlayAgain.setOnMouseClicked(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAutorization.fxml")), 1280, 720));
            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });

        btnBackToMenu.setOnMouseClicked(event -> {
            try {
                azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowMenu.fxml")), 1280, 720));
            } catch (IOException e) {
                e.printStackTrace();
            }
            azironStage.show();
        });



    }




    //Изменяем ранг профию:
    public void correctStatistics(Player player, Profile profile, Profile opponentProfile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(profile.getName()));
        if (player.isWinner()){
            for (int i = 0; i < 8; i++){
                switch (i){
                    case 2: //Коррекция рейтинга:
                        profile.setMMR(profile.getMMR() + 25 + opponentProfile.getRank() - profile.getRank()); // Изменить MMR
                        profile.correctRank(); // Изменить ранг
                        bufferedWriter.write(profile.getRank().toString() + "/" + profile.getMMR().toString());
                        bufferedWriter.newLine();
                        break;
                    case 3: //Коррекция побед:
                        profile.setWin(profile.getWin() + 1);
                        bufferedWriter.write(profile.getWin());
                        bufferedWriter.newLine();
                        break;
                    case 5: //Коррекция побед за выбранного героя:
                        if (player.getHero().getClass().equals(HeroDevourer.class)){
                            profile.setWinForDevourer(profile.getWinForDevourer() + 1);
                            bufferedWriter.write(profile.getWinForDevourer());
                        }
                        bufferedWriter.newLine();
                        break;
                    case 6:
                        if (player.getHero().getClass().equals(HeroLordVamp.class)){
                            profile.setWinForDevourer(profile.getWinForLV() + 1);
                            bufferedWriter.write(profile.getWinForLV());
                        }
                        bufferedWriter.newLine();
                        break;
                    case 7:
                        if (player.getHero().getClass().equals(HeroOrcBasher.class)){
                            profile.setWinForDevourer(profile.getWinForOrcBacher() + 1);
                            bufferedWriter.write(profile.getWinForOrcBacher());
                        }
                        bufferedWriter.close();
                        break;
                    default:
                        bufferedWriter.newLine();
                        break;
                }
            }
        } else { // Если поражение:
            for (int i = 0; i < 5; i++){
                switch (i){
                    case 2:
                        profile.setMMR(profile.getMMR() - 20 - profile.getRank() + opponentProfile.getRank()); //Изменить MMR
                        profile.correctRank(); // Изменить ранг
                        bufferedWriter.write(profile.getRank().toString() + "/" + profile.getMMR().toString());
                        bufferedWriter.newLine();
                        break;
                    case 4: //Коррекция поражений
                        profile.setLose(profile.getLose() + 1);
                        bufferedWriter.write(profile.getLose());
                        bufferedWriter.close();
                    default:
                        bufferedWriter.newLine();
                        break;
                }
            }
        }
    }

}
