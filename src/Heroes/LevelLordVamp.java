package Heroes;

public class LevelLordVamp {
    private static Double[] attackList = {0.0, 10.0, 12.0, 13.0, 19.0, 21.0, 24.0, 30.0, 36.0, 41.0};
    private static Double[] treatmentList = {0.0, 15.0, 18.0, 22.0, 26.0, 31.0, 37.0, 45.0, 53.0, 65.0};
    private static Double[] supplyHealthList = {0.0, 60.0, 70.0, 90.0, 105.0, 120.0, 150.0, 180.0, 225.0, 250.0};
    private static Double experience;
    private static Double attack;
    private static Double treatment;
    private static Double hitPoints;
    private static Double supplyHealth;
    private static int levelHero;

    public static void LevelUpLordVamp(Hero hero) {
        if (hero.getHitPoints() > hero.getSupplyHealth()) hero.setHitPoints(hero.getSupplyHealth());
        experience = hero.getExperience();
        attack = hero.getAttack();
        treatment = hero.getTreatment();
        supplyHealth = hero.getSupplyHealth();
        levelHero = hero.getLevelHero();
        hitPoints = hero.getHitPoints();

        Double[] levelList = {0.0, 250.0, 610.0, 1114.0, 1794.0, 2730.0, 3980.0, 5619.0, 7767.0, 10562.0};
        int levelLast = levelHero;
        int levelNew = 0;
        for (int i = 1; i < levelList.length; i++)
            if (experience >= levelList[i - 1] && experience < levelList[i]) levelNew = i;
        if (levelLast != levelNew) {
            hero.setAttack(getAttack());
            hero.setExperience(getExperience());
            hero.setHitPoints(getHitPoints());
            hero.setLevelHero(levelNew);
            hero.setSupplyHealth(getSupplyHealth());
            hero.setTreatment(getTreatment());
        }
    }

    private static Double getAttack() {
        return attack + attackList[levelHero - 1];
    }

    private static Double getTreatment() {
        return treatment + treatmentList[levelHero - 1];
    }


    private static Double getHitPoints() {
        return hitPoints + supplyHealthList[levelHero - 1];
    }


    private static Double getSupplyHealth() {
        return supplyHealth + supplyHealthList[levelHero - 1];
    }


    private static Double getExperience() {
        return experience;
    }
}


