package Skills;

import Heroes.Hero;

public class Skill {
    private byte countdown;
    private byte necessaryLevel;

    //1. Доступна ли данная способность героя?
    public boolean isOpenSkill(Hero hero){
        return this.countdown == 0 && this.necessaryLevel >= hero.getLevelHero();
    }

    //2. Таймер:
    public void countdownDown(){
        if (this.countdown != 0) {
            this.countdown--;
        }
    }

    //Getters and Setters:
    public byte getCountdown() {
        return countdown;
    }

    public void setCountdown(byte countdown) {
        this.countdown = countdown;
    }

    public byte getNecessaryLevel() {
        return necessaryLevel;
    }

    public void setNecessaryLevel(byte necessaryLevel) {
        this.necessaryLevel = necessaryLevel;
    }
}
