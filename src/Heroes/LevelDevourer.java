package Heroes;

public class LevelDevourer {
    private static Double[] attackList = {0.0, 8.0, 10.0, 11.0, 14.0, 17.0, 20.0, 23.0, 29.0, 35.0};
    private static Double[] treatmentList = {0.0, 20.0, 24.0, 29.0, 34.0, 42.0, 50.0, 59.0, 72.0, 86.0};
    private static Double[] supplyHealthList = {0.0, 80.0, 95.0, 115.0, 140.0, 165.0, 200.0, 235.0, 290.0, 345.0};
    private static Double experience;
    private static Double attack;
    private static Double treatment;
    private static Double hitPoints;
    private static Double supplyHealth;
    private static int levelHero;

    public static void LevelUpDevourer(Hero hero) {
        if (hero.getHitPoints() > hero.getSupplyHealth()) hero.setHitPoints(hero.getSupplyHealth());
        experience = hero.getExperience();
        attack = hero.getAttack();
        treatment = hero.getTreatment();
        supplyHealth = hero.getSupplyHealth();
        levelHero = hero.getLevelHero();
        hitPoints = hero.getHitPoints();

        Double[] levelList = {0.0, 200.0, 488.0, 894.0, 1446.0, 2193.0, 3193.0, 4513.0, 6229.0, 8465.0};
        int levelLast = levelHero;
        int levelNew = 0;
        for (int i = 1; i < levelList.length; i++)
            if (experience >= levelList[i - 1] && experience < levelList[i]) levelNew = i;
        if (experience >= levelList[9]) levelNew = 10;

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

