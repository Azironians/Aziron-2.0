package Controllers;

import Interface.SceneMover;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import static Interface.SceneMover.transferredObject;

public class ControllerChoiceBonus implements Initializable, Controller{
   String lastWindow = "windowChoiceBonus";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appearance();
        //загрузка бонусов
    }



    @Override
    public void appearance() {

    }

    public void back(){
        SceneMover.moveToScene(lastWindow);
    }
}
