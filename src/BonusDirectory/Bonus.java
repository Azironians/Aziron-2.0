package BonusDirectory;

import javafx.scene.image.ImageView;

public abstract class Bonus {




    private int id;
    private int numberOfTurns; //??
    private int count;
    private ImageView sprite;
    private ImageView label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageView getSprite() {
        return sprite;
    }

    public abstract void run();

    public abstract void onStartTurn();

    public abstract void inEndTurn();

    public abstract boolean condition();

    public abstract void decreaseOfTurns(); // Уменьшение срабатывания бонусов на ходах ?? не точно.

    public abstract void controllingBattleProcess();

    public abstract int getCountActivity();
}
