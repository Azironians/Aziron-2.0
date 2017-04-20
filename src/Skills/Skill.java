package Skills;

import Heroes.Hero;

public class Skill {
    private byte coultdown;
    private byte necessaryLevel;

    //1. Доступна ли данная способность героя?
    public boolean isOpenSkill(Hero hero){
        return this.coultdown == 0 && this.necessaryLevel >= hero.getLevelHero();
    }

    //Getters and Setters:
    public byte getCoultdown() {
        return coultdown;
    }

    public void setCoultdown(byte coultdown) {
        this.coultdown = coultdown;
    }

    public byte getNecessaryLevel() {
        return necessaryLevel;
    }

    public void setNecessaryLevel(byte necessaryLevel) {
        this.necessaryLevel = necessaryLevel;
    }
}
