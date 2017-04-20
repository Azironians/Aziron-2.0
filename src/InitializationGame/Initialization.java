package InitializationGame;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class Initialization {
    public static Stage windowInitialization(Stage AzironStage) {
        Pane root = new Pane();

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\WindowBattleField.bmp").toURI().toString(),1280.0,720.0,true,true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);

        ImageView imageDevourer = new ImageView(new Image(new File("src\\Picture\\Heroes\\Devourer\\ger1g.png").toURI().toString(),1280.0,720.0,true,true));
        imageDevourer.setFitHeight(400.0);
        imageDevourer.setFitWidth(300.0);
        imageDevourer.setTranslateX(50);
        imageDevourer.setTranslateY(100);

        ImageView imageLordVampire = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\ger2g.png").toURI().toString(),1280.0,720.0,true,true));
        imageLordVampire.setFitHeight(400.0);
        imageLordVampire.setFitWidth(300.0);
        imageLordVampire.setTranslateX(930);
        imageLordVampire.setTranslateY(100);

        ImageView buttonTreatment = new ImageView(new Image(new File("src\\Picture\\Buttons\\Health_Moused.png").toURI().toString(),1280.0,720.0,true,true));


        buttonTreatment.setFitHeight(50.0);
        buttonTreatment.setFitWidth(50.0);
        buttonTreatment.setTranslateY(670);
        buttonTreatment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.out.println("sdfsdf"));

        root.getChildren().addAll( imageBattleGround, imageDevourer,imageLordVampire, buttonTreatment);
        Scene scene = new Scene(root, 1280, 720);
        AzironStage.setScene(scene);

        return AzironStage;
    }
}
