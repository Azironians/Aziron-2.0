package Main;

import javafx.stage.Stage;

public class BuildStage {
    //Приложение:
    public static Stage azironStage = new Stage();
    //Профиль для авторизации:
    public static Profile profile = new Profile("------");
    //Контроль профилей:
    public static byte profileController = 0;
    //Любимый герой
    public static String favouriteHero = "";
}
