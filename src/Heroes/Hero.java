package Heroes;

import Skills.Skill;

import java.util.List;

    public abstract class Hero {
        private String name;
        private Double attack;
        private Double treatment;
        private Double hitPoints;
        private Double supplyHealth;
        private Double levelHero;
        private List<Skill> skills;

        public Hero(String name, Double attack, Double treatment, Double hitPoints, Double supplyHealth, Double levelHero, List<Skill> skills) {}

        //Разыграть способность:
        public void castSkill(Skill skill){}

        public void levelUp(){

        }

        //Getters and Setters:
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public Double getAttack() {
            return attack;
        }

        public void setAttack(Double attack) {
            this.attack = attack;
        }

        public Double getTreatment() {
            return treatment;
        }

        public void setTreatment(Double treatment) {
            this.treatment = treatment;
        }

        public Double getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(Double hitPoints) {
            this.hitPoints = hitPoints;
        }

        public Double getSupplyHealth() {
            return supplyHealth;
        }

        public void setSupplyHealth(Double supplyHealth) {
            this.supplyHealth = supplyHealth;
        }

        public Double getLevelHero() {
            return levelHero;
        }

        public void setLevelHero(Double levelHero) {
            this.levelHero = levelHero;
        }

        public List<Skill> getSkills() {
            return skills;
        }

        public void setSkills(List<Skill> skills) {
            this.skills = skills;
        }


    }




