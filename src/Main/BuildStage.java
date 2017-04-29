package Main;

import GulkinInterface.Profile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class BuildStage {

    public static Stage azironStage = new Stage();
    public static Profile profile1 = null;
    public static Profile profile2 = null;
    public static byte profileController = 1;

}

//    public Parent rootMenu;
//    public Parent rootChoiceHero;
//
//
//
//
//
//    public BuildStage() throws IOException {
//        this.rootMenu = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowMenu.fxml"));
//        this.rootChoiceHero = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowChoiceHero.fxml"));
//    }