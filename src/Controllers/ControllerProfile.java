package Controllers;

import BonusDirectory.Deck;
import Interface.SceneMover;
import Main.Clock;
import Main.Profile;
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

import static Controllers.ControllerChoiceHero.*;
import static Main.BuildStage.*;

public class ControllerProfile implements Initializable, Controller {
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
    private Pane paneHeroes;
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

    private Deck defaultPrimaryDeck;

    private Profile currentProfile = new Profile();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appearance();
        initStatistics();
    }

    public void buttonSetOnKeyPressed() {
        SceneMover.moveToScene("windowChoiceHero"); // if (event.getCode() == KeyCode.ENTER) {

        SceneMover.moveToScene("windowAuthorization"); // if (event.getCode() == KeyCode.ESCAPE) {
    }

    @Override
    public void appearance() {
        Clock.launchTimer(time).start();
        textPlayer.setText("Игрок " + profileController);
        textProfileName.setText(currentProfile.getName());
    }

    private void initStatistics() {
        textRank.setText("Ранг: " + currentProfile.getRank().toString());
        textRating.setText("Рейтинг: " + currentProfile.getMMR().toString());
        textWins.setText("Побед: " + currentProfile.getWin().toString());
        textLoses.setText("Поражений: " + currentProfile.getLose().toString());
        textWinsDevourer.setText("Побед за Пожирателя: " + currentProfile.getWinForDevourer().toString());
        textWinsLV.setText("Побед за Лорда Вампа: " + currentProfile.getWinForLV().toString());
        textWinsOrcBasher.setText("Побед за Орка-Оглушителя: " + currentProfile.getWinForOrcBacher().toString());

    }

    //Style & Interface
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void buttonOffShowStatisticsEntered() {
        buttonOnShowStatistics.setVisible(true);
        buttonOffShowStatistics.setVisible(false);
    }
    public void buttonOnShowStatisticsExited() {
        buttonOnShowStatistics.setVisible(false);
        buttonOffShowStatistics.setVisible(true);
    }

    public void buttonOffLogOutEntered(){
        buttonOnLogOut.setVisible(true);
        buttonOffLogOut.setVisible(false);

    }
    public void buttonOnLogOutExited(){
        buttonOnLogOut.setVisible(false);
        buttonOffLogOut.setVisible(true);
    }

    public void buttonOffChoiceHeroesEntered() {
        buttonOnChoiceHeroes.setVisible(true);
        buttonOffChoiceHeroes.setVisible(false);
    }

    public void buttonOnChoiceHeroesExited() {
        buttonOnChoiceHeroes.setVisible(false);
        buttonOffChoiceHeroes.setVisible(true);
    }

    public void buttonOnChoiceHeroesClicked() {
        SceneMover.moveToScene("windowChoiceHero");
    }

    public void buttinOnLogOutClicked() {
        SceneMover.moveToScene("windowAuthorization");
    }

    public void buttonShowStatisticsClicked() {
        paneStatistics.setVisible(true);
        background.setDisable(true);
        buttonOnShowStatistics.setVisible(false);
        buttonOffShowStatistics.setVisible(false);
        buttonOnChoiceHeroes.setVisible(false);
        buttonOffChoiceHeroes.setVisible(false);
        buttonOnLogOut.setVisible(false);
        buttonOffLogOut.setVisible(false);
    }

    public void buttonOnCloseStatisticsClicked() {
        paneStatistics.setVisible(false);
        buttonOffLogOut.setVisible(true);
        buttonOffChoiceHeroes.setVisible(true);
        buttonOffShowStatistics.setVisible(true);
    }

    public void buttonOffCloseStatisticEntered() {
        buttonOnCloseStatistics.setVisible(true);
        buttonOffCloseStatistics.setVisible(false);
    }

    public void buttonOnCloseStatisticsExited() {
        buttonOffCloseStatistics.setVisible(true);
        buttonOnCloseStatistics.setVisible(false);
    }

}
