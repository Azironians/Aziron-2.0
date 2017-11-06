package BonusDirectory;

import Heroes.Hero;
import Main.Profile;
import org.jetbrains.annotations.Contract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BonusCollectionReaderWriter {
    BonusCollection bonusCollection = new BonusCollection();
    int classicBonuses = 16; //верхние границы
    int devourer = 64;
    int lordVampire = 112;
    int orcBacher = 160;

    @Contract(pure = true)
    private boolean isClassicBonus(int bonus) {
        return bonus > 0 && bonus < 16;
    }


    public List<List<Bonus>> parseBonusesCollection(File collectionOfBonus) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(collectionOfBonus));
        List<String> listOfInputCollection = bufferedReader.lines().collect(Collectors.toList());
        switch (collectionOfBonus.getName()) {
            case "collectionDevourer.hoa":
                return parseBonusesForCurrentHero(listOfInputCollection, classicBonuses + 1, devourer);
            case "collectionLordVampire.hoa":
                return parseBonusesForCurrentHero(listOfInputCollection, devourer + 1, lordVampire);
            case "collectionOrcBasher.hoa":
                return parseBonusesForCurrentHero(listOfInputCollection, lordVampire + 1, orcBacher);
        }
        throw new IllegalArgumentException("Collections not founded");
    }

    private List<List<Bonus>> parseBonusesForCurrentHero(List<String> listOfInputCollection, int start, int end) {
        List<List<Bonus>> outputList = new ArrayList<>();
        for (String inputCollection : listOfInputCollection) {
            String[] bonusesId = inputCollection.split(" ");
            List<Bonus> currentOutputList = new ArrayList<>();
            for (String elementOfBonus : bonusesId) {
                int bonus = Integer.parseInt(elementOfBonus);
                if (isClassicBonus(bonus) || (bonus >= start && bonus <= end)) {
                    if (!currentOutputList.contains(bonusCollection.getMapOfBonus().get(bonus))) {
                        currentOutputList.add(bonusCollection.getMapOfBonus().get(bonus));
                    } else {
                        throw new IllegalArgumentException("This bonus was added");
                    }
                } else {
                    throw new IllegalArgumentException("This bonus is not valid for");
                }
            }
            outputList.add(currentOutputList);
        }
        return outputList;
    }

    public void reWriteBonusesCollection(List<List<Bonus>> listOfCollections , List<Bonus> inputListOfCollection , Hero hero, String profileName, int numberOfCollection) throws IOException {
        String nameOfHeroCollection = "";
        switch (hero.getClass().toString()) {
            case "HeroDevourer":
                nameOfHeroCollection = "collectionDevourer.hoa";
                break;
            case "HeroLordVamp":
                nameOfHeroCollection = "collectionLordVamp.hoa";
                break;
            case "HeroOrcBasher":
                nameOfHeroCollection = "collectionOrcBasher";

        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Profiles/" + profileName + "/" + nameOfHeroCollection)));
        for(int i=0;i<listOfCollections.size();i++) {
            if (i == numberOfCollection ) {
                bufferedWriter.write() ;
            }
        }
    }


}



