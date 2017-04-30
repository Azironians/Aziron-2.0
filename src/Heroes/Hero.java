package Heroes;

import Match.Player;
import Skills.Skill;
import javafx.scene.image.ImageView;

import java.util.List;

public interface Hero {

    void setPlayer(Player player);

    Player getPlayer();

    void levelUp();

    Double getExperience();

    void setExperience(Double experience);

    ImageView getImage();

    Double getAttack();

    void setAttack(Double attack);

    Double getTreatment();

    void setTreatment(Double treatment);

    Double getHitPoints();

    void setHitPoints(Double hitPoints);

    Double getSupplyHealth();

    void setSupplyHealth(Double supplyHealth);

    int getLevelHero();

    Boolean getLocation();

    void setLocation(Boolean location);

    void setLevelHero(int levelHero);

    Skill getSkills();

    void setSkills(Skill skills);


}




