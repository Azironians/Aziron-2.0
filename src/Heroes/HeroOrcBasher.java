package Heroes;

import Skills.Skill;

import java.util.List;

public class HeroOrcBasher extends Hero {
    HeroOrcBasher(String name, Double attack, Double treatment, Double hitPoints, Double supplyHealth, Double levelHero, List<Skill> skills) {
        super(name, attack, treatment, hitPoints, supplyHealth, levelHero, skills);
    }
}