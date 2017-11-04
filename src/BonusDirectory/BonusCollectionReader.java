package BonusDirectory;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BonusCollectionReader {
    BonusCollection bonusCollection = new BonusCollection();
    int classicBonuses = 16; //верхние границы
    int devourer = 64;
    int lordVampire = 112;
    int orcBacher = 160;

    @Contract(pure = true)
    private boolean isClassicBonus(int bonus) {
        return bonus > 0 && bonus < 16;
    }


    public List<List<Bonus>> parseBonusCollection(File collectionOfBonus) throws FileNotFoundException {
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


}



