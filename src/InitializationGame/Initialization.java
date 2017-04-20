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

        File file = new File("src\\Picture\\Windows\\WindowBattleField.bmp");
        Image image = new Image(file.toURI().toString(),1280.0,720.0,true,true);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(720.0);
        imageView.setFitWidth(1280.0);
        file= new File("src\\Picture\\Heroes\\Devourer\\ger1g.png");
        Image image2 = new Image(file.toURI().toString(),1280.0,720.0,true,true);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(400.0);
        imageView2.setFitWidth(300.0);
        imageView2.setTranslateX(50);
        imageView2.setTranslateY(100);
        ImageView imageView3 = new ImageView(image2);
        imageView3.setFitHeight(400.0);
        imageView3.setFitWidth(300.0);
        imageView3.setTranslateX(800);
        imageView3.setTranslateY(100);
        file= new File("src\\Picture\\Buttons\\Health_Moused.png");
        Image treatmentPict = new Image(file.toURI().toString(),50,50,true,true);
        ImageView treatmentVievPict = new ImageView(treatmentPict);
        treatmentVievPict.setFitHeight(50.0);
        treatmentVievPict.setFitWidth(50.0);
        treatmentVievPict.setTranslateY(670);
        treatmentVievPict.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.out.println("sdfsdf"));
        root.getChildren().addAll(imageView,imageView2,imageView3,treatmentVievPict);
        Scene scene = new Scene(root, 1280, 720);
        AzironStage.setScene(scene);

        return AzironStage;
    }
}
