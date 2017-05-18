package Heroes;

class LevelOrg {
    private static Double[] attackList = {0.0, 6.0, 7.0, 9.0, 10.0, 12.0, 16.0, 18.0, 22.0, 25.0};
    private static Double[] treatmentList = {0.0, 25.0, 30.0, 36.0, 43.0, 52.0, 62.0, 75.0, 89.0, 108.0};
    private static Double[] supplyHealthList = {0.0, 100.0, 120.0, 145.0, 170.0, 210.0, 245.0, 300.0, 360.0, 410.0};
    private static Double experience;
    private static Double attack;
    private static Double treatment;
    private static Double hitPoints;
    private static Double supplyHealth;
    private static int levelHero;

    static void LevelUpOgr(Hero hero) {
        if (hero.getHitPoints() > hero.getSupplyHealth()) hero.setHitPoints(hero.getSupplyHealth());
        experience = hero.getExperience();
        attack = hero.getAttack();
        treatment = hero.getTreatment();
        supplyHealth = hero.getSupplyHealth();
        levelHero = hero.getLevelHero();
        hitPoints = hero.getHitPoints();

        Double[] levelList = {0.0, 150.0, 366.0, 667.0, 1083.0, 1641.0, 2381.0, 3371.0, 4667.0, 6357.0};
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
