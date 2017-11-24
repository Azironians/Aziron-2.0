package Controllers;

import Interface.SceneMover;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerChoiceBonus implements Initializable, Controller{
    SceneMover sceneMover = new SceneMover();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appearance();
        //загрузка бонусов
    }

    @Override
    public SceneMover getSceneMover() {
        return null;
    }

    @Override
    public void appearance() {

    }

    public void back(){
        sceneMover.moveToScene("");
    }
}
