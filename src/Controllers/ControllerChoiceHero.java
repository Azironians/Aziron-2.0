package Controllers;

import Heroes.*;
import Interface.SceneMover;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static Main.AzironGame.soundFon;


public class ControllerChoiceHero implements Initializable, Controller {

    private AHero currentHero;

    private AHero devourer = BuilderAHero.buildDevourer();
    private AHero lordVamp = BuilderAHero.buildLordVamp();
    private AHero orgBasher = BuilderAHero.buildOrcBasher();

    @FXML
    private Pane paneHeroes;
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
    private Pane paneMessage;
    @FXML
    private ImageView btnOffBack;
    @FXML
    private ImageView btnOnBack;
    @FXML
    private ImageView btnOffChoiceHero;
    @FXML
    private ImageView btnOnChoiceHero;

    private List<AHero> heroes = Arrays.asList(devourer, lordVamp, orgBasher);
    private int pointer;


    private void ok() {
        if ()
    }

    public void buttonOnLeftClicked() {
        heroes.get(pointer).getPresentation().getPane().setVisible(false);
        heroes.get(--pointer).getPresentation().getPane().setVisible(true);
    }

    public void buttonOnRightClicked() {
        heroes.get(pointer).getPresentation().getPane().setVisible(false);
        heroes.get(++pointer).getPresentation().getPane().setVisible(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appearance();
    }


    @Override
    public void appearance() {
        for (AHero azironHero : heroes) {
            paneHeroes.getChildren().add(azironHero.getPresentation().getPane());
        }

        currentHero.getPresentation().getPane().setVisible(true);
        currentHero.getPresentation().getPane().setOpacity(100);
        pointer = heroes.indexOf(currentHero);
    }

    /////////////////////////////////////////////////////////////////////////////////////


    public void buttonMoveToWindowBonusChoiceClicked() {
        SceneMover.moveToScene("windowChoiceBonus");
    }

    public void buttonOffChoiceHeroEntered() {
        btnOffChoiceHero.setVisible(false);
        btnOnChoiceHero.setVisible(true);
    }

    public void buttonOnChoiceHeroExited() {
        btnOffChoiceHero.setVisible(true);
        btnOnChoiceHero.setVisible(false);
    }

    public void buttonOffLeftEntered() {
        btnOffLeft.setVisible(false);
        btnOnLeft.setVisible(true);
    }

    public void buttonOnLeftExited() {
        btnOffLeft.setVisible(true);
        btnOnLeft.setVisible(false);
    }

    public void buttonOnRightExited() {
        btnOffRight.setVisible(true);
        btnOnRight.setVisible(false);

    }

    public void buttonOffRightEntered() {
        btnOffRight.setVisible(true);
        btnOnRight.setVisible(false);
    }

    public void buttonOnBackClicked() {
        SceneMover.moveToScene("windowProfile");

    }

    public void buttonOnBackExited() {
        btnOnBack.setVisible(false);
        btnOffBack.setVisible(true);

    }

    public void buttonOffBackEntered() {
        btnOffBack.setVisible(false);
        btnOnBack.setVisible(true);
    }


}
