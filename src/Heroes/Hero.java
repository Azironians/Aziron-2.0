package Heroes;

import Skills.Skill;
import javafx.scene.image.ImageView;

import java.util.List;

    public interface Hero {


        //Разыграть способность:

       void levelUp();

        ImageView getImage();

        //Getters and Setters:
        Double getAttack();

        void setAttack(Double attack);

        Double getTreatment();

        void setTreatment(Double treatment);

        Double getHitPoints();

        void setHitPoints(Double hitPoints);

        Double getSupplyHealth();

        void setSupplyHealth(Double supplyHealth);

        Double getLevelHero();

        void setLevelHero(Double levelHero);

        List<Skill> getSkills();

        void setSkills(List<Skill> skills);


    }




