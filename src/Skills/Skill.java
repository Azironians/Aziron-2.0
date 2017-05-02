package Skills;

import Heroes.Hero;
import javafx.scene.image.ImageView;

public interface Skill{
    ImageView[] getImageViewsText();

    void setImageViewsText(ImageView[] imageViewsText);

    void firstUlt();

    void twoUlt();

    void threeUlt();

    ImageView[] getImageViewList();

    void updateSkills(Hero hero);

    boolean isFirstOpen();

    void setFirstOpen(boolean firstOpen);

    boolean isTwoOpen();

    void setTwoOpen(boolean twoOpen);

    boolean isThreeOpen();

    void setThreeOpen(boolean threeOpen);
}
