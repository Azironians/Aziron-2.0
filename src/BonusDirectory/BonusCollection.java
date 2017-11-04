package BonusDirectory;

import java.util.HashMap;
import java.util.Map;

public class BonusCollection {
    private  Map<Integer, Bonus> mapOfBonus = new HashMap<>();

    public static final Bonus bonus = new Bonus() {
        @Override
        public void run() {

        }

        @Override
        public void onStartTurn() {

        }

        @Override
        public void inEndTurn() {

        }
    };

    Map<Integer, Bonus> getMapOfBonus() {
        return mapOfBonus;
    }
}
