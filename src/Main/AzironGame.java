package Main;
import InitializationGame.Initialization;
import javafx.application.Application;
import javafx.stage.Stage;

public class AzironGame extends Application {

    @Override
    public void start(Stage AzironStage) throws Exception {
        AzironStage.setTitle("Heroes of Azironian");
        AzironStage.show();
        AzironStage.setResizable(false);
        Initialization.windowInitialization(AzironStage);
    }



    public static void main(String[] args) {
        launch(args);
    }
}