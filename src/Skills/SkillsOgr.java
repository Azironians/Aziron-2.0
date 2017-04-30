package Skills;

import Heroes.Hero;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import static Main.AzironGame.player1;
import static Main.AzironGame.player2;
import static Match.Battle.turn;
import static Match.Battle.turns;


public class SkillsOgr implements Skill {

    private boolean firstOpen = false;
    private boolean twoOpen = false;
    private boolean threeOpen = false;
    private ImageView[] imageViewList = {
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillBHR1.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillBHR2.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillBHR3.png"))};
    private int turnOpen1 = 0;
    private int turnOpen2 = 0;
    private int turnOpen3 = 0;

    public SkillsOgr(Hero hero) {
        imageViewList[0].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (firstOpen && ((turn == 1 && hero.getLocation()) || (turn == -1 && !hero.getLocation()))) {
                turns++;
                turn *= -1;
                firstUlt();
            }
        });
        imageViewList[1].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (twoOpen && ((turn == 1 && hero.getLocation()) || (turn == -1 && !hero.getLocation()))) {
                turns++;
                turn *= -1;
                twoUlt();
            }
        });
        imageViewList[2].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (threeOpen && ((turn == 1 && hero.getLocation()) || (turn == -1 && !hero.getLocation()))) {
                turns++;
                turn *= -1;
                threeUlt();
            }
        });

        imageViewList[0].setOpacity(0.3);
        imageViewList[1].setOpacity(0.3);
        imageViewList[2].setOpacity(0.3);


        for (int i = 0; i < 3; i++) {
            imageViewList[i].setFitHeight(112);
            imageViewList[i].setFitWidth(112);
        }
        imageViewList[0].setLayoutY(547);
        imageViewList[1].setLayoutY(547);
        imageViewList[2].setLayoutY(547);

        if (hero.getLocation()) {
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

    @Override
    public ImageView[] getImageViewList() {
        return imageViewList;
    }

    @Override
    public void firstUlt() {
        firstOpen = false;
        if (turn==1){
            player2.getHero().setHitPoints(player2.getHero().getHitPoints()-player1.getHero().getAttack()*5);
           turn*=-1;
        } else {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints()-player2.getHero().getAttack()*5);
            turn*=-1;
        }
    }

    @Override
    public void twoUlt() {
        twoOpen = false;
        if (turn==1){
            player2.getHero().setHitPoints(player2.getHero().getHitPoints()-player1.getHero().getAttack()*2.5);
            player2.getHero().setSupplyHealth( player2.getHero().getSupplyHealth()-player1.getHero().getAttack()*2.5);
        } else {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints()-player2.getHero().getAttack()*2.5);
            player1.getHero().setSupplyHealth( player1.getHero().getSupplyHealth()-player2.getHero().getAttack()*2.5);
        }

    }

    @Override
    public void threeUlt() {
        threeOpen = false;
        if (turn==1){
            player2.getHero().setHitPoints(player2.getHero().getHitPoints()-player1.getHero().getSupplyHealth());
        } else {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints()-player2.getHero().getSupplyHealth());
        }
    }

    @Override
    public boolean isFirstOpen() {
        return firstOpen;
    }

    @Override
    public void setFirstOpen(boolean firstOpen) {
        this.firstOpen = firstOpen;
    }

    @Override
    public boolean isTwoOpen() {
        return twoOpen;
    }

    @Override
    public void setTwoOpen(boolean twoOpen) {
        this.twoOpen = twoOpen;
    }

    @Override
    public boolean isThreeOpen() {
        return threeOpen;
    }

    @Override
    public void setThreeOpen(boolean threeOpen) {
        this.threeOpen = threeOpen;
    }

    public void updateSkills(Hero hero) {
        if (turnOpen1 == 0 && hero.getLevelHero() >= 3) turnOpen1 = turns;
        if (turnOpen2 == 0 && hero.getLevelHero() >= 5) turnOpen2 = turns;
        if (turnOpen3 == 0 && hero.getLevelHero() >= 9) turnOpen3 = turns;

        if ((turns - turnOpen1) % 14 == 0 && hero.getLevelHero() >= 3) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), imageViewList[0]);
            fadeTransition.setFromValue(0.3);
            fadeTransition.setToValue(1);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
            firstOpen = true;
        }

        if ((turns - turnOpen2) % 16 == 0 && hero.getLevelHero() >= 5) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), imageViewList[1]);
            fadeTransition.setFromValue(0.3);
            fadeTransition.setToValue(1);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
            twoOpen = true;
        }

        if ((turns - turnOpen3) % 20 == 0 && hero.getLevelHero() >= 9) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), imageViewList[2]);
            fadeTransition.setFromValue(0.3);
            fadeTransition.setToValue(1);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
            threeOpen = true;
        }

        if (!firstOpen) imageViewList[0].setOpacity(0.3);
        if (!twoOpen) imageViewList[1].setOpacity(0.3);
        if (!threeOpen) imageViewList[2].setOpacity(0.3);
    }
}
