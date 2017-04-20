package Heroes;

import Skills.Skill;

import java.util.List;

    public interface Hero {


        //Разыграть способность:

        public void levelUp();

        //Getters and Setters:
        public Double getAttack();

        public void setAttack(Double attack);

        public Double getTreatment();

        public void setTreatment(Double treatment);

        public Double getHitPoints();

        public void setHitPoints(Double hitPoints);

        public Double getSupplyHealth();

        public void setSupplyHealth(Double supplyHealth);

        public Double getLevelHero();

        public void setLevelHero(Double levelHero);

        public List<Skill> getSkills();

        public void setSkills(List<Skill> skills);


    }




