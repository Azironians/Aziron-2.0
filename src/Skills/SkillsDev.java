package Skills;

import Heroes.Hero;
import Match.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

import static Match.Battle.turn;

public class SkillsDev implements Skill {
    private static Double experience;
    private static Double attack;
    private static Double treatment;
    private static Double hitPoints;
    private static Double supplyHealth;
    private static boolean firstOpen = false;
    private static boolean twoOpen = false;
    private static boolean threeOpen = false;
    private static int levelHero;
    private ImageView imageView;
    private ImageView[] imageViewList = {new ImageView(new Image("file:src\\Picture\\Skills\\SkillDev1.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillDev2.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillDev3.png"))};

    public SkillsDev(Player player) {

        for (int i = 0; i < 3; i++) {
            imageViewList[i].setFitHeight(112);
            imageViewList[i].setFitWidth(112);
        }
        imageViewList[0].setLayoutY(547);
        imageViewList[1].setLayoutY(547);
        imageViewList[2].setLayoutY(547);

        if (player.getLocation()) {
            imageViewList[0].setLayoutX(29);
            imageViewList[1].setLayoutX(108);
            imageViewList[2].setLayoutX(177);
        } else {
            for (int i = 0; i < 3; i++) {
                imageViewList[i].setScaleX(-1);
            }
            imageViewList[0].setLayoutX(983);
            imageViewList[1].setLayoutX(1058);
            imageViewList[2].setLayoutX(1131);
        }
    }

    public static boolean isFirstOpen() {
        return firstOpen;
    }

    public static void setFirstOpen(boolean firstOpen) {
        SkillsDev.firstOpen = firstOpen;
    }

    public static boolean isTwoOpen() {
        return twoOpen;
    }

    public static void setTwoOpen(boolean twoOpen) {
        SkillsDev.twoOpen = twoOpen;
    }

    public static boolean isThreeOpen() {
        return threeOpen;
    }

    public static void setThreeOpen(boolean threeOpen) {
        SkillsDev.threeOpen = threeOpen;
    }
}
